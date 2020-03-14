class Solution {
    //DP solution using bottom up approach
    public int minCut(String s) {
        int n=s.length();
        boolean p[][]=new boolean[n][n]; //to signify whether the substring is plaindrome or not
        int c[][]=new int[n][n]; //signifies the min no of cuts of substring from i to j
        int l,k,i,j;

        //for strings of length 1
        for(i=0;i<n;i++)
        {
            p[i][i]=true; //since strings of length 1 will be 0
            c[i][i]=0; //since min no of cuts for palindrome strings will be 0
        }

        //for all substrings from length 2 to n
        for(l=2;l<=n;l++)
        {
            //i represents the starting index of the substring
            for(i=0;i<n-l+1;i++)
            {
                j=i+l-1;

                if(l==2)
                    p[i][j]=s.charAt(i)==s.charAt(j);
                else
                    p[i][j]=s.charAt(i)==s.charAt(j) && p[i+1][j-1];

                if(p[i][j]==true)
                    c[i][j]=0; //since palindrome
                else
                {
                    c[i][j]=Integer.MAX_VALUE;
                    for(k=i;k<=j-1;k++)
                        c[i][j]=Math.min(c[i][j],c[i][k]+c[k+1][j]+1);
                }
            }
        }
        return c[0][n-1]; //represents the minimum number of cuts to form all palindrome substrings
    }
}
