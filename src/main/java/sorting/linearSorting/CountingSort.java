package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		Integer max = 0;

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}

		Integer[] aux = new Integer[max + 1];

		// popula aux com zeros
		for (int i = 0; i < aux.length; i++) {
			aux[i] = 0;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[array[i]]++;
		}

		
		for (int i = 1; i <= max; i++) {
			aux[i] += aux[i - 1];
		}

		Integer[] sortedArray = new Integer[array.length];

		// popula sortedArray com zeros
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = 0;
		}

		for (int j = rightIndex; j >= leftIndex; j--) {
			sortedArray[aux[array[j]] -1] = array[j];
			aux[array[j]]--;
		}


		// Replica os elementos de sortedArray no array original
		for (int i = 0; i <= rightIndex; i++) {
			array[i] = sortedArray[i];
		}

		
	}

}
