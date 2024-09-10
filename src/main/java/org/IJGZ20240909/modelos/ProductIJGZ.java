package org.IJGZ20240909.modelos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "productosIJGZ")
public class ProductIJGZ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreIJGZ;
    private String descripcionIJGZ;
    private BigDecimal precioIJGZ;
}
