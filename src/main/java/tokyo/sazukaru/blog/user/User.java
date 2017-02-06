package tokyo.sazukaru.blog.user;

import java.math.BigDecimal;

import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.UserInterface;
import tokyo.sazukaru.blog.user.profile.Profile;

public class User implements UserInterface {

	private BigDecimal userId;
	private String nickname;
	private boolean myself;
	private Profile profile;

	public static User loadByCredential(String mailAddress,String password) throws ServerException {
		User u = DBConnectionManager.getInstance().getConnection().get(User.class,"loadByCredential",mailAddress,password);
		return u;
	}

	public static User load(BigDecimal userId) throws ServerException {
		User u = DBConnectionManager.getInstance().getConnection().get(User.class,"get",userId);
		return u;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	public String getUsername() {
		return nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Profile getProfile() throws ServerException {
		if(profile==null){
			setProfile(Profile.load(userId));
		}
		return profile;
	}

	public boolean isMyself() {
		return myself;
	}

	void setMyself(boolean myself) {
		this.myself = myself;
	}

}
