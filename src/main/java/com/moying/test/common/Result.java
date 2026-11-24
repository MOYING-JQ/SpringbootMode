package com.moying.test.common;

import lombok.Data;

/**
 * @author 墨莹
 * @date 2026/11/20 11:40
 */


@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200,"success",data);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(500,message,null);
    }

}


