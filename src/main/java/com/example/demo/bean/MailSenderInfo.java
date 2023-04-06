
package com.example.demo.bean;

/**  
* 发送邮件需要使用的基本信息  
*/
import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailSenderInfo {
	private static Log log = LogFactory.getLog(MailSenderInfo.class);
	// 邮件信息号
	private String streamNumber;
	// 发送邮件的服务器的IP和端口
	private String mailServerHost;
	private String mailServerPort;
	// 邮件发送者的地址
	private String fromAddress;
	// 邮件接收者的地址
	private String[] toAddress;
	//邮件密送者的地址
	private String toBccAdress;
	// 邮件抄送者的地址
	private String[] Ccs;
	// 登陆邮件发送服务器的用户名和密码
	private String userName;
	private String password;
	// 是否需要身份验证
	private boolean validate;
	// 邮件主题
	private String subject;
	// 邮件的文本内容
	private String content;
	// 邮件的待发文本内容
	private String arrearsContent;
	// 邮件附件的文件名
	private String[] attachFileNames;
	// 邮件创建的用户
	private String createdUser;
	//	邮件创建的时间
	private String createdTime;
	// 邮件评论
	private String remark;
	/**
	 * 获得邮件会话属性
	 */
	public Properties getProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", this.mailServerHost);
		props.put("mail.smtp.port", this.mailServerPort);
		props.put("mail.smtp.auth", validate ? "true" : "false");
		try {
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			// or
			// sf.setTrustedHosts(new String[] { "my-server" });
			props.put("mail.smtp.ssl.enable", "true");
			// also use following for additional safety
			//props.put("mail.smtp.ssl.checkserveridentity", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
	//		props.setProperty("mail.smtp.host", "smtp.csair.com");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.transport.protocol", "smtp");
	//		props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", this.mailServerPort);
	//		props.put("mail.smtp.auth", "true");
		} catch (GeneralSecurityException e) {
			log.info("MailSSLSocketFactory fail:"+e.getMessage());
		}
		return props;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] fileNames) {
		this.attachFileNames = fileNames;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String[] getCcs() {
		return Ccs;
	}

	public void setCcs(String[] ccs) {
		this.Ccs = ccs;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String[] getToAddress() {
		return toAddress;
	}

	public void setToAddress(String[] toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String textContent) {
		this.content = textContent;
	}

	public String getToBccAdress() {
		return toBccAdress;
	}

	public void setToBccAdress(String toBccAdress) {
		this.toBccAdress = toBccAdress;
	}

	public String getArrearsContent() {
		return arrearsContent;
	}

	public void setArrearsContent(String arrearsContent) {
		this.arrearsContent = arrearsContent;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStreamNumber() {
		return streamNumber;
	}

	public void setStreamNumber(String streamNumber) {
		this.streamNumber = streamNumber;
	}
	
}