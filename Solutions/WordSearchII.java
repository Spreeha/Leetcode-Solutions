class WordSearchII {

    public boolean search(char[][]board,int r,int c,String word,int level)
    {

        int row=board.length; //number of rows
        int col=board[0].length; //number of columns

        if(level==word.length())
            return true;

        if(r<0 || r>=row || c<0 || c>=col)
            return false;
        if(board[r][c]==word.charAt(level))
        {
            //replacing the character with a * so that its not
            //reused again in the formation of the word
            char tmp=board[r][c];
            board[r][c]='*';

            //checking recursively in all 4 directions if the word can be formed
            boolean res=search(board,r+1,c,word,level+1)||
                        search(board,r-1,c,word,level+1)||
                        search(board,r,c-1,word,level+1)||
                        search(board,r,c+1,word,level+1);

            //the original character is replaced back after the
            //entire iteration of that particular grid index
            board[r][c]=tmp;

            return res;
        }
        else
        {
            return false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        int i,j,k;
        int row=board.length;
        int col=board[0].length;
        ArrayList<String> a=new ArrayList<>();
        //every index of the grid is checked whether a word can be formed starting from it
        for(k=words.length-1;k>=0;k--)
        {
            for(i=0;i<row;i++)
            {
                for(j=0;j<col;j++)
                {
                    if(board[i][j]==words[k].charAt(0))
                    {
                        if(search(board,i,j,words[k],0)==true)
                        {
                            if(a.contains(words[k])==false)
                            a.add(words[k]);
                        }
                    }
                }
            }
        }
        return a;
    }
}
