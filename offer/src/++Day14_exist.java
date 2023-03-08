/**
 * @author Okunoda
 * @date 2023年03月08日23:05
 */
 class Day14_exist {
    public boolean exist(char[][] board, String word) {
        chs = word.toCharArray();
        m = board.length;
        n = board[0].length;
        len = word.length();
        path = new boolean[m][n];
        return dfs(board,0,0,0);
    }
    int m = 0;
    int n = 0;
    int len=0;
    char[] chs;
    boolean[][] path;
    private boolean dfs(char[][] board , int step ,int ii , int jj){
        if(ii<0 || jj < 0||ii > m || jj > n || chs[step]!= board[ii][jj] ){
            return false;
        }else if(step == len -1 )
            return true;

        //过了11个点，感觉问题就是在不能从 i=ii 与 j=jj 开始，即不能把二重循环放在 dfs 中
        for(int i = ii ; i < m ;i++){
            for(int j = jj ; j < n ; j++){
                if(!path[i][j]){
                    if(dfs(board,step+1,i+1,j))
                        return true;
                    if(dfs(board,step+1,i,j+1))
                        return true;
                    if(dfs(board,step+1,i,j-1))
                        return true;
                    if(dfs(board,step+1,i-1,j))
                        return true;
                }
            }
        }
        return false;
    }



    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }
        boolean dfs(char[][] board, char[] word, int i, int j, int path) {
            if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[path]) return false;
            if(path == word.length - 1) return true;
            board[i][j] = '\0';
            boolean res =
                    dfs(board, word, i + 1, j, path + 1) ||
                    dfs(board, word, i - 1, j, path + 1) ||
                    dfs(board, word, i, j + 1, path + 1) ||
                    dfs(board, word, i , j - 1, path + 1);

            board[i][j] = word[path];
            return res;
        }
    }

    /*作者：jyd
    链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


}
