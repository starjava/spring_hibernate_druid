package com.spring.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 会把一些特殊字符全部处理掉，被处理的特殊字符就是那些会造成script的字符，
 * 把他们全部“全角化”，来避免植入恶意代码，这是通过覆写getParameter()和getHeader()方法来实现的：
 * 
 * @author wangn
 * 
 */
public class XSSHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XSSHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);

	}

	/**
	 * /** 这样它可以过滤所有的参数名称和参数值 然后使用替换的特殊字符，可能会导致XSS攻击
	 */
	@Override
	public String getParameter(String name) {

		String value = super.getParameter(encodeXSS(name));
		// 原始的参数值是
		System.out.println("原始的参数值 getParameter() 是:" + value);
		if (value != null) {
			value = encodeXSS(value);
		}
		// 处理XSS后，实际值是
		System.out.println("处理XSS后，实际值是:" + value);
		System.out.println();
		return value;
	}

	/**
	 * Override the original getHeader() method , 替换特殊字符
	 */
	@Override
	public String getHeader(String name) {

		String value = super.getHeader(encodeXSS(name));

		System.out.println("header()替换之前 getHeader() is:" + value);

		if (value != null) {
			value = encodeXSS(value);
		}

		System.out.println("header() XSS替换之后的值:" + value);
		System.out.println();

		return value;
	}

	/**
	 * 过滤特殊字符
	 * 
	 * @param s
	 * @return
	 */
	private String encodeXSS(String s) {
		if (s == null || "".equals(s)) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append('＞');
				break;
			case '<':
				sb.append('＜');
				break;
			case '\'':
				sb.append('‘');
				break;
			case '\"':
				sb.append('“');
				break;
			case '&':
				sb.append('＆');
				break;
			case '\\':
				sb.append('＼');
				break;
			case '#':
				sb.append('＃');
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}
}
