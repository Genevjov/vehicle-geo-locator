package io.genevjov.vgl.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RectangleSearchDto {

    @NotNull
    @Valid
    private GeoPintDto leftTopPoint;
    @NotNull
    @Valid
    private GeoPintDto leftBottomPoint;
    @NotNull
    @Valid
    private GeoPintDto rightTopPoint;
    @NotNull
    @Valid
    private GeoPintDto rightBottomPoint;

}