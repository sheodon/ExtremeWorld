package com.jixianxueyuan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jixianxueyuan.R;
import com.jixianxueyuan.activity.UserHomeActivity;
import com.jixianxueyuan.config.ImageLoaderConfig;
import com.jixianxueyuan.config.QiniuImageStyle;
import com.jixianxueyuan.config.TopicType;
import com.jixianxueyuan.config.UmengEventId;
import com.jixianxueyuan.dto.MediaDTO;
import com.jixianxueyuan.dto.MediaWrapDTO;
import com.jixianxueyuan.dto.TopicDTO;
import com.jixianxueyuan.dto.VideoDetailDTO;
import com.jixianxueyuan.util.DateTimeFormatter;
import com.jixianxueyuan.util.Util;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.BindView;


/**
 * Created by pengchao on 2015/4/12.
 */
public class TopicListAdapter extends BaseAdapter {

    Context context;

    List<TopicDTO> topicDTOList;

    private DisplayImageOptions options;

    public TopicListAdapter(Context context)
    {
        this.context = context;
        topicDTOList = new ArrayList<TopicDTO>();

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new RoundedBitmapDisplayer(20)).build();
    }

    public void refresh(List<TopicDTO> list)
    {
        topicDTOList.clear();
        topicDTOList.addAll(list);

        this.notifyDataSetChanged();
    }

    public void addDatas(List<TopicDTO> topicDTOs)
    {
        topicDTOList.addAll(topicDTOs);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return topicDTOList.size();
    }

    @Override
    public TopicDTO getItem(int position) {
        if(position < topicDTOList.size()){
            return topicDTOList.get(position);
        }else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return topicDTOList.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.topic_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TopicDTO topicDTO = topicDTOList.get(position);


        viewHolder.nameTextView.setText(topicDTO.getUser().getName());
        String timeAgo = DateTimeFormatter.getTimeAgo(context, topicDTO.getCreateTime());
        viewHolder.timeTextView.setText(timeAgo);
        viewHolder.viewCountTextView.setText( String.valueOf(topicDTO.getAllReplyCount()));
        viewHolder.agreeCountTextView.setText(String.valueOf(topicDTO.getAgreeCount()));

        String avatarUrl = topicDTO.getUser().getAvatar();
        if(Util.isOurServerImage(avatarUrl)){
            avatarUrl += QiniuImageStyle.LIST_AVATAR;
        }
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(avatarUrl, viewHolder.avatarImageView , ImageLoaderConfig.getAvatarOption(context));

        MediaWrapDTO mediawrap = topicDTO.getMediaWrap();

        VideoDetailDTO videoDetailDTO = topicDTO.getVideoDetail();



        if(topicDTO.getType() != null && topicDTO.getType().length() > 0)
        {
            switch (topicDTO.getType())
            {
                case TopicType.MOOD:
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_mood);
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;

                case TopicType.DISCUSS:
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_discuss);
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;

                case TopicType.VIDEO:
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_video);
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;

                case TopicType.S_VIDEO:
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_video);
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;

                case TopicType.ACTIVITY:
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;
                case TopicType.NEWS:
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_news);
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;
                case TopicType.COURSE:
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_teach);
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;
                case TopicType.CHALLENGE:
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_challenge);
                    viewHolder.titleTextView.setText(topicDTO.getTitle());
                    break;
            }
        }


        //多媒体信息
        if(videoDetailDTO != null)
        {
            viewHolder.videoFrontLayout.setVisibility(View.VISIBLE);
            ImageLoader.getInstance().displayImage(videoDetailDTO.getThumbnail() + "!AndroidListItem", viewHolder.videoFrontImageView);
        }
        else
        {
            viewHolder.videoFrontLayout.setVisibility(View.GONE);
        }

        viewHolder.topicImageView_1.setVisibility(View.GONE);
        viewHolder.topicImageView_2.setVisibility(View.GONE);
        viewHolder.topicImageView_3.setVisibility(View.GONE);
        viewHolder.topicImageView_4.setVisibility(View.GONE);
        viewHolder.topicImageView_5.setVisibility(View.GONE);


        if(mediawrap != null)
        {
            if(mediawrap.getMedias().size() > 0)
            {
                viewHolder.topicImageView_1.setVisibility(View.VISIBLE);
                MediaDTO mediaDto = mediawrap.getMedias().get(0);

                String url =  mediaDto.getPath();
                ImageLoader.getInstance().displayImage(url + QiniuImageStyle.LIST_ITEM, viewHolder.topicImageView_1);
            }
            if(mediawrap.getMedias().size() > 1)
            {
                viewHolder.topicImageView_2.setVisibility(View.VISIBLE);
                MediaDTO mediaDto = mediawrap.getMedias().get(1);

                String url =  mediaDto.getPath();
                ImageLoader.getInstance().displayImage(url + QiniuImageStyle.LIST_ITEM, viewHolder.topicImageView_2);
            }
            if(mediawrap.getMedias().size() > 2)
            {
                viewHolder.topicImageView_3.setVisibility(View.VISIBLE);
                MediaDTO mediaDto = mediawrap.getMedias().get(2);

                String url =  mediaDto.getPath();
                ImageLoader.getInstance().displayImage(url + QiniuImageStyle.LIST_ITEM, viewHolder.topicImageView_3);
            }
            if(mediawrap.getMedias().size() > 3)
            {
                viewHolder.topicImageView_4.setVisibility(View.VISIBLE);
                MediaDTO mediaDto = mediawrap.getMedias().get(3);

                String url =  mediaDto.getPath();
                ImageLoader.getInstance().displayImage(url + QiniuImageStyle.LIST_ITEM, viewHolder.topicImageView_4);
            }
            if(mediawrap.getMedias().size() > 4)
            {
                viewHolder.topicImageView_5.setVisibility(View.VISIBLE);
                MediaDTO mediaDto = mediawrap.getMedias().get(4);

                String url =  mediaDto.getPath();
                ImageLoader.getInstance().displayImage(url + QiniuImageStyle.LIST_ITEM, viewHolder.topicImageView_5);
            }
        }

        viewHolder.avatarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobclickAgent.onEvent(context, UmengEventId.TOPIC_LIST_AVATAR_CLICK);
                Intent intent = new Intent(context, UserHomeActivity.class);
                intent.putExtra(UserHomeActivity.INTENT_USER_MIN, topicDTOList.get(position).getUser());
                context.startActivity(intent);
            }
        });

        return convertView;
    }


    public static class ViewHolder{

        @BindView(R.id.topic_list_item_type)
        ImageView typeImageView;
        @BindView(R.id.topic_list_item_title)
        TextView titleTextView;
        @BindView(R.id.topic_list_item_avatar)
        ImageView avatarImageView;

        @BindView(R.id.topic_list_item_name)
        TextView nameTextView;

        @BindView(R.id.topic_list_item_time)
        TextView timeTextView;

        @BindView(R.id.topic_list_item_view_count)
        TextView viewCountTextView;

        @BindView(R.id.topic_list_item_agree_count)
        TextView agreeCountTextView;

        @BindView(R.id.topic_list_item_image_1)
        ImageView topicImageView_1;

        @BindView(R.id.topic_list_item_image_2)
        ImageView topicImageView_2;

        @BindView(R.id.topic_list_item_image_3)
        ImageView topicImageView_3;

        @BindView(R.id.topic_list_item_image_4)
        ImageView topicImageView_4;

        @BindView(R.id.topic_list_item_image_5)
        ImageView topicImageView_5;

        @BindView(R.id.topic_list_item_video_front_layout)
        RelativeLayout videoFrontLayout;

        @BindView(R.id.topic_list_item_video_front_image)
        ImageView videoFrontImageView;


        public ViewHolder(View itemView){

            ButterKnife.bind(this,itemView);
        }
    }
}
