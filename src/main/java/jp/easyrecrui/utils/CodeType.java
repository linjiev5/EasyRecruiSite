package jp.easyrecrui.utils;

/**
 *
 * @author lin
 *
 */
public enum CodeType {
	/**
	 * 状態のタイプを設置する
	 */
	LOGIN_SUCESS(0, "ログイン成功"),
	USERNAME_NOT_EXIST(1, "ユーザすでに存在する"),
	PASSWORD_ERROR(2,"パスワード正しくない"),
	;

	private int code;

	private String message;

	CodeType(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}