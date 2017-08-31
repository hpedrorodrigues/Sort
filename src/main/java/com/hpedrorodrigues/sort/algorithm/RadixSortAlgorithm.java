package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class RadixSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] radixSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int i, maxValue = copiedArray[0], exp = 1, n = copiedArray.length;
        int[] auxArray = new int[n];

        for (i = 1; i < n; i++) {
            if (copiedArray[i] > maxValue) {
                maxValue = copiedArray[i];
            }
        }

        while (maxValue / exp > 0) {
            int[] bucket = new int[n];

            for (i = 0; i < n; i++) {
                bucket[(copiedArray[i] / exp) % n]++;
            }
            for (i = 1; i < n; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (i = n - 1; i >= 0; i--) {
                auxArray[--bucket[(copiedArray[i] / exp) % n]] = copiedArray[i];
            }
            for (i = 0; i < n; i++) {
                copiedArray[i] = auxArray[i];
            }
            exp *= n;
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        radixSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.RADIX_SORT;
    }
}