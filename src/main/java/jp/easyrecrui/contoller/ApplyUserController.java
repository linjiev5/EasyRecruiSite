package jp.easyrecrui.contoller;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jp.easyrecrui.object.ApplyUser;
import jp.easyrecrui.object.User;
import jp.easyrecrui.service.ApplyUserService;
import jp.easyrecrui.utils.CodeType;
import jp.easyrecrui.utils.Md5Code;

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
			@RequestParam(name = "userPwd") String userPwd, Map<String, Object> message) {
		User user = new User();
		userPwd = Md5Code.md5Code(userPwd);
		user.setUserId(userId);
		user.setPassword(userPwd);
		int result = applyUserService.findUser(user);
		if (result == CodeType.USERNAME_NOT_EXIST.getCode()) {
			ModelAndView mav = new ModelAndView("login/login");
			message.put("message", CodeType.USERNAME_NOT_EXIST.getMessage());
			return mav;
		} else if (result == CodeType.PASSWORD_ERROR.getCode()) {
			ModelAndView mav = new ModelAndView("login/login");
			message.put("message", CodeType.PASSWORD_ERROR.getMessage());
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("main/main");
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
		User user = new User();
		user.setUserId(userId);
		user.setPassword(userPwd);
		int result = applyUserService.findUser(user);
		if(result == CodeType.USERNAME_NOT_EXIST.getCode()) {
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
		ModelAndView mav = new ModelAndView("login/login");
		return mav;
		}else {
			message.put("message", CodeType.USER_EXIST.getMessage());
			ModelAndView mav = new ModelAndView("login/regist");
			return mav;
		}
	}

}
