import sys

def floyd_warshall(weights,v):
	for k in range(v):
		for i in range(v):
			for j in range(v):
				if(weights[i][k]+weights[k][j]<weights[i][j] and weights[i][k]+weights[k][j]>0):
					weights[i][j]=weights[i][k]+weights[k][j]
				



print("Enter the no. of vertices:\n")
v=int(input())

weights=[]
for i in range(v):
	w=[]
	for j in range(v):
		print("Enter the weight of between "+str(i+1)+"-"+str(j+1)+" vertices (-1 if not connecting):")
		w.append(int(input()))
		if(w[j]==-1):
			w[j]=sys.maxsize
	weights.append(w)

floyd_warshall(weights,v)

print("\nResultant matrix:\n")

for i in range(v):
	for j in range(v):
		if(weights[i][j]==sys.maxsize):
			print("INF\t",end="")
		
		else:
			print(str(weights[i][j])+"\t",end="")
		
	print("")
