package ombhardwaj155.gmail.com.demo.service.impl;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ombhardwaj155.gmail.com.demo.DTO.StudentDTO;
import ombhardwaj155.gmail.com.demo.repository.StudentRepository;
import ombhardwaj155.gmail.com.demo.service.StudentService;
import ombhardwaj155.gmail.com.demo.entity.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

   private final StudentRepository studentRepository;
   private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudent() {
       List<Student> students = studentRepository.findAll();
       return students.stream().
       map(student -> new StudentDTO(
         student.getId(),
         student.getName(),
         student.getEmail()))
         .toList();      
    }

    @Override
    public StudentDTO getStudentById(Long id){
      Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student no found with ID:" + id));
      return modelMapper.map(student, StudentDTO.class);
    }

}


