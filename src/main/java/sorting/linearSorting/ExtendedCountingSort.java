package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (leftIndex < 0 || rightIndex >= array.length || array.length == 0) {
			return;
		}

		int min = array[leftIndex];
		int max = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}
		}

		int[] countArray = new int[max - min + 1];

		for (int i = leftIndex; i <= rightIndex; i++) {
			countArray[array[i] - min]++;
		}

		for (int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1];
		}

		Integer[] sortedArray = new Integer[rightIndex - leftIndex + 1];
		for (int i = rightIndex; i >= leftIndex; i--) {
			sortedArray[--countArray[array[i] - min]] = array[i];
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = sortedArray[i - leftIndex];
		}
	}

}
