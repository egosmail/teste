package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.Matriz;

public class MatrizTest {

    @Test
    void testMultiplica() {
        float[][] valoresA = {{1, 2}, {3, 4}};
        Matriz matrizA = new Matriz(2, 2, valoresA);

        float[][] valoresB = {{5, 6}, {7, 8}};
        Matriz matrizB = new Matriz(2, 2, valoresB);

        Matriz resultado = matrizA.multiplica(matrizB);

        assertEquals(19, resultado.getElemento(0, 0));
        assertEquals(22, resultado.getElemento(0, 1));
        assertEquals(43, resultado.getElemento(1, 0));
        assertEquals(50, resultado.getElemento(1, 1));
    }

    @Test
    void testMultiplicaElementos() {
        float[][] valores = {{1, 2}, {3, 4}};
        Matriz matriz = new Matriz(2, 2, valores);

        Matriz resultado = matriz.multiplicaElementos(2);

        assertEquals(2, resultado.getElemento(0, 0));
        assertEquals(4, resultado.getElemento(0, 1));
        assertEquals(6, resultado.getElemento(1, 0));
        assertEquals(8, resultado.getElemento(1, 1));
    }

    @Test
    void testSoma() {
        float[][] valoresA = {{1, 2}, {3, 4}};
        Matriz matrizA = new Matriz(2, 2, valoresA);

        float[][] valoresB = {{5, 6}, {7, 8}};
        Matriz matrizB = new Matriz(2, 2, valoresB);

        Matriz resultado = matrizA.soma(matrizB);

        assertEquals(6, resultado.getElemento(0, 0));
        assertEquals(8, resultado.getElemento(0, 1));
        assertEquals(10, resultado.getElemento(1, 0));
        assertEquals(12, resultado.getElemento(1, 1));
    }

    @Test
    void testSomaElementos() {
        float[][] valores = {{1, 2}, {3, 4}};
        Matriz matriz = new Matriz(2, 2, valores);

        Matriz resultado = matriz.somaElementos(2);

        assertEquals(3, resultado.getElemento(0, 0));
        assertEquals(4, resultado.getElemento(0, 1));
        assertEquals(5, resultado.getElemento(1, 0));
        assertEquals(6, resultado.getElemento(1, 1));
    }
}
