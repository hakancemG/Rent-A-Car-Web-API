package com.hakan.rentacar.dto.Customer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "İsim boş bırakılamaz!")
    @Size(max = 20, message = "İsim 20 karakterden uzun olamaz!")
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ ]+$", message = "İsim yalnızca harf içermelidir!")
    private String firstName;

    @NotBlank(message = "Soyisim boş bırakılamaz!")
    @Size(max = 20, message = "Soyisim 20 karakterden uzun olamaz!")
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ ]+$", message = "Soyisim yalnızca harf içermelidir!")
    private String lastName;
}