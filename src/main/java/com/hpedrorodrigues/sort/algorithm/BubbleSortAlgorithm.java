package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class BubbleSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] bubbleSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        final int n = copiedArray.length;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (copiedArray[j - 1] > copiedArray[j]) {
                    int aux = copiedArray[j - 1];
                    copiedArray[j - 1] = copiedArray[j];
                    copiedArray[j] = aux;
                }
            }
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        bubbleSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.BUBBLE_SORT;
    }
}