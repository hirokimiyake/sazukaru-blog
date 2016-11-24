package tokyo.sazukaru.blog.login;

import jp.co.eatsmart.framework.ServerException;

public class InvalidLoginException extends ServerException {

	public InvalidLoginException(String mailAddress,String password) {
		super("ログインできません。mailAddress=["+mailAddress+"] password=["+password+"]");
	}
}
