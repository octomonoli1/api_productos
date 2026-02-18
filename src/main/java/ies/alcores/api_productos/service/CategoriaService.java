package ies.alcores.api_productos.service;

import ies.alcores.api_productos.model.Categoria;
import ies.alcores.api_productos.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return this.categoriaRepository.findAll();
    }

}
