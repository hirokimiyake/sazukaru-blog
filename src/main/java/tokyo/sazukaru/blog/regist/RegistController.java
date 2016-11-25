package tokyo.sazukaru.blog.regist;

import javax.validation.Valid;

import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tokyo.sazukaru.common.BaseController;

@Controller
public class RegistController extends BaseController {

	@RequestMapping(value = "/regist/entry", method = RequestMethod.GET)
	public ModelAndView entry(@ModelAttribute EntryProfile entryProfile) throws SystemException, ServerException {
		return new ModelAndView("/regist/entry").addObject("entryProfile", entryProfile);
	}

	@RequestMapping(value = "/regist/regist", method = RequestMethod.POST)
	public ModelAndView regist(@Valid @ModelAttribute EntryProfile entryProfile,BindingResult result) throws SystemException, ServerException {
		if(result.hasErrors()){
			return new ModelAndView("/regist/entry").addObject("entryProfile", entryProfile);
		}
		entryProfile.registTemporary();

		sendMessage("abc");

		return new ModelAndView("/regist/regist");
	}

	@RequestMapping(value = "/regist/finish", method = RequestMethod.GET)
	public ModelAndView finish(@RequestParam("accessId") String accessId) throws SystemException, ServerException {
		EntryProfile ep = EntryProfile.loadByAccessId(accessId);
		ep.regist();
		return new ModelAndView("/regist/finish");
	}

}
