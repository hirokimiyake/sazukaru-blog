package tokyo.sazukaru.blog;

import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() throws SystemException, ServerException {
		System.out.println("aaaa");
		return
			new ModelAndView("index");
	}
}
