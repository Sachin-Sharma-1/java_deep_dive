package com.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<>(2);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(Object i : list.getArr()){
            System.out.println(i);
        }

        list.clear();

        list.add(56);

        for(Object i : list.getArr()){
            System.out.println(i);
        }

    }

}