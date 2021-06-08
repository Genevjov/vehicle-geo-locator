package io.genevjov.vgl.converter;

import io.genevjov.vgl.dto.GeoPintDto;
import io.genevjov.vgl.dto.VehicleLocationDto;
import io.genevjov.vgl.model.VehicleLocationEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VehicleLocationEntityToVehicleLocationDtoConverter implements Converter<VehicleLocationEntity, VehicleLocationDto> {

    @Override
    public VehicleLocationDto convert(VehicleLocationEntity vehicleLocationDto) {
        GeoPintDto geoPintDto = GeoPintDto.builder()
                                          .latitude(vehicleLocationDto.getLocation().getPosition().getValues().get(0))
                                          .longitude(vehicleLocationDto.getLocation().getPosition().getValues().get(1))
                                          .build();

        return VehicleLocationDto.builder()
                                 .id(vehicleLocationDto.getId())
                                 .geoPintDto(geoPintDto)
                                 .build();
    }
}
