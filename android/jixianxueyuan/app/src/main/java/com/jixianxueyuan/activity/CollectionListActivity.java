package com.jixianxueyuan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.jixianxueyuan.R;
import com.jixianxueyuan.adapter.CollectionListAdapter;
import com.jixianxueyuan.app.Mine;
import com.jixianxueyuan.app.MyApplication;
import com.jixianxueyuan.config.TopicType;
import com.jixianxueyuan.config.UmengEventId;
import com.jixianxueyuan.dto.CollectionDTO;
import com.jixianxueyuan.dto.MyPage;
import com.jixianxueyuan.dto.MyResponse;
import com.jixianxueyuan.dto.TopicDTO;
import com.jixianxueyuan.http.MyPageRequest;
import com.jixianxueyuan.server.ServerMethod;
import com.jixianxueyuan.util.MyLog;
import com.jixianxueyuan.widget.ClickLoadMoreView;
import com.jixianxueyuan.widget.MyActionBar;
import com.umeng.analytics.MobclickAgent;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

/**
 * Created by pengchao on 2/28/16.
 */
public class CollectionListActivity extends BaseActivity {

    @InjectView(R.id.collection_list_actionbar)
    MyActionBar actionBar;
    @InjectView(R.id.collection_list_swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @InjectView(R.id.collection_list_listview)
    ListView listView;


    private MyApplication myApplication;
    private Mine mine;

    private ClickLoadMoreView clickLoadMoreView;

    int currentPage = 0;
    int totalPage = 0;
    private CollectionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.collection_list_activity);

        ButterKnife.inject(this);

        adapter = new CollectionListAdapter(this);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.primary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refreshCollectionList();
            }
        });

        initFootView();

        refreshCollectionList();
    }

    private void initFootView(){
        clickLoadMoreView = new ClickLoadMoreView(this);
        clickLoadMoreView.setVisibility(View.GONE);
        clickLoadMoreView.setClickLoadMoreViewListener(new ClickLoadMoreView.ClickLoadMoreViewListener() {
            @Override
            public void runLoad() {
                getNextPage();
            }
        });
        listView.addFooterView(clickLoadMoreView);
    }

    private void doHideFootView()
    {
        if(totalPage > 1)
        {
            if(clickLoadMoreView.isLoading() == true)
            {
                clickLoadMoreView.onFinish();
            }

            if(currentPage >= totalPage)
            {
                clickLoadMoreView.setOver();
            }

        }

    }

    private void refreshCollectionList()
    {
        currentPage = 0;
        requestCollectionList();
    }

    private void getNextPage(){
        if(currentPage < totalPage ){
            requestCollectionList();
        }else {
            Toast.makeText(this, R.string.not_more, Toast.LENGTH_SHORT).show();
        }
    }

    private void requestCollectionList(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = ServerMethod.collection() + "?page=" + (currentPage + 1);


        MyPageRequest<CollectionDTO> myPageRequest = new MyPageRequest<CollectionDTO>(Request.Method.GET, url, CollectionDTO.class,
                new Response.Listener<MyResponse<MyPage<CollectionDTO>>>() {
                    @Override
                    public void onResponse(MyResponse<MyPage<CollectionDTO>> response) {

                        if(response.getStatus() == MyResponse.status_ok){

                            MyLog.d("RemindListActivity", "onResponse");
                            MyPage myPage = response.getContent();
                            List<CollectionDTO> remindDTOList = myPage.getContents();
                            if(currentPage == 0){
                                adapter.refreshData(remindDTOList);
                            }else {
                                adapter.addData(remindDTOList);
                            }


                            totalPage = myPage.getTotalPages();
                            currentPage = myPage.getCurPage() + 1;

                            doHideFootView();
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(myPageRequest);
    }

    @OnItemClick(R.id.collection_list_listview)void onItemClick(int position){
        if (position > adapter.getCount()) {
            return;
        }
        TopicDTO topicDTO = adapter.getItem(position).getTopic();

        Intent intent = null;
        switch (topicDTO.getType()) {
            case TopicType.MOOD:
            case TopicType.NEWS:
            case TopicType.COURSE:
                intent = new Intent(this, TopicDetailActivity.class);
                intent.putExtra(TopicType.TYPE, TopicType.MOOD);
                break;
            case TopicType.DISCUSS:
                intent = new Intent(this, TopicDetailActivity.class);
                intent.putExtra(TopicType.TYPE, TopicType.DISCUSS);
                break;
            case TopicType.VIDEO:
            case TopicType.S_VIDEO:
                intent = new Intent(this, TopicDetailActivity.class);
                intent.putExtra(TopicType.TYPE, TopicType.S_VIDEO);
                break;
            default:
                Toast.makeText(this,R.string.app_version_is_low, Toast.LENGTH_SHORT).show();
                break;

        }

        if (intent != null) {
            intent.putExtra(TopicDetailActivity.INTENT_TOPIC, topicDTO);
            startActivity(intent);
        }
    }

}
