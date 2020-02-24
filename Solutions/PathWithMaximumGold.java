class Solution {
    //using DFS approach to find the path with maximum gold
    public int findGold(int mat[][],int i,int j,int r,int c,int vis[][])
    {

        if(i<0 || i>=r ||j<0 || j>=c) //out of bounds of the grid
            return 0;
        else if(vis[i][j]==1) //already visited cell
            return 0;
        else if(mat[i][j]==0)
            return 0;
        else if(((i+1)>=r||i<0||((i+1)>=0 && (i+1)<r && mat[i+1][j]==0)) && ((i-1)>=r||i<0||((i-1)>=0 && (i-1)<r && mat[i-1][j]==0)) && ((j+1)>=c||j<0||((j+1)>=0 && (j+1)<c && mat[i][j+1]==0)) && ((j-1)>=c||j<0||((j-1)>=0 && (j-1)<c && mat[i][j-1]==0)))
        {
            return mat[i][j]; //if the boundary has been reached or current
                              //element is in such a cell where movement
                              //cannot progress in all 4 directions around it
        }
        else
        {
            vis[i][j]=1; //marking the cell as visited
            //storing the sum of amounts in the direction that gives maximum gold
            int res = mat[i][j] + Math.max(Math.max(findGold(mat,i+1,j,r,c,vis),findGold(mat,i-1,j,r,c,vis)),Math.max(findGold(mat,i,j+1,r,c,vis),findGold(mat,i,j-1,r,c,vis)));
            vis[i][j]=0; //backtracking
            return res;
        }
    }

    public int getMaximumGold(int[][] grid) {
        int r,c;int i,j; int max=0;int res;
        r=grid.length;
        c=grid[0].length;

        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(grid[i][j]!=0)
                {
                    int vis[][]=new int[r][c];
                    //for every set of index if it is not empty,
                    //DFS is launched to find the path with maximum gold
                    res=findGold(grid,i,j,r,c,vis);
                    if(max<res)
                        max=res;
                }
            }
        }
        return max;
    }
}
