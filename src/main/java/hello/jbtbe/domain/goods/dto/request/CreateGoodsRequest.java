package hello.jbtbe.domain.goods.dto.request;

import hello.jbtbe.domain.goods.entity.Category;
import hello.jbtbe.domain.goods.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class CreateGoodsRequest {
    private MultipartFile picture;
    private String name;
    private String description;
    private Category category;
    private Integer price;
    private Location location;
    private String locationDetail;
    private Boolean isDokyung;
    private MultipartFile detail;
}
