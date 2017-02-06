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
	public ModelAndView entryBlog(User user) throws SystemException, ServerException {

		// userid未指定の場合は、自分のマイページを表示
		if(user.getUserId()==null){
			user = (User)UserManager.getInstance().getUser();
		} else {
			user = User.load(user.getUserId());
		}

		return new ModelAndView("/user/index").addObject("user", user);
	}

}
