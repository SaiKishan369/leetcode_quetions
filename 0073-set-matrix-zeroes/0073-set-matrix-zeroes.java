class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length == 0 || matrix[0].length == 0)return ;
        
        boolean firstr=false;
        boolean firstc=false;
        int row=matrix.length-1;
        int col=matrix[0].length-1;

        for(int i=0;i<=col;i++){
            if(matrix[0][i]==0){
                firstr=true;
                break;
            }
        }

        for(int i=0;i<=row;i++){
            if(matrix[i][0]==0){
                firstc=true;
                break;
            }
        }

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstr){
            for(int i=0;i<=col;i++){
                matrix[0][i]=0;
            }
        } 

        if(firstc){
            for(int i=0;i<=row;i++){
                matrix[i][0]=0;
            }
        }

        
    }
}