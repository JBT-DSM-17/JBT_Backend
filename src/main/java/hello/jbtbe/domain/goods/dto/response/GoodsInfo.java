package hello.jbtbe.domain.goods.dto.response;

import hello.jbtbe.domain.goods.entity.GoodsJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GoodsInfo {
    private Long id;
    private String picture;
    private String name;
    private Integer price;
    private String location;
    private String locationDetail;
    private String description;

    public static GoodsInfo from(GoodsJpaEntity goods) {
        return GoodsInfo.builder()
                .id(goods.getId())
                .picture(goods.getPictureUrl())
                .name(goods.getName())
                .price(goods.getPrice())
                .location(goods.getLocation().value)
                .locationDetail(goods.getLocationDetail())
                .description(goods.getDescription())
                .build();
    }
}
