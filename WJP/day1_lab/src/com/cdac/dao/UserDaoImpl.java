package com.cdac.dao;

import java.sql.*;

import com.cdac.pojos.User;
import static com.cdac.utils.DBUtils.*;

public class UserDaoImpl implements UserDao {
	// dependency - DB connection - DBUtils
	private Connection connection;
	private PreparedStatement pst1, pst2,pst3,pst4;

	// def ctor - will be invoked by layer above - Tester (dyn web comp)
	public UserDaoImpl() throws SQLException {
		// establish db cn
		openConnection();
		connection = getConnection();
		// creates PreparedStament
		String sql = "select * from users where email=? and password=?";
		pst1 = connection.prepareStatement(sql);
		// create PST - to insert a record
		pst2 = connection.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("user dao created !");
	}

	@Override
	public User signIn(String email, String pwd) throws SQLException {
		// 1. set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		// 2. execute query n process RST
		try (ResultSet rst = pst1.executeQuery()) {
			/*
			 * id | first_name | last_name | email | password | dob | status | role
			 */
			if (rst.next()) {
				// success
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
			return null;

		}

	}
	
	@Override
	public String changePassword(String email, String oldPassword, String newPassword) throws SQLException {
	    // Step 1: Verify email and old password
	    String selectQuery = "SELECT * FROM users WHERE email = ? AND password = ?";
	    try (PreparedStatement pst3 = connection.prepareStatement(selectQuery)) {
	    	pst3.setString(1, email);
	    	pst3.setString(2, oldPassword);
	        try (ResultSet rs = pst3.executeQuery()) {
	            if (rs.next()) {
	                // Step 2: Update to new password
	                String updateQuery = "UPDATE users SET password = ? WHERE email = ?";
	                try (PreparedStatement updatePst = connection.prepareStatement(updateQuery)) {
	                    updatePst.setString(1, newPassword);
	                    updatePst.setString(2, email);
	                    int updateCount = updatePst.executeUpdate();
	                    if (updateCount == 1)
	                        return "success";
	                }
	            }
	        }
	    }
	    return "failed";
	}


	@Override
	public String signUp(User newUser) throws SQLException {
		/*
		 * first_name | last_name | email | password | dob | status | role
		 */
		// set In params
		pst2.setString(1, newUser.getFirstName());// 1 - in param index
		pst2.setString(2, newUser.getLastName());
		pst2.setString(3, newUser.getEmail());
		pst2.setString(4, newUser.getPassword());
		pst2.setDate(5, newUser.getDob());
		pst2.setBoolean(6, false);
		pst2.setString(7, "voter");
		// execute query - public int executeUpdate() throws SQLException
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Voter registered....";
		return "reg failed !!!!!!";
	}
	
	public String deleteVoter(int voterId) throws SQLException {
	    String sql = "DELETE FROM users WHERE id = ?";
	    try (PreparedStatement pst4 = connection.prepareStatement(sql)) {
	        pst4.setInt(1, voterId);
	        int rows = pst4.executeUpdate();
	        return rows > 0 ? "Voter deleted successfully." : "Voter ID not found.";
	    }
	}


	// clean up - close db resources (PST , DB cn)
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		if (pst2 != null) {
			pst2.close();
			pst2 = null;
		}
		if (pst3 != null) {
			pst3.close();
			pst3 = null;
		}
		
		if (pst4 != null) {
			pst4.close();
			pst4 = null;
		}
		closeConnection();
	}

}
