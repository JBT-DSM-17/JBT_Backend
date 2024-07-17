package hello.jbtbe.domain.goods.dto;

import hello.jbtbe.domain.goods.entity.Category;
import lombok.SneakyThrows;

public class CategoryConvertor {

    public static Category convert(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return Category.of(str);
    }
}
