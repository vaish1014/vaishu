package com.ddsoft.tornado.image.test;

import com.ddsoft.tornado.core.image.ImageAnalyzerUtil;

public class HideDataTest 
{
	public static void main(String[] args)
	{
		String secretData = "It contains all my secret materials and my bank information details";
		String destinationImathPath = "D:/image/secretImage.jpg";
		//Hide the information inside the image
		ImageAnalyzerUtil.hideTextDataInsideImage(destinationImathPath,secretData);
		//Get back the data hidden inside an image
		String hiddenData = ImageAnalyzerUtil.getHiddenDataFromImage(destinationImathPath);
		System.out.println(hiddenData);
	}

}