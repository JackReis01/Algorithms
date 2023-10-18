package algo;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sorting {
	public static void main(String[] args)
	{
		String testCase1 = "6,1,20,3,3,4,3,14,13,20,6,8,8,12,13,15,5,18" + "\n" +
		"1,6,20,3,3,4,3,14,13,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,6,20,3,3,4,3,14,13,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,6,20,3,4,3,14,13,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,6,20,4,3,14,13,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,4,6,20,3,14,13,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,20,14,13,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,14,20,13,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,13,14,20,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,13,14,20,20,6,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,6,13,14,20,20,8,8,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,6,8,13,14,20,20,8,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,6,8,8,13,14,20,20,12,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,6,8,8,12,13,14,20,20,13,15,5,18"  + "\n" +
		"1,3,3,3,4,6,6,8,8,12,13,13,14,20,20,15,5,18"  + "\n" +
		"1,3,3,3,4,6,6,8,8,12,13,13,14,15,20,20,5,18"  + "\n" +
		"1,3,3,3,4,5,6,6,8,8,12,13,13,14,15,20,20,18"  + "\n" +
		"1,3,3,3,4,5,6,6,8,8,12,13,13,14,15,18,20,20"  + "\n" +
		"1,3,3,3,4,5,6,6,8,8,12,13,13,14,15,18,20,20";

		System.out.println(testCase1);
		String userInput = "0";
		File myFile = new File("filename.txt");
		while (!userInput.equals("-1"))
		{
			// Get user input
			Scanner user = new Scanner(System.in);
			System.out.println("Input Sort");
			userInput = user.nextLine();
			int[] arr = {6, 1, 20, 3, 3, 4, 3, 14, 13, 20, 6, 8, 8, 12, 13, 15, 5, 18};
		
			if (userInput.equals("1"))
			{
				Insertion(arr);
			}
			else if (userInput.equals("2"))
			{
				Selection(arr);
			}
			else if (userInput.equals("3"))
			{
				int Low = 0;
				int High = arr.length - 1;
				QuickSort(arr, Low, High);
			}
			else if (userInput.equals("4"))
			{
				MergeSort(arr);
			}
			else
			{
				System.out.println("Invalid input");
			}
		}
	}
	
	public static void Insertion(int[] arr)
	{
		Printer(arr);
		int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            Printer(arr);
        }	
	}
	
	public static void Selection(int[] arr)
	{
		 int n = arr.length;

	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (arr[j] < arr[minIndex]) {
	                    minIndex = j;
	                }
	            }
	            int temp = arr[minIndex];
	            arr[minIndex] = arr[i];
	            arr[i] = temp;
	        }
	}
	
	public static void QuickSort(int[] arr, int Low, int High)
	{
		if (Low < High) {
            int pivotIndex = Partitioning(arr, Low, High);
            Printer(arr);
            QuickSort(arr, Low, pivotIndex - 1);
            QuickSort(arr, pivotIndex + 1, High);
        }
	}
	
	public static int Partitioning(int[] arr, int Low, int High) {
        int pivot = arr[High];
        int i = Low - 1;
        for (int j = Low; j < High; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[High];
        arr[High] = temp;
        Printer(arr);
        return i + 1;
    }
	
	public static void MergeSort(int[] arr)
	{
		Printer(arr);
		int n = arr.length;
        if (n > 1) {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, n - mid);

            MergeSort(left);
            MergeSort(right);

            Merge(arr, left, right);
            Printer(arr);
        }
	}
	public static void Merge(int[] arr, int[] left, int[] right) {
        int LeftNode = left.length;
        int RightNode = right.length;
        int i = 0, j = 0, k = 0;

        while (i < LeftNode && j < RightNode) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < LeftNode) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < RightNode) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
	
	public static void Printer(int[] arr)
	{
		int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
	
}
