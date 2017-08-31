package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class ShellSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] shellSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int n = copiedArray.length, h = 1;

        while (h <= n / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                int aux = copiedArray[i];
                int j = i;
                while (j > h - 1 && copiedArray[j - h] >= aux) {
                    copiedArray[j] = copiedArray[j - h];
                    j -= h;
                }
                copiedArray[j] = aux;
            }
            h = (h - 1) / 3;
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        shellSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.SHELL_SORT;
    }
}