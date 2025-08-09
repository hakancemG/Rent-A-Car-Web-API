package com.hakan.rentacar.dto.Rent;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentAdminDTO {

    private Long id;

    @NotNull(message = "Başlangıç tarihi boş bırakılamaz!")
    @FutureOrPresent(message = "Başlangıç tarihi geçmişte olamaz!")
    private LocalDate startDate;

    @NotNull(message = "Bitiş tarihi boş bırakılamaz!")
    @Future(message = "Bitiş tarihi gelecekte olmalıdır!")
    private LocalDate endDate;

    @NotBlank(message = "Durum boş bırakılamaz!")
    @Pattern(regexp = "^(PENDING|APPROVED|CANCELLED|COMPLETED)$", message = "Geçerli bir durum giriniz!")
    private String status;

    @NotNull(message = "Toplam fiyat boş bırakılamaz!")
    @DecimalMin(value = "0.0", message = "Toplam fiyat negatif olamaz!")
    private BigDecimal totalPrice;

    @NotNull(message = "Araç ID boş bırakılamaz!")
    @Positive(message = "Araç ID pozitif olmalıdır!")
    private Long carId;

    @NotNull(message = "Müşteri ID boş bırakılamaz!")
    @Positive(message = "Müşteri ID pozitif olmalıdır!")
    private Long customerId;
}