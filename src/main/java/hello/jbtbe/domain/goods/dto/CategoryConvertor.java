package hello.jbtbe.domain.goods.dto;

import hello.jbtbe.domain.goods.entity.Category;

public class CategoryConvertor {

    public static Category convert(String str) {
        return Category.valueOf(str);
    }
}
