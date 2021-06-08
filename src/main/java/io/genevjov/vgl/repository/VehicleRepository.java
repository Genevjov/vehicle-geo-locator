package io.genevjov.vgl.repository;

import java.util.List;

import io.genevjov.vgl.model.VehicleLocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleLocationEntity, Long> {

    @Query("location: { $geoWithin: { $box: [?0, ?1]}}}")
    List<VehicleLocationEntity> findAllByLocationIsWithin(double[] a, double[] b);

}
