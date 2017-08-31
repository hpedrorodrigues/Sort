package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class BubbleSortAlgorithmWithFlag extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] bubbleSortWithFlag(int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        final int n = copiedArray.length;
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int j = 0; j < n - 1; j++) {
                if (copiedArray[j] > copiedArray[j + 1]) {
                    final int aux = copiedArray[j];
                    copiedArray[j] = copiedArray[j + 1];
                    copiedArray[j + 1] = aux;
                    changed = true;
                }
            }
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        bubbleSortWithFlag(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.BUBBLE_SORT_WITH_FLAG;
    }
}