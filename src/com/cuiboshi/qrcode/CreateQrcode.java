package com.cuiboshi.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

import com.swetake.util.Qrcode;
/**
 * ���ɶ�ά��
 * @author Administrator
 *
 */
public class CreateQrcode{

	public static void main(String[] args) throws Exception {
		
		final int version = 7; //�汾��(1-40)
		
		//������ά���һ����
		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M');//����ȼ�
		x.setQrcodeEncodeMode('B');//N�����������,A����a-Z,B���������ַ�
		x.setQrcodeVersion(version);//�汾��(1-40)
		
		String qrDate = "���ӿ�";//ɨ���ά��ᷢ��������
		
		//����һ����������ͼƬ(����������:1.ͼƬ��	2.ͼƬ��		3.ͼƬ������)
		int width = 67 + 12 * (version - 1);//��߲�������Ϊ�̶�����ֵ,���㷽��Ϊ:  67 + 12 * (��ǰsetQrcodeVersion(7)�汾�� - 1)
		int height = 67 + 12 * (version - 1);
		BufferedImage bufferedImage = 
				new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//����ʹ��Java��2D��ͼ����
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);//���屳����ɫΪ��ɫ
		gs.setColor(Color.BLACK);//������ɫΪ��ɫ
		gs.clearRect(0, 0, width, height);//������������
		
		int pixoff = 2;//ƫ����
		
		//�򻭰����������
		byte[] d = qrDate.getBytes("gb2312");//����������ת����byte������ֽ���,����к��ֵĻ���Ҫ���"gb2312"
		if(d.length>0 && d.length<120){
			boolean[][] s = x.calQrcode(d);
			for(int i=0;i<s.length;i++){
				for(int j=0;j<s.length;j++){
					if(s[j][i]){
						gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);//ˢ����������
					}
				}
			}
		}
		
		gs.dispose();//����д��
		bufferedImage.flush();//���ͼƬ������
		//�Ѷ�ά�����(���������ֱ���:1.Ҫ���������	2.������ݵĸ�ʽ	3.���������(���λ��))
		ImageIO.write(bufferedImage, "png", new File("F:/���ɵĶ�ά��/qrcode.png"));
	}
	
}
