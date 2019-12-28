package com.gigiosouza.moltres.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "sku", length = 10, unique = true, nullable = false)
  private String sku;

  @Column(name = "name", length = 255, nullable = false)
  private String name;

  @Column(name = "price", nullable = false, precision = 2)
  private Double price;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "active")
  private Boolean active;

  public Product(final String sku, final String name, final Double price) {
    this.sku = sku;
    this.name = name;
    this.price = price;
  }

  @PrePersist
  public void prePersist() {
    this.createdAt = LocalDateTime.now();
    this.active = true;
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}

