package io.genevjov.vgl.converter;

import java.util.ArrayList;
import java.util.List;

import io.genevjov.vgl.dto.GeoPointDto;
import io.genevjov.vgl.dto.VehicleLocationDto;
import io.genevjov.vgl.model.VehicleLocationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;


@SpringBootTest
class VehicleLocationDtoToVehicleLocationEntityConverterTest {

    @Autowired
    private ConversionService conversionService;

    @Test
    public void shouldVerifyThatConverterIsPresentAndCanConvertData() {
        Assertions.assertTrue(conversionService.canConvert(VehicleLocationDto.class, VehicleLocationEntity.class));
    }

    @Test
    public void shouldVerifyThatConverterSetsDataAsExpected() {
        VehicleLocationDto vehicleLocationDto = VehicleLocationDto.builder()
                                                                  .geoPointDto(GeoPointDto.builder()
                                                                                          .latitude(1D)
                                                                                          .longitude(1D)
                                                                                          .build())
                                                                  .id(1L)
                                                                  .build();
        List<Double> expectedCoordinates = new ArrayList<>();
        expectedCoordinates.add(vehicleLocationDto.getGeoPointDto().getLatitude());
        expectedCoordinates.add(vehicleLocationDto.getGeoPointDto().getLongitude());

        VehicleLocationEntity result = conversionService.convert(vehicleLocationDto, VehicleLocationEntity.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), vehicleLocationDto.getId());
        Assertions.assertTrue(result.getLocation().getPosition().getValues().containsAll(expectedCoordinates));
    }
}
