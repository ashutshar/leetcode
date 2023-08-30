package org.reshma;

public class TotalStepsTakenToWaterplants {

    public static void main(String[] args) {
        int[] arr = {3,5,1,2};
        int k = 6;//capacity of water can
        System.out.println("total no. pf steps taken to water plants: "+stepstakenTowaterplant(arr,k));
    }

    private static int stepstakenTowaterplant(int[] arr, int k) {
        int tempk = k;
        int steps = 0;
        for(int i =0;i< arr.length;i++){
            if(arr[i]<=tempk){
                tempk = tempk-arr[i];
                ++steps;
            }else{

                steps = steps + 2*i;//go back to before the first flower pot and fill the water can and come back
                tempk=k;
                i =i-1;

            }
        }
        return steps;
    }

}
