package tokyo.sazukaru.blog.login;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import tokyo.sazukaru.blog.user.User;
import jp.co.eatsmart.framework.ServerException;
import tokyo.sazukaru.blog.user.UserManager;

public class Credential {

	@NotEmpty
	private String mailAddress;
	@NotEmpty
	private String password;
	private String path;

	public void login() throws ServerException {
		User u = User.loadByCredential(mailAddress, password);
		System.out.println(u.getNickname());
		if(u==null||u.getUserId()==null){
			throw new InvalidLoginException(mailAddress,password);
		}
		((UserManager)UserManager.getInstance()).login(u);
	}

	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
