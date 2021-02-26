package jp.easyrecrui.object;

public class User {

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", toString()=" + super.toString() + "]";
	}
	private String userid;
	private String password;
	/**
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid セットする userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
