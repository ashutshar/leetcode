package org.example;

import java.util.Arrays;

public class IonFluxRelabbeling {
    public static int[] solution(int h, int[] q) {
        int[] answer = new int[q.length];
        int heightIndex = 0;
        for (int i = 0; i < q.length ; i++) {
            heightIndex = 0;
            if (q[i] == (int)Math.pow(2, h) -1) {
                answer[i] = -1;
            } else {
                answer[i] = getParent(q[i], (int)Math.pow(2, h) -1);
            }
        }
        return answer;
    }


    public static int getParent(int node, int size)
    {
        int rank = size;
        int index = size;

        while (rank > 0) {
            int leftIndex = index - (rank + 1)/2;
            int rightIndex = index - 1;

            if (node == leftIndex || node == rightIndex) {
                return index;
            }

            index = (node < leftIndex ? leftIndex : rightIndex);
            rank  = (rank - 1)/2;
        }
        return index;
    }

    public static void main(String[] args) {
        int h = 30;
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(solution(h, arr)));

    }


}
