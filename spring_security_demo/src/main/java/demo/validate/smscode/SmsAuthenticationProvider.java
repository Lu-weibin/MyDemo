package demo.validate.smscode;

import demo.security.MyUserDetailService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by luwb on 2019/12/26.
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {
	private MyUserDetailService userDetailService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SmsAuthenticationToken authenticationToken = (SmsAuthenticationToken) authentication;
		UserDetails userDetails = userDetailService.loadUserByUsername((String) authenticationToken.getPrincipal());

		if (userDetails == null)
			throw new InternalAuthenticationServiceException("未找到与该手机号对应的用户");

		SmsAuthenticationToken authenticationResult = new SmsAuthenticationToken(userDetails, userDetails.getAuthorities());

		authenticationResult.setDetails(authenticationToken.getDetails());

		return authenticationResult;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return SmsAuthenticationToken.class.isAssignableFrom(aClass);
	}

	public MyUserDetailService getUserDetailService() {
		return userDetailService;
	}

	public void setUserDetailService(MyUserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}
}