package hello.jbtbe.domain.goods.dto.request;

import hello.jbtbe.domain.goods.entity.Category;
import hello.jbtbe.domain.goods.entity.Location;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GoodsListRequest {

    private Category category;

    private List<Location> location;

    private boolean isDokyung;
}
