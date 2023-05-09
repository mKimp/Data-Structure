import java.util.*;

class TreeNodeAllPath {
    int val;
    TreeNodeAllPath left;
    TreeNodeAllPath right;

    TreeNodeAllPath(int x) {
        val = x;
    }
};

class SolutionAllPath {
    public static List<List<Integer>> findPaths(TreeNodeAllPath root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        // TODO: Write your code here
        List<Integer>current = new ArrayList<>();
        helper(root, sum, current, allPaths);
        return allPaths;
    }

    public static void helper(TreeNodeAllPath root, int sum, List<Integer>current, List<List<Integer>> allPaths  ){
        if(root == null){
            return;
        }

        current.add(root.val);

        if(sum == root.val && root.left == null && root.right == null){
            allPaths.add(new ArrayList<Integer>(current));
        }

        helper(root.left, sum - root.val, current, allPaths);
        helper(root.right, sum - root.val, current, allPaths);

        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        TreeNodeAllPath root = new TreeNodeAllPath(12);
        root.left = new TreeNodeAllPath(7);
        root.right = new TreeNodeAllPath(1);
        root.left.left = new TreeNodeAllPath(4);
        root.right.left = new TreeNodeAllPath(10);
        root.right.right = new TreeNodeAllPath(5);
        int sum = 23;
        List<List<Integer>> result = SolutionAllPath.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
