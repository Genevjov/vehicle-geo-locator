package io.genevjov.vgl.service;

import java.util.List;

import io.genevjov.vgl.model.VehicleLocationEntity;
import org.springframework.data.geo.Box;
import org.springframework.stereotype.Service;

@Service
public interface VehicleService {

    VehicleLocationEntity save(VehicleLocationEntity aVehicleLocationEntity);

    List<VehicleLocationEntity> findAllInsideThePolygon(double[] a, double[] b);
}
