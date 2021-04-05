package com.friendsurance.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.friendsurance.backend.User;

/**
 * @author Kunal
 * Generate Random Users
 */
public class UserGenerationImpl implements IUserGeneration{

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub

		List<User> users = new ArrayList<User>();
		Random random = new Random();
		int max=10;
		int min=0;
		// Generate Users , randomly 9 users are considered
		IntStream.range(1, 10).forEach(x -> {
			
			
			String email = "email_" + x+"@supermail.com";
			int friendsNumber = random.nextInt(max)-min;
			int sentInvitationsNumber = random.nextInt(max)-min;
			
			
			if (x % 2 == 0) {
				User userWithContract = new User(email, Boolean.TRUE, friendsNumber, sentInvitationsNumber);
				users.add(userWithContract);
			} else {
				User userWithoutContract = new User(email, Boolean.FALSE, friendsNumber, sentInvitationsNumber);
				users.add(userWithoutContract);
			}

		}

		);
		
		/*
		 * users.stream().forEach(x->{ System.out.println(x.toString()); });
		 */
		return users;
	}

}
