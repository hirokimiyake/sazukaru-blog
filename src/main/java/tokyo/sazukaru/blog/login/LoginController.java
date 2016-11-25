package tokyo.sazukaru.blog.login;

import javax.validation.Valid;

import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.util.CheckUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tokyo.sazukaru.common.BaseController;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute Credential credential) {
		return new ModelAndView("/login/index").addObject("credential", credential);
	}

	@RequestMapping(value = "/login/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute Credential credential,BindingResult result) throws ServerException {
		if(result.hasErrors()){
			return new ModelAndView("/login/index").addObject("credential", credential);
		}
		try{
			credential.login();
		} catch(InvalidLoginException e) {
			LogManager.trace(e);
			result.addError(new ObjectError("login",getMessage("error.login.invalid")));
			return new ModelAndView("/login/index").addObject("credential", credential);
		}
		String path = (CheckUtil.isNull(credential.getPath())?"/user/":credential.getPath());
		return new ModelAndView("redirect:"+path);
	}


}
