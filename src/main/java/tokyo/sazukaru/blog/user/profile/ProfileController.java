package tokyo.sazukaru.blog.user.profile;

import java.math.BigDecimal;

import javax.validation.Valid;

import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.util.CheckUtil;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tokyo.sazukaru.blog.user.User;
import tokyo.sazukaru.blog.user.UserManager;
import tokyo.sazukaru.common.BaseController;

@Controller
public class ProfileController extends BaseController {

	@RequestMapping(value = "/user/profile/entry", method = RequestMethod.GET)
	public ModelAndView entry(@ModelAttribute Profile profile) {
		return new ModelAndView("/user/profile/entry").addObject("profile", profile);
	}

	@RequestMapping(value = "/user/profile/regist", method = RequestMethod.POST)
	public ModelAndView regist(@Valid @ModelAttribute Profile profile,BindingResult result) throws ServerException {
		if(result.hasErrors()){
			return new ModelAndView("/user/profile/entry").addObject("profile", profile);
		}
		User user = (User)UserManager.getInstance().getUser();
		profile.setUserId(user.getUserId());
		profile.regist();
		return new ModelAndView("/user/profile/regist").addObject("profile", profile);
	}

	@RequestMapping(value = "/user/profile/edit", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute Profile profile) throws ServerException {
		if(CheckUtil.isNull(profile.getSexKbn())){
			profile = ((User)UserManager.getInstance().getUser()).getProfile();
		}
		return new ModelAndView("/user/profile/edit").addObject("profile", profile);
	}

	@RequestMapping(value = "/user/profile/finish", method = RequestMethod.POST)
	public ModelAndView finish(@Valid @ModelAttribute Profile profile,BindingResult result) throws ServerException {
		if(result.hasErrors()){
			return new ModelAndView("/user/profile/edit").addObject("profile", profile);
		}
		User user = (User)UserManager.getInstance().getUser();
		profile.setUserId(user.getUserId());
		profile.update();
		user.setProfile(profile);
		return new ModelAndView("redirect:/user/index");
	}


}
