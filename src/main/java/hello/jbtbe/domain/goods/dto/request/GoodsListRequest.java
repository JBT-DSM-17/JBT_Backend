package hello.jbtbe.domain.goods.dto.request;

import hello.jbtbe.domain.goods.entity.Category;
import hello.jbtbe.domain.goods.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GoodsListRequest {

    private Category category;

    private List<Location> location;

    private boolean isDokyung;
}
