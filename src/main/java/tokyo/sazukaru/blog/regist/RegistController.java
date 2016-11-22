package tokyo.sazukaru.blog.regist;

import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(value = "/regist/entry", method = RequestMethod.GET)
	public ModelAndView preEntry() throws SystemException, ServerException {

		jmsTemplate.convertAndSend("abc");

		return new ModelAndView("/regist/entry").addObject("bean", new EntryProfile());
	}

	@RequestMapping(value = "/regist/regist", method = RequestMethod.POST)
	public ModelAndView preRegist(@ModelAttribute EntryProfile bean) throws SystemException, ServerException {
		bean.registTemporary();
		return new ModelAndView("/regist/regist");
	}

	@RequestMapping(value = "/regist/finish", method = RequestMethod.GET)
	public ModelAndView finish(@RequestParam("accessId") String accessId) throws SystemException, ServerException {
		EntryProfile ep = EntryProfile.loadByAccessId(accessId);
		ep.regist();
		return new ModelAndView("/regist/finish");
	}


}
