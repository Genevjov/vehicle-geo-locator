package io.genevjov.vgl.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RectangleSearchDto {

    @NotNull
    @Size(min = 2, max = 2, message = "Point might be described with 2 coordinate values")
    private double[] leftBottomPoint;
    @NotNull
    @Size(min = 2, max = 2, message = "Point might be described with 2 coordinate values")
    private double[] rightTopPoint;

}