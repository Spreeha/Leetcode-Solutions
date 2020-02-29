class Solution {
    public int shortestWay(String source, String target) {
        int ind=0,c=0;
        int i,t;

        while(ind<target.length())
        {
            t=ind;
            for(i=0;i<source.length();i++)
            {
                if(ind<target.length() && target.charAt(ind)==source.charAt(i))
                {
                    ind++;
                }
            }
            if(t==ind) //the characters of target are not contained in source
                return -1;
            c++; //stores the number of subsequences
        }

        return c;
    }
}
