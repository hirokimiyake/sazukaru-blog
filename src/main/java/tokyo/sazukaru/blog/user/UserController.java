package tokyo.sazukaru.blog.user;

import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ModelAndView entryBlog() throws SystemException, ServerException {
		return new ModelAndView("/user/index");
	}

}
