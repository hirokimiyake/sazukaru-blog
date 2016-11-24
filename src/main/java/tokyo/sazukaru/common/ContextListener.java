package tokyo.sazukaru.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.activemq.broker.BrokerService;

import tokyo.sazukaru.blog.user.UserManager;
import jp.co.eatsmart.framework.LogManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.SystemException;

public class ContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		try{
			LogManager.info("◆◆◆◆◆◆◆◆"+this.getClass().getName()+" initialize");
			Properties appProperties = getApplicationProperties();
			String applicationRoot = arg0.getServletContext().getRealPath("/");
			String propertyClass = appProperties.getProperty("class.property");
			String propertyPath = appProperties.getProperty("path.property");
			LogManager.info("applicationRoot:"+applicationRoot);
			LogManager.info("propertyClass:"+propertyClass);
			LogManager.info("propertyPath:"+propertyPath);
			prepareProperty(propertyClass,applicationRoot,propertyPath);
			LogManager.init();

			// ユーザーマネージャー
			UserManager.initialize(UserManager.class.getName());

			// ActiveMQ
			BrokerService broker = new BrokerService();
			// configure the broker
			broker.addConnector("tcp://localhost:61616");
			broker.start();

		} catch(Exception e){
			LogManager.trace(e);
		}
	}

	private Properties getApplicationProperties() throws ServerException {
		InputStream is = this.getClass().getResourceAsStream("/application.properties");
		Properties p = new Properties();
		try{
			p.load(is);
			return p;
		} catch(IOException ioe){
			throw new SystemException(ioe);
		} finally {
			try{
				is.close();
			} catch(Exception e){}
		}
	}
	
	private void prepareProperty(String propertyClass,String applicationRoot,String propertyPath) throws ServerException {
		LogManager.audit("\t\u30af\u30e9\u30b9\u540d=>" + propertyClass);
		LogManager.audit("\t\u30d5\u30a1\u30a4\u30eb\u30d1\u30b9=>" + propertyPath);
		PropertyManager pm;
		try {
			pm = (PropertyManager)Class.forName(propertyClass).newInstance();
		} catch (Exception e) {
			throw new SystemException(e);
		}
		pm.initialize(applicationRoot,propertyPath);
		PropertyManager.APPLICATION_ROOT = applicationRoot;
	}
}
