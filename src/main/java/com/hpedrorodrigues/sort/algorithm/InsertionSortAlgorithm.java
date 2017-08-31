package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class InsertionSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] insertionSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int n = copiedArray.length;

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && copiedArray[j] > copiedArray[j + 1]) {
                int aux = copiedArray[j];
                copiedArray[j] = copiedArray[j + 1];
                copiedArray[j + 1] = aux;
                j--;
            }
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        insertionSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.INSERTION_SORT;
    }
}