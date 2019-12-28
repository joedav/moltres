package com.gigiosouza.moltres.api.view.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gigiosouza.moltres.api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductView {

  private Long id;
  private String sku;
  private String name;
  private Double price;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime createdAt;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime updatedAt;
  private Boolean active;

  public static ProductView fromEntity(Product product) {
    return new ProductView(
      product.getId(),
      product.getSku(),
      product.getName(),
      product.getPrice(),
      product.getCreatedAt(),
      product.getUpdatedAt(),
      product.getActive()
    );
  }
}
