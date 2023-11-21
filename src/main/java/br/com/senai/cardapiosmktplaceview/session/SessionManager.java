package br.com.senai.cardapiosmktplaceview.session;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
