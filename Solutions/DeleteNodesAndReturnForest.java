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
    ArrayList<TreeNode> a=new ArrayList<>(); //list stores root node of every tree after deleting nodes

    public TreeNode delete(TreeNode node, HashSet<Integer> h)
    {
        if(node==null)
            return null;
        node.left=delete(node.left,h);
        node.right=delete(node.right,h);

        if(h.contains(node.val))
        {
            if(node.left!=null)
                a.add(node.left);
            if(node.right!=null)
                a.add(node.right);
            return null; //if it is a node to be deleted
        }
        return node; //if it is a node not to be deleted
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        HashSet<Integer> h=new HashSet<>();
        int i;

        for(i=0;i<to_delete.length;i++)
            h.add(to_delete[i]);
        root=delete(root,h);
        if(root!=null)
        {
            //if the root node itself wasn't a node to be deleted
            if(h.contains(root.val)==false)
                a.add(root);
        }
        return a; //returning the list containing root nodes of every tree
    }

}
