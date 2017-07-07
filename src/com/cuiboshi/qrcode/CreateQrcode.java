package com.cuiboshi.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

import com.swetake.util.Qrcode;
/**
 * 生成二维码
 * @author Administrator
 *
 */
public class CreateQrcode{

	public static void main(String[] args) throws Exception {
		
		final int version = 7; //版本号(1-40)
		
		//创建二维码的一个类
		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M');//纠错等级
		x.setQrcodeEncodeMode('B');//N代表的是数字,A代表a-Z,B代表其他字符
		x.setQrcodeVersion(version);//版本号(1-40)
		
		String qrDate = "刘子凯";//扫描二维码会发生的内容
		
		//创建一个缓冲区的图片(三个参数是:1.图片宽	2.图片高		3.图片的类型)
		int width = 67 + 12 * (version - 1);//宽高不能设置为固定的数值,计算方法为:  67 + 12 * (当前setQrcodeVersion(7)版本号 - 1)
		int height = 67 + 12 * (version - 1);
		BufferedImage bufferedImage = 
				new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建使用Java的2D画图工具
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);//定义背景颜色为白色
		gs.setColor(Color.BLACK);//定义颜色为黑色
		gs.clearRect(0, 0, width, height);//清除画板的内容
		
		int pixoff = 2;//偏移量
		
		//向画板中填充内容
		byte[] d = qrDate.getBytes("gb2312");//把填充的内容转换成byte数组的字节数,如果有汉字的话需要添加"gb2312"
		if(d.length>0 && d.length<120){
			boolean[][] s = x.calQrcode(d);
			for(int i=0;i<s.length;i++){
				for(int j=0;j<s.length;j++){
					if(s[j][i]){
						gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);//刷新填充的内容
					}
				}
			}
		}
		
		gs.dispose();//结束写入
		bufferedImage.flush();//清空图片缓存区
		//把二维码输出(三个参数分别是:1.要输出的内容	2.输出内容的格式	3.输出到哪里(输出位置))
		ImageIO.write(bufferedImage, "png", new File("F:/生成的二维码/qrcode.png"));
	}
	
}
