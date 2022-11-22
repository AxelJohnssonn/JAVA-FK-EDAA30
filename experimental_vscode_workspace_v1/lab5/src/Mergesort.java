

import java.util.Arrays;

public class Mergesort {

    public static void main(String[] args) {
        int[] a = {1000, 1, 300, 90, 70, 2};
        int[] sorted = mergesort(a);
        
        for(int i = 0; i < sorted.length; i++){
            System.out.println(sorted[i]);
        }
    }

    public static int[] mergesort(int[] a){
        if(a.length == 1){
            return a;
        }

        int half = a.length/2;
        int[] left = Arrays.copyOfRange(a, 0, half);
        int[] right = Arrays.copyOfRange(a, half, a.length);

        left = mergesort(left);
        right = mergesort(right);

        int[] sorted = new int[a.length];
        int sorted_index = 0; 
        int left_index = 0; 
        int right_index = 0; 

        while(left_index < left.length && right_index < right.length){
            if(left[left_index] <= right[right_index]){
                sorted[sorted_index] = left[left_index];
                left_index++;
            }else{
                sorted[sorted_index] = right[right_index];
                right_index++;
            }
        }

        while(left_index < left.length){
            sorted[sorted_index] = left[left_index];
                left_index++;
                sorted_index++;
        }

        while(right_index < right.length){
            sorted[sorted_index] = right[right_index];
                right_index++;
                sorted_index++;
        }

        return sorted;

    }
}
