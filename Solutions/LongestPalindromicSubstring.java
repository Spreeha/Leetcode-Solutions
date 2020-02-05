class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int i,j,k;int max=1;int start=0;
        int n=s.length();
        boolean table[][]=new boolean[n][n];

        for(i=0;i<n;i++)
            table[i][i]=true;

        //for palindromic sequences of length 2
        for(i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                table[i][i+1]=true;
                start=i;
                max=2;
            }
        }

        //k is the length of the palindromic substring
        for(k=3;k<=n;k++)
        {
            //i serves as the starting index, it goes on till that index
            //where the length of substring(i,i+k)=k
            for(i=0;i<n-k+1;i++)
            {
                //j is the last index of the substring of length k
                j=i+k-1;
                //if substring(i+1,j-1)=true and characters at ith =character at jth index
                //then t[i][j]=true meaning the substring(i,j)=true
                if(table[i+1][j-1]==true && s.charAt(i)==s.charAt(j))
                {
                    table[i][j]=true;

                    if(k>max)
                    {
                        //max stores the maximum length of the substring
                        max=k;
                        start=i;
                    }
                }
            }
        }
        if(s.equals("")==false)
        {
            System.out.println(max);
            String str=s.substring(start,start+max);
            //The maximum length substring gets returned
            return str;
        }
        else
            return s;
    }
}
