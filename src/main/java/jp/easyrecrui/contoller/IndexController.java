package jp.easyrecrui.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.easyrecrui.object.User;
import jp.easyrecrui.service.UserInfoService;
import jp.easyrecrui.utils.Md5Code;
import jp.easyrecrui.utils.UrlPath;

@Controller
public class IndexController {
	@Autowired
	UserInfoService userInfoService;

	@PostMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "userPwd") String userPwd) {
		User user = new User();
		userPwd = Md5Code.md5Code(userPwd);
		user.setUserid(userName);
		user.setPassword(userPwd);
		int result = userInfoService.findUser(user);
		if (result == 0) {
			ModelAndView mav = new ModelAndView("login/sucess");
			return mav;
		} else if (result == 1) {
			ModelAndView mav = new ModelAndView("login/login");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("login/login");
			return mav;
		}

	}

	@RequestMapping(UrlPath.MAIN_VIEW) // url地址值
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("main/main");// path,指向templates中的文件路径
		return mav;
	}

	@RequestMapping(UrlPath.MYPAGE_VIEW)
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView("login/myPage");// テンプレートHTML指定
		return mav;
	}

	@RequestMapping(UrlPath.JOBPAGE_VIEW)
	public ModelAndView jobpage() {

		ModelAndView mav = new ModelAndView("main/jobPage");// テンプレートHTML指定
		return mav;
	}

	@RequestMapping(UrlPath.LOGIN)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login/login");
		return mav;
	}
}