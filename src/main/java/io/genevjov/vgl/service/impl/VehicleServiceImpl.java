package io.genevjov.vgl.service.impl;

import io.genevjov.vgl.model.VehicleLocationEntity;
import io.genevjov.vgl.repository.VehicleLocationRepository;
import io.genevjov.vgl.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleLocationRepository vehicleLocationRepository;

    @Override
    public VehicleLocationEntity save(VehicleLocationEntity vehicleLocationEntity) {
        return vehicleLocationRepository.save(vehicleLocationEntity);
    }

    @Override
    public List<VehicleLocationEntity> findAllInsideThePolygon(double[] letBottomPoint, double[] rightTopPoint) {
        return vehicleLocationRepository.getByLocationInside(letBottomPoint, rightTopPoint);
    }
}
