package com.jixianxueyuan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.MenuSheetView;
import com.jixianxueyuan.R;
import com.jixianxueyuan.adapter.SponsorshipListAdapter;
import com.jixianxueyuan.app.MyApplication;
import com.jixianxueyuan.commons.MyErrorHelper;
import com.jixianxueyuan.commons.pay.PayHelper;
import com.jixianxueyuan.config.HobbyType;
import com.jixianxueyuan.config.TopicType;
import com.jixianxueyuan.dto.*;
import com.jixianxueyuan.dto.Error;
import com.jixianxueyuan.dto.request.SponsorshipRequestDTO;
import com.jixianxueyuan.http.MyPageRequest;
import com.jixianxueyuan.http.MyRequest;
import com.jixianxueyuan.http.MyVolleyErrorHelper;
import com.jixianxueyuan.server.ServerMethod;
import com.jixianxueyuan.widget.AutoLoadMoreView;

import java.util.List;
import java.util.UUID;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by pengchao on 12/3/15.
 */
public class SponsorshipActivity extends BaseActivity {

    public static final String TAG = SponsorshipActivity.class.getSimpleName();

    @InjectView(R.id.bottom_sheet)
    BottomSheetLayout bottomSheetLayout;
    @InjectView(R.id.sponsorship_list_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @InjectView(R.id.sponsorship_activity_list_view)
    ListView listView;

    private SponsorshipListAdapter adapter;

    private List<SponsorshipDTO> sponsorshipDTOList;

    private PayHelper payHelper;

    private SponsorshipRequestDTO sponsorshipRequestDTO;

    private AutoLoadMoreView autoLoadMoreView;
    private int currentPage = 0;
    private int totalPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sponsorship_activity);
        ButterKnife.inject(this);

        bottomSheetLayout.setPeekOnDismiss(true);

        adapter = new SponsorshipListAdapter(this);
        listView.setAdapter(adapter);

        initFooterView();
        registerListener();

        refreshData();
    }

    private void initFooterView(){
        autoLoadMoreView = new AutoLoadMoreView(this);
        listView.addFooterView(autoLoadMoreView);
    }

    private void registerListener(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

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


    }
    private void refreshData(){
        currentPage = 0;
        requestNewSponsorship();
    }

    private void getNextPage(){
        if (currentPage < totalPage) {
            requestNewSponsorship();
        }
    }

    private void doHideFootView() {
        if (totalPage > 0 && currentPage >= totalPage) {
            autoLoadMoreView.setOver();
        }else {
            autoLoadMoreView.reset();
        }
    }

    private void requestTopSponsorship(){

        String url = ServerMethod.sponsorship();

        MyPageRequest<SponsorshipDTO> myPageRequest =
                new MyPageRequest<SponsorshipDTO>(Request.Method.GET, url, SponsorshipDTO.class, new Response.Listener<MyResponse<MyPage<SponsorshipDTO>>>() {
                    @Override
                    public void onResponse(MyResponse<MyPage<SponsorshipDTO>> response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        MyApplication.getContext().getRequestQueue().add(myPageRequest);
    }

    private void requestNewSponsorship(){

        String url = ServerMethod.sponsorship() + "?page=" + (currentPage + 1);

        MyPageRequest<SponsorshipDTO> myPageRequest =
                new MyPageRequest<SponsorshipDTO>(Request.Method.GET, url, SponsorshipDTO.class, new Response.Listener<MyResponse<MyPage<SponsorshipDTO>>>() {
                    @Override
                    public void onResponse(MyResponse<MyPage<SponsorshipDTO>> response) {
                        if(response.getStatus() == MyResponse.status_ok){
                            sponsorshipDTOList = response.getContent().getContents();
                            if (currentPage == 0){
                                adapter.setData(sponsorshipDTOList);
                            }else {
                                adapter.addData(sponsorshipDTOList);
                            }

                            totalPage = response.getContent().getTotalPages();
                            currentPage = response.getContent().getCurPage() + 1;
                            doHideFootView();

                        }else {
                            MyErrorHelper.showErrorToast(SponsorshipActivity.this, response.getError());
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        MyVolleyErrorHelper.showError(SponsorshipActivity.this, error);
                    }
                });
        MyApplication.getContext().getRequestQueue().add(myPageRequest);
    }

    private void createSponsorshipOrder(){

        String url = ServerMethod.sponsorship();
        MyRequest<SponsorshipTradeDTO> myRequest = new MyRequest<SponsorshipTradeDTO>(Request.Method.POST,
                url, SponsorshipTradeDTO.class,
                sponsorshipRequestDTO,
                new Response.Listener<MyResponse<SponsorshipTradeDTO>>() {
                    @Override
                    public void onResponse(MyResponse<SponsorshipTradeDTO> response) {

                        if(response.getStatus() == MyResponse.status_ok){
                            if(payHelper == null){
                                payHelper = new PayHelper(SponsorshipActivity.this);
                            }
                            SponsorshipTradeDTO sponsorshipTradeDTO = response.getContent();
                            if(sponsorshipTradeDTO != null){

                            }else {

                            }
                            payHelper.pay(sponsorshipTradeDTO.getTrade().getInternalTradeNo(),
                                    String.valueOf(sponsorshipTradeDTO.getSum()));
                        }else {

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MyApplication.getContext().getRequestQueue().add(myRequest);
    }

    private void showMoneySheet(final MenuSheetView.MenuType menuType){
        MenuSheetView menuSheetView =
                new MenuSheetView(SponsorshipActivity.this, menuType, getString(R.string.donation), new MenuSheetView.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String money = "0.01";
                        switch (item.getItemId()){
                            case R.id.menu_donation_1:
                                money = "0.1";
                                break;
                            case R.id.menu_donation_5:
                                money = "5.00";
                                break;
                            case R.id.menu_donation_20:
                                money = "20.00";
                                break;
                            case R.id.menu_donation_50:
                                money = "50.00";
                                break;
                            case R.id.menu_donation_100:
                                money = "100.00";
                                break;
                        }

                        buildSponsorshipRequestDTO(money);
                        createSponsorshipOrder();

                        if (bottomSheetLayout.isSheetShowing()) {
                            bottomSheetLayout.dismissSheet();
                        }
                        return true;
                    }

                    private void buildSponsorshipRequestDTO(String money) {
                        if(sponsorshipRequestDTO == null){
                            sponsorshipRequestDTO = new SponsorshipRequestDTO();
                        }
                        sponsorshipRequestDTO.setSum(Double.parseDouble(money));
                        HobbyDTO hobbyDTO = new HobbyDTO();
                        Long hobbyId = HobbyType.getHobbyId(MyApplication.getContext().getAppInfomation().getCurrentHobbyStamp());
                        hobbyDTO.setId(hobbyId);
                        sponsorshipRequestDTO.setHobby(hobbyDTO);
                        UserMinDTO userMinDTO = new UserMinDTO();
                        userMinDTO.setId(MyApplication.getContext().getMine().getUserInfo().getId());
                        sponsorshipRequestDTO.setUser(userMinDTO);
                        sponsorshipRequestDTO.setTicket(UUID.randomUUID().toString());
                    }
                });
        menuSheetView.inflateMenu(R.menu.donation_money);
        bottomSheetLayout.showWithSheetView(menuSheetView);
    }

    @OnClick(R.id.sponsorship_activity_donation)void onDonation(){
        showMoneySheet(MenuSheetView.MenuType.GRID);
    }


}
