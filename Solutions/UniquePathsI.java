class UniquePathsI {
    //DP solution
    public int unique(int m,int n,int r,int c)
    {
        int dp[][]=new int[r][c];
        int i,j;

        for(i=0;i<r;i++)
            dp[i][0]=1;
        for(i=0;i<c;i++)
            dp[0][i]=1;

        for(i=1;i<r;i++)
        {
            for(j=1;j<c;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[r-1][c-1];
    }

    //recursive solution results in TLE
    /*public int unique(int m,int n,int r,int c)
    {
        if(m<0 || m>=r || n<0 || n>=c)
            return 0;

        if(m==r-1 && n==c-1)
        {
            return 1;
        }
        else
        {
            int t = unique(m+1,n,r,c) + unique(m,n+1,r,c) ;
            System.out.println("= "+t);
            return t;
        }

    }*/
    public int uniquePaths(int m, int n) {

        int num=unique(0,0,m,n);
        return num;
    }
}
