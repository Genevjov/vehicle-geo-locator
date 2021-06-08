package io.genevjov.vgl.service;

import io.genevjov.vgl.model.VehicleLocationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    VehicleLocationEntity save(VehicleLocationEntity aVehicleLocationEntity);

    List<VehicleLocationEntity> findAllInsideThePolygon(double[] letBottomPoint, double[] rightTopPoint);

}
