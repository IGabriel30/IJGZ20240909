package org.IJGZ20240909.dtos.products;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter

public class ProductIJGZSalida  implements Serializable{

    private Integer id;
    private String nombreIJGZ;
    private String descripcionIJGZ;
    private BigDecimal precioIJGZ;

}
