package com.hpedrorodrigues.sort;

import com.hpedrorodrigues.sort.algorithm.AbstractSortAlgorithm;
import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortAlgorithmHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortAlgorithmHandler.class);

    private static final int ARRAY_SIZE = 100000;

    public void run() {
        final int[] array = ArrayGenerator.random(ARRAY_SIZE);

        for (final SortAlgorithm sortAlgorithm : SortAlgorithm.values()) {
            final AbstractSortAlgorithm algorithm = SortAlgorithmFactory.create(sortAlgorithm);

            LOGGER.info("Running sort algorithm [{}]", sortAlgorithm);
            final long time = algorithm.sort(array);
            LOGGER.info("Finished sort algorithm [{}] with array size [{}] with {}ms", sortAlgorithm, ARRAY_SIZE, time);
        }
    }
}