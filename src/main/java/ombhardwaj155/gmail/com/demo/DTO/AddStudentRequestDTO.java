package ombhardwaj155.gmail.com.demo.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class AddStudentRequestDTO {

    @NotBlank(message = "name is required")
    private String name;

    @Email
    @NotBlank(message="Email is required")
    private String email;   

}
