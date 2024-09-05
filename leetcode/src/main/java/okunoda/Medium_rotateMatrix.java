package okunoda;

/**
 * @author Erywim 2024/9/4
 */
public class Medium_rotateMatrix {
    public static void main(String[] args) {
        Medium_rotateMatrix mediumRotateMatrix = new Medium_rotateMatrix();
        //[[1,2,3],[4,5,6],[7,8,9]]
        int[][] param = {{1,2,3},{4,5,6},{7,8,9}};
        mediumRotateMatrix.rotate(param);
    }
    private int n;
    public void rotate(int[][] matrix) {
        n = matrix.length;
        for (int i = 0; i < matrix.length/2; i++) {
            for (int i1 = 0; i1 < (matrix[i].length + 1) / 2; i1++) {
                cpAndrmNum(matrix,i,i1,i,i1,matrix[i][i1]);
            }
        }
    }
    private void cpAndrmNum(int[][] matrix, int x, int y,int orgX,int orgY,int temp) {
        int tarX = y;
        int tarY = n - 1 - x;

            int t = matrix[tarX][tarY];
            matrix[tarX][tarY] = temp;
        if(tarX == orgX && tarY == orgY){
            return ;
        }else{
            cpAndrmNum(matrix,tarX,tarY,orgX,orgY,t);
        }
    }
}
