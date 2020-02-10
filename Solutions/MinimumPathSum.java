class MinimumPathSum {

    //DP solution
    public int path(int grid[][],int r,int c)
    {
        int dp[][]=new int[r][c];
        int i,j;
        dp[0][0]=grid[0][0];

        for(i=1;i<c;i++)
            dp[0][i]=dp[0][i-1]+grid[0][i];
        for(i=1;i<r;i++)
            dp[i][0]=dp[i-1][0]+grid[i][0];

        for(i=1;i<r;i++)
        {
            for(j=1;j<c;j++)
            {
                dp[i][j]=Math.min(grid[i][j]+dp[i-1][j],grid[i][j]+dp[i][j-1]);
            }
        }
        return dp[r-1][c-1];
    }

    //recursive solution
    /*public int path(int grid[][],int m,int n,int r,int c,int sum)
    {
        if(m<0 || m>=r || n<0 || n>=c)
            return Integer.MAX_VALUE;
        if(m==r-1 && n==c-1)
        {
            return sum+grid[m][n];
        }
        else
        {
            int p1=Integer.MAX_VALUE;
            int p2=Integer.MAX_VALUE;
            sum=sum+grid[m][n];
            p1=path(grid,m+1,n,r,c,sum);
            p2=path(grid,m,n+1,r,c,sum);
            int x=Math.min(p1,p2);
            return x;
        }
    }*/

    public int minPathSum(int[][] grid) {

        int r=grid.length;
        int c=grid[0].length;
        //int res = path(grid,0,0,r,c,0);
        int res=path(grid,r,c);
        return res;
    }
}
