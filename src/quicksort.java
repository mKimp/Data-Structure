import java.util.Random;
import java.util.*;

public class quicksort {



    public static class Pair<Integer>{
        int f;
        int s;
        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        public int getFirst() {
            return this.f;
        }

        public int getSecond() {
            return this.s;
        }
    }

    public static void main(String[] args) {
            int [] a;
            a = new int[]{8, 5, 1, 3, 4, 2, 7, 6};
            quickSort(a);

            for (int i : a)
                System.out.println(i);
    }
/*
    public static Pair<Integer> dutchNationalFlag(int[] a, int start, int end, int pivotIndex) {
        int pivot = a[pivotIndex];
        int low = start - 1, mid = start - 1, high = end + 1;
        while (mid + 1 < high) {
            if (a[mid + 1] > pivot) {
                int temp = a[high-1];
                a[high-1]  = a[mid + 1];
                a[mid + 1] = temp;
                high--;
            } else if (a[mid + 1] == pivot) {
                mid++;
            } else {
                int temp = a[mid + 1];
                a[mid + 1] = a[low+1];
                a[low+1] = temp;
                mid++;
                low++;
            }
        }
        return new Pair<Integer>(low, high);
    } */

    public static void quickSort(int[] a, int start, int end) {
        if(start < end){
            int pivotIndex = partition(a, start, end);
            quickSort(a, start, pivotIndex -1 );
            quickSort(a, pivotIndex + 1, end);

        }
    }

    private static int partition(int[] a, int start, int end) {
        randomPivot(a, start, end);
        int pivotValue = a[end];
        int pIndex = start - 1;
        for (int i = start; i <= end - 1; ++i){
            if(a[i] <= pivotValue){
                ++pIndex;
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
            }
        }
        int temp = a[end];
        a[end] = a[pIndex + 1];
        a[pIndex + 1] = temp;
        return pIndex + 1;
    }

    private static void randomPivot(int[] a, int start, int end) {
        int randomPivotIndex = start + (new Random().nextInt(end-start + 1));
        int temp = a[end];
        a[end] = a[randomPivotIndex];
        a[randomPivotIndex] = temp;
    }

    public static int[] quickSort(int[] a) {
        if (a == null)
            return a;
        quickSort(a, 0, a.length - 1);
        return a;
    }
}
