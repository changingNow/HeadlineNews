package com.lw.headlinenews.event;

/**
 * Created by lw on 2017/12/23.
 */

public class NewsChannelSavedEvent {

    public boolean successful;

    public NewsChannelSavedEvent(boolean successful) {
        this.successful = successful;
    }
}
