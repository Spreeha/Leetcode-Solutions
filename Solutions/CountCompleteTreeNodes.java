/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        //BFS solution
        /*Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root!=null)
        {
            q.add(root);
            int c=0;
            while(q.isEmpty()==false)
            {
                TreeNode t=q.peek();
                c++;
                q.remove();
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
            return c;
        }
        else
            return 0;*/

        //recursive solution
        if(root==null)
            return 0;
        else
            return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
