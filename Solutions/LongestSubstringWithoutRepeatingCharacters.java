class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        int i;char ch;
        int max=0;
        int c=0;
        int vis[]=new int[256]; //to store the last occuring position of the character
        for(i=0;i<256;i++)
            vis[i] = -1;
        if(s.length()>0)
        {
            vis[s.charAt(0)]=0;
            c++;
            for(i=1;i<s.length();i++)
            {
                ch=s.charAt(i);
                //to check if a character hasn't been visited
                //or if it has been visited, then it should be after the
                //first occurence of the newly formed substring
                if(vis[ch]==-1 || (i-c>vis[ch]))
                {
                    c++;
                    vis[ch] = i;
                }
                else
                {
                    if(max<c)
                        max=c;
                    c = i - vis[ch]; //sliding window - to start from the position after the                                        repeated character
                    vis[ch] = i;
                }
            }
            if(max<c)
            {
                max=c;
            }
        }
        return max;

    }
}
