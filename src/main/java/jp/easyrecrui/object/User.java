package jp.easyrecrui.object;

public class User {

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", toString()=" + super.toString() + "]";
	}
	private String userId;
	private String password;
	/**
	 * @return userid
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userid セットする userid
	 */
	public void setUserId(String userid) {
		this.userId = userid;
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
