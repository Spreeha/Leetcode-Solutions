class Solution {
    //using runlength encoding to store the characters in one list and
    //frequency of their adjacent appearances in corresponsing positions of another list
    public int expressiveWords(String s, String[] words) {

        char cs[]=s.toCharArray();
        int i,j; int count = 0;int p=0;
        //a stores the characters and ac stores the count of adjacent appearances
        //Eg, for "heeellooo" a=['h','e','l','o'] and ac=[1,3,2,3] because h1e3l2o3
        ArrayList<Character> a=new ArrayList<>();
        ArrayList<Integer> ac=new ArrayList<>();
        int k=1;;
        for(i=0;i<cs.length-1;i++)
        {
            if(cs[i]==cs[i+1])
            {
                k++;
            }
            else
            {
                a.add(cs[i]);
                ac.add(k);
                k=1;
            }
        }
        if(cs[cs.length-1]==cs[cs.length-2])
        {
            a.add(cs[cs.length-1]);
            ac.add(k);
        }
        else
        {
            a.add(cs[cs.length-1]);
            ac.add(1);
        }

        //performing runlength encoding for every word in the list
        //count stores the number of expressive words
        for(i=0;i<words.length;i++)
        {
            char ws[]=words[i].toCharArray();
            //b stores the characters and bc stores the count of adjacent appearances
            ArrayList<Character> b=new ArrayList<>();
            ArrayList<Integer> bc=new ArrayList<>();
            k=1;
            for(j=0;j<ws.length-1;j++)
            {
                if(ws[j]==ws[j+1])
                {
                    k++;
                }
                else
                {
                    b.add(ws[j]);
                    bc.add(k);
                    k=1;
                }
            }
            if(ws[ws.length-1]==ws[ws.length-2])
            {
                b.add(ws[ws.length-1]);
                bc.add(k);
            }
            else
            {
                b.add(ws[ws.length-1]);
                bc.add(1);
            }

            //condition to check if b when expanded becomes the expressive word a
            //the list sizes of the runlength encoding
            //will be the same if they are expressive
            if(a.size()==b.size())
            {
                for(j=0;j<a.size();j++)
                {
                    if(a.get(j)!=b.get(j)) //not expressive
                    {
                        p=1;
                        break;
                    }
                    if(a.get(j)==b.get(j))
                    {
                        //the condition bc.get(j)<2 is kept because if the length is more                             //than 2, the first character will anyway have a difference more than                         //3 with the expressive word, so it can also be
                        //expanded to make an expressive word
                        if((ac.get(j)!=bc.get(j)&&ac.get(j)-bc.get(j)<2&&bc.get(j)<2) || ac.get(j)<bc.get(j))
                        {
                            p=1; //not expressive
                            break;
                        }
                    }
                }
                //word can be expressive because the loop hasn't been broken from
                if(p==0)
                    {
                        p=0;
                        count++;
                    }
                    else
                        p=0;
                    }

        }
        //returning the number of expressive words from words[] array
        return count;
    }
}
