package tokyo.sazukaru.common;

import java.io.File;
import java.io.IOException;

import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.SystemException;
import jp.co.eatsmart.util.FileUtil;

import org.springframework.web.multipart.MultipartFile;

public class Picture {

	private MultipartFile file;
	private String idName;
	private String path;

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public void saveTemporary() throws SystemException {
		String savePath = PropertyManager.APPLICATION_ROOT + PropertyManager.USER_IMAGE_TEMPORARY_PATH;
		try {
			LogManager.debug("保存先:"+savePath);
			LogManager.debug("アップロードファイル名:"+file.getOriginalFilename());
			File dest = File.createTempFile("tmp", FileUtil.getExtention(file.getOriginalFilename()), new File(savePath));
			file.transferTo(dest);
			path = PropertyManager.USER_IMAGE_TEMPORARY_PATH + "/" + dest.getName();
		} catch (IOException e) {
			throw new SystemException(e);
		}
		
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
}
