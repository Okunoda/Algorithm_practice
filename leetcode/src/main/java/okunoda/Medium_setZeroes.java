package okunoda;

/**
 * @author Erywim 2024/9/2
 */
public class Medium_setZeroes {
    public void setZeroes(int[][] matrix) {
        //找出所有行和列存在零的并且做好标记
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rowZeros = new int[row];
        int[] colZeros = new int[col];

        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < col; i1++) {
                if(matrix[i][i1] == 0){
                    rowZeros[i] = 1;
                    colZeros[i1] = 1;
                }
            }
        }

        //将有标记的行和列值为零
        for (int i = 0; i < row; i++) {
            if(rowZeros[i] == 1){
                for (int j1 = 0; j1 < col; j1++) {
                    matrix[i][j1] = 0;
                }
            }
        }

        for (int i = 0; i < col; i++) {
            if(colZeros[i] == 1){
                for (int j1 = 0; j1 < row; j1++) {
                    matrix[j1][i] = 0;
                }
            }
        }
    }

}
