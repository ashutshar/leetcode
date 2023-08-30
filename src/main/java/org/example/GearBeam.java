package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GearBeam {
    //If even path r = 2/3 * (p-q+r)
    //If odd path r = 2 (p - q)
    public static int[] solution(int[] pegs) {
        List<Integer> diffArr = new ArrayList<>();
        for (int i =1; i < pegs.length; i++) {
            diffArr.add(pegs[i]-pegs[i-1]);
        }
        int sum = 0;
        for (int i = 0 ; i < diffArr.size(); i++) {
            if (i % 2 == 0) {
                sum = sum + diffArr.get(i);
            } else {
                sum = sum - diffArr.get(i);
            }
        }
        sum = 2 * sum;
        int[] potentialAns;
        if (sum <= 0) {
            potentialAns  = new int[]{-1, -1};
        } else if(diffArr.size() % 2 == 0) {
            potentialAns = new int[]{sum, 1};
        } else {
            if (sum % 3 == 0) {
                potentialAns = new int[]{ sum / 3, 1};
            } else {
                potentialAns = new int[]{sum, 3};
            }
        }
        return verifyAns(potentialAns, diffArr);
    }

    public static int[] verifyAns(int[] ans, List<Integer> diffArr) {
        float remain = 0;
        boolean first = true;
        boolean fails = false;
        for (int i : diffArr) {
            if (first) {
                remain = i - (ans[0]/ans[1]);
                first = false;
            } else {
                remain = i - remain;
            }
            if (remain <= 0) {
                fails = true;
                break;
            }
        }
        if (fails) {
            return new int[] {-1, -1};
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 30, 50, 53};
        int[] arr3 = new int[]{4,17,50};
        int[] arr2 = new int[]{4,30,50};
        int[] arr4 = new int[]{4, 27};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr3)));
        System.out.println(Arrays.toString(solutionReshu(arr2)));
        System.out.println(Arrays.toString(solution(arr4)));
    }

    public static int[] solutionReshu(int[] pegs) {
        int[] diff = new int[pegs.length-1];
        for(int i=1;i<pegs.length;i++){
           diff[i-1] = pegs[i]-pegs[i-1];
            if((i-1)%2==1)
                diff[i-1] = -1*diff[i-1];
        }
        int sum =0;
        for(int j=0;j<diff.length;j++){
            sum = sum + diff[j];
        }
        if(sum>0 && diff.length%2==0){
            return new int[]{2*sum,1};
        }
        else if(sum>0 && diff.length%2==0){
            if(sum%3==0)
              return new int[]{2*sum/3,1};
            else
              return new int[]{2*sum,3};
        }
       return new int[]{-1,-1};
    }

}
