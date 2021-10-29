package com.ddsoft.tornado.image.test;


import com.ddsoft.tornado.core.image.ImageAnalyzerUtil;

public class MinimizeImageSizeTest 
{
	public static void main(String[] args) throws Exception
	{
		String originalImageSrcPath = "D:/image/Jellyfish.JPG";
		ImageAnalyzerUtil.convertImageToText(originalImageSrcPath);
		ImageAnalyzerUtil.convertTextToImage("D:/image/Jellyfish.txt");
	}
}