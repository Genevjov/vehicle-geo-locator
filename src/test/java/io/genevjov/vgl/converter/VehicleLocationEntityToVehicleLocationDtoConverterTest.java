package io.genevjov.vgl.converter;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import io.genevjov.vgl.dto.VehicleLocationDto;
import io.genevjov.vgl.model.VehicleLocationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;

@SpringBootTest
class VehicleLocationEntityToVehicleLocationDtoConverterTest {

    @Autowired
    private ConversionService conversionService;

    @Test
    public void shouldVerifyThatConverterIsPresentAndCanConvertData() {
        Assertions.assertTrue(conversionService.canConvert(VehicleLocationEntity.class, VehicleLocationDto.class));
    }

    @Test
    public void shouldVerifyThatConverterSetsDataAsExpected() {
        VehicleLocationEntity vehicleLocationEntity = VehicleLocationEntity.builder()
                                                                           .id(1L)
                                                                           .location(new Point(
                                                                                   new Position(1D, 1D)))
                                                                           .build();

        VehicleLocationDto result = conversionService.convert(vehicleLocationEntity, VehicleLocationDto.class);

        Assertions.assertNotNull(result);
        List<Double> resultCoordinates = new ArrayList<>();
        resultCoordinates.add(result.getGeoPointDto().getLatitude());
        resultCoordinates.add(result.getGeoPointDto().getLongitude());
        Assertions.assertEquals(result.getId(), vehicleLocationEntity.getId());
        Assertions.assertTrue(vehicleLocationEntity.getLocation()
                                                   .getPosition()
                                                   .getValues()
                                                   .containsAll(resultCoordinates));
    }

}
