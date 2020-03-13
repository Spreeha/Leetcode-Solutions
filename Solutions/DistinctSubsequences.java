class Solution {
    public int numDistinct(String s, String t) {
        int i,j;
        int m=t.length();
        int n=s.length();
        if(m>n)
            return 0;
        //the rows represent target string and colums represent the source string
        int dp[][]=new int[m+1][n+1];
        //an empty target string wont contain any subsequence
        for(i=0;i<=m;i++)
        {
            dp[i][0]=0;
        }
        //an empty string will always be a subsequence of target string hence 1
        for(i=0;i<=n;i++)
        {
            dp[0][i]=1;
        }

        for(i=1;i<=m;i++)
        {
            for(j=1;j<=n;j++)
            {
                //if the last charactersw don't match, then last character from s can be removed without causing a difference
                if(t.charAt(i-1)!=s.charAt(j-1))
                    dp[i][j]=dp[i][j-1];
                else //sum of substring where last charcters from both strings were removed and the case of all substrings where the last character from the source string s wasn't removed
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
