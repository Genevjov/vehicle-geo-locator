package io.genevjov.vgl.model;

import com.mongodb.client.model.geojson.Point;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "vehicle_location")
public class VehicleLocationEntity {

    @Id
    private Long id;
    @GeoSpatialIndexed(name="location")
    private Point location;

}
