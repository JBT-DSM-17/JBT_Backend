package hello.jbtbe.domain.goods.entity;

import lombok.SneakyThrows;

public enum Location {
    ChungCheongNamdo("충청남도"),
    ChungCheongBukdo("충청북도"),
    GyeongSangnamDo("경상남도"),
    GyeongSangBukDo("경상북도"),
    JeollaNamDo("전라남도"),
    JeollaBukDo("전라북도"),
    GyeonggiDo("경기도"),
    GangwonDo("강원도");

    Location(String value) {
        this.value = value;
    }

    public final String value;

    @SneakyThrows
    public static Location of(String value) {
        for (Location location : Location.values()) {
            if (location.value.equals(value)) {
                return location;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
