package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class BucketSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] bucketSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int maxValue = copiedArray[0];

        for (int item : copiedArray) {
            if (item > maxValue) {
                maxValue = item;
            }
        }

        final int[] bucket = new int[maxValue + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < copiedArray.length; i++) {
            bucket[copiedArray[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                copiedArray[outPos++] = i;
            }
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        bucketSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.BUCKET_SORT;
    }
}