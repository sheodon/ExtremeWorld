package com.jixianxueyuan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;

import com.jixianxueyuan.R;
import com.jixianxueyuan.adapter.TopicTaxonomyListFragmentPageAdapter;
import com.jixianxueyuan.config.TopicType;
import com.jixianxueyuan.util.MyLog;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by pengchao on 6/29/15.
 */
public class TopicTaxonomyHomeActivity extends FragmentActivity {

    @InjectView(R.id.discuss_home_activity_pager)ViewPager viewPager;
    @InjectView(R.id.discuss_home_activity_pager_title_strip)PagerTitleStrip pagerTitleStrip;

    TopicTaxonomyListFragmentPageAdapter pageAdapter;

    String topicType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.discuss_home_activity);

        ButterKnife.inject(this);

        Intent intent = this.getIntent();
        if(intent.hasExtra(TopicType.STRING))
        {
            topicType = intent.getStringExtra(TopicType.STRING);
            MyLog.d("TopicTaxonomyHomeActivity", "topicType=" + topicType);
        }
        else
        {
            finish();
        }


        pageAdapter = new TopicTaxonomyListFragmentPageAdapter(this.getSupportFragmentManager(), this, topicType);

        viewPager.setAdapter(pageAdapter);

    }
}
