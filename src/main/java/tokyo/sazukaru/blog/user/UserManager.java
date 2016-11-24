package tokyo.sazukaru.blog.user;

import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.SessionManager;
import jp.co.eatsmart.framework.UserInterface;

public class UserManager extends jp.co.eatsmart.framework.UserManager implements jp.co.eatsmart.framework.UserManagerInterface {

	public static final String LOGIN_USER_SESSION_KEY = User.class.getName();

	public void login(User user) {
		LogManager.info("userLogin:"+user.getUserId());
		SessionManager.getInstance().setSessionAttribute(LOGIN_USER_SESSION_KEY,user);
	}

	public UserInterface getUser() {
		return (UserInterface)SessionManager.getInstance().getSessionAttribute(LOGIN_USER_SESSION_KEY);
	}

}
