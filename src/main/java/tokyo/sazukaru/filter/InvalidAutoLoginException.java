/**
 * 
 * @author miyake
 * @author EatSmart,Inc.
 * @since 2014/04/10
 */
package tokyo.sazukaru.filter;

import jp.co.eatsmart.framework.ServerException;

/**
 *
 * @author miyake
 * @author EatSmart,Inc.
 * @since 2014/04/10
 *
 */
public class InvalidAutoLoginException extends ServerException {

	public InvalidAutoLoginException(String msg){
		super(msg);
	}
}
