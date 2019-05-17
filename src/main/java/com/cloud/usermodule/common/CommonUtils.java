package com.cloud.usermodule.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {


    private static final CreateUUID systemIDUtil = new  CreateUUID(1, 1);

    /**
     * 生成唯一的ID
     * @return
     */
    public static String UUIDUtil(){
        long id = systemIDUtil.generate();
        return  String.valueOf(id);
    }



    /**
     * 根据指定的格式，格式化日期
     * @param date
     * @param datepattern  格式化模式
     * @return 格式化后日期
     */
    public static String formatDate(Date date, String datepattern){
        SimpleDateFormat sf = new SimpleDateFormat(datepattern);
        return sf.format(date);
    }



    /**
     * 判断STRING value是否为空
     * @param value 参数
     * @return 为空返回True，不为空返回false
     */
    public static boolean isEmpty(String value){
        if(value == null || value.equals("")){
            return true;
        }
        return false;
    }

    /**
     * 创建Mapper的映射文件的ID
     * @param cls
     * @param mapperid
     * @return
     */
    public static String createMapperName(Class<?> cls,String mapperid){
        return cls.getName()+"."+mapperid;
    }

}
