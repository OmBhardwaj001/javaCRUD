package ombhardwaj155.gmail.com.demo.service;
import ombhardwaj155.gmail.com.demo.DTO.AddStudentRequestDTO;
import ombhardwaj155.gmail.com.demo.DTO.StudentDTO;
import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id, AddStudentRequestDTO AddStudentRequestDTO);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}
