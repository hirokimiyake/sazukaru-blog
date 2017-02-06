package tokyo.sazukaru.common;

import jp.co.eatsmart.framework.ServerException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PictureController {

	@RequestMapping(value = "/common/picture/entry", method = RequestMethod.GET)
	public ModelAndView entry(@ModelAttribute Picture picture) throws  ServerException {
		System.out.println("idName:"+picture.getIdName());
		return new ModelAndView("/common/picture/entry").addObject("picture", picture);
	}

	@RequestMapping(value = "/common/picture/upload", method = RequestMethod.POST)
	public ModelAndView upload(@ModelAttribute Picture picture) throws  ServerException {
		picture.saveTemporary();
		return new ModelAndView("/common/picture/entry").addObject("picture", picture);
	}

}
