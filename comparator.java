class sortBySomething implements Comparator<T> 
{
    public int compare(T a, T b) 
    { 
        return a.something - b.something; 
    } 
} 

// Arrays.sort(<>, new sortBySomething());
