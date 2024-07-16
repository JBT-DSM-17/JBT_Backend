package hello.jbtbe.domain.goods.dto.response;

import hello.jbtbe.domain.goods.entity.GoodsJpaEntity;
import hello.jbtbe.domain.user.dto.response.SellerInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class GoodsDetailResponse {
    private String picture;
    private String name;
    private Integer price;
    private String location;
    private String locationDetail;
    private String description;
    private String detail;
    private SellerInfo seller;

    public static GoodsDetailResponse from(GoodsJpaEntity goods) {
        return GoodsDetailResponse.builder()
                .picture(goods.getPictureUrl())
                .name(goods.getName())
                .price(goods.getPrice())
                .location(goods.getLocation())
                .locationDetail(goods.getLocationDetail())
                .description(goods.getDescription())
                .detail(goods.getDetailUrl())
                .seller(SellerInfo.from(goods.getUser()))
                .build();
    }
}
