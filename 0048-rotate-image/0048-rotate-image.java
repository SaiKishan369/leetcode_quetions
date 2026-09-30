class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 )return ;

        int n=matrix.length-1;

        for(int i=0;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<=n;i++){
            int left = 0;
            int right =n;
            while(left <= right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }
}