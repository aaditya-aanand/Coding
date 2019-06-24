/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
   public static void main (String[] args) throws java.lang.Exception
   {
      Scanner in = new Scanner(System.in);
      int T = in.nextInt();

      for(int t = 0; t<T; t++)
      {
         int N = in.nextInt();
         int arr[] = new int[N];

         for(int i = 0; i<N; i++)
            arr[i] = in.nextInt();

         long max_sum_left[] = new long[N];
         long min_sum_left[] = new long[N];

         long curr_max = -1;
         long curr_min = 1;

         for(int i = 0; i<N; i++)
         {
            if(arr[i] < curr_min + arr[i])
            	curr_min = arr[i];

            else
            	curr_min += arr[i];

            if(arr[i] > curr_max + arr[i])
            	curr_max = arr[i];

            else
            	curr_max += arr[i];

            min_sum_left[i] = curr_min;
            max_sum_left[i] = curr_max;
         }

         long max_sum_right[] = new long[N];
         long min_sum_right[] = new long[N];

         curr_max = -1;
         curr_min = 1;

         for(int i = N-1; i>=0; i--)
         {
            if(arr[i] < curr_min + arr[i])
            	curr_min = arr[i];

            else
            	curr_min += arr[i];

            if(arr[i] > curr_max + arr[i])
            	curr_max = arr[i];

            else
            	curr_max += arr[i];

            min_sum_right[i] = curr_min;
            max_sum_right[i] = curr_max;
         }

         long max_diff = 0;
         for(int i = 0; i<N-1; i++)
         {
            long w = min_sum_left[i];
            long x = min_sum_right[i+1];
            long y = max_sum_left[i];
            long z = max_sum_right[i+1];

            long diff = Math.max(Math.abs(x-y), Math.abs(w-z));
            max_diff = Math.max(max_diff, diff);
         }

         System.out.println(max_diff);
      }

      in.close();
   }
}
