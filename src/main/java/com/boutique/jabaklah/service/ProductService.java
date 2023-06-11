package com.boutique.jabaklah.service;

import com.boutique.jabaklah.model.Product;

import java.util.List;

public interface ProductService {

    String saveProduct(Product product);

    List<Product> findAllProducts();

    List<Product> findAllProductsForAdmin();

    Product findProductById(Integer id);

    String deleteProduct(Integer id);

    String updateProduct(Product product);

    List<Product> findProductByCategoryId(Integer categoryId);

    Product findProductByIdForAdmin(int id);


}
