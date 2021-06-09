package io.genevjov.vgl.controller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import io.genevjov.vgl.BaseSpringTest;
import io.genevjov.vgl.dto.GeoPointDto;
import io.genevjov.vgl.dto.RectangleSearchDto;
import io.genevjov.vgl.dto.VehicleLocationDto;
import io.genevjov.vgl.model.VehicleLocationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

class VehicleControllerTest extends BaseSpringTest {

    @Autowired
    private VehicleController controller;

    @Test
    public void shouldVerifyThatCorrectDataWillBeProcessedAsExpectedForAddCoordinatesFlow() {
        VehicleLocationDto vehicleLocationDto = VehicleLocationDto.builder()
                                                                  .geoPointDto(GeoPointDto.builder()
                                                                                          .latitude(1D)
                                                                                          .longitude(1D)
                                                                                          .build())
                                                                  .id(1L)
                                                                  .build();
        VehicleLocationEntity vehicleLocationEntity = VehicleLocationEntity.builder()
                                                                           .id(1L)
                                                                           .location(new Point(
                                                                                   new Position(1D, 1D)))
                                                                           .build();
        when(mockLocationRepository.save(vehicleLocationEntity)).thenReturn(vehicleLocationEntity);

        ResponseEntity<VehicleLocationDto> response = controller.addVehicleLocation(vehicleLocationDto);
        VehicleLocationDto responseBody = response.getBody();

        assertEquals(vehicleLocationDto, responseBody);
    }

    @Test
    public void shouldVerifyThatCorrectDataWillBeProcessedAsExpectedForTheSearchFlow() {

        List<VehicleLocationDto> expectedResponseBody = new ArrayList<>();
        expectedResponseBody.add(VehicleLocationDto.builder().id(1L).geoPointDto(new GeoPointDto(1D, 1D)).build());
        expectedResponseBody.add(VehicleLocationDto.builder().id(2L).geoPointDto(new GeoPointDto(1D, 1D)).build());

        double[] testBottomLeft = new double[] {1D, 1D};
        double[] testTopRight = new double[] {1D, 1D};
        List<VehicleLocationEntity> foundEntities = new ArrayList<>();
        foundEntities.add(new VehicleLocationEntity(1L, new Point(new Position(1D, 1D))));
        foundEntities.add(new VehicleLocationEntity(2L, new Point(new Position(1D, 1D))));
        RectangleSearchDto searchDto = new RectangleSearchDto(testBottomLeft, testTopRight);
        when(mockLocationRepository.getByLocationInside(testBottomLeft, testTopRight)).thenReturn(foundEntities);

        ResponseEntity<List<VehicleLocationDto>> response = controller.findAllVehiclesLocatedInRectangle(searchDto);
        List<VehicleLocationDto> responseBody = response.getBody();

        assertEquals(expectedResponseBody, responseBody);
    }
}
