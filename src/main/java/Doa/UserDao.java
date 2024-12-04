package Doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DbUtil.DBUtil;
import Model.User;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserDao {
	
	 private Connection connection;

	    public UserDao() {
	        connection = DBUtil.getConnection();
	    }

	    public void addUser(User user) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(name, email, phone, password) values (?, ?, ?, ?)");
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPhone());
	            preparedStatement.setString(4, user.getPassword());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteUser(int userId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id=?");
	            preparedStatement.setInt(1, userId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateUser(User user) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET name=?, email=?, phone=?, password=? WHERE id=?");
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPhone());
	            preparedStatement.setString(4, user.getPassword());
	            preparedStatement.setInt(5, user.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<User> getAllUsers() {
	        List<User> users = new ArrayList<>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM user");
	            System.out.println("Fetching all users");
	            while (rs.next()) {
	                User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPhone(rs.getString("phone"));
	                user.setPassword(rs.getString("password"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    public User getUserById(int userId) {
	        User user = new User();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id=?");
	            preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPhone(rs.getString("phone"));
	                user.setPassword(rs.getString("password"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	    
	    public User validateUser(String email, String password) {
	        User user = null;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email=? AND password=?");
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPhone(rs.getString("phone"));
	                user.setPassword(rs.getString("password"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }


}
