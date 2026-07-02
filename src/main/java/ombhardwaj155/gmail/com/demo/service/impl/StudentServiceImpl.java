package ombhardwaj155.gmail.com.demo.service.impl;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ombhardwaj155.gmail.com.demo.DTO.AddStudentRequestDTO;
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

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDTO AddStudentRequestDTO){
      Student newStudent = modelMapper.map(AddStudentRequestDTO, Student.class);
      Student student =  studentRepository.save(newStudent);
      return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id){
      if(studentRepository.existsById(id)){
        studentRepository.deleteById(id);
      }else{
        throw new IllegalArgumentException("Student does not exist by id:"+id);
      }
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentRequestDTO AddStudentRequestDTO){
      Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("no such student with id:"+id+"exists"));
      modelMapper.map(AddStudentRequestDTO, student);

      student = studentRepository.save(student);
      return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<String, Object> updates){
      Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("no such student with id:" + id + "exists"));

      updates.forEach((field,value)->{
        switch (field){
          case "name":
             student.setName((String) value);
             break;
          case "email": 
             student.setEmail((String) value);
             break;  
          default:
            throw new IllegalArgumentException("Field is not supported"); 
        }
      });
      Student saveStudent  = studentRepository.save(student);
      return modelMapper.map(saveStudent, StudentDTO.class);
    }

}


