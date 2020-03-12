class Solution {

    public int longestStrChain(String[] words) {

        HashMap<String,Integer> map=new HashMap<>();//to store the chain length for every corresponding word
        //set to store copy of all words in array without duplicates
        Set<String> set=new HashSet<>(Arrays.asList(words));
        int max=0;
        Arrays.sort(words);
        int res;

        for(String s:words)
        {
            if(s.length()>1)
            {
                res=check(s,map,set); //recursive func to find the chain length
                max=Math.max(max,res);
            }
            else
            {
                map.put(s,1);
            }
        }
        return max;
    }

    public int check(String s,HashMap map,Set set)
    {
        int i;String str;int max=0;
        if(map.containsKey(s))
            return (int)map.get(s);
        else
        {
            for(i=0;i<s.length();i++)
            {
                //removing 1 character and forming a word and seeing if it exists in the set so that +1 can be added to chain length
                str=s.substring(0,i)+s.substring(i+1); //leaving out the ith char every time
                if(set.contains(str))
                {
                    max=Math.max(max,check(str,map,set));
                }
            }
        }
        //max has to be 0 here since we are returning max+1, if we set value of max as negative value then negative number will get returned
        //max is the max chain length of the intermediate subsequence string and +1 for the current word
        map.put(s,max+1);
        return max+1;
    }
}
