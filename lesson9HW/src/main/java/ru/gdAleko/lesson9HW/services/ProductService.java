package ru.gdAleko.lesson9HW.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gdAleko.lesson9HW.data.Product;
import ru.gdAleko.lesson9HW.dto.ProductDto;
import ru.gdAleko.lesson9HW.repositories.ProductRepository;
import ru.gdAleko.lesson9HW.repositories.specification.ProductSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> find(Integer p, Integer maxCost, Integer minCost){
        Specification<Product> spec = Specification.where(null);

        if(minCost != null){
            spec = spec.and(ProductSpecification.scoreGreaterOrElseThan(minCost));
        }
        if(maxCost != null){
            spec = spec.and(ProductSpecification.lessThanOrEqualTo(maxCost));
        }
        return productRepository.findAll(spec, PageRequest.of(p -1, 10));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findBiRangeCost(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public Optional<Product> findByTitle(String title) {
        return productRepository.findProductByTitle(title);
    }

    public List<Product> findCostLessThan(Integer max) {
        return productRepository.findCostLessThan(max);
    }

    public List<Product> findCostMoreThan(Integer min) {
        return productRepository.findCostMoreThan(min);
    }

}
