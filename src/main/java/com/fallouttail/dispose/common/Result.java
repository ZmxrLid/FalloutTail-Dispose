package com.fallouttail.dispose.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Boolean really;

    private Object data;

    public static Result error(){
        return new Result(false,null);
    }

    public static Result suc(Object data){
        return new Result(true,data);
    }
}
