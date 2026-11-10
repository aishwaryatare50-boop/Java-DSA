package AdvancedJava;

import java.util.ArrayList;

class MyGeneric<T> {
    int val;

    private T t1;

    public MyGeneric(int val, T t1) {
        this.val = val;
        this.t1 = t1;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public T getT() {
        return t1;
    }

    public void setT(T t1) {
        this.t1 = t1;
    }
}

public class Generics {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(6);
        arrayList.add(8);
        arrayList.add(4);
        System.out.println(arrayList); 

        MyGeneric<String> g1 = new MyGeneric<>(23, "MyString");
        String str = g1.getT();
        System.out.println(str);
    }
}