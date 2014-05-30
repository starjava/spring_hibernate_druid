package com.spring.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;
import com.spring.util.XSSHttpServletRequestWrapper;
/**
 * 修复XssProtect漏洞
 * @author Administrator
 *
 */
public class XssProtectFilter extends GenericFilterBean {
	public static Logger logger=Logger.getLogger(XssProtectFilter.class);
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		XSSHttpServletRequestWrapper xssRequest = new XSSHttpServletRequestWrapper((HttpServletRequest) request);
		  chain.doFilter(xssRequest, response);
	}

}
