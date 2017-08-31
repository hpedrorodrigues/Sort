package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class HeapSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] heapSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int n = copiedArray.length;

        buildMaxHeap(copiedArray);

        for (int i = n - 1; i > 0; i--) {
            swap(copiedArray, i, 0);
            maxHeapify(copiedArray, 0, --n);
        }

        return copiedArray;
    }

    private void buildMaxHeap(final int[] array) {
        final int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, n);
        }
    }

    private void maxHeapify(final int[] array, final int position, final int arraySize) {
        int max = 2 * position + 1, right = max + 1;

        if (max < arraySize) {
            if (right < arraySize && array[max] < array[right]) {
                max = right;
            }

            if (array[max] > array[position]) {
                swap(array, max, position);
                maxHeapify(array, max, arraySize);
            }
        }
    }

    private void swap(final int[] array, final int j, final int afterJ) {
        final int aux = array[j];
        array[j] = array[afterJ];
        array[afterJ] = aux;
    }

    @Override
    public void run(final int... array) {
        heapSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.HEAP_SORT;
    }
}