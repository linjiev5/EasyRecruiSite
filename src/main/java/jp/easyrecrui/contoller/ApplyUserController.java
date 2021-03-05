package jp.easyrecrui.contoller;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jp.easyrecrui.object.ApplyUser;
import jp.easyrecrui.object.User;
import jp.easyrecrui.service.ApplyUserService;
import jp.easyrecrui.utils.CodeType;
import jp.easyrecrui.utils.Md5Code;
import jp.easyrecrui.utils.UrlPath;

@RestController
public class ApplyUserController {
	@Autowired
	ApplyUserService applyUserService;

	/**
	 * ログインする
	 * @param userName
	 * @param userPwd
	 * @param message
	 * @return
	 */
	@PostMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "userId") String userId,
			@RequestParam(name = "userPwd") String userPwd, Map<String, Object> message, HttpSession session) {
		ModelAndView mav = new ModelAndView("login/login");
		User user = new User();
		userPwd = Md5Code.md5Code(userPwd);
		user.setUserId(userId);
		user.setPassword(userPwd);
		int result = applyUserService.findUser(user);
		if (result == CodeType.USERNAME_NOT_EXIST.getCode()) {
			// ユーザが存在しない場合
			message.put("message", CodeType.USERNAME_NOT_EXIST.getMessage());
			return mav;
		} else if (result == CodeType.PASSWORD_ERROR.getCode()) {
			//　パスワードが間違った場合
			message.put("message", CodeType.PASSWORD_ERROR.getMessage());
			return mav;
		} else {
			// ログイン成功
			session.setAttribute("loginUser", userId);
			mav.setViewName("main/main");
			return mav;
		}

	}

	/**
	 * 登録する
	 */
	@PostMapping(value = "/regist")
	public ModelAndView regist(@RequestParam(name = "userId") String userId,
			@RequestParam(name = "userPwd") String userPwd, @RequestParam(name = "name") String name,
			@RequestParam(name = "mail") String mail, @RequestParam(name = "tel") String tel,
			@RequestParam(name = "sex") int sex, @RequestParam(name = "adress") String adress,
			@RequestParam(name = "birth") Date birth, Map<String, Object> message) {
		ModelAndView mav = new ModelAndView("login/regist");
		// 空欄あるかどうかを確認
		if ((sex == 1 || sex == 0)
				&& !userId.toString().equals("") && !userPwd.toString().equals("") && !name.toString().equals("")
				&& !mail.toString().equals("") && !tel.toString().equals("") && !adress.toString().equals("")
				&& !birth.toString().equals("")) {
			// 空欄がなければ登録行う
			User user = new User();
			user.setUserId(userId);
			user.setPassword(userPwd);
			int result = applyUserService.findUser(user);
			// 判断した結果を処理する
			if (result == CodeType.USERNAME_NOT_EXIST.getCode()) {
				// ユーザが重複してなければ登録する
				ApplyUser applyUser = new ApplyUser();
				userPwd = Md5Code.md5Code(userPwd);
				applyUser.setAdress(adress);
				applyUser.setMail(mail);
				applyUser.setName(name);
				applyUser.setPassword(userPwd);
				applyUser.setSex(sex);
				applyUser.setTel(tel);
				applyUser.setUserId(userId);
				applyUser.setBirth(birth);
				applyUserService.addUser(applyUser);
				message.put("message", CodeType.REGIST_SUCESS.getMessage());
				name = null;
				userPwd = null;
				adress = null;
				mail = null;
				tel = null;
				userId = null;
				birth = null;
				mav.setViewName("login/login");
				return mav;
			} else {
				// ユーザが存在すれば画面に提示する
				message.put("message", CodeType.USER_EXIST.getMessage());
				return mav;
			}
		} else {
			// それぞれ未入力の項目の提示
			if (userId.toString().trim().equals("")) {
				message.put("message", "ユーザ名を入力してください");
			} else if (userPwd.toString().trim().equals("")) {
				message.put("message", "パスワードを入力してください");
			} else if (name.toString().trim().equals("")) {
				message.put("message", "名前を入力してください");
			} else if (mail.toString().trim().equals("")) {
				message.put("message", "メールを入力してください");
			} else if (tel.toString().trim().equals("")) {
				message.put("message", "電話番号を入力してください");
			} else if (sex != 1 || sex != 0) {
				message.put("message", "性別を選択してください");
			} else if (adress.toString().trim().equals("")) {
				message.put("message", "住所を入力してください");
			} else if (birth.toString().trim().equals("")) {
				message.put("message", "生年月日を選択してください");
			} else {
			}
			return mav;
		}
	}

	//	/**
	//	 *
	//	 */
	//	@RequestMapping(value = "/login/mypage")
	//	public String getApplyUserInfo( Map<String, Object> message,HttpSession session,Model  model) {
	//
	//		ApplyUser applyUser = new ApplyUser();
	//		int result = applyUserService.findUser(applyUser);
	//		// ユーザが存在する場合
	//		if (result == CodeType.USER_EXIST.getCode()) {
	//			List<ApplyUser> applyInfo = new ArrayList<ApplyUser>();
	//			String userLogin=(String)session.getAttribute("userLogin");
	//			applyInfo = applyUserService.getUserData(userLogin);
	//			model.addAttribute("applyInfo",applyInfo);
	//			System.out.println(applyInfo);
	//		}
	//
	//	return "login/mypage";
	//	}
	@RequestMapping(UrlPath.APPLY_USER_INFO)
	public ModelAndView list(Model model,HttpSession hs) {
		ModelAndView mav =new ModelAndView("applyUser/applyUserInfo");
		String userLogin = (String)hs.getAttribute("loginUser");
		ApplyUser applyUser = applyUserService.getUserData(userLogin);
		model.addAttribute("applyUserInfo",applyUser);
		return mav;
	}
}