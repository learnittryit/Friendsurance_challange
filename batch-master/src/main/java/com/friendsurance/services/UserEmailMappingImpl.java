package com.friendsurance.services;

import java.util.HashMap;
import java.util.List;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;
import com.friendsurance.mail.EmailService.MailType;


/**
 * @author Kunal
 * Email- EmailTypeMapping
 */
public class UserEmailMappingImpl implements IUserEmailMapping{
	
	//Default settings
	private static final EmailService.MailType DEFAULT_MAIL_TYPE=EmailService.MailType.MAIL_TYPE_1;
	
	/**
	 * set the user-email mapping for each user
	 */
	public HashMap<User, EmailService.MailType>  setUserMailMaping(List<User> users){
		HashMap<User, EmailService.MailType> userMailMapping=new HashMap<User, MailType>();
		
		users.forEach(x->{
			
			boolean hasContract=x.hasContract();
			int firendsNo =x.getFriendsNumber();
			int invitationNo=x.getSentInvitationsNumber();
			
			userMailMapping.put(x, this.checkMailType(hasContract, firendsNo, invitationNo));
			
		});
		
		return userMailMapping;
	}
	
	
	/*
	 * Logic to return email type
	 * Descending order - because highest priority is considered first
	 */
	private  EmailService.MailType checkMailType(boolean hasContract,int friends, int invitations) {
		
		if(hasContract) {
			return friends>4 && invitations>3 ? EmailService.MailType.MAIL_TYPE_5
					: friends>1 && invitations==0 ? EmailService.MailType.MAIL_TYPE_4
							:friends==0 && invitations>3 ? EmailService.MailType.MAIL_TYPE_3
									:friends==0 && invitations==0 ? EmailService.MailType.MAIL_TYPE_3:DEFAULT_MAIL_TYPE;
		}else {
			return friends<3 && invitations>6 ? EmailService.MailType.MAIL_TYPE_3
					: friends<3 && invitations>1 ? EmailService.MailType.MAIL_TYPE_2
							:friends>3 && invitations>1 ? EmailService.MailType.MAIL_TYPE_1
									:friends>1 && invitations==0 ? EmailService.MailType.MAIL_TYPE_3
											:friends==0 && invitations==0 ? EmailService.MailType.MAIL_TYPE_3:DEFAULT_MAIL_TYPE;
		}
	}

}
