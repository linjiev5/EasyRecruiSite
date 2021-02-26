package jp.easyrecrui.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * UrlPathを読みやすいように設置する
 * @author user
 *
 */
@Data
@AllArgsConstructor
public class UrlPath {

	public static final String MAIN_VIEW = "/main";
	public static final String MYPAGE_VIEW = "/login/mypage";
	public static final String JOBPAGE_VIEW = "/main/jobpage";
	public static final String LOGIN = "login";
}
