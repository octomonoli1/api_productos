package ies.alcores.api_productos.controller;

import ies.alcores.api_productos.model.Categoria;
import ies.alcores.api_productos.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> list(){
        return ResponseEntity.ok(this.categoriaService.findAll());
    }
}
