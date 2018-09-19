	public static int pairs(int targetValue, int[] inputArray) {

		Arrays.sort(inputArray);
		int index = 0;
		int totalPairs = 0;

		while (index < inputArray.length) {

			int indexOfPotentialPair = index + 1;

			while (indexOfPotentialPair < inputArray.length
					&& inputArray[indexOfPotentialPair] - inputArray[index] < targetValue) {
				indexOfPotentialPair++;
			}

			if (indexOfPotentialPair < inputArray.length
					&& inputArray[indexOfPotentialPair] - inputArray[index] == targetValue) {
				totalPairs++;
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
