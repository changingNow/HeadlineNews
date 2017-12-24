package com.lw.headlinenews.module.news.channel;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lw.commonUtils.ToastUtils;
import com.lw.headlinenews.R;
import com.lw.headlinenews.adapter.NewsChannelAdapter;
import com.lw.headlinenews.base.BaseActivity;
import com.lw.headlinenews.dbmodel.NewsTabItems;
import com.lw.headlinenews.event.NewsChannelSavedEvent;
import com.lw.headlinenews.helper.TabItemsHelper;
import com.lw.headlinenews.utils.AppConstant;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AddChannelActivity extends BaseActivity {

    private RecyclerView channelView;
    private List<NewsTabItems> myChannels;
    private List<NewsTabItems> otherChannels;
    private NewsChannelAdapter adapter;

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
        adapter = new NewsChannelAdapter(myChannels, otherChannels);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == NewsChannelAdapter.MY_CHANNEL || viewType == NewsChannelAdapter.OTHER_CHANNEL ? 1 : AppConstant.CHANNEL_COLUMNS;
            }
        });
        channelView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (adapter != null) {
                    if (adapter.canExit()) {
                        saveChannelInfo();
                        onBackPressed();
                    } else {
                        ToastUtils.showToast(this, R.string.make_confirm);
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    private void saveChannelInfo() {
        if (adapter != null) {
            Observable
                    .create(new ObservableOnSubscribe<Boolean>() {
                        @Override
                        public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                            if (adapter != null) {
                                List<NewsTabItems> myChannels = adapter.getMyChannels();
                                List<NewsTabItems> otherChannels = adapter.getOtherChannels();
                                for (NewsTabItems item : myChannels) {
                                    item.setIsEnable(1);
                                    item.update();
                                }
                                for (NewsTabItems item : otherChannels) {
                                    item.setIsEnable(0);
                                    item.update();
                                }
                                e.onNext(true);
                            }
                            e.onNext(false);
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Boolean>() {
                        @Override
                        public void accept(Boolean b) throws Exception {
                            if (b) {
                                EventBus.getDefault().post(new NewsChannelSavedEvent(true));
                            } else {
                                EventBus.getDefault().post(new NewsChannelSavedEvent(false));
                            }
                        }
                    });
        }
    }
}
