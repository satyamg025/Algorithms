#include<stdio.h>

int is_safe(int board[][100],int row,int col,int n){
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

int solve_board(int board[][100],int col,int n){
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

int main()
{
	int n,board[100][100],i,j;

	printf("Enter the value of n:");
	scanf("%d",&n);
	
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			board[i][j]=0;
		}
	}

	if(solve_board(board,0,n)==0){
		printf("Solution doesn't exist");
	}
	else{
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				printf("%d\t",board[i][j]);
			}
			printf("\n");
		}	
	}
	return 0;
}