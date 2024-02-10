package my.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private Integer id;

    @NotEmpty
    @NotNull
    @Email(regexp = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")
    private String email;

    @NotNull
    @Size(min = 4, max = 42)
    private String password;

    @Valid
    @NotNull
    private UserDetailsDto userDetails;

    public UserRequestDto(UserDetailsDto userDetailsDto) {
        this.userDetails = userDetailsDto;
    }
}
