class Solution {
    //DP solution
    public int minSwap(int[] a, int[] b) {
        int i;int n1,n2,s1,s2;
        //n1 represents no swapping till the (i-1)th position in which case the elements are         //naturally increasing in order. n2 represents no swapping at the ith position

       //s1 represents  swap is done at the (i-1)th pos and
       //s2 represnts a swap is performed at the ith position

        n1=0; //n1 will naturally be 0 since the first element is going to have no larger                   //element before it, so the number of swaps required would be 0
        s1=1; //considering the first element is swapped

        for(i=1;i<a.length;i++)
        {
            n2=Integer.MAX_VALUE;
            s2=Integer.MAX_VALUE;

            //the case where adjacent elements of both the arrays are strictly increasing
            if(a[i-1]<a[i] && b[i-1]<b[i])
            {
                n2=Math.min(n1,n2);
                s2=Math.min(s2,s1+1); //still considering a swap is done since a swap at ith                                       //position maybe needed for the (i+1)th position                                             //element to maintain the strictly increasing property
            }

            //the case where diagonal elements are also strictly increasing in which case the             //values need to be floored. If the diagonal elements are strictly increasing,               //the adjacent elements of both arrays may or may not be
            //strictly increasing which is why this condition is there
            if(a[i-1]<b[i] && b[i-1]<a[i])
            {
                n2=Math.min(n2,s1); //for cases where adjacent elements are not strictly                                        //increasing but diagonal elements are strictly
                                   //increasing so swapping needs to be done
                s2=Math.min(s2,n1+1);//Minimum of (swaps till the ith position) and the                       //(count of natural till the (i-1)th position + 1 swap for the ith position)
            }
            n1=n2;
            s1=s2;
        }
        //minimum of natural and the number of swaps is returned
        return Math.min(n1,s1);
    }
}
