package com.company;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private List<Digito> digitos = new ArrayList<>();

    private String txtNumber;


    public List<Digito> getDigitos() {
        return digitos;
    }

    public Number(String numberImp){
        this.txtNumber =numberImp;
        this.digitos=new ArrayList<>();
        this.obtenerDigitos();
    }

    private void obtenerDigitos(){
        // crea el arreglo de digitos
        char[] arregloDigitos = this.txtNumber.toCharArray();

        //Generar cada uno de los objetos Digito que tiene el numero
        for (char digito : arregloDigitos) {
            //Valida que el caracter sea un digito
            if( ! Character.isDigit(digito))
            {
                throw new IllegalArgumentException("Caracter " + digito
                        + " no es un digito");
            }
            int number = Integer.parseInt(String.valueOf(digito));
            addDigito(number);
        }

    }
    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
     *
     * @paramnumerDigito
     */
    private void addDigito(int number) {

        // Establece los segmentos de cada numero
        List<Integer> segList = new ArrayList<>();

        switch (number) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }

        digitos.add(new Digito(segList));
    }
}
