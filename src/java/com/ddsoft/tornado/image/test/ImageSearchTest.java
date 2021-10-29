package com.ddsoft.tornado.image.test;

import com.ddsoft.tornado.core.image.ImageAnalyzerUtil;

public class ImageSearchTest 
{
	public static void main(String[] args) 
	{
		try
		{
			String photoPath = "photos";
			String searchPhotoPath = "data/PhotoToSearch.JPG";
			//Search the image inside the directory of images
			boolean searchFlag = ImageAnalyzerUtil.searchImage(searchPhotoPath, photoPath);
			if( searchFlag )
				System.out.println("Image Found");
			else
				System.out.println("Specified Image Not Found");
			//Search and get the full path of the image inside a directory of images
			System.out.println("Found Image Name----->"+ImageAnalyzerUtil.searchAndGetImageName(searchPhotoPath, photoPath));
			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

}