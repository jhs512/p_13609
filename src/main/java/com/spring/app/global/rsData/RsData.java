package com.spring.app.global.rsData;

import lombok.Getter;

import java.util.Map;

@Getter
public class RsData {
    private final String resultCode;
    private final int statusCode;
    private final String msg;
    private final Map<String, Object> body;

    public RsData(Map<String, Object> body) {
        this("S-200", "성공", body);
    }

    public RsData(String resultCode, String msg, Map<String, Object> body) {
        this.resultCode = resultCode;
        this.statusCode = Integer.parseInt(resultCode.split("-", 2)[1]);
        this.msg = msg;
        this.body = body;
    }
}