package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;

public abstract class AbstractSortAlgorithm {

    public long sort(int... array) {
        final long startTime = System.currentTimeMillis();
        run(array);
        return System.currentTimeMillis() - startTime;
    }

    protected abstract void run(int... array);

    protected abstract SortAlgorithm getSortAlgorithm();
}