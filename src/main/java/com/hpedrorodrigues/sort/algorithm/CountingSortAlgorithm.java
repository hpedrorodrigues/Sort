package com.hpedrorodrigues.sort.algorithm;

import com.hpedrorodrigues.sort.constant.SortAlgorithm;
import com.hpedrorodrigues.sort.util.ArrayUtil;

public class CountingSortAlgorithm extends AbstractSortAlgorithm {

    @SuppressWarnings("UnusedReturnValue")
    private int[] countingSort(final int... array) {
        final int[] copiedArray = ArrayUtil.copy(array);
        int n = copiedArray.length;

        int maxValue = copiedArray[0];
        for (int item : copiedArray) {
            if (item > maxValue) {
                maxValue = item;
            }
        }
        maxValue++;

        int[] aux = new int[maxValue];

        //1ª - (Inicializar com zero)
        for (int i = 0; i < maxValue; i++) {
            aux[i] = 0;
        }

        //2ª - Contagem das ocorrências
        for (int i = 0; i < n; i++) {
            aux[copiedArray[i]]++;
        }

        //3ª - Ordenando os indices do vetor auxiliar
        int sum = 0;
        for (int i = 1; i < maxValue; i++) {
            int auxValue = aux[i];
            aux[i] = sum;
            sum += auxValue;
        }
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArray[aux[copiedArray[i]]] = copiedArray[i];
            aux[copiedArray[i]]++;
        }

        //4ª Retornando os valores ordenados para o vetor de entrada
        for (int i = 0; i < n; i++) {
            copiedArray[i] = sortedArray[i];
        }

        return copiedArray;
    }

    @Override
    public void run(final int... array) {
        countingSort(array);
    }

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return SortAlgorithm.COUNTING_SORT;
    }
}