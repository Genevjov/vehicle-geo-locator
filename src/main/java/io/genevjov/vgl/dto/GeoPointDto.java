package io.genevjov.vgl.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GeoPointDto {

    @NotNull(message = "The latitude can not be null")
    @DecimalMin(value = "-90.000000", message = "The minimal latitude value is -90.000000")
    @DecimalMax(value = "90.000000", message = "The maximum latitude value is 90.000000")
    private Double latitude;
    @NotNull(message = "The longitude can not be null")
    @DecimalMin(value = "-180.000000", message = "The minimal longitude value is -180.000000")
    @DecimalMax(value = "180.000000", message = "The maximum longitude value is 180.000000")
    private Double longitude;

}
