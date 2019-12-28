package com.gigiosouza.moltres.api.controller;

import com.gigiosouza.moltres.api.entity.Product;
import com.gigiosouza.moltres.api.exception.ProductNotFoundException;
import com.gigiosouza.moltres.api.repository.ProductRepository;
import com.gigiosouza.moltres.api.view.product.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductRepository repository;

  @GetMapping
  public List<ProductListView> listAll() {
    return this.repository.findAll().stream().map(ProductListView::fromEntity).collect(Collectors.toList());
  }

  @PostMapping
  public ProductInsertResponseView insert(@RequestBody ProductInsertView view) {
    Product product = view.toEntity();
    product = this.repository.save(product);
    return ProductInsertResponseView.fromEntity(product);
  }

  @GetMapping("/{id}")
  public ProductView getProduct(@PathVariable Long id) throws ProductNotFoundException {
    Optional<Product> product = this.repository.findById(id);

    if (!product.isPresent()) {
      throw new ProductNotFoundException();
    }

    return ProductView.fromEntity(product.get());
  }

  @PatchMapping("/{id}")
  public ProductUpdateResponseView update(@PathVariable Long id, @RequestBody ProductUpdateView view) throws
    ProductNotFoundException {
    Optional<Product> optionalProduct = this.repository.findById(id);

    if (!optionalProduct.isPresent()) {
      throw new ProductNotFoundException();
    }

    Product product = optionalProduct.get();
    product.setName(view.getName());
    product.setPrice(view.getPrice());

    product = this.repository.save(product);

    return ProductUpdateResponseView.fromEntity(product);
  }


  @PatchMapping("/{id}/active")
  public ProductUpdateResponseView active(@PathVariable Long id, @RequestBody ProductChangeActiveStateView view) throws ProductNotFoundException {
    Optional<Product> optionalProduct = this.repository.findById(id);

    if (!optionalProduct.isPresent()) {
      throw new ProductNotFoundException();
    }

    Product product = optionalProduct.get();
    product.setActive(view.getActive());

    this.repository.save(product);

    product = this.repository.save(product);

    return ProductUpdateResponseView.fromEntity(product);
  }
}
