package cn.zora.study.common.handler;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import org.apache.ibatis.reflection.MetaObject;

/**
 * <h3>study</h3>
 * <p>公共字段填充处理器</p>
 *
 * @author : zora
 * @date : 2019/11/28
 */
public class FillCommonFieldsHandler implements MetaObjectHandler {
    /**
     * 插入操作时填充
     *
     * @param metaObject 元数据
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object id = getFieldValByName("id", metaObject);
        Object insertTime = getFieldValByName("insertTime", metaObject);
        if (id == null) {
            setFieldValByName("id", UUID.fastUUID().toString(), metaObject);
        }
        if (insertTime == null) {
            setFieldValByName("insertTime", UUID.fastUUID().toString(), metaObject);
        }
    }

    /**
     * 插入操作时填充
     *
     * @param metaObject 元数据
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            setFieldValByName("updateTime", UUID.fastUUID().toString(), metaObject);
        }
    }

    /**
     * 利用MyBatisPlus获取表名
     *
     * @param metaObject 元数据
     * @return 表名
     */
    private String getTableName(MetaObject metaObject) {
        Object object = metaObject.getOriginalObject();
        Class<?> clazz = object.getClass();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(clazz);
        return tableInfo.getTableName();
    }
}
