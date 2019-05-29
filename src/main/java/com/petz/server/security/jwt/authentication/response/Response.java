package com.petz.server.security.jwt.authentication.response;

public class Response {
    private String token;
    private String type = "Bearer";

    public Response(String accessToken) {
        this.token = accessToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

   public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}
