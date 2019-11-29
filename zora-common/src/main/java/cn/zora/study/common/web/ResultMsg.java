package cn.zora.study.common.web;

import cn.zora.study.common.constance.ResultCode;
import cn.zora.study.common.constance.ResultPattern;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <h3>study</h3>
 * <p>控制器返回消息</p>
 *
 * @author : zora
 * @date : 2019/11/28
 */
@ApiModel(value = "返回类型")
@Data
public class ResultMsg<T> implements Serializable {
    @ApiModelProperty(value = "状态")
    private boolean status;
    @ApiModelProperty(value = "code")
    private Integer code;
    @ApiModelProperty(value = "消息描述")
    private String message;
    @ApiModelProperty(value = "返回对象")
    private T data;

    private ResultMsg() {
    }

    public static ResultMsg special(ResultPattern pattern,String message){
        return setResult(pattern,message);
    }

    public static ResultMsg success() {
        return setResult(ResultCode.SUCCESS);
    }

    public static ResultMsg success(String message) {
        return setResult(ResultCode.SUCCESS, message);
    }

    public static ResultMsg success(String message, Object data) {
        return setResult(message, data);
    }

    public static ResultMsg success(Object data) {
        return setResult(data);
    }

    public static ResultMsg fail() {
        return setResult(ResultCode.FAIL);
    }

    public static ResultMsg fail(String message) {
        return setResult(ResultCode.FAIL, message);
    }

    public static ResultMsg unauthorized() {
        return setResult(ResultCode.UN_AUTHOR);
    }

    public static ResultMsg wrongParam() {
        return setResult(ResultCode.PARAM_ERROR);
    }

    public static ResultMsg systemException() {
        return setResult(ResultCode.SYSTEM_ERROR);
    }

    private static ResultMsg setResult(ResultPattern pattern) {
        ResultMsg result = new ResultMsg();
        result.setStatus(pattern.getStatus());
        result.setCode(pattern.getCode());
        result.setMessage(pattern.getMessage());
        return result;
    }

    private static ResultMsg setResult(ResultPattern pattern, String message) {
        ResultMsg result = new ResultMsg();
        result.setStatus(pattern.getStatus());
        result.setCode(pattern.getCode());
        result.setMessage(message);
        return result;
    }

    private static ResultMsg setResult(Object data) {
        ResultMsg result = new ResultMsg();
        result.setStatus(ResultCode.SUCCESS.getStatus());
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    private static ResultMsg setResult(String message, Object data) {
        ResultMsg result = new ResultMsg();
        result.setStatus(ResultCode.SUCCESS.getStatus());
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }

}
