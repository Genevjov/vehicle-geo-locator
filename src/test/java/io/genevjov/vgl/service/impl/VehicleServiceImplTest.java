package io.genevjov.vgl.service.impl;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import io.genevjov.vgl.BaseSpringTest;
import io.genevjov.vgl.model.VehicleLocationEntity;
import io.genevjov.vgl.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class VehicleServiceImplTest extends BaseSpringTest {

    @Autowired
    private VehicleService vehicleService;

    @Test
    public void shouldVerifyThatThatSaveMethodReturnTheSameDataOnlyInEntityObject() {
        VehicleLocationEntity expectedEntity = new VehicleLocationEntity(1L, new Point(new Position(1D, 1D)));
        when(mockLocationRepository.save(expectedEntity)).thenReturn(expectedEntity);

        VehicleLocationEntity result = vehicleService.save(expectedEntity);

        assertEquals(expectedEntity, result);
    }

    @Test
    public void shouldVerifyThatThatFindMethodReturnDataCorrectly() {
        List<VehicleLocationEntity> expectedResult = new ArrayList<>();
        expectedResult.add(new VehicleLocationEntity(1L, new Point(new Position(1D, 1D))));
        expectedResult.add(new VehicleLocationEntity(2L, new Point(new Position(1D, 1D))));
        double[] testBottomLeft = new double[] {1D, 1D};
        double[] testTopRight = new double[] {1D, 1D};
        when(mockLocationRepository.getByLocationInside(testBottomLeft, testTopRight)).thenReturn(expectedResult);

        List<VehicleLocationEntity> result = vehicleService.findAllInsideThePolygon(testBottomLeft,
                                                                                    testTopRight);
        assertEquals(expectedResult, result);
    }
}