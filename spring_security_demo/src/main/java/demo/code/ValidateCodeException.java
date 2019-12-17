package demo.code;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by luwb on 2019/12/17.
 * 自定义异常
 */
public class ValidateCodeException extends AuthenticationException {
	private static final long serialVersionUID = 5022575393500654458L;

	ValidateCodeException(String message) {
		super(message);
	}
}
