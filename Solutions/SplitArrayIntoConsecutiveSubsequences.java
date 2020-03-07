
class Solution {
    public boolean isPossible(int[] nums) {
        //count stores the count of each element
        HashMap<Integer,Integer> count=new HashMap<>();
        //end[n] signifies the number of subsequences that end right before n
        HashMap<Integer,Integer> end=new HashMap<>();
        int i;int p=0;

        for(i=0;i<nums.length;i++)
        {
            end.put(nums[i],0);
            p=nums[i];
            if(count.containsKey(nums[i]))
                count.put(nums[i],count.get(nums[i])+1);
            else
                count.put(nums[i],1);
        }
        for(int n:nums)
        {
            if(count.get(n)==0) //the element has already been used up in a subsequence
                continue;
            else if(end.get(n)>0)//the element n can also be added to the subsequence preceeding it
            {
                end.put(n,end.get(n)-1);
                if(end.containsKey(n+1))
                    end.put(n+1,end.get(n+1)+1);
                else
                    end.put(n+1,1);
            }
            else if(count.containsKey(n+1) && count.containsKey(n+2) &&(count.get(n+1)>0 && count.get(n+2)>0))
            {
                count.put(n+1,count.get(n+1)-1);
                count.put(n+2,count.get(n+2)-1);
                if(end.containsKey(n+3))
                    end.put(n+3,end.get(n+3)+1);
                else
                    end.put(n+3,1);
            }
            else
                return false;
            //since the current element was used to form a subsequence
            count.put(n,count.get(n)-1);
        }
        return true;
    }
}
