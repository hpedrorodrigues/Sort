package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class MergeSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] mergeSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int n = copiedArray.length;

        if (n <= 1) {
            return copiedArray;
        }

        int half = n / 2;
        int[] right = (n % 2 == 0) ? new int[half] : new int[half + 1];
        int[] left = new int[half];

        for (int i = 0; i < half; i++) {
            left[i] = array[i];
        }

        for (int i = half; i < n; i++) {
            right[i - half] = copiedArray[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private int[] merge(final int[] left, final int[] right) {
        int m = left.length, n = right.length, j = 0, i = 0, k = 0;
        final int[] result = new int[m + n];

        while (i < m || j < n) {
            if (i < m && j < n) {
                if (left[i] <= right[j]) {
                    result[k] = left[i];
                    k++;
                    i++;
                } else {
                    result[k] = right[j];
                    k++;
                    j++;
                }
            } else if (i < m) {
                result[k] = left[i];
                k++;
                i++;
            } else if (j < n) {
                result[k] = right[j];
                k++;
                j++;
            }
        }
        return result;
    }

    @Override
    public void run(final int... array) {
        mergeSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.MERGE_SORT;
    }
}