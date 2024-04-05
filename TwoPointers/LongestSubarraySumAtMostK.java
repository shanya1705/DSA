package TwoPointers;

import java.util.Scanner;

class LongestSubarraySumAtMostK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int i = 0; // Change to 0-based index
        int j = 0; // Change to 0-based index
        int maxLen = 0;

        int sum = b[0]; // Change to 0-based index
        while (i < n && j < n) {
            if (i == j) {
                if (b[i] > k) {
                    i++;
                    j++;
                    if(i < n){
                        sum = b[i];
                    }
                } else {
                    int curLen = 1;
                    maxLen = Math.max(curLen, maxLen);

                    j++;
                    if(j < n){
                        sum += b[j];
                    }
                }
            } else {
                if (sum > k) {
                    //[i....j] is invalid but [i......j-1] was valid
                    //so->[i+1...j-1] will also be valid hence
                    //i++ and j--

                    sum -= b[i];
                    i++;
                    sum -= b[j];
                    j--;
                    if (i > j) {
                        j = i;
                    }
                } else {
                    int curLen = Math.abs(i - j) + 1;

                    j++;

                    if (j < n) {
                        sum += b[j];
                    }

                    maxLen = Math.max(curLen, maxLen);
                }
            }
        }

        System.out.println(maxLen);
        scanner.close();
    }
}
