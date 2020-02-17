class Solution {
    public int maximalSquare(char[][] matrix) {
        //Dp solution

        int i,j;int max=0;
        int r=matrix.length;
        if(r>0)
        {
            int c=matrix[0].length;
            int dp[][]=new int[r][c];
            int mat[][]=new int[r][c];

           for(i=0;i<r;i++)
            {
                for(j=0;j<c;j++)
                {
                    mat[i][j]=(int)matrix[i][j]-48;
                }
            }

            for(i=0;i<r;i++)
                dp[i][0]=mat[i][0];
            for(i=0;i<c;i++)
                dp[0][i]=mat[0][i];

            //each index will store the square size at that instance
            for(i=1;i<r;i++)
            {
                for(j=1;j<c;j++)
                {
                    if(mat[i][j]==1)
                    {
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    }
                    else
                        dp[i][j]=0;
                }
            }

            //finding the maximum size of the largest possible subsquare
            for(i=0;i<r;i++)
            {
                for(j=0;j<c;j++)
                {
                    if(max<dp[i][j])
                        max=dp[i][j];
                }
            }

            return (max*max);
        }
        else
            return 0;
    }
}
