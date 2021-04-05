package com.friendsurance.services;

import java.util.HashMap;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailService;
import com.friendsurance.processing.ItemWriter;


/**
 * @author Kunal
 * Sending Notification Mail
 */
public class ItemWriterImpl implements ItemWriter<HashMap<User, EmailService.MailType>> {

	private EmailServiceImpl emailServiceImpl = new EmailServiceImpl();
	

	@Override
	public void write(HashMap<User, EmailService.MailType> notificationInfo) {

		notificationInfo.entrySet().stream().forEach(x -> {
			emailServiceImpl.sendMail(x.getKey().getEmail(),x.getValue());
		});

	}

}
