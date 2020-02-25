class Solution {
//if the elements at the rest of the indices can be made equal to the element of the
//first index needs to be checked. That will give minimum number of swaps. Only a[0] and b[0] //needs to be considered because for the rotataions to be possible, atleast one element at //each of the corresponding indices needs to be the same.
    public int rotate(int a[],int b[])
    {
        int ca=0,cb=0;int i;
        for(i=0;i<a.length;i++)
        {
            if(a[i]!=a[0] && b[i]!=a[0])
                return -1;
            else if(a[i]!=a[0])
                ca++;
            else if(b[i]!=a[0])
                cb++;
        }
        return Math.min(ca,cb);
    }

    public int minDominoRotations(int[] a, int[] b) {

        int c1=rotate(a,b);
        int c2=rotate(b,a);
        System.out.println(c1+" "+c2);
        if(c1==-1 && c2==-1)
            return -1;
        else
        {
            if(c1==-1)
                return c2;
            else if(c2==-1)
                return c1;
            else
                return Math.min(c1,c2);
        }
    }
}
