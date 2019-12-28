package com.gigiosouza.moltres.api.view.product;

import com.gigiosouza.moltres.api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInsertResponseView {
  private Long id;
  private String sku;
  private String name;
  private Double price;

  public static ProductInsertResponseView fromEntity(Product product) {
    return new ProductInsertResponseView(
      product.getId(),
      product.getSku(),
      product.getName(),
      product.getPrice()
    );
  }
}
