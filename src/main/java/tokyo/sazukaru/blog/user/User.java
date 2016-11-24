package tokyo.sazukaru.blog.user;

import java.math.BigDecimal;

import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.UserInterface;

public class User implements UserInterface {

	private long userId;
	private String nickname;

	public static User loadByCredential(String mailAddress,String password) throws ServerException {
		User u = DBConnectionManager.getInstance().getConnection().get(User.class,"loadByCredential",mailAddress,password);
		return u;
	}

	public BigDecimal getUserId() {
		return new BigDecimal(userId);
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

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
}
