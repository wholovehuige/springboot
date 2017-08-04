package com.study.utils.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/7.
 */
public class ImageTrans {
    private Font font = new Font("H-冬青黑体传统中文-W3", Font.PLAIN, 30);// 添加字体的属性设置
    private Font font1 = new Font("H-冬青黑体传统中文-W3", Font.PLAIN, 24);// 添加字体的属性设置
    private Font font2 = new Font("H-冬青黑体传统中文-W3", Font.PLAIN, 20);// 添加字体的属性设置

    private Graphics2D g = null;

    private int fontsize = 0;

    private int x = 0;

    private int y = 0;

    public BufferedImage modifyImagetogeter(String type, BufferedImage hospitalName, BufferedImage codeImages, BufferedImage docImage, BufferedImage imageSource) {

        try {
            //二维码
            int w0 = codeImages.getWidth();
            int h0 = codeImages.getHeight();
            //头像
            int w1 = docImage.getWidth();
            int h1 = docImage.getHeight();
            //源图片的宽度和高度
            int w2 = imageSource.getWidth();
            int h2 = imageSource.getHeight();
            //医院
            int w3 = hospitalName.getWidth();
            int h3 = hospitalName.getHeight();


            g = imageSource.createGraphics();
            g.drawImage(hospitalName, (w2 / 2) - (w3 / 2), 300, w3, h3, null);
            g.drawImage(docImage, 313, 105, 120, 120, null);
            if ("app".equals(type)) {
                g.drawImage(codeImages, 190, 520, 370, 370, null);
            } else if ("code".equals(type)) {
                g.drawImage(codeImages, 190, 520, 370, 370, null);
            }

            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return imageSource;
    }

    /**
     * 从url链接中获取图片
     *
     * @param imgName
     * @return
     */
    public BufferedImage loadImageUrl(String imgName) {
        try {
            URL url = new URL(imgName);
            return ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 向图片中写入文字
     *
     * @param img
     * @param content
     * @param x
     * @param y
     * @param type
     * @return
     */
    public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y, String type) {

        try {
            int len = content.toString().length() * 12;
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
//            g.setColor(Color.black);//设置字体颜色
            if ("docName".equals(type)) {
                if (this.font != null) {
                    Color color1 = new Color(9, 9, 9);
                    g.setColor(color1);
                    g.setFont(this.font);
                    if (x >= h || y >= w) {
                        this.x = h - this.fontsize + 2;
                        this.y = w;
                    } else {
                        this.x = w / 2 - len / 2 - 28;
                        this.y = h / 5;
                    }
                }
            } else if ("docHospital".equals(type)) {
                if (this.font1 != null) {
                    g.setColor(Color.darkGray);
                    g.setFont(this.font1);
                    if (x >= h || y >= w) {
                        this.x = h - this.fontsize - 2;
                        this.y = w;
                    } else {
                        this.x = w / 2 - len / 2 - 16;
                        this.y = (24 * h) / 100;
                    }
                }
            } else if ("depart".equals(type)) {
                if (this.font2 != null) {
                    Color color2 = new Color(81, 81, 81);
                    g.setColor(color2);
                    g.setFont(this.font2);
                    if (x >= h || y >= w) {
                        this.x = h - this.fontsize + 2;
                        this.y = w;
                    } else {
                        this.x = (39 * w) / 100;
                        this.y = (28 * h) / 100;
                    }
                }
            } else if ("title".equals(type)) {
                if (this.font2 != null) {
                    Color color2 = new Color(81, 81, 81);
                    g.setColor(color2);
                    g.setFont(this.font2);
                    if (x >= h || y >= w) {
                        this.x = h - this.fontsize + 2;
                        this.y = w;
                    } else {
                        this.x = (50 * w) / 100;
                        this.y = (28 * h) / 100;
                    }
                }
            } else if ("docNo".equals(type)) {
                if (this.font2 != null) {
                    g.setColor(Color.BLACK);
                    g.setFont(this.font2);
                    // 验证输出位置的纵坐标和横坐标
                    if (x >= h || y >= w) {
                        this.x = h - this.fontsize + 2;
                        this.y = w;
                    } else {
                        this.x = (47 * w) / 100;
                        this.y = (72 * h) / 100;
                    }
                }
            }
            if (content != null) {
                g.drawString(content.toString(), this.x, this.y);
            }
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    //BufferedImage  ---->byte[]
    public boolean bytesTrans(BufferedImage image, String format, OutputStream out) {
        try {
            ImageIO.write(image, format, out);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
