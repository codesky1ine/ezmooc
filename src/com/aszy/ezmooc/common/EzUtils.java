package com.aszy.ezmooc.common;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.aszy.ezmooc.po.EzUser;

/**
 * @经验之谈
 * 	每日工作结束后 记得备份
 * @author aszy
 *
 */
public class EzUtils {
	public static EzUser loginUser;
	
	/**
	 * 
	 * @param file
	 * @param directory
	 * @param fileName
	 * @return
	 */
	public static String ezFileUpload(MultipartFile file, String directory, String fileName){
		
		File resourse = null;
		
		if(file.getSize() > 0){
			//原始文件名
			String oname = file.getOriginalFilename();
			String fileType = oname.substring( oname.lastIndexOf(".") );
			
			resourse = new File(directory);
			if( !resourse.exists() ){
				resourse.mkdirs();
			}
			resourse = new File(resourse, fileName+fileType);
			
			try {
				file.transferTo( resourse );
				
				String fileURL = resourse.getAbsolutePath();
				fileURL = "/"+fileURL.substring( fileURL.lastIndexOf("ezmooc") ).replace("\\", "/");
				
				return fileURL;
			
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
