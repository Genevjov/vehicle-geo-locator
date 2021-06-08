package io.genevjov.vgl.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RectangleSearchDto {

    @NotNull
    @Valid
    private double[] leftBottomPoint;
    @NotNull
    @Valid
    private double[] rightTopPoint;

}