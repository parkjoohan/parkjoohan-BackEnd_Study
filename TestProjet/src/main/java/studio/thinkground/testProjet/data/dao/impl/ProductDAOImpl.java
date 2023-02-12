package studio.thinkground.testProjet.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.testProjet.data.dao.ProductDAO;
import studio.thinkground.testProjet.data.entity.ProductEntity;
import studio.thinkground.testProjet.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    // @AutoWired를 통해 자동 연결 후 객체를 주입 받음 (의존성 주입)
    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
