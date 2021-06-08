package io.genevjov.vgl.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoPintDto {

    @NotNull(message = "The latitude can not be null")
    @DecimalMin(value = "-90.000000", inclusive = true, message = "The minimal latitude value is -90.000000")
    @DecimalMax(value = "90.000000", inclusive = true, message = "The maximum latitude value is 90.000000")
    private Double latitude;
    @NotNull(message = "The longitude can not be null")
    @DecimalMin(value = "-180.000000", inclusive = true, message = "The minimal longitude value is -180.000000")
    @DecimalMax(value = "180.000000", inclusive = true, message = "The maximum longitude value is 180.000000")
    private Double longitude;

}
