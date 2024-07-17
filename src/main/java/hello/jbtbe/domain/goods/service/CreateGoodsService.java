package hello.jbtbe.domain.goods.service;

import hello.jbtbe.domain.goods.dto.request.CreateGoodsRequest;
import hello.jbtbe.domain.goods.entity.GoodsJpaEntity;
import hello.jbtbe.domain.goods.repository.GoodsRepository;
import hello.jbtbe.global.file.FileUploader;
import hello.jbtbe.global.security.currentuser.CurrentUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateGoodsService {

    private final CurrentUser currentUser;

    private final GoodsRepository goodsRepository;
    private final FileUploader fileUploader;

    public void create(CreateGoodsRequest request) {

        final String pictureUrl = fileUploader.upload(request.getPicture());
        final String detailUrl = fileUploader.upload(request.getDetail());

        final GoodsJpaEntity goods = GoodsJpaEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .pictureUrl(pictureUrl)
                .price(request.getPrice())
                .otherPrice(getOtherPrice(request.getPrice()))
                .location(request.getLocation())
                .locationDetail(request.getLocationDetail())
                .detailUrl(detailUrl)
                .category(request.getCategory())
                .user(currentUser.get())
                .isDokyung(request.getIsDokyung())
                .build();

        goodsRepository.save(goods);
    }

    private Integer getOtherPrice(Integer price) {

        int rand = (new Random().nextInt() % 21);

        if (rand < 0) {
            rand = rand * -1 + 1;
        }

        return price + rand * 100; // 100원 ~ 2000원 추가된 값
    }
}
