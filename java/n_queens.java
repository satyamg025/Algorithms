import java.util.*;

class n_queens{

	public static int is_safe(int board[][],int row,int col,int n){
		int i,j;
		for(i=0;i<col;i++){
			if(board[row][i]==1)
				return 0;
		}

		for(i=row,j=col;i>=0 && j>=0;i--,j--){
			if(board[i][j]==1)
				return 0;
		}

		for(i=row,j=col;i<n && j>=0;i++,j--){
			if(board[i][j]==1)
				return 0;
		}
		return 1;
	} 

	public static int solve_board(int board[][],int col,int n){
		if(col>=n){
			return 1;
		}

		for(int i=0;i<n;i++){
			if(is_safe(board,i,col,n)==1){
				board[i][col]=1;

				if(solve_board(board,col+1,n)==1){
					return 1;
				}

				board[i][col]=0;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		int board[][]=new int[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board[i][j]=0;
			}
		}
		if(solve_board(board,0,n)==0){
			System.out.println("Solution doesn't exist");
		}
		else{
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(""+board[i][j]+"\t");
				}
				System.out.print("\n");
			}	
		}
	}
}