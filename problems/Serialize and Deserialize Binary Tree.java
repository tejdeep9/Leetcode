/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serHelper(root, sb);
        System.out.println(sb.toString());
        return sb.toString();  
    }
    
    private void serHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null ");
            return;
        } 
        
        sb.append(root.val);
        sb.append(" ");
        serHelper(root.left, sb);
        serHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
            String[] list = data.split(" ");
            System.out.println(list.length);
            return deSerHelper(list);
    }
    
    private TreeNode deSerHelper(String[] list) {
        if(index == list.length || list[index].compareTo("null") == 0) {
            index++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(list[index]));
        index++;
        node.left = deSerHelper(list);
        node.right = deSerHelper(list);
                                    
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));