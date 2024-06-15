package HASHING;

import java.util.Arrays;
import java.util.Scanner;

public class CountTriplets {
    public  static int countTriplets(int []arr,int n){
        int []pref=new int[n];
        Arrays.fill(pref,0);
        if(arr[1]<arr[0])pref[1]=1;
        int []suff=new int[n];
        Arrays.fill(suff,0);
        if(arr[n-2]<arr[n-1])suff[n-2]=1;
        for(int j=2;j<n;j++){
            int cnt=0;
            for(int i=0;i<=j-1;i++){
                if(arr[i]>arr[j])cnt++;
            }
            pref[j]=cnt;
        }

        int j=n-2;
        while (j>=0){
            int cnt=0;
            int k=j+1;
            while (k<n){
                if(arr[j]<arr[k])cnt++;
                k++;
            }
            suff[j]=cnt;
            j--;
        }
        int res=0;
        for (int i=0;i<n;i++){
            res+=pref[i]*suff[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }

        int ans=countTriplets(a,n);
        System.out.println(ans);



    }
}