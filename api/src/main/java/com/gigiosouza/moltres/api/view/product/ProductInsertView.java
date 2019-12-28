package com.gigiosouza.moltres.api.view.product;

import com.gigiosouza.moltres.api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInsertView {
  private String sku;
  private String name;
  private Double price;

  public Product toEntity() {
    return new Product(sku, name, price);
  }
}
