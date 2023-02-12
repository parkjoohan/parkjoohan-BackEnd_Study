package studio.thinkground.testProjet.data.dao;

import studio.thinkground.testProjet.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
