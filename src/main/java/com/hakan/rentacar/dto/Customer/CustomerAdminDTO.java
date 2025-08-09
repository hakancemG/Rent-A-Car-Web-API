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
public class CustomerAdminDTO {

    private Long id;

    @NotBlank(message = "İsim boş bırakılamaz!")
    @Size(max = 20, message = "İsim 20 karakterden uzun olamaz!")
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ ]+$", message = "İsim yalnızca harf içermelidir!")
    private String firstName;

    @NotBlank(message = "Soyisim boş bırakılamaz!")
    @Size(max = 20, message = "Soyisim 20 karakterden uzun olamaz!")
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ ]+$", message = "Soyisim yalnızca harf içermelidir!")
    private String lastName;

    @NotBlank(message = "Email boş bırakılamaz!")
    @Email(message = "Geçerli bir email adresi girilmelidir!")
    private String email;

    @NotBlank(message = "Telefon numarası boş bırakılamaz!")
    @Pattern(regexp = "^(\\+\\d{1,3})?\\d{10}$", message = "Geçerli bir telefon numarası girilmelidir!")
    private String phone;

    @NotBlank(message = "TCKN boş bırakılamaz!")
    @Pattern(regexp = "\\d{11}", message = "TCKN 11 haneli olmalıdır!")
    private String tckn;
}