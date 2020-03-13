class Solution {
    public boolean check(String s1,int i,String s2,int j,String s3,int k,int dp[][])
    {
        boolean res;

        if(i==s1.length())
            return s2.substring(j).equals(s3.substring(k));
        if(j==s2.length())
            return s1.substring(i).equals(s3.substring(k));
        if(dp[i][j]>=0)
        {
            if(dp[i][j]==1)
                return true;
            else
                return false;
        }

        res=false;
        if((s1.charAt(i)==s3.charAt(k) && check(s1,i+1,s2,j,s3,k+1,dp)) || (s2.charAt(j)==s3.charAt(k) && check(s1,i,s2,j+1,s3,k+1,dp)))
            res=true;

        if(res==true)
            dp[i][j]=1;
        else
            dp[i][j]=0;
        return res;
    }
    public boolean isInterleave(String s1, String s2, String s3)
    {
        int dp[][]=new int[s1.length()][s2.length()];
        int i,j;
        for(i=0;i<s1.length();i++)
        {
            for(j=0;j<s2.length();j++)
            {
                dp[i][j]=-1;
            }
        }
        return check(s1,0,s2,0,s3,0,dp);
    }

    //recursive solution gives TLE
    /*public boolean isInterleave(String s1, String s2, String s3)
    {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        return leave(s1,s2,s3,0,0,0);
    }
    public boolean leave(String s1, String s2, String s3,int i,int j,int k)
    {
        if(i==s1.length() && j==s2.length() && k==s3.length())
            return true;
        if(s1.equals("") && s2.equals("") && s3.equals(""))
            return true;
        if(s3.equals(""))
            return false;

         boolean res = ((i<s1.length() && k<s3.length() && s1.charAt(i)==s3.charAt(k) && leave(s1,s2,s3,i+1,j,k+1))||(j<s2.length() && k<s3.length() && s2.charAt(j)==s3.charAt(k) && leave(s1,s2,s3,i,j+1,k+1)));

        return res;
    }*/
}  
