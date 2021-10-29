
package com.ddsoft.tornado.core.image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;

/**
 * This class contains the following utility methods.
 * <p>
 * <li> Utility Method to read converted image text file </li>
 * <li> Utility method to write the image as text file </li>
 * <li> Utility method to get the image contents as String </li>
 * <li> Utility method hide the text data inside an image </li>
 * <li> Utility method get the hidden data from an image </li>
 * <li> Utility method to search a particular image inside a directory </li>
 * <li> Utility method to search and to obtain the full path of an image </li>
 * <li> Utility method to convert an image into a text file </li>
 * <li> Utility method to convert a text back into image </li>
 * @author Debadatta Mishra(PIKU)
 *
 */
public class ImageAnalyzerUtil 
{
	/**
	 * String type constant to define the image type.
	 */
	private static String IMAGE_TYPE = "jpg";
	/**
	 * An extra String that separates the image data and the secret information data
	 */
	private static String extraStr = "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@";

	/**
	 * This method is used to read the contents of a text( converted from image ) file
	 * and provides byte[].
	 * @param imageTextFilePath of type String indicating the path of the text file
	 * @return an array of bytes
	 * @author Debadatta Mishra(PIKU)
	 */
	public static byte[] readImageTextFile( String imageTextFilePath )
	{
		byte[] dataFile = null;
		try
		{
			StringBuffer textData = new StringBuffer();
			FileInputStream fstream = new FileInputStream(imageTextFilePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String srtData;
			while ((srtData = br.readLine()) != null) {
				textData.append(srtData);
			}
			br.close();
			fstream.close();
			in.close();
			dataFile = new sun.misc.BASE64Decoder().decodeBuffer(textData.toString());
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return dataFile;
	}
	
	/**
	 * This method is used to write the contents of an image into a text file.
	 * @param filePath of type String indicating the path of the text file
	 * @param imageContents of type String indicating the image contents as String
	 * @author Debadatta Mishra(PIKU)
	 */
	public static void writeImageAsTextFile( String filePath , String imageContents )
	{
		FileOutputStream fout=null;
		OutputStreamWriter osw = null;
		OutputStream bout = null;
		try
		{
			fout = new FileOutputStream (filePath);
			bout= new BufferedOutputStream(fout);
			osw = new OutputStreamWriter(bout, "utf-8");
			osw.write(imageContents);
			bout.close();
			osw.close();
			fout.close();
		}
		catch( Exception e )
		{System.out.print("chiru"+e);
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the image contents as String.
	 * @param imagePath of type String indicating the path of image file
	 * @return a String of image contents
	 * @author Debadatta Mishra(PIKU)
	 */
	public static String getImageAsString( String imagePath )
	{
		String imageString = null;
		try
		{
			File f = new File(imagePath);
			BufferedImage buffImage = ImageIO.read(f);
                        System.out.print("suganya"+buffImage.toString());
			ByteArrayOutputStream os= new ByteArrayOutputStream();
			ImageIO.write(buffImage, IMAGE_TYPE, os);
			byte[] data= os.toByteArray();
			imageString = new sun.misc.BASE64Encoder().encode(data);
		}
		catch( FileNotFoundException fnfe )
		{
			fnfe.printStackTrace();
			System.out.println("Image is not located in the proper path.");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Error in reading the image.");
		}
		return imageString;
	}
	
	/**
	 * This method is used to hide the data contents inside the image.
	 * @param srcImagePath of type String indicating the path of the source image
	 * @param dataContents of type String containing data
	 * @author Debadatta Mishra(PIKU)
	 */
	public static void hideTextDataInsideImage( String srcImagePath , String dataContents )
	{
		try 
		{
			dataContents = new sun.misc.BASE64Encoder().encode(dataContents.getBytes());
			extraStr = new sun.misc.BASE64Encoder().encode(extraStr.getBytes());
			FileOutputStream fos = new FileOutputStream( srcImagePath , true );
			fos.write(new sun.misc.BASE64Decoder().decodeBuffer(extraStr.toString()));
			fos.write( dataContents.getBytes() );
			fos.close();
		}
		catch( FileNotFoundException fnfe )
		{
			fnfe.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the hidden data from an image.
	 * @param imagePath of type String indicating the path of the image
	 * which contains the hidden data
	 * @return the String containing hidden data inside an image
	 * @author Debadatta Mishra(PIKU)
	 */
	public static String getHiddenDataFromImage( String imagePath )
	{
		String dataContents = null;
		try
		{
			File file = new File( imagePath );
			byte[] fileData = new byte[ (int)file.length()];
			InputStream inStream = new FileInputStream( file );
			inStream.read(fileData);
			inStream.close();
			String tempFileData = new String(fileData);
			String finalData = tempFileData.substring(tempFileData
					.indexOf(extraStr)
					+ extraStr.length(), tempFileData.length());
			byte[] temp = new sun.misc.BASE64Decoder().decodeBuffer(finalData);
			dataContents = new String(temp);
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return dataContents;
	}

	/**
	 * This method is used to search a particular image in a image directory.
	 * In this method, it will search for the image contents for the image
	 * you are passing.
	 * @param imageToSearch of type String indicating the file name of the image
	 * @param imageFolderToSearch of type String indicating the name of the directory
	 * which contains the images
	 * @return true if image is found else false
	 * @author Debadatta Mishra(PIKU)
	 */
	public static boolean searchImage( String imageToSearch , String imageFolderToSearch )
	{
		boolean searchFlag = false;
		try
		{
			String searchPhotoStr = getImageAsString(imageToSearch);
			File files = new File( imageFolderToSearch );
			File[] photosFiles = files.listFiles();
			for( int i = 0 ; i < photosFiles.length ; i++ )
			{
				String photoFilePath = photosFiles[i].getAbsolutePath();
				String photosStr = getImageAsString(photoFilePath);
				if( searchPhotoStr.equals(photosStr))
				{
					searchFlag = true;
					break;
				}
				else
				{
					continue;
				}
			}	
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return searchFlag ;
	}

	/**
	 * This method is used to search for a particular image found in a directory
	 * and it will return the full path of the image found. Sometimes it is required
	 * to find out the particular image and the path of the image so that the path
	 * String can be used for further processing.
	 * @param imageToSearch of type String indicating the file name of the image
	 * @param imageFolderToSearch of type String indicating the name of the directory
	 * which contains the images
	 * @return the full path of the image
	 * @author Debadatta Mishra(PIKU)
	 */
	public static String searchAndGetImageName( final String imageToSearch , final String imageFolderToSearch )
	{
		String foundImageName = null;
		try
		{
			String searchPhotoStr = ImageAnalyzerUtil.getImageAsString(imageToSearch);
			File files = new File( imageFolderToSearch );
			File[] photosFiles = files.listFiles();
			for( int i = 0 , n = photosFiles.length; i < n ; i++ )
			{
				final String photoFilePath = photosFiles[i].getAbsolutePath();
				final String photosStr = ImageAnalyzerUtil.getImageAsString(photoFilePath);
				if( searchPhotoStr.equals(photosStr))
				{
					foundImageName = photosFiles[i].getAbsolutePath();
					break;
				}
				else
				{
					continue;
				}
			}	
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return foundImageName;
	}

	/**
	 * This method is used to convert an image into a text file.
	 * @param imagePath of type String indicating the path of the image file
	 * @author Debadatta Mishra(PIKU)
	 */
	public static void convertImageToText( String imagePath )
	{
		File file = new File( imagePath );
		String fileName = file.getAbsolutePath();
		String textFilePath = new StringBuilder(fileName.substring(0, fileName
				.lastIndexOf("."))).append(".txt").toString();
                System.out.print("chiru2"+textFilePath);
		writeImageAsTextFile(textFilePath, getImageAsString(imagePath));
		/*
		 * There may be requirement to delete the original image,
		 * write the code here for this purpose.
		 */
	}
	
	/**
	 * This method is used to convert the text file into image.
	 * However all text files will not be converted into images.
	 * Those text files which have been converted from images files
	 * will be converted back into image.
	 * @param imageTextFilePath of type String indicating the converted text file
	 * from image file.
	 * @author Debadatta Mishra(PIKU)
	 */
	public static void convertTextToImage( String imageTextFilePath )
	{
		try
		{
			File file = new File( imageTextFilePath );
			String fileName = file.getAbsolutePath();
			String imageFilePath = new StringBuilder(fileName.substring(0, fileName
					.lastIndexOf("."))).append(".").append(IMAGE_TYPE).toString();
			OutputStream out = new FileOutputStream( imageFilePath );
			byte[] imageBytes = readImageTextFile(imageTextFilePath);
			out.write(imageBytes);
			out.close();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

}
