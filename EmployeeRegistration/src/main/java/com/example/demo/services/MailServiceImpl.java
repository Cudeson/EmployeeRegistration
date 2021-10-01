package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void run(String... args) throws Exception {

	}

	public void sendVerifyEmail(String mail) {
		
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(mail);
			msg.setSubject(" Email Verification ");
			msg.setText("You have Successfully Registered");
			javaMailSender.send(msg);
		
	}
}
