package tokyo.sazukaru.blog.regist;

import java.math.BigDecimal;

import org.apache.commons.beanutils.BeanUtils;

import net.arnx.jsonic.JSON;
import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;
import jp.co.eatsmart.util.SequenceUtil;
import jp.co.eatsmart.util.StringUtil;

public class EntryProfile {

	private String mailaddress;
	private String password;
	private String name;
	private String nickname;
	private boolean kiyakuAgree;
	private boolean privacyAgree;

	public static EntryProfile loadByAccessId(String accessId) throws ServerException {
		String json = DBConnectionManager.getInstance().getConnection().getString("SELECT JSON FROM T_TEMPORARY_REGIST WHERE ACCESS_ID=?", accessId);
		EntryProfile obj = JSON.decode(json,EntryProfile.class);
		DBConnectionManager.getInstance().getConnection().execute("DELETE FROM T_TEMPORARY_REGIST WHERE ACCESS_ID=?",accessId);
		return obj;
	}

	public void registTemporary() throws ServerException {
		String json = JSON.encode(this);
		String accessId = StringUtil.getAccessId();
		DBConnectionManager.getInstance().getConnection().execute("INSERT INTO T_TEMPORARY_REGIST(JSON,ACCESS_ID) VALUES (?,?)", json,accessId);
		
		//TODO:メール送信処理
	}

	public void regist() throws ServerException {
		DBConnectionManager.getInstance().getConnection().execute("insert",this);

		//TODO:roグイン処理
		BigDecimal userId = SequenceUtil.getCurVal("m_user_user_id_seq");
	}

	public String getMailaddress() {
		return mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isKiyakuAgree() {
		return kiyakuAgree;
	}
	public void setKiyakuAgree(boolean kiyakuAgree) {
		this.kiyakuAgree = kiyakuAgree;
	}
	public boolean isPrivacyAgree() {
		return privacyAgree;
	}
	public void setPrivacyAgree(boolean privacyAgree) {
		this.privacyAgree = privacyAgree;
	}
	

	
}
