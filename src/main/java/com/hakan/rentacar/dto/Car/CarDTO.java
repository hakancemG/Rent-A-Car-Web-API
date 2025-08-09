package com.hakan.rentacar.dto.Car;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {

    private Long id;

    @NotBlank(message = "Marka boş bırakılamаz!")
    @Size(min = 3, max = 15, message = "Marka ismi 3-15 karakter olmalıdır!")
    private String brand;

    @NotBlank(message = "Model boş bırakılamаz!")
    @Size(min = 2, max = 10, message = "Model ismi 2-10 karakter olmalıdır!")
    private String model;

    @NotNull(message = "Model yılı boş bırakılamаz!")
    @Min(value = 1900, message = "Model yılı 1900'den küçük olamaz!")
    @Max(value = 2100, message = "Model yılı 2100'den büyük olamaz!")
    private Integer modelYear;

    @NotBlank(message = "Renk boş bırakılamаz!")
    @Size(min = 2, max = 10, message = "Renk 2-10 karakter olmalıdır!")
    private String color;

    @NotBlank(message = "Vites tipi boş bırakılamаz!")
    @Pattern(regexp = "^(Manuel|Otomatik)$", message = "Vites tipi 'Manuel' veya 'Otomatik' olmalıdır!")
    private String transmissionType;

    @NotBlank(message = "Yakıt tipi boş bırakılamаз!")
    @Pattern(regexp = "^(Benzin|Dizel|Hibrit|Elektrik)$", message = "Geçerli bir yakıt tipi giriniz!")
    private String fuelType;

    @NotNull(message = "Günlük fiyat boş bırakılamаz!")
    @DecimalMin(value = "0.0", message = "Günlük fiyat negatif olamaz!")
    private BigDecimal dailyPrice;

    @NotBlank(message = "Araç tipi boş bırakılamаз!")
    @Size(min = 3, max = 10, message = "Araç tipi 3-10 karakter olmalıdır!")
    private String vehicleType;

    @NotNull(message = "Araç durumu boş bırakılamаз!")
    private String status;

    @NotNull(message = "Kilometre yaşı boş bırakılamаз!")
    @Min(value = 0, message = "Kilometre yaşı negatif olamaz!")
    private Integer kilometerAge;
}