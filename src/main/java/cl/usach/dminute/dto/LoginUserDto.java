package cl.usach.dminute.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUserDto {

    private String username;
    private String password;
    private String name;
    private String id;
}
