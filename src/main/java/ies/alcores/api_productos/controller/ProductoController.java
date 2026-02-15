package ies.alcores.api_productos.controller;

import ies.alcores.api_productos.model.Producto;
import ies.alcores.api_productos.service.ProductoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    private ResponseEntity<List<Producto>> listar(){
        return ResponseEntity.ok(this.productoService.findAll());
    }

    @GetMapping("/{codBarras}")
    private ResponseEntity<Producto> obtenerPorCodBarras(@PathVariable final String codBarras){
        return this.productoService.findByCodigoBarras(codBarras)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    private ResponseEntity<Producto> craete(@Valid @RequestBody Producto producto){
        return ResponseEntity.ok(this.productoService.save((producto)));
    }

    @DeleteMapping("/delete/{codBarras}")
    private ResponseEntity<Void> delete(@PathVariable final String codBarras){
        this.productoService.delete(codBarras);
        return ResponseEntity.noContent().build();
    }
}
