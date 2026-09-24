class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean firstrow=false;
        boolean firstcol=false;
        int r=matrix.length;
        int c=matrix[0].length;

        for(int i=0;i<c;i++){
            if(matrix[0][i] == 0){
                firstrow=true;
                break;
            }
        }

        for(int j=0;j<r;j++){
            if(matrix[j][0]==0){
                firstcol=true;
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

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstrow){
            for(int i=0;i<c;i++){
                matrix[0][i]=0;
            }
        }
        if(firstcol){
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }

    }
}