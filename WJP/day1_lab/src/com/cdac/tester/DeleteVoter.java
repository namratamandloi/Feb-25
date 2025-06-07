package com.cdac.tester;

import java.util.Scanner;

import com.cdac.dao.UserDaoImpl;

public class DeleteVoter {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 1. Create DAO instance
            UserDaoImpl dao = new UserDaoImpl();

            // 2. Accept voter id
            System.out.println("Enter Voter ID to delete:");
            int voterId = sc.nextInt();

            // 3. Call DAO method to delete user
            String result = dao.deleteVoter(voterId);
            System.out.println("Delete Result: " + result);

            // 4. Clean up
            dao.cleanUp();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
