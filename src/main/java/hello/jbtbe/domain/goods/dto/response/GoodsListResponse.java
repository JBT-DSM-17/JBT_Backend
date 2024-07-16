package hello.jbtbe.domain.goods.dto.response;

import hello.jbtbe.domain.goods.entity.Category;
import hello.jbtbe.domain.goods.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class GoodsListResponse {
    private final List<GoodsInfo> items;

}
