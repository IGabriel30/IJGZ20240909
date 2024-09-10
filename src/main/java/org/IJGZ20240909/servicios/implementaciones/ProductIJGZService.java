package org.IJGZ20240909.servicios.implementaciones;

import org.IJGZ20240909.dtos.products.ProductIJGZGuardar;
import org.IJGZ20240909.dtos.products.ProductIJGZModificar;
import org.IJGZ20240909.dtos.products.ProductIJGZSalida;
import org.IJGZ20240909.modelos.ProductIJGZ;
import org.IJGZ20240909.repositorios.IProductIJGZRepository;
import org.IJGZ20240909.servicios.interfaces.IProductIJGZService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductIJGZService implements IProductIJGZService {
    @Autowired
    private IProductIJGZRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductIJGZSalida> obtenerTodos() {
        List<ProductIJGZ> products = productRepository.findAll();

        return products.stream()
                .map(product -> modelMapper.map(product, ProductIJGZSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductIJGZSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<ProductIJGZ> page = productRepository.findAll(pageable);

        List<ProductIJGZSalida> productsDto = page.stream()
                .map(product -> modelMapper.map(product, ProductIJGZSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productsDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProductIJGZSalida obtenerPorId(Integer id) {
        return modelMapper.map(productRepository.findById(id).get(), ProductIJGZSalida.class);
    }

    @Override
    public ProductIJGZSalida crear(ProductIJGZGuardar productGuardar) {
        ProductIJGZ product = productRepository.save(modelMapper.map(productGuardar, ProductIJGZ.class));
        return modelMapper.map(product, ProductIJGZSalida.class);
    }

    @Override
    public ProductIJGZSalida editar(ProductIJGZModificar  productModificar) {
        ProductIJGZ product = productRepository.save(modelMapper.map(productModificar, ProductIJGZ.class));
        return modelMapper.map(product, ProductIJGZSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productRepository.deleteById(id);
    }
}
