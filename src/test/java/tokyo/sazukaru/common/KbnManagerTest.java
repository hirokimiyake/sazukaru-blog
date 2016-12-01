package tokyo.sazukaru.common;

import static org.junit.Assert.*;
import jp.co.eatsmart.framework.kbn.KbnBean;
import jp.co.eatsmart.framework.kbn.KbnListBean;
import jp.co.eatsmart.framework.kbn.KbnManager;
import jp.co.eatsmart.framework.test.TestManager;

import org.junit.Before;
import org.junit.Test;


public class KbnManagerTest {

	@Before
	public void setUp() throws Exception {
		TestManager.getInstance().initialize();
	}

	@Test
	public void testKbn() throws Exception {
		KbnListBean klb = KbnManager.getInstance().get("NINKATSU_STYLE_KBN");
		for(KbnBean b:klb.getKbn()){
			System.out.println(b.getKbnKanjiName()+":"+b.getKbnValueKanjiName()+"/"+b.getKbnValueCode());
		}
	}

}
