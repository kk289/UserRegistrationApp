package com.example.userapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "testpassword";
		String encodedPassword = passwordEncoder.encode(rawPassword);

		System.out.println(encodedPassword);
	}
}