package com.company;

import java.util.ArrayList;
import java.util.List;

public class Digito {
    private List<Integer> segList = new ArrayList<>();


      //El constructor recibe el listado de Segmentos del dígito


    public Digito(List<Integer> segList) {
        this.segList=segList;
    }

    public List<Integer> getSegList() {
        return segList;
    }
}
