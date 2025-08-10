package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Token;

public class TokenDTO {

    private Long id;
    private String token;
    private boolean logout;

    public TokenDTO(Token token) {
        this.id = token.getId();
        this.token = token.getToken();
        this.logout = token.isLogout();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isLogout() {
        return logout;
    }

    public void setLogout(boolean logout) {
        this.logout = logout;
    }
}
