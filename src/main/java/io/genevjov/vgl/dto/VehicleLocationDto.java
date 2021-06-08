package io.genevjov.vgl.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleLocationDto {

    @NotNull
    private Long id;
    @NotNull
    @Valid
    private GeoPintDto geoPintDto;
}
