package com.example;

import java.util.Arrays;
import java.util.Collection;

public class DynamicArray<T>{
    private Object[] arr;
    private int initialCapacity = 16;
    private int size;

    public DynamicArray(){
        arr = new Object[initialCapacity];
        size = 0;
    }

    public DynamicArray(int initialCapacity){
        size = 0;
        this.initialCapacity = initialCapacity;
        initialize();
    }

    public DynamicArray(Collection<T> collection){
        size = 0;
        this.initialCapacity = collection.size();
        initialize();
        collection.forEach((e) -> {
            arr[size++] = e;
        });
    }

    public void initialize(){
        arr = new Object[this.initialCapacity];
    }

    @SuppressWarnings("unchecked")
    public boolean add(Object element){
        if(size >= arr.length){
            Object[] newArr = new Object[initialCapacity*2];
            System.arraycopy(arr, 0, newArr, 0, initialCapacity);
            arr = newArr;
            initialCapacity = initialCapacity*2;
        }
        arr[size++] = (T) element;

        return true;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, Object element) throws IndexOutOfBoundsException{
        if(index >= size) throw new IndexOutOfBoundsException();
        else{
            if(size >= arr.length){
                Object[] newArr = new Object[initialCapacity*2];
                System.arraycopy(arr, 0, newArr, 0, initialCapacity);
                arr = newArr;
                initialCapacity = initialCapacity*2;
            }
            shiftArray(index);
            arr[index] = element;
        }
    }

    public void shiftArray(int index){
        for(int i = size - 1; i > index; i--){
            arr[i+1] = arr[i];

        }
    }

    public void clear(){
        size = 0;
        initialize();
    }

    public Object[] getArr(){
        return Arrays.copyOfRange(arr, 0, size);
    }

}
