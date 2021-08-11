package com.pan.demo.util;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCode {
    private static final int NUMBER_OF_CHARACTERS = 6;
    private static final int NUMBER_OF_LINES = 6;
    private static final int NUMBER_OF_NOISY_POINTS = 30;

    public static String drawRandomText(int width, int height, BufferedImage verifyImg) {
        Graphics2D graphics = (Graphics2D) verifyImg.getGraphics();
        //设置画笔颜色-验证码背景色
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, width, height);
        String allNumAndLetter = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
        //存储验证码字符串
        StringBuffer code = new StringBuffer();

        //旋转原点的 x 坐标
        int x = 10;
        String ch = "";
        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
            //随机字体大小和颜色
            graphics.setFont(new Font("微软雅黑", Font.BOLD, (Math.abs(random.nextInt()) % 10 + 35)));
            graphics.setColor(getRandomColor());
            //随机选择字符
            ch = allNumAndLetter.charAt(random.nextInt(allNumAndLetter.length())) + "";
            code.append(ch);
            //设置图片旋转角度,写入字符后，反向旋转相同度数，实现旋转文字效果
            //角度小于30度
            int degree = random.nextInt() % 30;
            //正向旋转
            graphics.rotate(degree * Math.PI / 180, x, 45);
            graphics.drawString(ch, x, 45);
            //反向旋转
            graphics.rotate(-degree * Math.PI / 180, x, 45);
            x += 36;
        }
        //添加干扰线
        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            graphics.setColor(getRandomColor());
            graphics.setStroke(new BasicStroke(2.0f));
            graphics.drawLine(random.nextInt(width), random.nextInt(height),
                    random.nextInt(width), random.nextInt(height));
        }
        //添加噪点
        for (int i = 0; i < NUMBER_OF_NOISY_POINTS; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            graphics.setColor(getRandomColor());
            graphics.fillRect(x1, y1, 2, 2);
        }
        return code.toString();
    }

    private static Color getRandomColor() {
        Random random = new Random();
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return color;
    }

}
