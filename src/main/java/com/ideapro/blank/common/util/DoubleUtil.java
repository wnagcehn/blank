package com.ideapro.blank.common.util;

/**
 * Double工具类
 *
 * @author wangchen870
 *         createAt 2019/4/24
 *         updateAt 2019/4/24
 */
public class DoubleUtil {
    /**
     * 判断Double类型数据是否为空值
     * @param d double参数
     * @return
     * null -> true
     * 0 -> true   0.0 -> true  -0.0 -> true
     * 其他返回 false
     */
    public static boolean isBlank(Double d){

        if(d == null){
            return true;
        }
        else if(d == 0){
            return true;
        }
        return false;
    }

    /**
     * 判断Integer类型数据是否为空值
     * @param d 整数
     * @return
     * null -> true
     * 0 -> true   0.0 -> true  -0.0 -> true
     * 其他返回 false
     */
    public static boolean isBlank(Integer d){

        if(d == null){
            return true;
        }
        else if(d == 0){
            return true;
        }
        return false;
    }
}
 
