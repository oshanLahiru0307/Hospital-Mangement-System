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

public class UserDao {
	
	 private Connection connection;

	    public UserDao() {
	        connection = DBUtil.getConnection();
	    }

	    public void addUser(User user) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, email, password) values (?, ?, ?)");
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteUser(int userId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
	            preparedStatement.setInt(1, userId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateUser(User user) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET name=?, email=?, password=? WHERE id=?");
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setInt(4, user.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<User> getAllUsers() {
	        List<User> users = new ArrayList<>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM users");
	            while (rs.next()) {
	                User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
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
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
	            preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }

}
