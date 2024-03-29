package com.example.demo.Utils;

public class ResultUtil {

    public static <T, P> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

//    public static Result success() {
//        return success(null);
//    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}