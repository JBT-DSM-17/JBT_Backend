package hello.jbtbe.domain.goods.entity;

import hello.jbtbe.domain.user.entity.UserJpaEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class GoodsJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String pictureUrl;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Location location;

    @Column(nullable = false)
    private String locationDetail;

    @Column(nullable = false)
    private String detailUrl;

    @Column(nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    @Column(nullable = false)
    private boolean isDokyung;
}
