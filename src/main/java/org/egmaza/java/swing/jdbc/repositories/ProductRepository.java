package org.egmaza.java.swing.jdbc.repositories;

import org.egmaza.java.swing.jdbc.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findBy(Long id);
    Product  save(Product product);
    void delete(Long id);

}
