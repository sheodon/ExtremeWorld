package com.jixianxueyuan.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jixianxueyuan.R;
import com.jixianxueyuan.dto.MediaDTO;
import com.jixianxueyuan.dto.TopicDTO;
import com.jixianxueyuan.server.StaticResourceConfig;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


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

    public void addDatas(List<TopicDTO> topicDTOs)
    {
        for(TopicDTO dtoItem : topicDTOs)
        {
            topicDTOList.add(dtoItem);
        }

        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return topicDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return topicDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return topicDTOList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

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


        viewHolder.nameTextView.setText(topicDTO.getUserInfo().getName());
        viewHolder.titleTextView.setText(topicDTO.getTitle());
        viewHolder.timeTextView.setText(topicDTO.getCreateTime());

        if(topicDTO.getMedias().size() > 0)
        {
            viewHolder.frontImageView.setVisibility(View.VISIBLE);
            MediaDTO mediaDto = topicDTO.getMedias().get(0);

            String url = StaticResourceConfig.IMG_DOMAIN + mediaDto.getPath();
            ImageLoader.getInstance().displayImage(url, viewHolder.frontImageView);
        }
        else
        {
            viewHolder.frontImageView.setVisibility(View.GONE);
        }

        if(topicDTO.getTypec() != null || topicDTO.getTypec().length() > 0)
        {
            switch (topicDTO.getTypec())
            {
                case "mood":
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_face_grey600_18dp);
                    break;

                case "discuss":
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_message_grey600_24dp);
                    break;

                case "video":
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_videocam_grey600_18dp);
                    break;

                case "activity":
                    viewHolder.typeImageView.setImageResource(R.mipmap.ic_assistant_photo_grey600_18dp);
                    break;
            }
        }


        return convertView;
    }


    public static class ViewHolder{

        @InjectView(R.id.topic_list_item_type)
        ImageView typeImageView;
        @InjectView(R.id.topic_list_item_title)
        TextView titleTextView;

        @InjectView(R.id.topic_list_item_name)
        TextView nameTextView;

        @InjectView(R.id.topic_list_item_time)
        TextView timeTextView;

        @InjectView(R.id.topic_list_item_front_image)
        ImageView frontImageView;

        public ViewHolder(View itemView){

            ButterKnife.inject(this,itemView);
        }
    }
}
