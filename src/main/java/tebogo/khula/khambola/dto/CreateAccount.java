package tebogo.khula.khambola.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CreateAccount {
    @NotNull(message = "firstName cannot be null.")
    @NotEmpty(message = "firstName cannot be empty.")
    @NotBlank(message = "firstName cannot be blank.")
    private String firstName;
    @NotNull(message = "lastName cannot be null.")
    @NotEmpty(message = "lastName cannot be empty.")
    @NotBlank(message = "lastName cannot be blank.")
    private String lastName;
    @Max(35)
    @Min(18)
    @NotNull(message = "age cannot be null.")
    private int age;
}
    

