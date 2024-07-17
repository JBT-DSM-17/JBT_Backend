package hello.jbtbe.domain.goods.dto;

import hello.jbtbe.domain.goods.entity.Location;

import java.util.List;

public class LocationConvertor {

    public static Location convert(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return Location.of(str);
    }

    public static List<Location> convertList(List<String> str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str.stream().map(Location::of).toList();
    }
}
