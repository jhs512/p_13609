package com.spring.app.global.rsData;

import lombok.Getter;

@Getter
public class RsData<T> {
    private final String resultCode;
    private final int statusCode;
    private final String msg;
    private final T body;

    private RsData(T body) {
        this("S-200", "성공", body);
    }

    private RsData(String resultCode, String msg, T body) {
        this.resultCode = resultCode;
        this.statusCode = Integer.parseInt(resultCode.split("-", 2)[1]);
        this.msg = msg;
        this.body = body;
    }

    public static <T> RsData<T> of(T body) {
        return new RsData<>(body);
    }

    public static <T> RsData<T> of(String resultCode, String msg, T body) {
        return new RsData<>(resultCode, msg, body);
    }
}