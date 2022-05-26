package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author zlx
 * Creat on 2022-02-14
 * 控制验证码的controller
 */
@CrossOrigin
@RestController
@RequestMapping("/codeController")
public class CodeController {
    private int width = 83;//验证码宽度
    private int height = 30;//验证码高度
    private int codeCount = 4;//验证码个数
    private int lineCount = 19;//混淆线个数
    private int fontSize = 22;//验证码字体大小

    private int x = fontSize / 2;

    char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    @RequestMapping(value = "/code/{time}", method = RequestMethod.GET)
    public void getCode(@PathVariable("time") String time, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //定义随机数类
        Random random = new Random();
        //定义存储验证码的类
        StringBuffer builderCode = new StringBuffer();
        //定义画布
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //得到画笔
        Graphics g=bufferedImage.getGraphics();
        //1、设置颜色，画边框
        g.setColor(Color.BLACK);
        g.drawRect(0,0,width,height);
        //2、设置颜色，填充内部
        g.setColor(Color.WHITE);
        g.fillRect(1,1,width-2,height-2);
        //3、设置干扰线
        g.setColor(Color.gray);
        for (int i=0;i<lineCount;i++){
            g.drawLine(random.nextInt(width),random.nextInt(width),random.nextInt(width),random.nextInt(width));
        }
        //4、设置验证码
        g.setColor(Color.BLUE);
        //4 1、设置验证码字体
        g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,fontSize));
        for (int i=0;i<codeCount;i++){
            char c=codeSequence[random.nextInt(codeSequence.length)];
            builderCode.append(c);
            g.drawString(c+"",15*(i+1),fontSize);
        }
        //5、输出到屏幕
        ServletOutputStream sos=response.getOutputStream();
        ImageIO.write(bufferedImage,"png",sos);
        //6、保存到session中
        HttpSession session=request.getSession();
        session.setAttribute("codeValidate",builderCode.toString());
        //7、禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/png");
        //8、关闭sos
        sos.close();
    }
}
