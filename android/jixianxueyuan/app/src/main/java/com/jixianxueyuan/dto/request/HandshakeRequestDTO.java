package com.jixianxueyuan.dto.request;

import java.io.Serializable;

/**
 * Created by pengchao on 8/21/15.
 */
public class HandshakeRequestDTO implements Serializable {

    private Long userId;
    private String hobbyStamp;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHobbyStamp() {
        return hobbyStamp;
    }

    public void setHobbyStamp(String hobbyStamp) {
        this.hobbyStamp = hobbyStamp;
    }
}
