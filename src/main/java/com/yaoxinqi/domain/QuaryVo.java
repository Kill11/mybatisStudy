package com.yaoxinqi.domain;

import com.yaoxinqi.domain.User;

public class QuaryVo {
    private User user;

    public QuaryVo(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
