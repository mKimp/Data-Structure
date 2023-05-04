public class WordSearch {

    public static void main(String[] args) {

        // Test Case 1
        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word1 = "ABCCED";
        System.out.println(exist(board1, word1)); // expected output: true

        // Test Case 2
        char[][] board2 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word2 = "SEE";
        System.out.println(exist(board2, word2)); // expected output: true

        // Test Case 3
        char[][] board3 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word3 = "ABCB";
        System.out.println(exist(board3, word3)); // expected output: false

        char[][] board4 = { { 'a', 'a' } };
        String word4 = "aaa";
        System.out.println(exist(board4, word4)); // expected output: false

        char[][] board5 = { { 'a' } };
        String word5 = "a";
        System.out.println(exist(board5, word5)); // expected output: true

        char[][] board6 = {
                { 'a', 'b', 'c', 'd', 'e' },
                { 'f', 'g', 'h', 'i', 'j' },
                { 'k', 'l', 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's', 't' },
                { 'u', 'v', 'w', 'x', 'y' },
                { 'z', 'a', 'b', 'c', 'd' }
        };
        String word6 = "abcde";
        System.out.println(exist(board6, word6)); // expected output: true

        char[][] board7 = {
                { 'a', 'b', 'c', 'd', 'e' },
                { 'f', 'g', 'h', 'i', 'j' },
                { 'k', 'l', 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's', 't' },
                { 'u', 'v', 'w', 'x', 'y' },
                { 'z', 'a', 'b', 'c', 'd' }
        };
        String word7 = "zabcd";
        System.out.println(exist(board7, word7)); // expected output: true


    }
    public static boolean exist(char[][] board, String word) {
        // TODO: Write your code here

        boolean[][]isVisited = new boolean[board.length][board[0].length];

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(dfs(board, isVisited, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, boolean[][]isVisited, int i, int j, int k, String word ){
        //termination case
        if(i < 0 || i >= board.length || j >= board[0].length || j < 0 || board[i][j] != word.charAt(k)){
            return false;
        }

        if(isVisited[i][j]) return false;

        if(k == word.length() - 1) return true;

        if(!isVisited[i][j]) {
            isVisited[i][j] = true;
            ++k;
            if(dfs(board, isVisited, i + 1, j, k, word)
                    || dfs(board, isVisited, i - 1, j, k, word)
                    || dfs(board, isVisited, i, j + 1, k, word)
                    || dfs(board, isVisited, i, j - 1, k, word)) {
                return true;
            }
            isVisited[i][j] = false;
            --k;
        }
        return false;

    }

}
