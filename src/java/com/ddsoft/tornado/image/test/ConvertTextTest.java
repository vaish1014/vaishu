package com.ddsoft.tornado.image.test;

import com.ddsoft.tornado.core.image.ImageAnalyzerUtil;

public class ConvertTextTest 
{
	public static void main(String[] args) 
	{
		//String sourceImagePath = "D:/image/Jellyfish.JPG";
		//String sourceImagePath = "D:\\image\\New folder\\New folder\\Lighthouse.jpg";
		String sourceImagePath1 = "D:\\image\\New folder\\New folder\\Lighthouse.txt";
		//Convert the image into text file
		//ImageAnalyzerUtil.convertImageToText(sourceImagePath);
                //System.out.println("The Text is"+sourceImagePath);
                ImageAnalyzerUtil.convertTextToImage(sourceImagePath1);
                System.out.println("The Image is"+sourceImagePath1);
                
	}

}

