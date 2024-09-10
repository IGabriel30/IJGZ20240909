package org.IJGZ20240909.servicios.interfaces;

import org.IJGZ20240909.dtos.products.ProductIJGZGuardar;
import org.IJGZ20240909.dtos.products.ProductIJGZModificar;
import org.IJGZ20240909.dtos.products.ProductIJGZSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IProductIJGZService {
    List<ProductIJGZSalida> obtenerTodos();

    Page<ProductIJGZSalida> obtenerTodosPaginados(Pageable pageable);

    ProductIJGZSalida obtenerPorId(Integer id);

    ProductIJGZSalida crear(ProductIJGZGuardar productGuardar);

    ProductIJGZSalida editar(ProductIJGZModificar productModificar);

    void eliminarPorId(Integer id);
}
