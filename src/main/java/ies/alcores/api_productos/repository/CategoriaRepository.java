package ies.alcores.api_productos.repository;

import ies.alcores.api_productos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
