package com.cuiboshi.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

/**
 * 解析二维码
 * @author Administrator
 *
 */
public class ReadQRCode {

	public static void main(String[] args) throws Exception {
		//获取文件
		File file = new File("F:/生成的二维码/qrcode.png");
		//使用图片缓冲区接收获取的文件
		BufferedImage bufferedImage = ImageIO .read(file);
		//使用QRCode里的QRCodeDecoder方法
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		//返回的是一个byte[]数组
//		codeDecoder.decode(new MyQRCodeImage(bufferedImage));
		//把 byte[] 数组转换成 String 类型
		String result = new String(codeDecoder.decode(
				new MyQRCodeImage(bufferedImage)),"gb2312");
		
		System.out.println(result);
		
	}
	
	
	
	
	
	
	
	
	
	
}
