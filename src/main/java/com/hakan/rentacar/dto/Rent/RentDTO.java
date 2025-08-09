package com.hakan.rentacar.dto.Rent;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentDTO {

    private Long id;

    @NotBlank(message = "Durum boş bırakılamaz!")
    @Pattern(regexp = "^(PENDING|APPROVED|CANCELLED|COMPLETED)$", message = "Geçerli bir durum giriniz!")
    private String status;

    @NotNull(message = "Müşteri ID boş bırakılamaz!")
    @Positive(message = "Müşteri ID pozitif olmalıdır!")
    private Long customerId;

    @NotNull(message = "Araç ID boş bırakılamaz!")
    @Positive(message = "Araç ID pozitif olmalıdır!")
    private Long carId;
}