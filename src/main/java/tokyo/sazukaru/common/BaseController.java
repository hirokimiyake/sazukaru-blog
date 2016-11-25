package tokyo.sazukaru.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

abstract public class BaseController {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	  binder.setValidator(validator);
	}

	protected String getMessage(String key,String... args) {
		return messageSource.getMessage(key, args, Locale.JAPAN);
	}

	protected void sendMessage(Object message) {
		jmsTemplate.convertAndSend(message);
	}
}
