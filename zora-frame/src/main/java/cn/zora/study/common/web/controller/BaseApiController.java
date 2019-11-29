package cn.zora.study.common.web.controller;

import cn.zora.study.common.constance.ResultPattern;
import cn.zora.study.common.web.ResultMsg;

/**
 * <h3>study</h3>
 * <p>封装的控制器</p>
 *
 * @author : zora
 * @date : 2019/11/28
 */
public abstract class BaseApiController {
    protected ResultMsg ok() {
        return ResultMsg.success();
    }

    protected ResultMsg ok(String message) {
        return ResultMsg.success(message);
    }

    protected ResultMsg ok(Object data) {
        return ResultMsg.success(data);
    }

    protected ResultMsg ok(String message, Object data) {
        return ResultMsg.success(message, data);
    }

    /**
     * 手动设定返回消息
     *
     * @param pattern 返回状态机
     * @param message 消息
     * @return 返回内容
     */
    protected ResultMsg special(ResultPattern pattern, String message) {
        return ResultMsg.special(pattern, message);
    }

    protected ResultMsg fail() {
        return ResultMsg.fail();
    }

    protected ResultMsg fail(String message) {
        return ResultMsg.fail(message);
    }

    /**
     * 无权限
     *
     * @return 无权限
     */
    protected ResultMsg unauthorized() {
        return ResultMsg.unauthorized();
    }

    /**
     * 参数错误
     *
     * @return 参数错误
     */
    protected ResultMsg wrongParam() {
        return ResultMsg.wrongParam();
    }

    /**
     * 系统异常
     *
     * @return 系统异常
     */
    protected ResultMsg systemException() {
        return ResultMsg.systemException();
    }
}
