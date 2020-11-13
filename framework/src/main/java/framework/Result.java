package framework;

import lombok.Data;

/**
 * @author sunxiaoyu3
 * @description 返回数据类
 * @createTime 2020/11/05 20:20:00
 */
@Data
public class Result<T> {
    /**
     * 操作 是否成功   0:失败  1：成功
     */
    private boolean success;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回附加信息 可以是String、List、JSON、Map 类型
     */
    private T data;

    /**
     * 返回码
     */
    private Integer code;

    private Result() {

    }

    public Result(boolean success) {
        this.success = success;
        if (success) {
            this.setMessage("操作成功");//操作成功
        } else {
            this.setMessage("操作失败");//操作失败
        }
    }

    public Result(boolean b, String message) {
        super();
        this.success = b;
        this.message = message;
    }

    public Result(boolean b, T data) {
        super();
        this.success = b;
        this.message = b ? "操作成功" : "操作失败";
        this.data = data;
    }

    public Result(boolean b, String message, T data) {
        super();
        this.success = b;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> buildSuccessResult(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }


    public static <T> Result<T> buildSuccessResult(T content) {
        Result<T> result = new Result<>();
        result.success(content);
        return result;
    }


    public static <T> Result<T> buildSuccessResult(T content, String message) {
        Result<T> result = buildSuccessResult(content);
        result.setMessage(message);
        return result;
    }


    public static <T> Result<T> buildSuccessResult(T content, String message, Integer code) {
        Result<T> result = buildSuccessResult(content);
        result.setMessage(message);
        result.setCode(code);
        return result;
    }


    public static <T> Result<T> buildFailResult(String message) {
        Result<T> result = new Result<>();
        result.fail(message == null ? "操作失败." : message);
        return result;
    }


    public static <T> Result<T> buildFailResult(T data, String message) {
        Result<T> result = buildFailResult(message);
        result.setData(data);
        return result;
    }

    public void success(T data) {
        this.success = true;
        this.data = data;
    }

    public void success(T data, String message) {
        this.success = true;
        this.data = data;
        this.message = message;
    }

    public void fail(String message) {
        this.setSuccess(false);
        this.setMessage(message);
    }
}
