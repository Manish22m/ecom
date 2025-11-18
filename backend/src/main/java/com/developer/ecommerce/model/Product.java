package com.developer.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String description;
        private String brand;
        private int price;
        private String category;
        private Date releasedate;
        private boolean productAvailable;
        private int stockQuantity;
        private String imageName;
        private String imageType;

        @Lob
        private byte[] imageData;
}
