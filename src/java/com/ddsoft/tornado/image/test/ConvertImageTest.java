package com.ddsoft.tornado.image.test;

import com.ddsoft.tornado.core.image.ImageAnalyzerUtil;

public class ConvertImageTest 
{
	public static void main(String[] args) 
	{
		//String sourceImagePath = "D:/image/Jellyfish.JPG";
		String sourceImagePath = "D:\\image\\New folder\\New folder\\Lighthouse.jpg";
		//Convert the image into text file
		ImageAnalyzerUtil.convertImageToText(sourceImagePath);
		
		//Convert the image text file back into actual image file
		//ImageAnalyzerUtil.convertTextToImage("D:/image/Jellyfish.txt");
		ImageAnalyzerUtil.convertTextToImage("D:\\image\\New folder\\Lighthouse.txt");
                
	}

}

