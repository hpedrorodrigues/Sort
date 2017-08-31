package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class QuickSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] quickSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        quickSort(copiedArray, 0, copiedArray.length - 1);
        return copiedArray;
    }

    private void quickSort(final int[] array, final int start, final int end) {
        if (start < end) {
            int pivotPosition = partition(array, start, end);
            quickSort(array, start, pivotPosition - 1);
            quickSort(array, pivotPosition + 1, end);
        }
    }

    private int partition(final int[] array, final int start, final int end) {
        int pivot = array[start];
        int leftPosition = start + 1, rightPosition = end;
        while (leftPosition <= rightPosition) {
            if (array[leftPosition] <= pivot) {
                leftPosition++;
            } else if (pivot < array[rightPosition]) {
                rightPosition--;
            } else {
                int aux = array[leftPosition];
                array[leftPosition] = array[rightPosition];
                array[rightPosition] = aux;
                leftPosition++;
                rightPosition--;
            }
        }
        array[start] = array[rightPosition];
        array[rightPosition] = pivot;
        return rightPosition;
    }


    @Override
    public void run(final int... array) {
        quickSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.QUICK_SORT;
    }
}