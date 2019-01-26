package com.msbhosale.DemoApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msbhosale.DemoApp.beans.Student;
import com.msbhosale.DemoApp.services.StudentService;

@Controller
public class AppController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/")
	public String indexPage() {

		return "index";
	}

	@RequestMapping("/viewstudents")
	public String viewStudentPage(Model model) {

		model.addAttribute("studentsList", studentService.getStudentsList());

		return "viewstudents";
	}

	@RequestMapping("/studentform")
	public String studentFormPage(Model model) {

		model.addAttribute("command", new Student());

		return "studentform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudentRecord(@ModelAttribute("student") Student student) {

		studentService.saveStudentRecord(student);

		return "redirect:/viewstudents";
	}

	@RequestMapping(value = "/updatestudent/{rollNumber}")
	public String updateStudentForm(@PathVariable int rollNumber, Model model) {

		Student student = studentService.getStudentByRollNumber(rollNumber);
		model.addAttribute("command", student);

		return "updatestudent";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateStudentRecord(@ModelAttribute("student") Student student) {

		studentService.updateStudentRecord(student);

		return "redirect:/viewstudents";
	}
}