package com.uguraldanmaz.resmin.api;

/**
 * Created by Ugur Aldanmaz on 10.01.2016 20:17.
 * https://github.com/UgurAldanmaz
 * http://bilprog.org
 * open[at]bilprog[dot]org
 */

/*
* API'den alinan cevaplarin tasinacagi sinif.
* */
public class ApiResponse<T> {

    private boolean success;
    private String errorMessage;

    private T data;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /*
    * Returns successful API call result.
    * */
    public static <T> ApiResponse<T> Ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = true;
        response.data = data;
        return  response;
    }

    public static <T> ApiResponse<T> NotOk(String errorMessage) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = false;
        response.data = null;
        response.errorMessage = errorMessage;
        return  response;
    }
}
