package com.youyue.test.regular;

/**
 * Created by dllo on 17/11/20.
 */
public class Regular {

    /**
     * 正则判断手机号
     * @param phone 手机号
     */
    public boolean phone(String phone){

        String regex = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

        return phone.matches(regex);

    }

    /**
     * 正则判断电子邮箱
     * @param email 电子邮箱
     */
    public boolean email(String email){



        return true;

    }



}
