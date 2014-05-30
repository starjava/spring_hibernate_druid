package com.spring.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ConverImages {
	public static int DEFAULT_IMAGE_WIDTH = 1024;
	public static int DEFAULT_IMAGE_HEIGHT = 768;
	public static void main(String[] args) {
		try {
	      
			Map<String,String> map=new HashMap<String,String>();
			Map<String,String> map1=new HashMap<String,String>();
			map.put("1", "1");
			map.put("2", "2");
			map1.put("1", "1");
			map1.put("2", "2");
			System.out.println(map.hashCode()+"---map1 hascode="+map1.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * html转换为ｊｐｅｇ文件
	 * 
	 * @param bgColor
	 *            图片的背景色
	 * @param html
	 *            html的文本信息
	 * @param width
	 *            显示图片的Ｔｅｘｔ容器的宽度
	 * @param height
	 *            显示图片的Ｔｅｘｔ容器的高度
	 * @param eb
	 *            設置容器的边框
	 * @return
	 * @throws Exception
	 */
	private static ArrayList<String> html2jpeg(Color bgColor, String html,EmptyBorder eb,String filepath) throws Exception {
		ArrayList<String> ret = new ArrayList<String>();
		try {
			JTextPane tp = new JTextPane();
			tp.setSize(DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
			if (eb == null) {
				eb = new EmptyBorder(0, 50, 0, 50);
			}
			if (bgColor != null) {
				tp.setBackground(bgColor);
			}
			tp.setBorder(eb);
			tp.setContentType("text/html");
			tp.setText(html);
			PrintView m_printView = new PrintView(tp);
			int pageIndex = 1;
			boolean bcontinue = true;
			while (bcontinue) {
				BufferedImage image = new java.awt.image.BufferedImage(DEFAULT_IMAGE_WIDTH,
						DEFAULT_IMAGE_HEIGHT, java.awt.image.BufferedImage.TYPE_INT_RGB);
				Graphics g = image.getGraphics();
				g.setClip(0, 0, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
				bcontinue = m_printView.paintPage(g, DEFAULT_IMAGE_HEIGHT, pageIndex);
				g.dispose();
				String path = toJpeg(image,filepath);
				ret.add(path);
				pageIndex++;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return ret;
	}

	/**
	 * 将ＢｕｆｆｅｒｅｄＩｍａｇｅ转换为图片的信息
	 * 
	 * @param image
	 * @return
	 */
	public static String toJpeg(BufferedImage image,String filePath) {
		// 获取图片文件的在服务器的路径
		String imageName = filePath+System.currentTimeMillis()+".jpg";
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
			param.setQuality(1.0f, false);
			encoder.setJPEGEncodeParam(param);
			encoder.encode(image);
			byte[] buff = baos.toByteArray();
			baos.close();
			// 将字节流写入文件保存为图片
			FileUtils.writeByteArrayToFile(new File(imageName), buff);
			System.out.println("保存成功!....");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("保存删除图片失败:" + ex.getMessage());
		}
		return imageName;
	}

	public static StringBuilder getHtmlContent(String url,String encode){
		StringBuilder content=new StringBuilder();
		try {
			URL u=new URL(url);
			InputStream input=new BufferedInputStream(u.openStream());
			InputStreamReader htmlread=new InputStreamReader(input,encode);
			int end=0;
			while((end=htmlread.read())!=-1){
				content.append((char)end);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return content;	
	}
//	protected static void generateOutput(String url,String filename) throws Exception {  
//		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
//		imageGenerator.loadUrl(url);
//		imageGenerator.saveAsImage(filename);
//		 
//    }  
}
