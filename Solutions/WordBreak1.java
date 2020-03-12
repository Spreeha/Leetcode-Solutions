class Solution {
    //DP solution
    public boolean wordBreak(String s, List<String> wordDict)
    {
        int len=s.length();
        boolean dp[]=new boolean[len+1];
        int i,j;

        for(i=1;i<=len;i++)
        {
            if(dp[i]==false && wordDict.contains(s.substring(0,i)))
                dp[i]=true;
            if(dp[i]==true)
            {
                if(i==len)
                    return true;
                for(j=i+1;j<=len;j++)
                {
                    if(dp[j]==false && wordDict.contains(s.substring(i,j)))
                        dp[j]=true;
                    if(dp[j]==true && j==len)
                        return true;
                }
            }
        }
        return false;
    }

    //recursive solution
    /*public boolean wordBreak(String s, List<String> wordDict) {
        int i;String str1,str2;
        if(s.length()==0)
            return true;
        if(wordDict.contains(s))
            return true;
        for(i=0;i<s.length();i++)
        {
            str1=s.substring(0,i);
            str2=s.substring(i);
            if(wordDict.contains(str1) && wordBreak(str2,wordDict))
                return true;
        }
        return false;
    }*/
}
