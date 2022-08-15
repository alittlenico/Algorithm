package com.lc.review.c4_array;

/**
 * @author liuyi
 * @version 1.0
 * @description: 旋转图像
 * @date 2022/8/15 10:37
 */
public class LC48 {
    //使用辅助数组
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] matrix_new = new int[len][len];
        for(int i = 0;i < len;i++){
            for(int j = 0;j < len;j++){
                matrix_new[j][len-i-1] = matrix[i][j];
            }
        }
        for(int i = 0;i < len;i++){
            for(int j = 0;j < len;j++){
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    //原地修改 实际是找规律
    public void rotate1 (int[][] matrix) {
        int len = matrix.length;
        //原地修改 不能修改所有点 考虑奇偶两种情况
        for(int i = 0;i < len / 2; ++i) {
            for (int j = 0;j < (matrix[i].length + 1) / 2; ++j ) {
                int temp = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
