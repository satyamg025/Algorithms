def is_safe(board,row,col,n):
	
	for i in range(col):
		if(board[row][i]==1):
			return 0
	
	i=row
	j=col

	while i>=0 and j>=0:
		if(board[i][j]==1):
			return 0
		i-=1
		j-=1

	i=row
	j=col
	while i<n and j>=0:
		if(board[i][j]==1):
			return 0
		i+=1
		j-=1
	return 1


def solve_board(board,col,n):
	if(col>=n):
		return 1
	

	for i in range(n):
		if(is_safe(board,i,col,n)==1):
			board[i][col]=1

			if(solve_board(board,col+1,n)==1):
				return 1
			

			board[i][col]=0
		
	
	return 0


print("Enter the value of n:")
n=int(input())
board=[]
for i in range(n):
	b=[]
	for j in range(n):
		b.append(0)
	board.append(b)


if(solve_board(board,0,n)==0):
	print("Solution doesn't exist")

else:
	for i in range(n):
		for j in range(n):
			print(""+str(board[i][j])+"\t",end="")
		
		print("")
	
