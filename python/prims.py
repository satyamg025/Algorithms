import sys

def prin(parent,v,weights):

	for i in range(1,v):
		print(str(parent[i])+"-"+str(i)+"\tWeight: "+str(weights[i][parent[i]]))
	

def mini(key,processed,v):
	mi_val=sys.maxsize
	mi_index=-1
	for i in range(v):
		if(key[i]<mi_val and processed[i]==0):
			mi_val=key[i]
			mi_index=i
		
	
	return mi_index


def prim_mst(weights,v):
	parent=[]
	key=[]
	processed=[]

	for i in range(v):
		key.append(sys.maxsize)
		processed.append(0)
		parent.append(-1)
	
	key[0]=0
	parent[0]=-1
	for i in range(v-1):
		u=mini(key,processed,v)

		processed[u]=1
		for j in range(v):
			if(weights[u][j]!=0 and processed[j]==0 and weights[u][j]<key[j]):
				parent[j]=u
				key[j]=weights[u][j]
			
		
	
	prin(parent,v,weights)


print("Enter the no. of vertices:\n")
v=int(input())

weights=[]
for i in range(v):
	w=[]
	for j in range(v):
		print("Enter the weight of between "+str(i+1)+"-"+str(j+1)+" vertices:")
		w.append(int(input()))
		if(w[j]==-1):
			w[j]=sys.maxsize
	weights.append(w)
prim_mst(weights,v)