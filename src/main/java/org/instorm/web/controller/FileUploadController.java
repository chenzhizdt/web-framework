package org.instorm.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.csource.fastdfs.UploadCallback;
import org.instorm.utils.FFMpegUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;


@Controller
public class FileUploadController{
    
	private int smallImageWidth=30;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam("type")String fileType,@RequestParam("file") MultipartFile multipartFile,HttpServletRequest request) throws IOException{ 
	    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		String json="";
		String fileId="";
		String oldAddress="";
		String newAddress="";
		int smallWidth=0;
		int smallHeight=0;
		int bigWidth=0;
		int bigHeight=0;
	    TrackerClient tracker = new TrackerClient(); 
	    TrackerServer trackerServer = tracker.getConnection();  
	    StorageServer storageServer = null;  
	    String fileName=multipartFile.getOriginalFilename();
	    String extName=fileName=fileName.substring(fileName.lastIndexOf(".")+1);
	    StorageClient1 client = new StorageClient1(trackerServer, storageServer);
		final InputStream is=multipartFile.getInputStream();
	    //设置元信息  
////    NameValuePair[] metaList = new NameValuePair[3];  
////    metaList[0] = new NameValuePair("fileName", multipartFile.getOriginalFilename());  
////    metaList[1] = new NameValuePair("fileExtName", extName);  
////    metaList[2] = new NameValuePair("fileLength", String.valueOf(multipartFile.getSize()));
    //上传文件  
    	try {
			fileId=client.upload_file1("", multipartFile.getSize(), new UploadCallback() {
				@Override
				public int send(OutputStream out) throws IOException {
					int len=0;
					byte [] b=new byte[1024];
					while((len=is.read(b))!=-1){
						out.write(b, 0, len);
					}
					is.close();
					return 0;
				}

			
			},extName,null);
			if(fileId.indexOf("/")!=-1){
				oldAddress=fileId.substring(fileId.indexOf("/"));
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		if("image".equals(fileType)){
			//获得要压缩的宽度
			int width=Integer.valueOf(request.getParameter("width")).intValue();
			smallWidth=width;
			InputStream smallInputStream=multipartFile.getInputStream();
			BufferedImage originalImage = ImageIO.read(smallInputStream);
			//得到原图的宽和高
			bigWidth=originalImage.getWidth();
			bigHeight=originalImage.getHeight();
			//计算因该把图像的高压缩到色像素
			smallHeight=bigHeight*smallWidth/bigWidth;
			BufferedImage thumbnail = Thumbnails.of(originalImage)
			        .size(smallWidth, smallHeight)
			        .asBufferedImage();
			String imageName=UUID.randomUUID().toString()+extName;
			String filePath=WebUtils.getRealPath(request.getServletContext(),imageName);
			File file=new File(filePath);
			ImageIO.write(thumbnail, extName, file);
		    try {
				fileId=client.upload_file1("", filePath, extName, null);
			} catch (MyException e) {
				e.printStackTrace();
			}
			file.delete();
			if(fileId.indexOf("/")!=-1){
				newAddress=fileId.substring(fileId.indexOf("/"));
			}
			smallInputStream.close();
		}
		String firstFrame = null;
		if("video".equals(fileType)) {
			File file = new File("/tmp/" + System.currentTimeMillis());
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			InputStream fis = multipartFile.getInputStream();
			int len=0;
			byte [] b=new byte[1024];
			while((len=fis.read(b))!=-1){
				fos.write(b, 0, len);
			}
			fis.close();
			fos.flush();
			fos.close();
			FFMpegUtil ffmpeg = new FFMpegUtil("/usr/bin/ffmpeg", file.toString());
			String screenCutFilePath = file.toString() + ".jpg";
			ffmpeg.makeScreenCut(screenCutFilePath);
			final File screenCut = new File(screenCutFilePath);
			System.out.println("ScreenCut File Size: " + screenCut.length());
			System.out.println("ScreenCut File Exists: " + screenCut.exists());
			try {
				String screenCutId = client.upload_file1("", screenCut.length(), new UploadCallback() {

					@Override
					public int send(OutputStream out) throws IOException {
						int len=0;
						byte [] b=new byte[1024];
						InputStream is = new FileInputStream(screenCut);
						System.out.println("Begin Upload To FDFS");
						while((len=is.read(b))!=-1){
							out.write(b, 0, len);
						}
						is.close();
						return 0;
					}
					
				}, "jpg", null);
				if(screenCutId.indexOf("/")!=-1){
					firstFrame = screenCutId.substring(screenCutId.indexOf("/"));
				}
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		if ("image".equals(fileType)) {
			json= "{\"oldAddress\":\""+oldAddress+"\",\"bigWidth\":"+bigWidth+",\"bigHeight\":"+bigHeight+",\"newAddress\":\""+newAddress+"\",\"smallWidth\":"+smallWidth+",\"smallHeight\":"+smallHeight+"}";	
		} else if("video".equals(fileType)) {
			json= "{\"videoUrl\":\"" + oldAddress + "\",\"firstFrameUrl\":\"" + firstFrame + "\"}";
		} else {
			json= "{\"oldAddress\":\""+oldAddress+"\"}";	
		}
		System.out.println(json);
		return json;
	}
	

    public enum  Type{
        IMAGE,VIDEO,AUDIO,OTHNER;
    }
}
