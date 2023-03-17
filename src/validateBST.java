public class validateBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return checkBST(root, min, max );
    }

    public boolean checkBST(TreeNode root, int min, int max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
             this.right = right;
          }
    }
}
