package hello.jbtbe.domain.goods.controller;

import hello.jbtbe.domain.goods.dto.request.GoodsListWebRequest;
import hello.jbtbe.domain.goods.dto.response.GoodsDetailResponse;
import hello.jbtbe.domain.goods.dto.response.GoodsListResponse;
import hello.jbtbe.domain.goods.service.GetGoodsDetailService;
import hello.jbtbe.domain.goods.service.GetGoodsListService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public GoodsListResponse readList(
            @RequestBody
            GoodsListWebRequest request
    ) {
        return getGoodsListService.getGoodsList(request.toRequest());
    }
}
