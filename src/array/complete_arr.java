package array;

import java.util.Arrays;
import java.util.Scanner;

  class ArrayCompleteDemo {

    // Display Array
    static void display(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
    }

    // Find Sum
    static int findSum(int[] arr) {
        int sum = 0;

        for (int element : arr) {
            sum += element;
        }
        return sum;
    }
    // Find Maximum
    static int findMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    // Find Minimum
    static int findMin(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    // Linear Search
    static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Reverse Array
    static void reverse(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Insert Element
    static int[] insert(int[] arr, int index, int value) {

        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        newArr[index] = value;

        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    // Delete Element
    static int[] delete(int[] arr, int index) {

        int[] newArr = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        for (int i = index; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }

        return newArr;
    }

    // Copy Array
    static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // Count Frequency
    static void frequency(int[] arr) {

        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (visited[i]) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr[i] + " -> " + count + " times");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===============================
        // 1. ARRAY DECLARATION
        // ===============================

        int[] arr;

        // ===============================
        // 2. ARRAY CREATION
        // ===============================

        arr = new int[5];

        // ===============================
        // 3. ARRAY INITIALIZATION
        // ===============================

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        System.out.println("Original Array:");
        display(arr);


        // ===============================
        // 4. ARRAY LENGTH
        // ===============================

        System.out.println("\nLength = " + arr.length);


        // ===============================
        // 5. ARRAY TRAVERSAL
        // ===============================

        System.out.println("\nTraversal using normal for loop:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + " = " + arr[i]);
        }


        // Enhanced for loop
        System.out.println("\nTraversal using enhanced for loop:");

        for (int element : arr) {
            System.out.println(element);
        }


        // ===============================
        // 6. UPDATE ELEMENT
        // ===============================

        arr[2] = 100;

        System.out.println("\nAfter updating index 2:");
        display(arr);


        // ===============================
        // 7. USER INPUT ARRAY
        // ===============================

        System.out.print("\nEnter size of new array: ");
        int n = sc.nextInt();

        int[] userArray = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = sc.nextInt();
        }

        System.out.println("User Array:");
        display(userArray);


        // ===============================
        // 8. SUM
        // ===============================

        System.out.println("\nSum = " + findSum(userArray));


        // ===============================
        // 9. AVERAGE
        // ===============================

        double average = (double) findSum(userArray) / userArray.length;

        System.out.println("Average = " + average);


        // ===============================
        // 10. MAXIMUM
        // ===============================

        System.out.println("Maximum = " + findMax(userArray));


        // ===============================
        // 11. MINIMUM
        // ===============================

        System.out.println("Minimum = " + findMin(userArray));


        // ===============================
        // 12. LINEAR SEARCH
        // ===============================

        System.out.print("\nEnter element to search: ");
        int target = sc.nextInt();

        int index = linearSearch(userArray, target);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }


        // ===============================
        // 13. SORTING
        // ===============================

        int[] sortedArray = copyArray(userArray);

        Arrays.sort(sortedArray);

        System.out.println("\nSorted Array:");
        display(sortedArray);


        // ===============================
        // 14. REVERSE
        // ===============================

        int[] reversedArray = copyArray(userArray);

        reverse(reversedArray);

        System.out.println("\nReversed Array:");
        display(reversedArray);


        // ===============================
        // 15. COPY ARRAY
        // ===============================

        int[] copiedArray = copyArray(userArray);

        System.out.println("\nCopied Array:");
        display(copiedArray);


        // ===============================
        // 16. INSERT ELEMENT
        // ===============================

        System.out.print("\nEnter index for insertion: ");
        int insertIndex = sc.nextInt();

        System.out.print("Enter value: ");
        int insertValue = sc.nextInt();

        if (insertIndex >= 0 && insertIndex <= userArray.length) {

            int[] insertedArray =
                    insert(userArray, insertIndex, insertValue);

            System.out.println("After insertion:");
            display(insertedArray);

        } else {
            System.out.println("Invalid index");
        }


        // ===============================
        // 17. DELETE ELEMENT
        // ===============================

        System.out.print("\nEnter index for deletion: ");
        int deleteIndex = sc.nextInt();

        if (deleteIndex >= 0 && deleteIndex < userArray.length) {

            int[] deletedArray =
                    delete(userArray, deleteIndex);

            System.out.println("After deletion:");
            display(deletedArray);

        } else {
            System.out.println("Invalid index");
        }


        // ===============================
        // 18. FREQUENCY
        // ===============================

        System.out.println("\nFrequency of elements:");

        frequency(userArray);


        // ===============================
        // 19. ARRAY COMPARISON
        // ===============================

        int[] anotherArray = copyArray(userArray);

        System.out.println("\nAre both arrays equal? "
                + Arrays.equals(userArray, anotherArray));


        // ===============================
        // 20. ARRAY TO STRING
        // ===============================

        System.out.println("\nArray as String:");
        System.out.println(Arrays.toString(userArray));


        // ===============================
        // 21. FILL ARRAY
        // ===============================

        int[] filledArray = new int[5];

        Arrays.fill(filledArray, 7);

        System.out.println("\nArray after Arrays.fill():");
        display(filledArray);


        sc.close();
    }
}
