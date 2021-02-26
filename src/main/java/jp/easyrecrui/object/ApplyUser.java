package jp.easyrecrui.object;

public class ApplyUser extends User{


	private String mail;
	private String tel;
	private String name;
	private int sex;
	private String adress;
	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail セットする mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel セットする tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex セットする sex
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress セットする adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
