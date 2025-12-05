package com.shanti.compras.service;

import com.shanti.compras.entity.Tipo;
import com.shanti.compras.repository.TipoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TipoServiceTest {

    @Mock
    TipoRepository tipoRepository;

    @InjectMocks
    TipoService tipoService;

    private Tipo tipo;

    @BeforeEach
    void setUp() {
        tipo = new Tipo("Matéria Prima");
        tipo.setId(1L);
    }

    @Test
    void testListarTodos() {

        List<Tipo> tipos = Arrays.asList(tipo, new Tipo("Embalagem"));
        when(tipoRepository.listAll()).thenReturn(tipos);

        List<Tipo> resultado = tipoService.listarTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(tipoRepository, times(1)).listAll();
    }

    @Test
    void testBuscarPorId() {

        when(tipoRepository.findById(1L)).thenReturn(tipo);

        Tipo resultado = tipoService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Matéria Prima", resultado.getDescricao());
        verify(tipoRepository, times(1)).findById(1L);
    }

    @Test
    void testCriar() {

        Tipo novoTipo = new Tipo("Novo Tipo");
        doNothing().when(tipoRepository).persist(any(Tipo.class));

        Tipo resultado = tipoService.criar(novoTipo);

        assertNotNull(resultado);
        assertEquals("Novo Tipo", resultado.getDescricao());
        verify(tipoRepository, times(1)).persist(novoTipo);
    }

    @Test
    void testAtualizar() {

        Tipo tipoAtualizado = new Tipo("Matéria Prima Atualizada");
        when(tipoRepository.findById(1L)).thenReturn(tipo);
        doNothing().when(tipoRepository).persist(any(Tipo.class));

        Tipo resultado = tipoService.atualizar(1L, tipoAtualizado);

        assertNotNull(resultado);
        assertEquals("Matéria Prima Atualizada", resultado.getDescricao());
        verify(tipoRepository, times(1)).findById(1L);
        verify(tipoRepository, times(1)).persist(tipo);
    }

    @Test
    void testAtualizarNaoEncontrado() {

        when(tipoRepository.findById(999L)).thenReturn(null);

        Tipo resultado = tipoService.atualizar(999L, new Tipo("Teste"));

        assertNull(resultado);
        verify(tipoRepository, times(1)).findById(999L);
        verify(tipoRepository, never()).persist(any(Tipo.class));
    }

    @Test
    void testDeletar() {

        when(tipoRepository.deleteById(1L)).thenReturn(true);

        boolean resultado = tipoService.deletar(1L);

        assertTrue(resultado);
        verify(tipoRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeletarNaoEncontrado() {

        when(tipoRepository.deleteById(999L)).thenReturn(false);

        boolean resultado = tipoService.deletar(999L);

        assertFalse(resultado);
        verify(tipoRepository, times(1)).deleteById(999L);
    }
}