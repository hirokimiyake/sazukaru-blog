package tokyo.sazukaru.blog.user.profile;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import jp.co.eatsmart.framework.DBConnectionManager;
import jp.co.eatsmart.framework.ServerException;
import jp.co.eatsmart.framework.test.TestManager;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {

	@Before
	public void setUp() throws Exception {
		TestManager.getInstance().initialize();
	}

	@Test
	public void testRegist() throws ServerException {
		Profile p = new Profile();
		p.setUserId(new BigDecimal(1));
		p.setNinkatsuStyleKbn(new String[]{"01","02","03","04"});
		p.regist();

		p = Profile.load(new BigDecimal(1));
		assertEquals(p.getNinkatsuStyleKbn()[0],"01");
		assertEquals(p.getNinkatsuStyleKbn()[1],"02");
		assertEquals(p.getNinkatsuStyleKbn()[2],"03");
		assertEquals(p.getNinkatsuStyleKbn()[3],"04");
	}

}
