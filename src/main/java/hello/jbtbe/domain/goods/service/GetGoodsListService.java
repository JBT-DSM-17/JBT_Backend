package hello.jbtbe.domain.goods.service;

import hello.jbtbe.domain.goods.dto.request.GoodsListRequest;
import hello.jbtbe.domain.goods.dto.response.GoodsInfo;
import hello.jbtbe.domain.goods.dto.response.GoodsListResponse;
import hello.jbtbe.domain.goods.entity.GoodsJpaEntity;
import hello.jbtbe.domain.goods.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetGoodsListService {

    private final GoodsRepository goodsRepository;

    public GoodsListResponse getGoodsList(GoodsListRequest request) {
        List<GoodsJpaEntity> goods = goodsRepository.findAll();

        if (request.getCategory() != null) {
            goods = goods.stream()
                    .filter(it -> request.getCategory().equals(it.getCategory())).toList();
        }

        if (request.getLocation() != null) {
            goods = goods.stream()
                    .filter(it -> request.getLocation().contains(it.getLocation())).toList();
        }

        if (request.isDokyung()) {
            goods = goods.stream()
                    .filter(it -> it.isDokyung()).toList();
        }

        return new GoodsListResponse(
                goods.stream().map(it -> GoodsInfo.from(it)).toList()
        );
    }
}
