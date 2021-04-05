package com.friendsurance.execution;

import java.util.HashMap;
import java.util.List;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;
import com.friendsurance.processing.ItemProcessingImpl;
import com.friendsurance.processing.ItemWriter;
import com.friendsurance.services.IUserGeneration;
import com.friendsurance.services.ItemReaderImpl;
import com.friendsurance.services.ItemWriterImpl;
import com.friendsurance.services.UserGenerationImpl;

/**
 * @author Kunal
 * Main Execution Initialization Class
 */
public class ExecuteMainBatch {
	
	public static void main(String[] args) {
		
		/*
		 * Step 1 :
		 * Generate Users Randomly, or get from service
		 */
		IUserGeneration userGeneration=new UserGenerationImpl();
		List<User> users=userGeneration.getUsers();
		
		ItemReaderImpl itemReaderImpl=new ItemReaderImpl(users);
		ItemWriter<HashMap<User,EmailService.MailType>> itemWriter=new ItemWriterImpl();
		
		
		
		
		/*
		 * Step 2 :
		 * Process and Send Email-Notification
		 */
		
		ItemProcessingImpl itemProcessingImpl=new ItemProcessingImpl(
				itemReaderImpl, itemWriter);
		
		itemProcessingImpl.doProcessing();
		
		
		
		
	}

}
