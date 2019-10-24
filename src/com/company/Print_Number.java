package com.company;

import java.util.Iterator;

import java.util.List;

public class Print_Number {
    static final String VERTICAL = "|";
    static final String HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";


    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;

    // Calcula el numero de filasDig
    private int filasDig;
    private int columDig;
    private int totalFilas;
    private int totalColum;

    //Propiedades de visualización del numero
    private int space;
    private int size;
    // Número para imprimir en formato Numero
    private Number numberImp;

    //Matriz para imprimir
    private String[][] matrizImpr;

    public void imprimirMatriz(){
        // Imprime matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }
    public Print_Number(String txtNumber, int size, int space){
        // Inicializa puntos fijos para impresión
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
        this.numberImp=new Number(txtNumber);
        this.size = size;
        this.space=space;
        this.generarMatrizImpr();
    }

    /**
     *  Generar método para instanciar el objeto número y generar sus segmentos
     */
    private void generarMatrizImpr(){
        int pivotX = 0;
        List<Digito> digitos=numberImp.getDigitos();
        int numeroDigitos=numberImp.getDigitos().size();

        // Calcula el numero de filas cada digito
        this.filasDig = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        this.columDig = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDig;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (this.columDig * numeroDigitos) + (space * numeroDigitos);

        // crea matriz para almacenar los numero a imprimir
        this.matrizImpr = new String[this.totalFilas][this.totalColum];

        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }

        for (Digito digito : digitos) {
            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (this.filasDig / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (this.filasDig - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (this.columDig - 1);
            this.pf4[1] = (this.filasDig / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (this.columDig - 1) + pivotX;

            pivotX = pivotX + this.columDig + space;

            //Para cada uno de los dígitos se generan los caracteres que se imprimirán correspondientes a
            // los segmentos que conforman el dígito.

            Iterator<Integer> iterator = digito.getSegList().iterator();

            while (iterator.hasNext()) {
                newSegmento(iterator.next());
            }
        }

    }

    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */
    private void newSegmento(int segmento) {

        switch (segmento) {
            case 1:
                addLine(this.matrizImpr, this.pf1, POSICION_Y,
                        this.size, VERTICAL);
                break;
            case 2:
                addLine(this.matrizImpr, this.pf2, POSICION_Y,
                        this.size, VERTICAL);
                break;
            case 3:
                addLine(this.matrizImpr, this.pf5, POSICION_Y,
                        this.size, VERTICAL);
                break;
            case 4:
                addLine(this.matrizImpr, this.pf4, POSICION_Y,
                        this.size, VERTICAL);
                break;
            case 5:
                addLine(this.matrizImpr, this.pf1, POSICION_X,
                        this.size, HORIZONTAL);
                break;
            case 6:
                addLine(this.matrizImpr, this.pf2, POSICION_X,
                        this.size, HORIZONTAL);
                break;
            case 7:
                addLine(this.matrizImpr, this.pf3, POSICION_X,
                        this.size, HORIZONTAL);
                break;
            default:
                break;
        }
    }


    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote
     * @param posFija Posicion Fija
     * @param size Tamaño Segmento
     * @param caracter Caracter Segmento
     */
    private void addLine(String[][] matriz, int[] punto, String posFija,
                                int size, String caracter) {

        if (posFija.equalsIgnoreCase(POSICION_X))
        {
            for (int y = 1; y <= size; y++)
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        }
        else
        {
            for (int i = 1; i <= size; i++)
            {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }


}
