package com.example.caijie;

import java.util.UUID;

/**
 * Created by caijie on 16/3/24.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public UUID getmId() {

        return mId;
    }
}
