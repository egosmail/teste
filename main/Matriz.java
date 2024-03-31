package main;

/**
 * A classe Matriz deve ser capaz de amazenar uma valores reais em 
 * uma matriz 2D de dimensões arbitrárias. Além disso, ela deve ser 
 * capaz de realizar operações em sua matriz com outras matrizes
 * e números escalares.
 */
public class Matriz
{
    private int dimensaoX;
    private int dimensaoY;
    private float[][] valores;
   /**
   * Constroi uma matriz de dimensões X e Y contendo os valores especificados no parametro "valores".
   * 
   * O construtor deve construir uma matriz de dimensões X por Y
   * preenchendo-a com os valores especificados no parâmetro "valores".
   * Caso as dimensões sejam menores ou iguais a zero,
   * será construida uma matriz de dimensão 0x0 sem elementos.
   * 
   * @param dimensaoX Tamanho da matriz na dimensão X.
   * @param dimensaoY Tamanho da matriz na dimensão Y.
   * @param valores Valores dos elementos da matriz.
   */
  public Matriz(int dimensaoX, int dimensaoY, final float[][] valores)
  {
    this.dimensaoX = dimensaoX;
    this.dimensaoY = dimensaoY;
    this.valores = new float[dimensaoX][dimensaoY];
    for (int i = 0; i < dimensaoX; i++) {
        for (int j = 0; j < dimensaoY; j++) {
            this.valores[i][j] = valores[i][j];
        }
    }
  }

  /**
   * Retorna dimensão X da matriz.
   * 
   * @return Retorna inteiro informando dimensão X da matriz.
   */
  public int getDimensaoX()
  {
    return dimensaoX;
  }

  /**
   * Retorna dimensão Y da matriz.
   * 
   * @return Retorna inteiro informando dimensão Y da matriz.
   */
  public int getDimensaoY()
  {
   return dimensaoY;
  }

  /**
   * Calcula a multiplicação desta matriz por uma outra matriz.
   * 
   * A multiplicação de matrizes é realizada multiplicando-se a linha
   * de uma matriz pela coluna de outra de acordo com a regra [1]. Por
   * fim, o método deve retornar uma nova matriz contendo o resultado
   * da multiplicação.
   * 
   * [1] https://brasilescola.uol.com.br/matematica/multiplicacao-matrizes.htm
   * 
   * @param m Matriz que será usada na multiplicação.
   * @return Deve-se retornar uma nova matriz contendo o resultado da multiplicação.
   */
  public Matriz multiplica(final Matriz o)
  {
    if (this.dimensaoY != o.getDimensaoX()) {
        throw new IllegalArgumentException("Dimensões incompatíveis para multiplicação.");
    }
    float[][] result = new float[this.dimensaoX][o.getDimensaoY()];
    for (int i = 0; i < this.dimensaoX; i++) {
        for (int j = 0; j < o.getDimensaoY(); j++) {
            for (int k = 0; k < this.dimensaoY; k++) {
                result[i][j] += this.valores[i][k] * o.valores[k][j];
            }
        }
    }
    return new Matriz(this.dimensaoX, o.getDimensaoY(), result);
  }

  /**
   * Calcula a multiplicação desta matriz por um número escalar.
   * 
   * Este método calcula a multiplicação elemento a elemento pelo número
   * escalar passado como parâmetro.
   * 
   * @param v Número escalar usado na multiplicação.
   * @return Deve-se retornar uma nova matriz contendo o resultado da multiplicação.
   */
  public Matriz multiplicaElementos(float v)
  {

    float[][] result = new float[this.dimensaoX][this.dimensaoY];
    for (int i = 0; i < this.dimensaoX; i++) {
        for (int j = 0; j < this.dimensaoY; j++) {
            result[i][j] = this.valores[i][j] * v;
        }
    }
    return new Matriz(this.dimensaoX, this.dimensaoY, result);

  }

  /**
   * Calcula a soma desta matriz com outra matriz.
   * 
   * Calcula a soma desta matriz com outra matriz desde que ambas as
   * matrizes possuam a mesma dimensão. Caso as dimensões das matrizes não
   * sejam as mesmas, deve-se retornar esta matriz sem qualquer alteração
   * em seus valores.
   * 
   * @param m Matriz usada na soma com outra matriz.
   * @return Retorna uma nova matriz contendo o resultado da soma
   * ou esta matriz sem qualquer alteração em seus valores.
   */
  public Matriz soma(final Matriz o)
  {
    if (this.dimensaoX != o.getDimensaoX() || this.dimensaoY != o.getDimensaoY()) {
        throw new IllegalArgumentException("Dimensões incompatíveis para soma.");
    }
    float[][] result = new float[this.dimensaoX][this.dimensaoY];
    for (int i = 0; i < this.dimensaoX; i++) {
        for (int j = 0; j < this.dimensaoY; j++) {
            result[i][j] = this.valores[i][j] + o.valores[i][j];
        }
    }
    return new Matriz(this.dimensaoX, this.dimensaoY, result);
  }

  /**
   * Calcula a soma de cada elemento desta matriz com o escalar informado.
   * 
   * @param v Escalar a ser usado na soma.
   * @return Retorna uma nova matriz contendo o resultado da soma de cada
   * elemento com o escalar informado.
   */
  public Matriz somaElementos (float v)
  {
    float[][] result = new float[this.dimensaoX][this.dimensaoY];
    for (int i = 0; i < this.dimensaoX; i++) {
        for (int j = 0; j < this.dimensaoY; j++) {
            result[i][j] = this.valores[i][j] + v;
        }
    }
    return new Matriz(this.dimensaoX, this.dimensaoY, result);
  }

  /**
   * Retorna valor do elemento nas coordenadas [x,y].
   * 
   * @param x Coordenada X do elemento a ser retornado.
   * @param y Coordenada Y do elemento a ser retornado.
   * @return Retorna valor do elemento nas coordenadas [x,y].
   */
  public float getElemento(int x, int y)
  {
    return this.valores[x][y];
  }

  /**
   * Define um novo valor para o elemento nas coordenadas [x,y].
   * 
   * @param x Coordenada X do elemento a ser alterado.
   * @param y Coordenada Y do elemento a ser alterado.
   * @param v Novo valor do elemento.
   */
  public void setElemento(int x, int y, float v)
  {
    this.valores[x][y] = v;
  }
}