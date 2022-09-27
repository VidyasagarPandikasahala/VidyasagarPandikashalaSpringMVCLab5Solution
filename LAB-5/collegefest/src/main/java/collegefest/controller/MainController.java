package collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import collegefest.dao.StudentDao;
import collegefest.model.StudentDetail;

@Controller

public class MainController {

	@Autowired
	StudentDao studentDao;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("studentlist")
	public String showStudents(Model model) {
		List<StudentDetail> students = studentDao.getStudentDetail();
		model.addAttribute("students", students);
		return "studentlist";
	}

	@GetMapping("showForm")
	public String showStudentForm(Model model) {
		StudentDetail st = new StudentDetail();
		model.addAttribute("student", st);
		return "studentform";
	}
	
	@PostMapping("save")
	public String saveStudent(Model model, @ModelAttribute("student") StudentDetail student) {
		System.out.println(student);
		studentDao.createStudentDetails(student);
		return "redirect:/studentlist";
	}
	
	@GetMapping("edit")
	public String updateStudent(Model model,@RequestParam("id")int id) {
		StudentDetail sd = studentDao.getStudentDetail(id);
		System.out.println(sd);
		model.addAttribute("student",sd);
		return "studentform";
	}
	@GetMapping("delete")
	public String deleteStudent(Model model,@RequestParam("id")int id) {
		studentDao.deleteStudentDetail(id);
		return  "redirect:/studentlist";
	}
}
