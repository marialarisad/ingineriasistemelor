package org.example;
/*
public class Main
{
        System.out.println("Hello world!");
        char c = 'a';
        int len = 'z' - 'a';
        for (int i = 0; i <= len; i++) {
            int next = c + i;
            char nextChar = (char) next;
            System.out.println(nextChar);*/


//problema 1
//a inceput scoala --> invers

  /*  public static String SirInversat(String text)
        {
            return new StringBuilder(text).reverse().toString();
        }


        public static void main(String args[])
{
    String propozitie= "A inceput scoala.";
    String invers=SirInversat(propozitie);
}
    }

   */

//problema 2
//Creati o lista de 10 numere intregi aleatoare in intervalul [5..25]
//Parcurgeti lista si creati o alta lista prin pastrarea doar a elementelor in intervalul [10..20]. Afisati
//Calculati valoarea maxima si minima in prima si a doua lista. Afisati.

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Random rand = new Random();
        List<Integer> lista1 = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            lista1.add(rand.nextInt(21) + 5);
        }

        List<Integer> lista2 = new ArrayList<>();
        for (int numar : lista1) {
            if (numar >= 10 && numar < 20)
                lista2.add(numar);
        }
        //valoarea maxima si minima din fiecare lista
        int min1=100, max1=-0, v, min2=100;
//        for(int i=0; i<lista1.size();i++) {
//            v = lista1.get(i);
//            if (min1 > v) {
//                min1 = v;
//            }
//            if (max1 < v) {
//                max1 = v;
//            }
//        }
        for (int val: lista1) {
            if (min1 > val) {
                min1 = val;
            }
            if (max1 < val) {
                max1 = val;
            }
        }

        for (int val: lista2) {
            if (min2 > val) {
                min1 = val;
            }
            if (max1 < val) {
                max1 = val;
            }
        }
        System.out.println(" Prima lista: " + lista1);
        System.out.println("A doua lista: " + lista2);


    }
}