class ReverseWordsInAStringI {
    public String reverseWords(String s) {
        String str="";
        if(s.length()==0)
            return s;
        if(s.length()==1)
        {
            if(s.charAt(0)==' ')
                return str;
            else
                return s;
        }
        Scanner sc=new Scanner(s);
        while(sc.hasNext())
        {
            str=sc.next()+" "+str;
        }
        if(str.length()>1)
            if(str.charAt(str.length()-1)==' ')
                str=str.substring(0,str.length()-1);
        return str;
    }
}
