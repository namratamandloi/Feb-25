public class CountKey {
    public static int[] findOccurrences(int[] arr, int key) {
        int firstIndex = -1, lastIndex = -1, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (firstIndex == -1) {
                    firstIndex = i;
                }
                lastIndex = i;
                count++;
            }
        }
        return new int[]{firstIndex, lastIndex, count};
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 3, 3, 5, 6, 8};
        int key = 3;
        int[] result = findOccurrences(arr, key);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
        System.out.println("Total Count: " + result[2]);
    }
}
