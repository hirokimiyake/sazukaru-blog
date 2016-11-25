package tokyo.sazukaru.blog.user.blog;

import org.hibernate.validator.constraints.NotEmpty;

import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.ServerException;

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
		DBConnectionManager.getInstance().getConnection().execute("insert", this);
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
