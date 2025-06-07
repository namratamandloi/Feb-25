
	package com.cdac.tester;

	import java.util.Scanner;

	import com.cdac.dao.UserDaoImpl;

	public class ChangePassOfVoter {

	    public static void main(String[] args) {
	        try (Scanner sc = new Scanner(System.in)) {
	            // 1. Create DAO instance
	            UserDaoImpl dao = new UserDaoImpl();

	            // 2. Accept user input
	            System.out.println("Enter email:");
	            String email = sc.next();

	            System.out.println("Enter old password:");
	            String oldPwd = sc.next();

	            System.out.println("Enter new password:");
	            String newPwd = sc.next();

	            // 3. Call DAO method to change password
	            String result = dao.changePassword(email, oldPwd, newPwd);
	            System.out.println("Change Password Result: " + result);

	            // 4. Clean up
	            dao.cleanUp();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

