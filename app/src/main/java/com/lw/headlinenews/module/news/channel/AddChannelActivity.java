package com.lw.headlinenews.module.news.channel;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.lw.headlinenews.R;
import com.lw.headlinenews.adapter.NewsChannelAdapter;
import com.lw.headlinenews.base.BaseActivity;
import com.lw.headlinenews.dbmodel.NewsTabItems;
import com.lw.headlinenews.helper.TabItemsHelper;
import com.lw.headlinenews.utils.AppConstant;

import java.util.List;

public class AddChannelActivity extends BaseActivity {

    private RecyclerView channelView;
    private List<NewsTabItems> myChannels;
    private List<NewsTabItems> otherChannels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_channel);
        initChannels();
        initView();
    }

    private void initChannels() {
        myChannels = TabItemsHelper.getNewsTabItems();
        otherChannels = TabItemsHelper.getDisableItems();

    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar(toolbar, true, getResources().getString(R.string.add_channel));
        channelView = (RecyclerView) findViewById(R.id.channel_content_recycler_view);
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), AppConstant.CHANNEL_COLUMNS);
        channelView.setLayoutManager(manager);
        final NewsChannelAdapter adapter = new NewsChannelAdapter(myChannels, otherChannels);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == NewsChannelAdapter.MY_CHANNEL || viewType == NewsChannelAdapter.OTHER_CHANNEL ? 1 : AppConstant.CHANNEL_COLUMNS;
            }
        });
        channelView.setAdapter(adapter);
    }


}
