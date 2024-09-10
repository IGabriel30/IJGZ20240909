package org.IJGZ20240909.controladores;

import org.IJGZ20240909.dtos.products.ProductIJGZGuardar;
import org.IJGZ20240909.dtos.products.ProductIJGZModificar;
import org.IJGZ20240909.dtos.products.ProductIJGZSalida;
import org.IJGZ20240909.servicios.interfaces.IProductIJGZService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductIJGZController {
    @Autowired
    private IProductIJGZService productIJGZService;

    @GetMapping
    public ResponseEntity<Page<ProductIJGZSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<ProductIJGZSalida> productos = productIJGZService.obtenerTodosPaginados(pageable);
        if(productos.hasContent()){
            return ResponseEntity.ok(productos);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductIJGZSalida>> mostrarTodos(){
        List<ProductIJGZSalida> productos = productIJGZService.obtenerTodos();
        if(!productos.isEmpty()){
            return ResponseEntity.ok(productos);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductIJGZSalida> buscarPorId(@PathVariable Integer id){
        ProductIJGZSalida producto = productIJGZService.obtenerPorId(id);

        if(producto != null){
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductIJGZSalida> crear(@RequestBody ProductIJGZGuardar productGuardar){
        ProductIJGZSalida producto = productIJGZService.crear(productGuardar);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductIJGZSalida> editar(@PathVariable Integer id, @RequestBody ProductIJGZModificar productIJGZModificar){
        ProductIJGZSalida producto = productIJGZService.editar(productIJGZModificar);
        return ResponseEntity.ok(producto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        productIJGZService.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
