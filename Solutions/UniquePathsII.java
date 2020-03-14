class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        int i,j;
        dp[0][0]=1;

        if(grid[0][0]==1 || grid[m-1][n-1]==1)
            return 0;
        //filling all the first entries for the rows or the first column
        for(i=1;i<m;i++)
        {
            if(grid[i][0]==1)
                dp[i][0]=0;
            else
                dp[i][0]=dp[i-1][0];
        }

        //filling the first entries for all columns or the first row
        for(i=1;i<n;i++)
        {
            if(grid[0][i]==1)
                dp[0][i]=0;
            else
                dp[0][i]=dp[0][i-1];
        }

        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                if(grid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
