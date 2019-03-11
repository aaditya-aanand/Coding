/*
Generates all primes up to A, starting from 2, isComposite[i] = false signifies that i is a prime number
*/

public boolean[] primeGenerator(int A) 
{
    boolean isComposite[] = new boolean[A+1];

    for(int i = 2; i*i < isComposite.length; i++)
    {
        if(!isComposite[i])
        {
            for(int j = i*i; j<isComposite.length; j = j+i)
                isComposite[j] = true;
        }
    }
    return isComposite;
}
