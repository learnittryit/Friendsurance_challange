package com.friendsurance.processing;

import java.util.HashMap;
import java.util.List;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;
import com.friendsurance.mail.EmailService.MailType;
import com.friendsurance.services.IUserEmailMapping;
import com.friendsurance.services.UserEmailMappingImpl;


/**
 * @author Kunal
 * Set the Email and EmailType:Mapping(Which email should get what type of mail)
 */
public class ItemProcessingImpl extends ItemProcessing<List<User>, HashMap<User, EmailService.MailType>>{

	
	public ItemProcessingImpl(ItemReader<List<User>> reader, ItemWriter<HashMap<User, EmailService.MailType>> writer) {
		super(reader, writer);
		// TODO Auto-generated constructor stub
	}



	/*
	 * Email is Mapped with Email Type - The most important method
	 */
	@Override
	protected HashMap<User, MailType> process(List<User> item) {
		
		IUserEmailMapping emailMapping=new UserEmailMappingImpl();
		HashMap<User, EmailService.MailType> emailBatch=emailMapping.setUserMailMaping(item);
		
		return emailBatch;
	}


}
