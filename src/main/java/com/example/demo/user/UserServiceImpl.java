package com.example.demo.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserWithUsernameOnly> getUsers() {
		return userRepository.findBy(QUser.user.id.isNotNull(), q -> q.project("username").as(UserWithUsernameOnly.class).all());
	}

}
