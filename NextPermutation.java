class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i;int p,q;int t;
        p = -1;

        //p stores the index of the first element that is lesser than the element
        //to its right on scanning from right to left
        for(i=nums.length-1;i>=1;i--)
        {
            if(nums[i]>nums[i-1])
            {
                p = i-1;
                break;
            }
        }
        //No element found, so array gets sorted in ascending order
        if(p==-1)
        {
            Arrays.sort(nums);
        }
        else
        {
            for(i=nums.length-1; i>p; i--)
            {
                //The element at position p is swapped with the first occuring element
                //that is greater than it on scanning from right to left
                if(nums[i]>nums[p])
                {
                    t=nums[i];
                    nums[i]=nums[p];
                    nums[p]=t;
                    break;
                }
            }

            int l = p + 1;
            int r = nums.length-1;
            //The rest of the elements in the array from p+1 to
            //the last position are reversed
            while(l<r)
            {
                t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
                l++;
                r--;
            }
        }
        for(i=0; i<nums.length; i++)
        {
            System.out.print(nums[i]+",");
        }
    }
}
