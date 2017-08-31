package com.hpedrorodrigues.sort;

import com.hpedrorodrigues.Logger;
import com.hpedrorodrigues.sort.algorithm.AbstractSortAlgorithm;
import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayGenerator;

public class SortAlgorithmHandler {

    private static final int ARRAY_SIZE = 100000;

    public void run() {
        final int[] array = ArrayGenerator.random(ARRAY_SIZE);

        for (final SortAlgorithm sortAlgorithm : SortAlgorithm.values()) {
            final AbstractSortAlgorithm algorithm = SortAlgorithmFactory.create(sortAlgorithm);

            Logger.log("Running sort algorithm [%s]", sortAlgorithm);
            final long time = algorithm.sort(array);
            Logger.log("Finished sort algorithm [%s] with array size [%d] with [%d]ms", sortAlgorithm, ARRAY_SIZE, time);
        }
    }
}