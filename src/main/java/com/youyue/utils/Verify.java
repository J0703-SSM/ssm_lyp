package com.youyue.utils;

import com.youyue.utils.vcode.VerifyCode;

import java.awt.image.BufferedImage;

/**
 * Created by dllo on 17/11/11.
 */
public class Verify {

    public void a(){

        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
//        VerifyCode.output(image,response.getOutputStream());

    }

}
