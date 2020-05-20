class Solution {
    public int minSteps(String s, String t) {
        int sc[]=new int[26];
        int tc[]=new int[26];
        int i;char ch; int count=0;

        for(i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            sc[ch-'a']++;
        }
        for(i=0;i<t.length();i++)
        {
            ch=t.charAt(i);
            tc[ch-'a']++;
        }

        for(i=0;i<sc.length;i++)
        {
            if(sc[i]>0)
            {
                if(sc[i]>tc[i])
                {
                    count=count+(sc[i]-tc[i]);
                }
            }
        }

        return count;
    }
}
