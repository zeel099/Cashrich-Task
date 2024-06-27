package com.cashrich.task.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Column(name = "user_name")
    @NotBlank(message = "Username is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,15}$", message = "Username must be alphanumeric and between 4 to 15 characters")
    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 15, message = "Password must be between 8 to 15 characters")
    private String password;

    private String mobileNo;
}
