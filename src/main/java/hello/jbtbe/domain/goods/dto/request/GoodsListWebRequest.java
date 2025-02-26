package hello.jbtbe.domain.goods.dto.request;

import hello.jbtbe.domain.goods.dto.CategoryConvertor;
import hello.jbtbe.domain.goods.dto.LocationConvertor;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GoodsListWebRequest {

    private String category;

    private List<String> location;

    @NotNull
    private boolean isDokyung;

    public GoodsListRequest toRequest() {
        return new GoodsListRequest(
                CategoryConvertor.convert(this.category),
                LocationConvertor.convertList(this.location),
                this.isDokyung
        );
    }
}
