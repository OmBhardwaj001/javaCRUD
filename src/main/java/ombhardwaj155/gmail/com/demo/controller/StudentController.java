package ombhardwaj155.gmail.com.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ombhardwaj155.gmail.com.demo.DTO.StudentDTO;
import ombhardwaj155.gmail.com.demo.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> getStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return getStudentById(id);
    }
}
