package io.genevjov.vgl.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import io.genevjov.vgl.dto.RectangleSearchDto;
import io.genevjov.vgl.dto.VehicleLocationDto;
import io.genevjov.vgl.model.VehicleLocationEntity;
import io.genevjov.vgl.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    private final ConversionService conversionService;

    @PutMapping("/location")
    public ResponseEntity<VehicleLocationDto> addVehicleLocation(@Valid @RequestBody VehicleLocationDto vehicleLocationDto) {
        VehicleLocationEntity vehicleLocationEntity = conversionService.convert(vehicleLocationDto,
                                                                                VehicleLocationEntity.class);
        VehicleLocationEntity processingResult = vehicleService.save(vehicleLocationEntity);
        VehicleLocationDto response = conversionService.convert(processingResult, VehicleLocationDto.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/location/search/rectangle")
    public ResponseEntity<List<VehicleLocationDto>> findAllVehiclesLocatedInRectangle(@Valid @RequestBody RectangleSearchDto searchRequestDto) {

        List<VehicleLocationDto> response = vehicleService.findAllInsideThePolygon(searchRequestDto.getLeftBottomPoint(),
                                                                                   searchRequestDto.getRightTopPoint())
                                                          .stream()
                                                          .map(entity -> conversionService.convert(
                                                                  entity,
                                                                  VehicleLocationDto.class))
                                                          .collect(Collectors.toList());
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
