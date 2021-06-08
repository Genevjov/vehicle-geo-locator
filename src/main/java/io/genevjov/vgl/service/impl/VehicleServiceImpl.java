package io.genevjov.vgl.service.impl;

import java.util.List;

import io.genevjov.vgl.model.VehicleLocationEntity;
import io.genevjov.vgl.repository.VehicleRepository;
import io.genevjov.vgl.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private MongoTemplate fMongoTemplate;

    @Override
    public VehicleLocationEntity save(VehicleLocationEntity aVehicleLocationEntity) {
        return vehicleRepository.save(aVehicleLocationEntity);
    }

    @Override
    public List<VehicleLocationEntity> findAllInsideThePolygon(double[] a, double[] b) {
        return vehicleRepository.findAllByLocationIsWithin(a, b);
    }
}
