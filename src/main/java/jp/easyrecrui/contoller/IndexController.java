package jp.easyrecrui.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.easyrecrui.utils.UrlPath;

@Controller
public class IndexController {


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

	@RequestMapping(UrlPath.REGIST_VIEW)
	public ModelAndView regist() {

		ModelAndView mav = new ModelAndView("login/regist");
		return mav;
	}


}