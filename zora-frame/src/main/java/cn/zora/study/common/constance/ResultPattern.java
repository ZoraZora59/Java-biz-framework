package cn.zora.study.common.constance;

/**
 * <h3>study</h3>
 * <p>返回状态组合</p>
 *
 * @author : zora
 * @date : 2019/11/28
 */
public interface ResultPattern {
    /**
     * 获取状态结果
     *
     * @return 正常与否
     */
    boolean getStatus();

    /**
     * 获取状态Code
     *
     * @return 规则性编码
     */
    Integer getCode();

    /**
     * 获取消息内容
     *
     * @return Message
     */
    String getMessage();
}
