package com.company;

public class Container {
    private Object[] array = new Object[10];
    private int length = 0;
    private String type;

    public Container(String type) {
        this.type = type;
    }

    public void add(Object element) {
        array[length++] = element;
    }
    public void remove(Object element) {
        int i = -1;
        while (++i < length) {
            if (array[i] == element) {
                int j = i;
                while (j < 9) {
                    array[j] = array[j + 1];
                    j++;
                }
            }
        }
    }
    public Object get(int num) {
        return (array[num]);
    }
    public int length() {
        return (length);
    }
    public void show() {
        System.out.printf("List of %s\n", type);
        if (length != 0) {
            int i = -1;
            while (++i < length) {
                System.out.printf("%d %s\n", i, array[i].toString());
            }
        }
        else {
            System.out.println("Nothing to show...\n");
        }
    }
}
