package tokyo.sazukaru.blog.user.blog;

import java.math.BigDecimal;

import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tokyo.sazukaru.blog.user.User;
import tokyo.sazukaru.blog.user.UserManager;

@Controller
public class BlogController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(value = "/user/blog/entry", method = RequestMethod.GET)
	public ModelAndView entryBlog() throws SystemException, ServerException {
		return new ModelAndView("/user/blog/entry").addObject("userBlog", new UserBlog());
	}


	@RequestMapping(value = "/user/blog/regist", method = RequestMethod.POST)
	public ModelAndView regist(@ModelAttribute UserBlog userBlog) throws SystemException, ServerException {
		User user = (User)UserManager.getInstance().getUser();
		BigDecimal uid = user.getUserId();
		long userId = uid.longValue();
		userBlog.setUserId(userId);
		userBlog.regist();

		return new ModelAndView("/user/blog/regist");
	}

}
