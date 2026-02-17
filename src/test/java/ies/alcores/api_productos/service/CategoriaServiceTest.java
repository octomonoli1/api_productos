package ies.alcores.api_productos.service;

import ies.alcores.api_productos.model.Categoria;
import ies.alcores.api_productos.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CategoriaServiceTest {

    private CategoriaRepository categoriaRepository;
    private CategoriaService categoriaService;

    @BeforeEach
    public void setUp(){
        this.categoriaRepository = mock(CategoriaRepository.class);
        this.categoriaService = new CategoriaService(this.categoriaRepository);
    }

    @Test
    void test_findAll(){
        //Given
        Categoria cat1 = this.createCategoria();

        //When
        when(this.categoriaRepository.findAll()).thenReturn(List.of(cat1));
        List<Categoria> result = this.categoriaService.findAll();

        //Then
        assertNotNull(result);
        assertEquals(cat1, result.get(0));
        verify(this.categoriaRepository).findAll();
    }

    private Categoria createCategoria(){
        Categoria result = new Categoria();
        result.setId(1);
        result.setNombre("TEST");

        return result;
    }

}
