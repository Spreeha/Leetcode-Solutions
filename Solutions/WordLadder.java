class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //using a BFS approach
        //Initially level has been set as 1
        int i;String s;int level=1;int size=1;
        Queue<String> q=new LinkedList<>();

        if(wordList.contains(endWord)==false)
            return 0;

        q.add(beginWord);
        //hashset to keep track of which words havent been visited yet
        //using set because time to access an element is O(1) and it doesn't allow duplicates
        HashSet<String> h=new HashSet<>();
        for(i=0;i<wordList.size();i++)
            h.add(wordList.get(i));

        while(q.isEmpty()==false)
        {
            if(size==0)
                size=q.size();
            s=q.remove();
            char ch[]=s.toCharArray();
            //for every element in the queue, generating all words at an edit dist of 1
            //adding the newly generated word to the next level of
            //queue if they belong in the set
            for(i=0;i<s.length();i++)
            {
                char org=ch[i];
                for(char j='a';j<='z';j++)
                {
                    ch[i]=j;
                    String n=new String(ch);
                    if(n.equals(endWord))
                        return level+1;
                    if(h.contains(n))
                    {
                        q.add(n);
                        h.remove(n);
                    }
                }
                ch[i]=org;
            }
            //icrementing the level each time all the elements in the
            //current level have been processed
            size--;
            if(size==0)
                level=level+1;
        }
        //returning 0 if no such transition was possible
        return 0;
    }
}
