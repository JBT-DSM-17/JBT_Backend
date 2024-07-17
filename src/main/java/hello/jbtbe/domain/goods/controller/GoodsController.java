package hello.jbtbe.domain.goods.controller;

import hello.jbtbe.domain.goods.dto.CategoryConvertor;
import hello.jbtbe.domain.goods.dto.LocationConvertor;
import hello.jbtbe.domain.goods.dto.request.CreateGoodsRequest;
import hello.jbtbe.domain.goods.dto.request.GoodsListWebRequest;
import hello.jbtbe.domain.goods.dto.response.GoodsDetailResponse;
import hello.jbtbe.domain.goods.dto.response.GoodsListResponse;
import hello.jbtbe.domain.goods.service.CreateGoodsService;
import hello.jbtbe.domain.goods.service.GetGoodsDetailService;
import hello.jbtbe.domain.goods.service.GetGoodsListService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RequiredArgsConstructor
@RequestMapping("/goods")
@RestController
public class GoodsController {

    private final GetGoodsDetailService getGoodsDetailService;
    private final GetGoodsListService getGoodsListService;
    private final CreateGoodsService createGoodsService;

    @PostMapping("/new")
    public void create(
            @Valid
            @RequestParam("picture")
            @NotNull
            MultipartFile picture,
            @Valid
            @RequestParam("name")
            @Size(min = 1, max = 40)
            @NotBlank
            String name,
            @Valid
            @RequestParam("description")
            @Size(min = 1, max = 1000)
            String description,
            @Valid
            @RequestParam("category")
            String category,
            @Valid
            @RequestParam("price")
            @Positive
            @Max(1000000)
            Integer price,
            @Valid
            @RequestParam("location")
            @Size(min = 1, max = 20)
            @NotBlank
            String location,
            @Valid
            @RequestParam("location_detail")
            @Size(min = 1, max = 20)
            @NotBlank
            String locationDetail,
            @Valid
            @RequestParam("is_dokyung")
            Boolean isDokyung,
            @Valid
            @RequestParam("detail")
            @NotNull
            MultipartFile detail
    ) {
        createGoodsService.create(
                new CreateGoodsRequest(
                        picture,
                        name,
                        description,
                        CategoryConvertor.convert(category),
                        price,
                        LocationConvertor.convert(location),
                        locationDetail,
                        isDokyung,
                        detail
                )
        );
    }

    @GetMapping("/{id}")
    public GoodsDetailResponse getDetail(
            @PathVariable
            @Positive
            Long id
    ) {
        return getGoodsDetailService.getGoodsDetail(id);
    }

    @PostMapping
    public GoodsListResponse readList(
            @Valid
            @RequestBody
            GoodsListWebRequest request
    ) {
        return getGoodsListService.getGoodsList(request.toRequest());
    }
}
