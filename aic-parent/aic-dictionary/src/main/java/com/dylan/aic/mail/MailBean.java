package com.dylan.aic.mail;

import java.io.Serializable;
import java.util.Map;

/**
 * 邮件基础对象
 * @author Dylan
 * @date 2015年12月9日
 */
public class MailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发件人email
	 */
	private String from;
	
	/**
	 * 发件人别名（显示的发件人）
	 */
	private String fromName;
	
	/**
	 * 收件人email，支持群发
	 */
	private String[] toEmails;
	
	/**
	 * 主题
	 */
	private String subject;
	
	/**
	 * 邮件数据
	 */
	private Map data ;
	
	/**
	 * 邮件模板
	 */
	private String template;
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String[] getToEmails() {
		return toEmails;
	}
	public void setToEmails(String[] toEmails) {
		this.toEmails = toEmails;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public Map getData() {
		return data;
	}
	public void setData(Map data) {
		this.data = data;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	
}
