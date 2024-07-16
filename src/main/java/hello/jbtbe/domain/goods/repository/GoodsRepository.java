package hello.jbtbe.domain.goods.repository;

import hello.jbtbe.domain.goods.entity.GoodsJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsJpaEntity, Long> {
}
