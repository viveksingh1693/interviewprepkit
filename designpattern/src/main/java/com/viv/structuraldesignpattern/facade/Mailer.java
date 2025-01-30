package com.viv.structuraldesignpattern.facade;

public class Mailer {

	private static Mailer mailerInstance = new Mailer();

	private Mailer() {
		// private constructor to prevent instantiation
	}

	public static Mailer getMailer() {
		return mailerInstance;
	}

	public boolean send(Email email) {
		// logic to send email
		System.out.println("Sending email to " + email);
		return true;
	}
}
