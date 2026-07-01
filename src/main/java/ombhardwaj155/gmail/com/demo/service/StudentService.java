package ombhardwaj155.gmail.com.demo.service;
import ombhardwaj155.gmail.com.demo.DTO.StudentDTO;
import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Long id);
}
