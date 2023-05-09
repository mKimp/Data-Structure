import java.sql.PseudoColumnUsage;
import java.util.*;

class TreeNodePathWithGivenSequence {
    int val;
    TreeNodePathWithGivenSequence left;
    TreeNodePathWithGivenSequence right;

    TreeNodePathWithGivenSequence(int x) {
        val = x;
    }
};

class SolutionPathWithGivenSequence {
    public static boolean findPath(TreeNodePathWithGivenSequence root, int[] sequence) {
        // TODO: Write your code here

        return helper(root, sequence, 0);
    }

    public static boolean helper(TreeNodePathWithGivenSequence root, int[]sequence, int sequenceIndex){
        if(root == null) return false;

        if(root.val != sequence[sequenceIndex] || sequenceIndex >= sequence.length) {
            return false;
        }

        if(root.val == sequence[sequenceIndex] && root.left == null && root.right == null){
            return true;
        }

        return helper(root.left, sequence,sequenceIndex + 1) || helper(root.right, sequence, sequenceIndex + 1);

    }

    public static void main(String[] args) {
        TreeNodePathWithGivenSequence root = new TreeNodePathWithGivenSequence(1);
        root.left = new TreeNodePathWithGivenSequence(0);
        root.right = new TreeNodePathWithGivenSequence(1);
        root.left.left = new TreeNodePathWithGivenSequence(1);
        root.right.left = new TreeNodePathWithGivenSequence(6);
        root.right.right = new TreeNodePathWithGivenSequence(5);

        System.out.println("Tree has path sequence: " +
                SolutionPathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " +
                SolutionPathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
