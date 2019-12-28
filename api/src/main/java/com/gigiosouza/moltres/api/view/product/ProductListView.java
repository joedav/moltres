package com.gigiosouza.moltres.api.view.product;

import com.gigiosouza.moltres.api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListView {
  private Long id;
  private String sku;
  private String name;
  private Double price;
  private Boolean active;

  public static ProductListView fromEntity(Product product) {
    return new ProductListView(
      product.getId(),
      product.getSku(),
      product.getName(),
      product.getPrice(),
      product.getActive()
    );
  }
}
