package io.genevjov.vgl.converter;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import io.genevjov.vgl.dto.VehicleLocationDto;
import io.genevjov.vgl.model.VehicleLocationEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VehicleLocationDtoToVehicleLocationEntityConverter implements Converter<VehicleLocationDto, VehicleLocationEntity> {

    @Override
    public VehicleLocationEntity convert(VehicleLocationDto vehicleLocationDto) {
        return VehicleLocationEntity.builder()
                .id(vehicleLocationDto.getId())
                .location(new Point
                        (new Position(vehicleLocationDto.getGeoPointDto().getLatitude(), vehicleLocationDto.getGeoPointDto().getLongitude())))
                .build();
    }
}
