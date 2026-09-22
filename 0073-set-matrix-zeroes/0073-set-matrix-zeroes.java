class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ;
        }
        int r=matrix.length;
        int c=matrix[0].length;

        boolean firstrowzero=false;
        boolean firstcolzero=false;

        for(int i=0;i<c;i++){
            if(matrix[0][i] == 0){
                firstrowzero = true;
                break;
            }
        }

        
        for(int i=0;i<r;i++){
            if(matrix[i][0] == 0){
                firstcolzero = true;
                break;
            }
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){

                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstrowzero){
            for(int j=0;j<c;j++){
                matrix[0][j]=0;
            }
        }

          if(firstcolzero){
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }
    }
}