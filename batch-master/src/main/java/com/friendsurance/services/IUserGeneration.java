package com.friendsurance.services;

import java.util.List;

import com.friendsurance.backend.User;
import com.friendsurance.processing.ItemReader;

public interface IUserGeneration {

	/*
	 * Generate Users Interface
	 * Default Logic : 
	 * -------------------------------------------------------------------------------------------------------
	 * 1.  Has Contract 				:	Odd numbers -> False, even numbers -> True
	 * 2.  Email 						:	running number
	 * 3.  friendsNumber 				:	Random number
	 * 4.  sentInvitationsNumber 		:	Random number 
	 * -------------------------------------------------------------------------------------------------------
	 */
	List<User> getUsers();
}
