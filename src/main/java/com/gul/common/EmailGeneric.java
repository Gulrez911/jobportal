package com.gul.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import com.gul.entity.PropertyConfig;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

public class EmailGeneric implements Runnable {

	String sentTo;
	String subject;
	String content;
	PropertyConfig config;

	public EmailGeneric(String sentTo, String subject, String content, PropertyConfig config) {
		super();
		this.sentTo = sentTo;
		this.subject = subject;
		this.content = content;
		this.config = config;
	}

	@Override
	public void run() {
		Content content2 = new Content("text/plain", content);
		Mail mail = new Mail();
		mail.setFrom(new Email(config.getSender()));
		mail.setSubject(subject);
		mail.addContent(content2);
		Personalization personalization = new Personalization();
		personalization.addTo(new Email(sentTo));
		mail.addPersonalization(personalization);
		SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		System.out.println(System.getenv("SENDGRID_API_KEY"));
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			System.out.println(mail.build());
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
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

	public void setContent(String content) {
		this.content = content;
	}

}
