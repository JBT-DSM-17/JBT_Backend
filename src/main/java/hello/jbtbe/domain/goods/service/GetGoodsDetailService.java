package hello.jbtbe.domain.goods.service;

import hello.jbtbe.domain.goods.dto.response.GoodsDetailResponse;
import hello.jbtbe.domain.goods.entity.GoodsJpaEntity;
import hello.jbtbe.domain.goods.repository.GoodsRepository;
import hello.jbtbe.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetGoodsDetailService {

    public final GoodsRepository goodsRepository;

    public GoodsDetailResponse getGoodsDetail(Long goodsId) {
        GoodsJpaEntity goods = goodsRepository.findById(goodsId)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, "Goods not found."));

        return GoodsDetailResponse.from(goods);
    }
}
