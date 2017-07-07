package com.cuiboshi.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;
/**
 * 自定义的  QRCodeImage 的实现类
 * @author Administrator
 *
 */
public class MyQRCodeImage implements QRCodeImage{
	
	BufferedImage bufferedImage;
	
	public MyQRCodeImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	//高
	@Override
	public int getHeight() {
		return bufferedImage.getHeight();
	}

	//颜色
	@Override
	public int getPixel(int arg0, int arg1) {
		return bufferedImage.getRGB(arg0, arg1);
	}

	//宽
	@Override
	public int getWidth() {
		return bufferedImage.getWidth();
	}

}
