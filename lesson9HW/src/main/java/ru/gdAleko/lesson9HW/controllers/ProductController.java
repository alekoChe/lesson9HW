package ru.gdAleko.lesson9HW.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gdAleko.lesson9HW.data.Product;
import ru.gdAleko.lesson9HW.dto.ProductDto;
import ru.gdAleko.lesson9HW.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public Page<ProductDto> getAllProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                        @RequestParam(name = "min_Cost", required = false) Integer minCost,
                                        @RequestParam(name = "max_Cost", required = false) Integer maxCost
    ) {
        if(page < 1){
            page = 1;
        }
        return productService.find(page, minCost, maxCost).map(p -> new ProductDto(p));
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) { return productService.addProduct(product);}

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) { return productService.findById(id).map(p -> new ProductDto(p)).orElseThrow(); }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/{title}")
    public ProductDto getByTitle(@PathVariable String title) {
        return productService.findByTitle(title).map(p -> new ProductDto(p)).orElseThrow();
    }

    @GetMapping("/between")
    public List<ProductDto> findByRangeBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100000") Integer max) {
        return productService.findBiRangeCost(min, max).stream().map(p -> new ProductDto(p)).collect(Collectors.toList());
    }

    @GetMapping("/less")
    public  List<ProductDto> getLowThenMax(@RequestParam(defaultValue = "100000") Integer max) {
        return productService.findCostLessThan(max).stream().map(p -> new ProductDto(p)).collect(Collectors.toList());
    }

    @GetMapping("/more")
    public  List<ProductDto> getHighThenMax(@RequestParam(defaultValue = "0") Integer min) {
        return productService.findCostMoreThan(min).stream().map(p -> new ProductDto(p)).collect(Collectors.toList());
    }

}
