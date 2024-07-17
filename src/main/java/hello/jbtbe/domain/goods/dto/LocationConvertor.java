package hello.jbtbe.domain.goods.dto;

import hello.jbtbe.domain.goods.entity.Location;

import java.util.List;

public class LocationConvertor {

    public static List<Location> convert(List<String> str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str.stream().map(Location::of).toList();
    }
}
