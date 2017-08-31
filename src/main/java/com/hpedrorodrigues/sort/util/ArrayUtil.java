package com.hpedrorodrigues.sort.util;

public class ArrayUtil {

    private ArrayUtil() {
    }

    public static int[] copy(final int[] array) {
        final int size = array.length;
        final int[] copiedArray = new int[size];
        for (int i = 0; i < size; i++) {
            copiedArray[i] = array[i];
        }
        return copiedArray;
    }
}