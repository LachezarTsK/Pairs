import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static int pairs(int targetValue, int[] inputArray) {

		Arrays.sort(inputArray);
		int indexOfSmallerInteger = 0;
		int indexOfLargerInteger = 1;
		int totalPairs = 0;

		while (indexOfLargerInteger < inputArray.length) {

			while (indexOfLargerInteger < inputArray.length
					&& inputArray[indexOfLargerInteger] - inputArray[indexOfSmallerInteger] < targetValue) {
				indexOfLargerInteger++;
			}

			if (indexOfLargerInteger < inputArray.length
					&& inputArray[indexOfLargerInteger] - inputArray[indexOfSmallerInteger] == targetValue) {
				totalPairs++;
				indexOfLargerInteger++;
			}

			indexOfSmallerInteger++;
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
