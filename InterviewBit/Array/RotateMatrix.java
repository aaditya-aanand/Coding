/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
*/

public class Solution 
{
    public void rotate(ArrayList<ArrayList<Integer>> a) 
    {
        int n = a.size();
        int currColMax = n;
        int ni = 0;
        int nii = 0;
        int nj = 0;
        int temp = 0;
        int tempest = 0;

        for(int i = 0; i<Math.ceil(n/2); i++)
        {
            currColMax--;
            for(int j = i; j<currColMax; j++)
            {
                ni = j;
                nj = n-1-i;
                temp = a.get(ni).get(nj);
                a.get(ni).set(nj, a.get(i).get(j));

                nii = ni;
                ni = nj;
                nj = n-1-nii;
                tempest = a.get(ni).get(nj);
                a.get(ni).set(nj, temp);

                nii = ni;
                ni = nj;
                nj = n-1-nii;
                temp = a.get(ni).get(nj);
                a.get(ni).set(nj, tempest);

                nii = ni;
                ni = nj;
                nj = n-1-nii;
                a.get(ni).set(nj, temp);
            }
        }
    }
}
