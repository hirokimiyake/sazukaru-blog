package tokyo.sazukaru.blog.user.blog;

import java.io.File;
import java.io.IOException;

import org.hibernate.validator.constraints.NotEmpty;

import tokyo.sazukaru.common.PropertyManager;
import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;
import jp.co.eatsmart.util.FileUtil;

public class UserBlog {

	private long userBlogId;
	private long userId;
	private String blogName;

	@NotEmpty
	private String blogUrl;
	private String rss;

	private String introduction;
	private String profilePicturePath;

	private boolean kiyakuAgree;

	public void regist() throws ServerException {
		this.profilePicturePath = saveProfilePicture();
		DBConnectionManager.getInstance().getConnection().execute("insert", this);
	}

	String saveProfilePicture() throws ServerException {
		String src = PropertyManager.APPLICATION_ROOT + this.getProfilePicturePath();
		String savePath = getFullProfilePicturePath();
		String dest = PropertyManager.APPLICATION_ROOT + savePath;
		FileUtil.exists(dest, true);
		FileUtil.move(src, dest);
		return savePath;
	}

	String getFullProfilePicturePath() {
		String userIdStr = Long.toString(this.userId);
		StringBuffer path = new StringBuffer(PropertyManager.USER_IMAGE_PATH);
		long len = (long)((userIdStr.length()+1)/2);
		String dirStr = userIdStr + (userIdStr.length()%2==0?"":"_");
		for(int i=0;i<len;i++){
			path.append("/").append(dirStr.substring(i*2, i*2+2));
		}
		return path.append("/").append(userIdStr).append("_").append(Long.toString(System.currentTimeMillis())).append(FileUtil.getExtention(profilePicturePath)).toString();
	}

	public long getUserBlogId() {
		return userBlogId;
	}
	public void setUserBlogId(long userBlogId) {
		this.userBlogId = userBlogId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogUrl() {
		return blogUrl;
	}
	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}
	public String getRss() {
		return rss;
	}
	public void setRss(String rss) {
		this.rss = rss;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getProfilePicturePath() {
		return profilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public boolean isKiyakuAgree() {
		return kiyakuAgree;
	}

	public void setKiyakuAgree(boolean kiyakuAgree) {
		this.kiyakuAgree = kiyakuAgree;
	}
	
}
