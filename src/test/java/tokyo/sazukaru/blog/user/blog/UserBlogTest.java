package tokyo.sazukaru.blog.user.blog;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserBlogTest {

	@Test
	public void testGetFullProfilePicturePath() {
		
		UserBlog ub = new UserBlog();
		ub.setProfilePicturePath("aaaaaaaa.jpg");
		ub.setUserId(123456789);
		String savePath = ub.getFullProfilePicturePath();
		System.out.println(savePath);
		assertTrue(savePath.startsWith("/image/user/12/34/56/78/9_/123456789_"));
	}

}
