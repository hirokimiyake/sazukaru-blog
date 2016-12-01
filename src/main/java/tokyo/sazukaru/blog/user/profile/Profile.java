package tokyo.sazukaru.blog.user.profile;

import java.math.BigDecimal;
import java.sql.SQLException;

import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;
import jp.co.eatsmart.framework.kbn.KbnListBean;
import jp.co.eatsmart.framework.kbn.KbnManager;


public class Profile {

	private BigDecimal userId;
	private String sexKbn;
	private String sexDiscloseKbn;
	private String birthday;
	private String birthdayDiscloseKbn;
	private String homePrefectureKbn;
	private String homePrefectureDiscloseKbn;
	private String[] ninkatsuStyleKbn = new String[0];
	private String ninkatsuStyleDiscloseKbn;


	public void regist() throws ServerException {
		DBConnectionManager.getInstance().getConnection().execute("insert", this);
	}

	public static Profile load(BigDecimal userId) throws ServerException {
		return DBConnectionManager.getInstance().getConnection().get(Profile.class, "get", userId);
	}

	public KbnListBean getDiscloseKbnList() throws ServerException {
		return KbnManager.getInstance().get("DISCLOSE_KBN");
	}
	public KbnListBean getSexKbnList() throws ServerException {
		return KbnManager.getInstance().get("SEX_KBN");
	}
	public KbnListBean getPrefectureKbnList() throws ServerException {
		return KbnManager.getInstance().get("PREFECTURE_KBN");
	}
	public KbnListBean getNinkatsuStyleKbnList() throws ServerException {
		return KbnManager.getInstance().get("NINKATSU_STYLE_KBN");
	}

	public BigDecimal getUserId() {
		return userId;
	}
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	public String getSexKbn() {
		return sexKbn;
	}
	public void setSexKbn(String sexKbn) {
		this.sexKbn = sexKbn;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthdayDiscloseKbn() {
		return birthdayDiscloseKbn;
	}
	public void setBirthdayDiscloseKbn(String birthdayDiscloseKbn) {
		this.birthdayDiscloseKbn = birthdayDiscloseKbn;
	}
	public String getHomePrefectureKbn() {
		return homePrefectureKbn;
	}
	public void setHomePrefectureKbn(String homePrefectureKbn) {
		this.homePrefectureKbn = homePrefectureKbn;
	}
	public String getHomePrefectureDiscloseKbn() {
		return homePrefectureDiscloseKbn;
	}
	public void setHomePrefectureDiscloseKbn(String homePrefectureDiscloseKbn) {
		this.homePrefectureDiscloseKbn = homePrefectureDiscloseKbn;
	}
	public String[] getNinkatsuStyleKbn() {
		return ninkatsuStyleKbn;
	}
	public java.sql.Array getNinkatsuStyleKbnArray() throws SystemException, SQLException {
		return DBConnectionManager.getInstance().getConnection().createArrayOf("text", ninkatsuStyleKbn);
	}
	public void setNinkatsuStyleKbn(String[] ninkatsuStyleKbn) {
		this.ninkatsuStyleKbn = ninkatsuStyleKbn;
	}
	public void setNinkatsuStyleKbnArray(java.sql.Array array) throws SystemException {
		this.ninkatsuStyleKbn = DBConnectionManager.getInstance().getConnection().toList(array).toArray(new String[0]);
	}
	public String getNinkatsuStyleDiscloseKbn() {
		return ninkatsuStyleDiscloseKbn;
	}
	public void setNinkatsuStyleDiscloseKbn(String ninkatsuStyleDiscloseKbn) {
		this.ninkatsuStyleDiscloseKbn = ninkatsuStyleDiscloseKbn;
	}
	public String getSexDiscloseKbn() {
		return sexDiscloseKbn;
	}
	public void setSexDiscloseKbn(String sexDiscloseKbn) {
		this.sexDiscloseKbn = sexDiscloseKbn;
	}

}
