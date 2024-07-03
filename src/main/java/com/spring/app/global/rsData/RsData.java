package com.spring.app.global.rsData;

import lombok.Getter;

@Getter
public class RsData<T> {
    private final String resultCode;
    private final int statusCode;
    private final String msg;
    private final T body;

    public RsData(T body) {
        this("S-200", "성공", body);
    }

    public RsData(String resultCode, String msg, T body) {
        this.resultCode = resultCode;
        this.statusCode = Integer.parseInt(resultCode.split("-", 2)[1]);
        this.msg = msg;
        this.body = body;
    }
}