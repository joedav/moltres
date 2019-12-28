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
public class ProductUpdateResponseView {
  private Long id;
  private String sku;
  private String name;
  private Double price;
  private Boolean active;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime updatedAt;

  public static ProductUpdateResponseView fromEntity(Product product) {
    return new ProductUpdateResponseView(
      product.getId(),
      product.getSku(),
      product.getName(),
      product.getPrice(),
      product.getActive(),
      product.getUpdatedAt()
    );
  }
}
