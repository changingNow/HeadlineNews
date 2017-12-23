package com.lw.headlinenews.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lw.headlinenews.BR;
import com.lw.headlinenews.R;
import com.lw.headlinenews.databinding.MyChannelBinding;
import com.lw.headlinenews.databinding.MyChannelHeaderBinding;
import com.lw.headlinenews.databinding.OtherChannelBinding;
import com.lw.headlinenews.databinding.OtherChannelHeaderBinding;
import com.lw.headlinenews.dbmodel.NewsTabItems;
import com.lw.headlinenews.viewHolder.BaseDataBindingViewHolder;

import java.util.List;

/**
 * Created by lw on 17-12-21.
 */

public class NewsChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final String TAG = "NewsChannelAdapter";

    private final List<NewsTabItems> myChannels;
    private final List<NewsTabItems> otherChannels;
    private final int COUNT_ONLY_MY_CHANNEL_HEADER = 1;
    private final int COUNT_BOTH_CHANNEL_HEADER = COUNT_ONLY_MY_CHANNEL_HEADER + 1;

    //the type for different position
    public static final int MY_CHANNEL_HEADERS = 1;
    public static final int MY_CHANNEL = 2;
    public static final int OTHER_CHANNEL_HEADERS = 3;
    public static final int OTHER_CHANNEL = 4;
    private boolean isEditMode = false;
    private TextView editAndSure;


    public NewsChannelAdapter(List<NewsTabItems> myChannels, List<NewsTabItems> otherChannels) {
        this.myChannels = myChannels;
        this.otherChannels = otherChannels;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {//我的频道标题
            return MY_CHANNEL_HEADERS;
        } else if (position == myChannels.size() + 1) {// 影藏频道标题
            return OTHER_CHANNEL_HEADERS;
        } else if (position > 0 && position < myChannels.size() + 1) { //我的频道
            return MY_CHANNEL;
        } else {//影藏频道
            return OTHER_CHANNEL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case MY_CHANNEL_HEADERS:
                View view = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.my_channel_header, parent, false);
                return new MyChannelHeaderHolder((MyChannelHeaderBinding) DataBindingUtil.bind(view));
            case MY_CHANNEL:
                View view1 = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.my_channel, parent, false);
                return new MyChannelHolder((MyChannelBinding) DataBindingUtil.bind(view1));
            case OTHER_CHANNEL_HEADERS:
                View view2 = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.other_channel_header, parent, false);
                return new OtherChannelHeaderHolder((OtherChannelHeaderBinding) DataBindingUtil.bind(view2));
            case OTHER_CHANNEL:
                View view3 = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.other_channel, parent, false);
                return new OtherChannelHolder((OtherChannelBinding) DataBindingUtil.bind(view3));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyChannelHeaderHolder) {
            handleEventForMyChannelHeaderVH((MyChannelHeaderHolder) holder);
        } else if (holder instanceof MyChannelHolder) {
            handleEventForMyChannelVH(holder, position);

        } else if (holder instanceof OtherChannelHolder) {
            handleEventForOtherChannelVH(holder, position);
        }
    }

    private void handleEventForMyChannelHeaderVH(MyChannelHeaderHolder holder) {
        MyChannelHeaderBinding binding = holder.view;
        binding.executePendingBindings();
        editAndSure = binding.editAndSure;
        editAndSure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!isEditMode) {
                    switchToEditMode();
                } else {
                    confirmAndSave();
                }
            }
        });
    }

    private void handleEventForMyChannelVH(RecyclerView.ViewHolder holder, final int position) {
        final MyChannelBinding binding = ((MyChannelHolder) holder).view;
        final int myChannelPosition = position - COUNT_ONLY_MY_CHANNEL_HEADER;
        final NewsTabItems item = myChannels.get(myChannelPosition);
        binding.setVariable(BR.channelItem, item);
        binding.executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isEditMode) {
                    myChannels.remove(myChannelPosition);
                    otherChannels.add(0, item);
                    notifyItemMoved(position, myChannels.size() + COUNT_ONLY_MY_CHANNEL_HEADER);
                    notifyDataSetChanged();
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                if (!isEditMode) {
                    switchToEditMode();
                }
                return true;
            }
        });
    }

    private void handleEventForOtherChannelVH(RecyclerView.ViewHolder holder, final int position) {
        OtherChannelBinding binding = ((OtherChannelHolder) holder).view;
        final int otherChannelPosition = position - myChannels.size() - COUNT_BOTH_CHANNEL_HEADER;
        final NewsTabItems otherChannelItem = otherChannels.get(otherChannelPosition);
        binding.setOtherChannelItem(otherChannelItem);
        binding.executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("tag", "====OtherChannelBinding====" + otherChannelItem.getTabItemName() + " /other po " + otherChannelPosition + "//or:" + position);
                if (!isEditMode) {
                    otherChannels.remove(otherChannelPosition);
                    otherChannelItem.setEditing(false);
                    myChannels.add(otherChannelItem);
                    notifyItemMoved(position, myChannels.size() + COUNT_ONLY_MY_CHANNEL_HEADER);
                    notifyDataSetChanged();
                }
            }
        });
    }

    private void confirmAndSave() {
        isEditMode = false;
        editAndSure.setText(R.string.channel_edit);
        for (NewsTabItems item : myChannels) {
            item.setEditing(false);
        }
    }

    private void switchToEditMode() {
        isEditMode = true;
        editAndSure.setText(R.string.ok);
        for (NewsTabItems item : myChannels) {
            item.setEditing(true);
        }
    }

    @Override
    public int getItemCount() {
        return (myChannels == null ? 0 : myChannels.size()) + (otherChannels == null ? 0 : otherChannels.size()) + COUNT_BOTH_CHANNEL_HEADER;
    }

    public boolean canExit() {
        return !isEditMode;
    }

    public void saveChannelInfo() {
        for (NewsTabItems item : myChannels) {
            item.setIsEnable(1);
            item.update();
        }
        for (NewsTabItems item : otherChannels) {
            item.setIsEnable(0);
            item.update();
        }
    }


    class MyChannelHeaderHolder extends BaseDataBindingViewHolder<MyChannelHeaderBinding> {
        public MyChannelHeaderHolder(MyChannelHeaderBinding view) {
            super(view);
        }
    }

    class MyChannelHolder extends BaseDataBindingViewHolder<MyChannelBinding> {
        public MyChannelHolder(MyChannelBinding view) {
            super(view);
        }
    }

    class OtherChannelHeaderHolder extends BaseDataBindingViewHolder<OtherChannelHeaderBinding> {
        public OtherChannelHeaderHolder(OtherChannelHeaderBinding view) {
            super(view);
        }
    }

    class OtherChannelHolder extends BaseDataBindingViewHolder<OtherChannelBinding> {
        public OtherChannelHolder(OtherChannelBinding view) {
            super(view);
        }
    }


}
