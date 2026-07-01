package ombhardwaj155.gmail.com.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private String email;


// below all can be replaced using an annotation @data it will automatically create getter, setter, toString(), equalsHashCode() aur constructor bhi banata h par wo all args nhi banata to uske liye alag se annotation hai constructor ke liye  


    // public StudentDTO(Long id, String name, String email){
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    // }

    // public StudentDTO(){

    // }

    // public Long getId(){
    //     return id;
    // }

    // public void setId(Long id){
    //     this.id = id;
    // }

    // public String getName(){
    //     return name;
    // }

    // public void setName(String name){
    //     this.name = name;
    // }

    // public String getEmail(){
    //     return email;
    // }

    // public void setEmail(String email){
    //     this.email = email;
    // }

}

