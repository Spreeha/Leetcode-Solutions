/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node DFS(Node prev,Node cur)
    {
        if(cur==null)
            return prev;
        prev.next=cur;
        cur.prev=prev;
        Node next=cur.next;

        //end will store the last node of the child LL after which the
        //next nodes of the parent LL are to be added
        Node end = DFS(cur,cur.child);
        cur.child=null;
        //DFS for the last node from the child LL and the next nodes from the parent LL
        return DFS(end,next);
    }
    public Node flatten(Node head) {
        if(head==null)
            return head;

        //a prev node pointing to the head node has to be created in case
        //the very first node of the LL has a child node
        Node prev=new Node(0,null,head,null);
        DFS(prev,head);

        //detaching the pseudo head node from both next and prev positions
        //otherwise it will result in "not a valid doubly linked list"
        prev.next=null;
        head.prev=null;

        return head;
    }
}
