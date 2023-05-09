

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class SolutionHasPath {
    public static boolean hasPath(TreeNode root, int sum) {
        // TODO: Write your code here
        return helper(root, 0, sum);
    }

    public static boolean helper(TreeNode root, int sum, int target){
        if(root == null){
            return false;
        }
        sum += root.val;

        if(sum == target && root.left == null && root.right == null){

            return true;
        }
        return helper(root.left, sum, target) || helper(root.right, sum, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + SolutionHasPath.hasPath(root, 23));
        System.out.println("Tree has path: " + SolutionHasPath.hasPath(root, 16));
    }
}

