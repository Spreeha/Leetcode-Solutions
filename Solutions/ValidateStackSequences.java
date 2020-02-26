class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //pushing into anothyer stack s until an element to be popped from
        //popped[] array is encountered on top of stack. Elements are
        //continually popped until the current element to be popped is
        //equal to the top element of the stack
        Stack<Integer> s=new Stack<>();
        int c=0,i;

        for(i=0;i<pushed.length;i++)
        {
            s.push(pushed[i]);
            while(s.isEmpty()==false && popped[c]==s.peek())
            {
                s.pop();
                c++;
            }
        }

        if(c==pushed.length)
            return true;
        else
            return false;
    }
}
