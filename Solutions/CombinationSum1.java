class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        combine(candidates,target,0,0,res,tmp);
        return res;
    }

    public void combine(int arr[],int target,int sum, int start,List<List<Integer>>                                     res,List<Integer> tmp)
    {
        //base case
        if(sum>target)
            return;

        if(target==sum)
        {
            //Adding that list into the list of lists and
            //emptying that list to store a new list
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=start;i<arr.length;i++)
        {
            tmp.add(arr[i]);

            combine(arr,target,sum+arr[i],i,res,tmp);

            //to backtrack back by one position each time and check if
            //other element combinations can be added to that list
            tmp.remove(tmp.size()-1);
        }
    }
}
