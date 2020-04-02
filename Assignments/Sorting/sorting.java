/**
 * Programmer: Jonathan Manzano
 * 
 * Date: Thursday 02 April 2020
 * 
 * Assignment: Sorting
 * 
 * Description:
 * 
 * (Execution time for sorting) Write a program that obtains the execution time
 * of selection sort, merge sort, quick sort, heap sort, and radix sort for
 * input sizes of 50,000, 100,000, 200,000, 250,000, and 300,000.
 */

import java.util.Arrays;
import java.util.ArrayList;

public class sorting {
public static void main(String[] args) {
  System.out.println("ARRAY SIZE|  Selection  Merge  Quick  Heap  Radix");
  System.out.println("----------|--------------------------------------");

  for (int i = 50_000; i <= 300_000; i += 50_000) {
    int[] list = new int[i];
    for (int j = 0; j < list.length; j++) {
      list[j] = (int)(Math.random() * i);
    }

    int[] copy = Arrays.copyOf(list, list.length);

    System.out.printf("%6d    |", i);

    long start = System.currentTimeMillis();
    SelectionSort.sort(copy);
    long end = System.currentTimeMillis();
    System.out.printf("  %9d", end - start);

    copy = Arrays.copyOf(list, list.length);

    start = System.currentTimeMillis();
    MergeSort.mergeSort(copy);
    end = System.currentTimeMillis();
    System.out.printf("  %5d", end - start);

    copy = Arrays.copyOf(list, list.length);

    start = System.currentTimeMillis();
    QuickSort.quickSort(copy);
    end = System.currentTimeMillis();
    System.out.printf("  %5d", end - start);

    Integer[] heapCopy = new Integer[list.length];
    for (int j = 0; j < list.length; j++) {
      heapCopy[j] = list[j];
    }

    start = System.currentTimeMillis();
    HeapSort.heapSort(heapCopy);
    end = System.currentTimeMillis();
    System.out.printf("  %4d", end - start);

    copy = Arrays.copyOf(list, list.length);
    start = System.currentTimeMillis();
    RadixSort.sort(copy);
    end = System.currentTimeMillis();
    System.out.printf("  %5d\n", end - start);
  }
}

public static void displayList(int[] list) {
  for (int i = 0; i < list.length; i++) {
    System.out.print(list[i] + " ");
  }
  System.out.println();
}
}

class SelectionSort {
  public static void sort(int[] list) {
    for (int i = 0; i < list.length; i++) {
      int low = list[i];
      int lowIndex = i;
      for (int j = i + 1; j < list.length; j++) {
        if (list[j] < low) {
          low = list[j];
          lowIndex = j;
        }
      }
      if (list[i] != low) {
        int temp = list[i];
        list[i] = list[lowIndex];
        list[lowIndex] = temp;
      }
    }
  }
}

class MergeSort {
  public static void mergeSort(int[] list) {
    if (list.length > 1) {
      int[] firstHalf = new int[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);

      int secondHalfLength = list.length - list.length / 2;
      int[] secondHalf = new int[secondHalfLength];
      System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      merge(firstHalf, secondHalf, list);
    }
  }

  public static void merge(int[] list1, int[] list2, int[] temp) {
    int current1 = 0;
    int current2 = 0;
    int current3 = 0;

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2]) {
        temp[current3++] = list1[current1++];
      } else {
        temp[current3++] = list2[current2++];
      }
    }

    while (current1 < list1.length) {
      temp[current3++] = list1[current1++];
    }

    while (current2 < list2.length) {
      temp[current3++] = list2[current2++];
    }
  }
}

class QuickSort {
  public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }

  public static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  public static int partition(int[] list, int first, int last) {
    int pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && list[low] <= pivot) {
        low++;
      }

      while (low <= high && list[high] > pivot) {
        high--;
      }

      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high] >= pivot) {
      high--;
    }

    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }
}

class Heap<E extends Comparable<E>> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();

  public Heap() {
  }

  public void add(E newObject) {
    list.add(newObject);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      } else {
        break;
      }

      currentIndex = parentIndex;
    }
  }

  public E remove() {
    if (list.size() == 0) { return null; }

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      if (leftChildIndex >= list.size()) { break; }
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      } else {
        break;
      }
    }

    return removedObject;
  }

  public int getSize() {
    return list.size();
  }
}

class HeapSort {
  public static <E extends Comparable<E>> void heapSort(E[] list) {
    Heap<E> heap = new Heap<>();

    for (int i = 0; i < list.length; i++) {
      heap.add(list[i]);
    }

    for (int i = list.length - 1; i >= 0; i--) {
      list[i] = heap.remove();
    }
  }
}

class RadixSort {
  public static void sort(int[] list) {
    // find the largest integer in the list
    int largest = list[0];
    for (int i = 1; i < list.length; i++) {
      if (list[i] > largest) { largest = list[i]; }
    }

    // find number of significant digits in largest integer
    int digits = 0;
    do {
      largest /= 10;
      digits++;
    } while (largest != 0);

    // perform the sorting
    ArrayList<ArrayList<Integer>> buckets = getBuckets();
    int m = 10; // mod value for isolating digits up to significant digit
    int n = 1;  // divisor for isolating the significant digit itself
    // for each significant digit
    for (int i = 0; i < digits; i++) {
      // sort each integer into the appropriate bucket
      for (int j = 0; j < list.length; j++) {
        buckets.get((list[j] % m) / n).add(list[j]);
      }
      // put each integer back into the list in its new bucket order
      int count = 0;
      for (int k = 0; k < buckets.size(); k++) {
        for (int p = 0; p < buckets.get(k).size(); p++) {
          list[count++] = buckets.get(k).get(p);
        }
      }
      // increase mod and divisor for the next iteration
      m *= 10;
      n *= 10;
      buckets = getBuckets(); // get fresh buckets
    }
  }

  private static ArrayList<ArrayList<Integer>> getBuckets() {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(new ArrayList<Integer>());
    }
    return list;
  }
}