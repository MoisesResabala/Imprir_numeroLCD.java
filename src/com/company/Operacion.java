package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Operacion {
    static final String FINALIZAR = "0,0";
    private String txtNumber;
    private int size;
    private int space;
    private List<String> listSave_Valor;

    public Operacion(){
        this.txtNumber="0";
        this.size=1;
        this.space=1;
        this.listSave_Valor = new ArrayList<>();
    }


    public void read(){
        List<String> listSave_Valor = new ArrayList<>();
        String saveVal;

        try {

            try (Scanner leer = new Scanner(System.in)) {

                System.out.print("Espacio entre caracter (0 a 5): ");
                saveVal = leer.next();

                // Valida si es un numero
                if (this.isNumber(saveVal)) {
                    this.space = Integer.parseInt(saveVal);

                    // se valida que el espaciado este entre 0 y 5
                    if (this.space < 0 || this.space > 5) {
                        throw new IllegalArgumentException("El espacio entre "
                                + "caracter debe estar entre 0 y 5");
                    }

                } else {
                    throw new IllegalArgumentException("Cadena " + saveVal
                            + " no es un entero");
                }

                do {
                    System.out.print("Entrada: ");
                    saveVal = leer.next();
                    if (!saveVal.equalsIgnoreCase(FINALIZAR)) {
                        listSave_Valor.add(saveVal);
                    }
                } while (!saveVal.equalsIgnoreCase(FINALIZAR));
            }

            imprimirValor(listSave_Valor.iterator());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Este método revisa que todos los comandos cumplan con los requerimientos e imprime los números

     */
    private void imprimirValor(Iterator<String> iterator){

        while (iterator.hasNext()) {
            try {
                String saveVal = iterator.next();
                if (!saveVal.contains(",")) {
                    throw new IllegalArgumentException("Cadena " + saveVal
                            + " no contiene caracter ,");
                }

                String[] parametros =saveVal.split(",");

                if(parametros.length>2)
                {
                    throw new IllegalArgumentException("Cadena " + saveVal
                            + " contiene mas caracter ,");
                }


                if(parametros.length<2)
                {
                    throw new IllegalArgumentException("Cadena " + saveVal
                            + " no contiene lo requerido");
                }

                if(isNumber(parametros[0]))
                {
                    this.size = Integer.parseInt(parametros[0]);


                    if(this.size <1 || this.size >10)
                    {
                        throw new IllegalArgumentException("El size ["+this.size
                                + "] acepta entre 1 y 10");
                    }
                }
                else
                {
                    throw new IllegalArgumentException(" Size [" + parametros[0]
                            + "] no es un numero");
                }


                if (isNumber(parametros[1])){
                    this.txtNumber=parametros[1];
                }else{
                    throw new IllegalArgumentException("Parametro Numero [" + parametros[1]
                            + "] no es un numero");
                }
                //Si todas las condiciones se cumplen se genera un objeto Impresor para imprimir el número
                Print_Number print = new Print_Number (this.txtNumber, this.size,this.space);
                print.imprimirMatriz();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }




    /**
    validacion solo numeros en la cadena
     */

    static boolean isNumber(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}



