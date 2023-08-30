package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DARray {
    public static void main(String[] args) {
        int[][] arr = new int[4][2];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{2, 3};
        arr[2] = new int[]{3, 4};
        arr[3] = new int[]{1, 2};
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.toString(arr));

    }
}
