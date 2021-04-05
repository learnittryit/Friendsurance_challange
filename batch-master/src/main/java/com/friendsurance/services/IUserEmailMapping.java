package com.friendsurance.services;

import java.util.HashMap;
import java.util.List;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;

public interface IUserEmailMapping {

	public HashMap<User, EmailService.MailType>  setUserMailMaping(List<User> users);
}
