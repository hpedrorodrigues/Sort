package com.hpedrorodrigues.sort;

import com.hpedrorodrigues.sort.algorithm.*;
import com.hpedrorodrigues.sort.constant.SortAlgorithm;

public class SortAlgorithmFactory {

    private SortAlgorithmFactory() {
    }

    public static AbstractSortAlgorithm create(final SortAlgorithm algorithm) {
        switch (algorithm) {
            case SELECTION_SORT:
                return new SelectionSortAlgorithm();
            case INSERTION_SORT:
                return new InsertionSortAlgorithm();
            case BUBBLE_SORT:
                return new BubbleSortAlgorithm();
            case BUBBLE_SORT_WITH_FLAG:
                return new BubbleSortAlgorithmWithFlag();
            case SHELL_SORT:
                return new ShellSortAlgorithm();
            case MERGE_SORT:
                return new MergeSortAlgorithm();
            case QUICK_SORT:
                return new QuickSortAlgorithm();
            case COUNTING_SORT:
                return new CountingSortAlgorithm();
            case BUCKET_SORT:
                return new BucketSortAlgorithm();
            case RADIX_SORT:
                return new RadixSortAlgorithm();
            case HEAP_SORT:
                return new HeapSortAlgorithm();
            default:
                return null;
        }
    }
}