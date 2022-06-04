package ru.gdAleko.lesson9HW.repositories.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.gdAleko.lesson9HW.data.Product;

public class ProductSpecification {

    public static Specification<Product> scoreGreaterOrElseThan(Integer cost){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost));
    }

    public static Specification<Product> lessThanOrEqualTo(Integer cost){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost));
    }
}
