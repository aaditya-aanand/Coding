/*
N number of books are given. 
The ith book has Pi number of pages. 
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. 
A book will be allocated to exactly one student. Each student has to be allocated at least one book. 
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:

List of Books
M number of students
Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.
*/

public class Solution 
{
    public static int numStudentsReq(int arr[], long pages)
    {
        int students = 0;
        long temp_pages = pages;

        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i] <= temp_pages)
                temp_pages -= arr[i];

            else
            {
                temp_pages = pages;
                students++;

                if(arr[i] <= temp_pages)
                    temp_pages -= arr[i];
            }
        }

        return students+1;
    }

    public static long floorSearch(long low, long high, int arr[], int totalStudent)
    {
        long mid; 
        while(low <= high) 
        { 
            mid = low + (high-low)/2;

            if(numStudentsReq(arr, mid) > totalStudent)
                low = mid+1;

            else
                high = mid-1;
        } 
      
        return low;
    }

    public int books(int[] C, int B) 
    {
        int n = C.length;
        long sum = C[0];
        long maximum = C[0];

        for(int i = 1; i<n; i++)
        {
            sum = sum + C[i];
            maximum = Math.max(maximum, C[i]);
        }
            
        long low = maximum;
        long high = sum;

        int x = (int) floorSearch(low, high, C, B);

        if(x == low && B > C.length)
            return -1;
            
        return x;
    }
}
