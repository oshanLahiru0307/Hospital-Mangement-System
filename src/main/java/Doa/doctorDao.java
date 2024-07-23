package Doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DbUtil.DBUtil;
import Model.Doctor;

public class doctorDao {
	
	private Connection connection;
	
	public doctorDao(){
		
		connection = DBUtil.getConnection();
		
	}
	
	public void addDoctor(Doctor doctor) {
		
		try {
			
			PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO doctor(name, type, email, regid, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?)");
			preparedstatement.setString(1, doctor.getDoc_Name());
			preparedstatement.setString(1, doctor.getDoc_Type());
			preparedstatement.setString(1, doctor.getDoc_Email());
			preparedstatement.setString(1, doctor.getDoc_RegId());
			preparedstatement.setString(1, doctor.getDoc_Phone());
			preparedstatement.setString(1, doctor.getDoc_Password());
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public void deleteDoctor(int docId) {
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM WHERE id=?");
			preparedStatement.setInt(1, docId);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateDoctor(Doctor doctor) {
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE FROM doctor SET name=?, type=?, email=?, regid=?, phone=?, password=? WHERE id=?");
			preparedStatement.setString(1, doctor.getDoc_Name());
			preparedStatement.setString(2, doctor.getDoc_Type());
			preparedStatement.setString(3, doctor.getDoc_Email());
			preparedStatement.setString(4, doctor.getDoc_RegId());
			preparedStatement.setString(5, doctor.getDoc_Phone());
			preparedStatement.setString(6, doctor.getDoc_Password());
			preparedStatement.setInt(7, doctor.getDoc_Id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  List<Doctor> getAllDoctors() {

		ArrayList<Doctor> doctors  = new ArrayList();
		
		 try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM doctor");
			while(result.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoc_Name(result.getString("name"));
				doctor.setDoc_Type(result.getString("type"));
				doctor.setDoc_Email(result.getString("email"));
				doctor.setDoc_RegId(result.getString("regid"));
				doctor.setDoc_Phone(result.getString("phone"));
				doctor.setDoc_Password(result.getString("password"));
				doctors.add(doctor);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return doctors;
	}

}
