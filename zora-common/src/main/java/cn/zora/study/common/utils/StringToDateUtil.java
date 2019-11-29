package cn.zora.study.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h3>study</h3>
 * <p>字符串转日期工具</p>
 *
 * @author : zora
 * @date : 2019/11/28
 */
public class StringToDateUtil {
    /**
     * 日期格式化数组
     */
    private static DateFormat[] dateFormats = {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S"),
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("yyyy-MM-dd HH:mm"),
            new SimpleDateFormat("yyyy-MM-dd HH"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy-MM")
    };

    /**
     * <code>
     * <pre>
     * 1.如果日期字符串为空,则直接返回空
     * 2.使用格式化组进行格式化,如果解析成功,则直接返回
     * 4.否则,抛出非法参数异常
     * @param source 请求的日期参数
     * @return 解析后的日期类型:java.util.Date
     * @exception IllegalArgumentException 非法参数异常
     * </pre>
     * </code>
     */
    public static Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        source = source.trim();

        try {
            int timeLength = source.length();
            Long time = Long.parseLong(source);
            if (timeLength == 10) {
                time = time * 1000;
            }
            Date date = new Date(time);
            return date;
        } catch (Exception e) {

        }

        Date date = null;
        boolean flag = false;
        for (DateFormat dateFormat : dateFormats) {
            try {
                date = dateFormat.parse(source);
                flag = true;
                break;
            } catch (ParseException e) {
            }
        }

        if (flag) {
            return date;
        } else {
            throw new IllegalArgumentException("不能解析日期:" + source);
        }

    }
}
