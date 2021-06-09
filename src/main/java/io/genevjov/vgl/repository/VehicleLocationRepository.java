package io.genevjov.vgl.repository;

import java.util.List;

import io.genevjov.vgl.model.VehicleLocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLocationRepository extends MongoRepository<VehicleLocationEntity, Long> {

    @Query("{ \"location\" : { \"$geoWithin\" : { \"$box\" : [?0, ?1]}}}")
    List<VehicleLocationEntity> getByLocationInside(double[] letBottomPoint, double[] rightTopPoint);

}
