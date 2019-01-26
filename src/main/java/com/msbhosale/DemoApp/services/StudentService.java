package com.msbhosale.DemoApp.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.msbhosale.DemoApp.beans.Student;

@Component
public class StudentService {

	@Autowired
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@SuppressWarnings("unused")
	public boolean saveStudentRecord(Student student) {

		String query = "INSERT INTO student_master values ('" + student.getRollNumber() + "','" + student.getFirstName()
				+ "','" + student.getLastName() + "')";

		int rows = template.update(query);

		return true;

	}

	public List<Student> getStudentsList() {

		String query = "SELECT * FROM student_master";

		return template.query(query, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student student = new Student();

				student.setRollNumber(rs.getInt("roll_number"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));

				return student;
			}
		});
	}

	public Student getStudentByRollNumber(int rollNumber) {

		String query = "SELECT * FROM student_master WHERE roll_number = ?";

		return template.queryForObject(query, new Object[] { rollNumber },
				new BeanPropertyRowMapper<Student>(Student.class));
	}

	public boolean updateStudentRecord(Student student) {

		String query = "UPDATE student_master SET first_name='" + student.getFirstName() + "', last_name='"
				+ student.getLastName() + "' where roll_number=" + student.getRollNumber() + "";
		
		template.update(query);

		return true;
	}
}