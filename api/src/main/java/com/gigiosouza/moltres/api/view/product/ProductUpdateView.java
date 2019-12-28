package com.gigiosouza.moltres.api.view.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateView {
  private String name;
  private Double price;
}
