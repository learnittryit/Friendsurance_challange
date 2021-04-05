package com.friendsurance.services;

import java.util.List;

import com.friendsurance.backend.User;
import com.friendsurance.processing.ItemReader;

/**
 * @author Kunal
 * Setting the users and then implementing the read method
 */
public class ItemReaderImpl implements ItemReader<List<User>> {

	private List<User> users;
	
	
	
	public ItemReaderImpl(List<User> users) {
		super();
		this.users = users;
	}



	@Override
	public List<User> read() {
		return users;
	}

}
