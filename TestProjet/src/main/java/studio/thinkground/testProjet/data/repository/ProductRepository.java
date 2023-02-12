package studio.thinkground.testProjet.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.testProjet.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
