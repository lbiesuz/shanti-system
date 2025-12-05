package com.shanti.compras.service;

import com.shanti.compras.entity.Insumo;
import com.shanti.compras.entity.Tipo;
import com.shanti.compras.repository.InsumoRepository;
import com.shanti.compras.repository.TipoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsumoServiceTest {

    @Mock
    InsumoRepository insumoRepository;

    @Mock
    TipoRepository tipoRepository;

    @InjectMocks
    InsumoService insumoService;

    private Insumo insumo;
    private Tipo tipo;

    @BeforeEach
    void setUp() {
        tipo = new Tipo("Matéria Prima");
        tipo.setId(1L);
        
        insumo = new Insumo("Óleo Essencial", new BigDecimal("45.50"), tipo);
        insumo.setId(1L);
        insumo.setEstoqueInsumo(100);
    }

    @Test
    void testListarTodos() {

        List<Insumo> insumos = Arrays.asList(insumo);
        when(insumoRepository.listAll()).thenReturn(insumos);

        List<Insumo> resultado = insumoService.listarTodos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(insumoRepository, times(1)).listAll();
    }

    @Test
    void testBuscarPorId() {

        when(insumoRepository.findById(1L)).thenReturn(insumo);

        Insumo resultado = insumoService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Óleo Essencial", resultado.getDescricao());
        assertEquals(100, resultado.getEstoqueInsumo());
        verify(insumoRepository, times(1)).findById(1L);
    }

    @Test
    void testListarPorTipo() {

        List<Insumo> insumos = Arrays.asList(insumo);
        when(insumoRepository.findByTipo(1L)).thenReturn(insumos);

        List<Insumo> resultado = insumoService.listarPorTipo(1L);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(insumoRepository, times(1)).findByTipo(1L);
    }

    @Test
    void testListarEstoqueBaixo() {

        insumo.setEstoqueInsumo(5);
        List<Insumo> insumos = Arrays.asList(insumo);
        when(insumoRepository.findEstoqueBaixo(10)).thenReturn(insumos);

        List<Insumo> resultado = insumoService.listarEstoqueBaixo(10);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertTrue(resultado.get(0).getEstoqueInsumo() < 10);
        verify(insumoRepository, times(1)).findEstoqueBaixo(10);
    }

    @Test
    void testCriar() {

        Insumo novoInsumo = new Insumo("Novo Insumo", new BigDecimal("20.00"), tipo);
        doNothing().when(insumoRepository).persist(any(Insumo.class));

        Insumo resultado = insumoService.criar(novoInsumo);

        assertNotNull(resultado);
        assertEquals("Novo Insumo", resultado.getDescricao());
        verify(insumoRepository, times(1)).persist(novoInsumo);
    }

    @Test
    void testAtualizarEstoque() {

        when(insumoRepository.findById(1L)).thenReturn(insumo);
        doNothing().when(insumoRepository).persist(any(Insumo.class));

        insumoService.atualizarEstoque(1L, 50);

        assertEquals(150, insumo.getEstoqueInsumo());
        verify(insumoRepository, times(1)).findById(1L);
        verify(insumoRepository, times(1)).persist(insumo);
    }

    @Test
    void testAtualizarEstoqueNegativo() {

        when(insumoRepository.findById(1L)).thenReturn(insumo);
        doNothing().when(insumoRepository).persist(any(Insumo.class));

        insumoService.atualizarEstoque(1L, -30);

        assertEquals(70, insumo.getEstoqueInsumo());
        verify(insumoRepository, times(1)).findById(1L);
        verify(insumoRepository, times(1)).persist(insumo);
    }

    @Test
    void testDeletar() {

        when(insumoRepository.deleteById(1L)).thenReturn(true);

        boolean resultado = insumoService.deletar(1L);

        assertTrue(resultado);
        verify(insumoRepository, times(1)).deleteById(1L);
    }
}