

import java.util.*;
class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {

        int i;
        Arrays.sort(nums);
        int l=0;
        int sum=0;
        int s=0;
        int min=Integer.MAX_VALUE;
        int r;
        int f; int diff;
        //Array has been sorted
        //applying a meet in the middle approach, keeping the last element of the array fixed
        for(i=nums.length-1; i>1; i--)
        {
            l=0;
            r=i-1;
            while(l<r)
            {
                sum = nums[i] + nums[l] + nums[r] ;
                if(target>sum)
                    diff = target - sum;
                else
                    diff = sum - target;
                if(diff < min) //the closest sum will have the min difference from target
                {
                    min = diff;
                    s = sum;
                }
                if(sum<target)
                    l++;
                else
                    r--;
            }
        }
        return s;
    }
}
