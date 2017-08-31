package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class SelectionSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] selectionSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int n = copiedArray.length, minPos;

        for (int i = 0; i < n - 1; i++) {
            minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (copiedArray[j] < copiedArray[minPos]) {
                    minPos = j;
                }
            }

            if (minPos != i) {
                int aux = copiedArray[i];
                copiedArray[i] = copiedArray[minPos];
                copiedArray[minPos] = aux;
            }
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        selectionSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.SELECTION_SORT;
    }
}