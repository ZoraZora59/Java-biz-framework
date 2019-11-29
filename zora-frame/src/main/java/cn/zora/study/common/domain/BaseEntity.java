package cn.zora.study.common.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>study</h3>
 * <p>公共参数</p>
 *
 * @author : zora
 * @date : 2019/11/28
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 物理主键
     */
    @TableId(type = IdType.INPUT)
    @TableField(fill = FieldFill.INSERT)
    private long id;
    /**
     * 物理主键
     */
    @TableField(fill = FieldFill.INSERT)
    private Date insertTime;
    /**
     * 物理主键
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 乐观锁
     */
    @Version
    private int version;
}
