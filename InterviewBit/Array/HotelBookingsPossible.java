/*
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. 
Bookings contain an arrival date and a departure date. 
He wants to find out whether there are enough rooms in the hotel to satisfy the demand. 
Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.

Example :

Input : 
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False / 0 

At day = 5, there are 2 guests in the hotel. But I have only one room.
*/

class T
{
    int value;
    boolean start;
    
    public T(int a, boolean b)
    {
        this.value = a;
        this.start = b;
    }
}

class sortByT implements Comparator<T> 
{
    public int compare(T a, T b) 
    { 
        if(a.value != b.value)
            return a.value - b.value;
        
        return a.start ? 1 : -1;
    } 
}

public class Solution 
{
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) 
    {
        T arr[] = new T[arrive.size() + depart.size()];
        
        for(int i = 0; i<arrive.size(); i++)
            arr[i] = new T(arrive.get(i), true);
        
        for(int i = 0; i<depart.size(); i++)
            arr[arrive.size() + i] = new T(depart.get(i), false);
        
        Arrays.sort(arr, new sortByT());
        
        int count = 0;
        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i].start)
                count++;
            
            else
                count--;
            
            if(count > K)
                return false;
        }
        
        return true;
    }
}
