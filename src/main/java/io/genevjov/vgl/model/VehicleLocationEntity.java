package io.genevjov.vgl.model;

import javax.validation.constraints.NotNull;

import com.mongodb.client.model.geojson.Point;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "vehicle_location")
@EqualsAndHashCode
public class VehicleLocationEntity {

    @Id
    @NotNull
    private Long id;
    @GeoSpatialIndexed(name = "location")
    @NotNull
    private Point location;

}
