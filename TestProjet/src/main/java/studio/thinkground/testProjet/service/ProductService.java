package studio.thinkground.testProjet.service;

import studio.thinkground.testProjet.data.dto.ProductDto;

public interface ProductService {

    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);
}
