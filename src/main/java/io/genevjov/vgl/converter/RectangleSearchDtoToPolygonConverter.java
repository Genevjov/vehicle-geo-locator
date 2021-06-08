package io.genevjov.vgl.converter;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.Position;
import io.genevjov.vgl.dto.GeoPintDto;
import io.genevjov.vgl.dto.RectangleSearchDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

@Component
public class RectangleSearchDtoToPolygonConverter implements Converter<RectangleSearchDto, Polygon> {

    @Override
    public Polygon convert(RectangleSearchDto rectangleSearchDto) {
        List<Position> positions = new ArrayList<>();
        positions.add(toPoint(rectangleSearchDto.getLeftTopPoint()));
        positions.add(toPoint(rectangleSearchDto.getRightTopPoint()));
        positions.add(toPoint(rectangleSearchDto.getRightBottomPoint()));
        return new Polygon(positions);

    }

    private Position toPoint(GeoPintDto geoPintDto) {
        return new Position(geoPintDto.getLatitude(), geoPintDto.getLongitude());
    }
}
