import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static int pairs(int targetValue, int[] inputArray) {

		Arrays.sort(inputArray);
		int index = 0;
		int totalPairs = 0;

		while (index < inputArray.length) {

			int lastIndexOfSameInteger = index + 1;
			int totalOfSameInteger = 1;

			/**
			 * Counters each occurrence the first integer with which a potential pair could
			 * be formed.
			 */
			while (lastIndexOfSameInteger < inputArray.length
					&& inputArray[lastIndexOfSameInteger] - inputArray[index] == 0) {
				lastIndexOfSameInteger++;
				totalOfSameInteger++;
			}

			index = lastIndexOfSameInteger - 1;

			/**
			 * Searches for a second integer with which a pair could be formed.
			 */
			while (lastIndexOfSameInteger < inputArray.length
					&& inputArray[lastIndexOfSameInteger] - inputArray[index] < targetValue) {
				lastIndexOfSameInteger++;
			}

			/**
			 * If there is a pair, counters each occurrence the second integer and thus
			 * calculates the corresponding number of pairs.
			 */
			while (lastIndexOfSameInteger < inputArray.length
					&& inputArray[lastIndexOfSameInteger] - inputArray[index] == targetValue) {
				lastIndexOfSameInteger++;
				totalPairs += totalOfSameInteger;
			}
			index++;
		}
		return totalPairs;
	}

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int sizeOfArray = reader.nextInt();
		int targetValue = reader.nextInt();
		int[] inputArray = new int[sizeOfArray];

		for (int i = 0; i < sizeOfArray; i++) {
			inputArray[i] = reader.nextInt();
		}
		reader.close();

		int result = pairs(targetValue, inputArray);
		System.out.println(result);
	}
}
