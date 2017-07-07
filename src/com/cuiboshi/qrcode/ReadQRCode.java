package com.cuiboshi.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

/**
 * ������ά��
 * @author Administrator
 *
 */
public class ReadQRCode {

	public static void main(String[] args) throws Exception {
		//��ȡ�ļ�
		File file = new File("F:/���ɵĶ�ά��/qrcode.png");
		//ʹ��ͼƬ���������ջ�ȡ���ļ�
		BufferedImage bufferedImage = ImageIO .read(file);
		//ʹ��QRCode���QRCodeDecoder����
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		//���ص���һ��byte[]����
//		codeDecoder.decode(new MyQRCodeImage(bufferedImage));
		//�� byte[] ����ת���� String ����
		String result = new String(codeDecoder.decode(
				new MyQRCodeImage(bufferedImage)),"gb2312");
		
		System.out.println(result);
		
	}
	
	
	
	
	
	
	
	
	
	
}
