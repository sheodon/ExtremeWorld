package com.jixianxueyuan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.jixianxueyuan.R;
import com.jixianxueyuan.adapter.RemindListAdapter;
import com.jixianxueyuan.app.Mine;
import com.jixianxueyuan.app.MyApplication;
import com.jixianxueyuan.config.RemindType;
import com.jixianxueyuan.dto.MyPage;
import com.jixianxueyuan.dto.MyResponse;
import com.jixianxueyuan.dto.RemindDTO;
import com.jixianxueyuan.http.MyPageRequest;
import com.jixianxueyuan.http.MyVolleyErrorHelper;
import com.jixianxueyuan.server.ServerMethod;
import com.jixianxueyuan.util.MyLog;
import com.jixianxueyuan.widget.AutoLoadMoreView;
import com.jixianxueyuan.widget.MyActionBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by pengchao on 8/9/15.
 */
public class RemindListActivity extends BaseActivity {

    MyApplication myApplication;
    Mine mine;

    @BindView(R.id.remind_list_actionbar)
    MyActionBar actionBar;
    @BindView(R.id.remind_list_swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.remind_list_listview)
    ListView listView;
    private AutoLoadMoreView autoLoadMoreView;

    RemindListAdapter adapter;

    int currentPage = 0;
    int totalPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.remind_list_activity);

        ButterKnife.bind(this);

        myApplication = (MyApplication) this.getApplication();
        mine = myApplication.getMine();

        initFootView();
        swipeRefreshLayout.setColorSchemeResources(R.color.primary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refreshTopicList();
            }
        });

        adapter = new RemindListAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    //滚动到底部
                    if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                        getNextPage();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        refreshTopicList();
    }

    private void initFootView(){
        autoLoadMoreView = new AutoLoadMoreView(this);
        listView.addFooterView(autoLoadMoreView);
    }

    private void doHideFootView()
    {
        if ((totalPage > 0 && currentPage >= totalPage) || totalPage == 0 ) {
            autoLoadMoreView.setOver();
        }else {
            autoLoadMoreView.reset();
        }
    }

    private void refreshTopicList()
    {
        currentPage = 0;

        requestRemindReplyList();
    }

    private void getNextPage(){
        if(currentPage < totalPage ){
            requestRemindReplyList();
        }else {
            Toast.makeText(this, R.string.not_more, Toast.LENGTH_SHORT).show();
        }
    }


    private void requestRemindReplyList(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = ServerMethod.remind() + mine.getUserInfo().getId() + "?page=" + (currentPage + 1);
        MyLog.d("RemindListActivity", "request url=" + url);

        MyPageRequest<RemindDTO> myPageRequest = new MyPageRequest<RemindDTO>(Request.Method.GET, url, RemindDTO.class,
                new Response.Listener<MyResponse<MyPage<RemindDTO>>>() {
                    @Override
                    public void onResponse(MyResponse<MyPage<RemindDTO>> response) {

                        if(response.getStatus() == MyResponse.status_ok){

                            MyLog.d("RemindListActivity","onResponse");
                            MyPage myPage = response.getContent();
                            List<RemindDTO> remindDTOList = myPage.getContents();
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
                MyVolleyErrorHelper.showError(RemindListActivity.this, error);
            }
        });

        queue.add(myPageRequest);
    }

    @OnItemClick(R.id.remind_list_listview) void onItemClick(int position){

        RemindDTO remindDTO = adapter.getItem(position);
        int targetType = remindDTO.getTargetType();

        Intent intent = null;
        switch (targetType){

            case RemindType.TARGET_TYPE_TOPIC:
                intent = new Intent(RemindListActivity.this, TopicDetailActivity.class);
                intent.putExtra("topicId", remindDTO.getTargetId());
                break;
            case RemindType.TARGET_TYPE_REPLY:
            case RemindType.TARGET_TYPE_SUB_REPLY:
                intent = new Intent(RemindListActivity.this, ReplyDetailActivity.class);
                intent.putExtra("replyId", remindDTO.getTargetId());
                break;
            default:
                break;
        }

        if(intent != null){
            startActivity(intent);
        }
    }

}
