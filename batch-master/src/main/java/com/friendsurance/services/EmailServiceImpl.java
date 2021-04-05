package com.friendsurance.services;

import java.util.StringJoiner;
import java.util.function.BiConsumer;

import com.friendsurance.mail.EmailService;

public class EmailServiceImpl implements EmailService{

	private static final String EMAIL_TEMPLATE = " Email Template choosen is :";
	private static final String FOR_EMAIL = "For email : ";
	private static final String DEFAULT_EMAIL_MESSAGE = "OOps sorry !!!  there is some problem in sending email , our customer service will contact you soon";


	@Override
	public void sendMail(String recipient, MailType mailType) {
		// TODO Auto-generated method stub
		BiConsumer<String,MailType> generateContent=EmailServiceImpl::displayContent;
		generateContent.accept(recipient,mailType);
		System.out.println("Mail Sent Finally!!!!!\n\n");
	}
	
	
	public static void displayContent(String recipient,MailType mailType) {
		
		String email_Message_1 = FOR_EMAIL+recipient+EMAIL_TEMPLATE+EmailService.MailType.MAIL_TYPE_1;
		String email_Message_2 = FOR_EMAIL+recipient+EMAIL_TEMPLATE+EmailService.MailType.MAIL_TYPE_2;
		String email_Message_3 = FOR_EMAIL+recipient+EMAIL_TEMPLATE+EmailService.MailType.MAIL_TYPE_3;
		String email_Message_4 = FOR_EMAIL+recipient+EMAIL_TEMPLATE+EmailService.MailType.MAIL_TYPE_4;
		String email_Message_5 = FOR_EMAIL+recipient+EMAIL_TEMPLATE+EmailService.MailType.MAIL_TYPE_5;
		
		StringJoiner joiner=new StringJoiner(" | ");
		String default_Message = joiner.add(FOR_EMAIL).add(recipient).add(DEFAULT_EMAIL_MESSAGE).toString();
		
		String emailContent = generateEmail(mailType, email_Message_1, email_Message_2, email_Message_3,
				email_Message_4, email_Message_5,default_Message);
		
		System.out.println(emailContent);
		
	}


	private static String generateEmail(MailType mailType, String email_Message_1, String email_Message_2,
			String email_Message_3, String email_Message_4, String email_Message_5,String default_Message) {
		String emailContent=EmailService.MailType.MAIL_TYPE_1.equals(mailType)?
				email_Message_1
				:EmailService.MailType.MAIL_TYPE_2.equals(mailType)?
						email_Message_2
						:EmailService.MailType.MAIL_TYPE_3.equals(mailType)?
								email_Message_3
								:EmailService.MailType.MAIL_TYPE_4.equals(mailType)?
										email_Message_4
										:EmailService.MailType.MAIL_TYPE_5.equals(mailType)?
												email_Message_5
												:default_Message;
		return emailContent;
	}
	
}
