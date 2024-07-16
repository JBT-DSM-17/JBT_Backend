package hello.jbtbe.domain.goods.controller;

import hello.jbtbe.domain.goods.dto.request.GoodsListRequest;
import hello.jbtbe.domain.goods.dto.response.GoodsDetailResponse;
import hello.jbtbe.domain.goods.dto.response.GoodsListResponse;
import hello.jbtbe.domain.goods.service.GetGoodsDetailService;
import hello.jbtbe.domain.goods.service.GetGoodsListService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/goods")
@RestController
public class GoodsController {

    private final GetGoodsDetailService getGoodsDetailService;
    private final GetGoodsListService getGoodsListService;

    @GetMapping("/{id}")

    public GoodsDetailResponse getDetail(
            @PathVariable
            @Positive
            Long id
    ) {
        return getGoodsDetailService.getGoodsDetail(id);
    }

    @GetMapping
    public GoodsListResponse readlist (GoodsListRequest request){
        return getGoodsListService.getGoodsList(request);
    }
}
