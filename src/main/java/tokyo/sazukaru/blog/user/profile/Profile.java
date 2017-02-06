package tokyo.sazukaru.blog.user.profile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;
import jp.co.eatsmart.framework.kbn.KbnBean;
import jp.co.eatsmart.framework.kbn.KbnListBean;
import jp.co.eatsmart.framework.kbn.KbnManager;
import jp.co.eatsmart.util.ImageUtil;


public class Profile implements Serializable {

	private BigDecimal userId;
	private String picturePath;
	private String introduction;
	private String sexKbn;
	private String sexDiscloseKbn;
	private String birthday;
	private String birthdayDiscloseKbn;
	private String homePrefectureKbn;
	private String homePrefectureDiscloseKbn;
	private String[] ninkatsuStyleKbn = new String[0];
	private String ninkatsuStyleDiscloseKbn;
	private String[] troubleKbn = new String[0];
	private String troubleOther;
	private String troubleDiscloseKbn;
	private String[] ryuzanKbn = new String[0];
	private String ryuzanOther;
	private String ryuzanDiscloseKbn;
	private String[] husbandFuninKbn = new String[0];
	private String husbandFuninOther;
	private String husbandFuninDiscloseKbn;

	public void regist() throws ServerException {
		DBConnectionManager.getInstance().getConnection().execute("insert", this);
	}

	public void update() throws ServerException {
		regist();
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
	public KbnListBean getTroubleKbnList() throws ServerException {
		return KbnManager.getInstance().get("TROUBLE_KBN");
	}
	public KbnListBean getRyuzanKbnList() throws ServerException {
		return KbnManager.getInstance().get("RYUZAN_KBN");
	}
	public KbnListBean getHusbandFuninKbnList() throws ServerException {
		return KbnManager.getInstance().get("HUSBAND_FUNIN_KBN");
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
	public KbnBean getSex() throws ServerException {
		return getSexKbnList().get(getSexKbn());
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
	public KbnBean getHomePrefecture() throws ServerException {
		return getPrefectureKbnList().get(getHomePrefectureKbn());
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
	public KbnBean[] getNinkatsuStyle() throws ServerException {
		List<KbnBean> ret = new ArrayList<KbnBean>();
		KbnListBean kbnList = getNinkatsuStyleKbnList();
		for(String code:getNinkatsuStyleKbn()){
			ret.add(kbnList.get(code));
		}
		return ret.toArray(new KbnBean[0]);
	}
	public void setNinkatsuStyleKbn(String[] ninkatsuStyleKbn) {
		this.ninkatsuStyleKbn = ninkatsuStyleKbn;
	}
	public java.sql.Array getNinkatsuStyleKbnArray() throws SystemException, SQLException {
		return DBConnectionManager.getInstance().getConnection().createArrayOf("text", ninkatsuStyleKbn);
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

	public String[] getTroubleKbn() {
		return troubleKbn;
	}

	public KbnBean[] getTrouble() throws ServerException {
		List<KbnBean> ret = new ArrayList<KbnBean>();
		KbnListBean kbnList = getTroubleKbnList();
		for(String code:getTroubleKbn()){
			ret.add(kbnList.get(code));
		}
		return ret.toArray(new KbnBean[0]);
	}

	public void setTroubleKbn(String[] troubleKbn) {
		this.troubleKbn = troubleKbn;
	}
	public java.sql.Array getTroubleKbnArray() throws SystemException, SQLException {
		return DBConnectionManager.getInstance().getConnection().createArrayOf("text", troubleKbn);
	}
	public void setTroubleKbnArray(java.sql.Array array) throws SystemException {
		this.troubleKbn = DBConnectionManager.getInstance().getConnection().toList(array).toArray(new String[0]);
	}

	public String getTroubleOther() {
		return troubleOther;
	}

	public void setTroubleOther(String troubleOther) {
		this.troubleOther = troubleOther;
	}

	public String getTroubleDiscloseKbn() {
		return troubleDiscloseKbn;
	}

	public void setTroubleDiscloseKbn(String troubleDiscloseKbn) {
		this.troubleDiscloseKbn = troubleDiscloseKbn;
	}

	public String[] getRyuzanKbn() {
		return ryuzanKbn;
	}

	public KbnBean[] getRyuzan() throws ServerException {
		List<KbnBean> ret = new ArrayList<KbnBean>();
		KbnListBean kbnList = getRyuzanKbnList();
		for(String code:getRyuzanKbn()){
			ret.add(kbnList.get(code));
		}
		return ret.toArray(new KbnBean[0]);
	}

	public void setRyuzanKbn(String[] ryuzanKbn) {
		this.ryuzanKbn = ryuzanKbn;
	}

	public java.sql.Array getRyuzanKbnArray() throws SystemException, SQLException {
		return DBConnectionManager.getInstance().getConnection().createArrayOf("text", ryuzanKbn);
	}
	public void setRyuzanKbnArray(java.sql.Array array) throws SystemException {
		this.ryuzanKbn = DBConnectionManager.getInstance().getConnection().toList(array).toArray(new String[0]);
	}

	public String getRyuzanOther() {
		return ryuzanOther;
	}

	public void setRyuzanOther(String ryuzanOther) {
		this.ryuzanOther = ryuzanOther;
	}

	public String getRyuzanDiscloseKbn() {
		return ryuzanDiscloseKbn;
	}

	public void setRyuzanDiscloseKbn(String ryuzanDiscloseKbn) {
		this.ryuzanDiscloseKbn = ryuzanDiscloseKbn;
	}

	public String[] getHusbandFuninKbn() {
		return husbandFuninKbn;
	}

	public KbnBean[] getHusbandFunin() throws ServerException {
		List<KbnBean> ret = new ArrayList<KbnBean>();
		KbnListBean kbnList = getHusbandFuninKbnList();
		for(String code:getHusbandFuninKbn()){
			ret.add(kbnList.get(code));
		}
		return ret.toArray(new KbnBean[0]);
	}

	public void setHusbandFuninKbn(String[] husbandFuninKbn) {
		this.husbandFuninKbn = husbandFuninKbn;
	}

	public java.sql.Array getHusbandFuninKbnArray() throws SystemException, SQLException {
		return DBConnectionManager.getInstance().getConnection().createArrayOf("text", husbandFuninKbn);
	}
	public void setHusbandFuninKbnArray(java.sql.Array array) throws SystemException {
		this.husbandFuninKbn = DBConnectionManager.getInstance().getConnection().toList(array).toArray(new String[0]);
	}


	public String getHusbandFuninOther() {
		return husbandFuninOther;
	}

	public void setHusbandFuninOther(String husbandFuninOther) {
		this.husbandFuninOther = husbandFuninOther;
	}

	public String getHusbandFuninDiscloseKbn() {
		return husbandFuninDiscloseKbn;
	}

	public void setHusbandFuninDiscloseKbn(String husbandFuninDiscloseKbn) {
		this.husbandFuninDiscloseKbn = husbandFuninDiscloseKbn;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public String getDisplayPicturePath200x200() throws ServerException {
		return getDisplayPicturePath0(200);
	}

	String getDisplayPicturePath0(int size) throws ServerException {
		String path = picturePath;
		return ImageUtil.resize(path, size);
	}


	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
