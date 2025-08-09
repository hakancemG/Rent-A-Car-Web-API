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
public class CarAdminDTO {

    private Long id;

    @NotBlank(message = "Plaka numarası boş bırakılamаз!")
    @Size(min = 7, max = 9, message = "Plaka numarası 7-9 karakter olmalıdır!")
    private String plateNumber;

    @NotBlank(message = "Marka boş bırakılamаз!")
    @Size(min = 3, max = 15, message = "Marka ismi 3-15 karakter olmalıdır!")
    private String brand;

    @NotBlank(message = "Model boş bırakılamаз!")
    @Size(min = 2, max = 10, message = "Model ismi 2-10 karakter olmalıdır!")
    private String model;

    @NotNull(message = "Model yılı boş bırakılamаз!")
    @Min(value = 1900, message = "Model yılı 1900'den küçük olamaz!")
    @Max(value = 2100, message = "Model yılı 2100'den büyük olamaz!")
    private Integer modelYear;

    @NotBlank(message = "Renk boş bırakılamаз!")
    @Size(min = 2, max = 10, message = "Renk 2-10 karakter olmalıdır!")
    private String color;

    @NotBlank(message = "Vites tipi boş bırakılamаз!")
    @Pattern(regexp = "^(Manuel|Otomatik)$", message = "Vites tipi 'Manuel' veya 'Otomatik' olmalıdır!")
    private String transmissionType;

    @NotBlank(message = "Yakıt tipi boş bırakılamаз!")
    @Pattern(regexp = "^(Benzin|Dizel|Hibrit|Elektrik)$", message = "Geçerli bir yakıt tipi giriniz!")
    private String fuelType;

    @NotNull(message = "Günlük fiyat boş bırakılamаз!")
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

    @Pattern(regexp = "^(https?://.*\\.(?:png|jpg|jpeg))$", message = "Geçerli bir resim URL'si giriniz!")
    private String imageUrl;
}