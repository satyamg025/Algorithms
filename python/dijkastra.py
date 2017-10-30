import sys

def prin(v,key_val):
	print("Vertex\tDistance")
	for i in range(1,v):
		print(str(i)+"\tWeight: "+str(key_val[i]))
	

def mini(key_val,processed,v):
	mi_val=sys.maxsize
	mi_index=-1
	for i in range(v):
		if(key_val[i]<=mi_val and processed[i]==0):
			mi_val=key_val[i]
			mi_index=i
		
	
	return mi_index


def mst(weights,v,o):
	key_val=[]
	processed=[]

	for i in range(v):
		key_val.append(sys.maxsize)
		processed.append(0)
		
	key_val[o]=0
	
	for i in range(v-1):
		u=mini(key_val,processed,v)

		processed[u]=1
		for j in range(v):
			if(weights[u][j]!=0 and processed[j]==0 and weights[u][j]+key_val[u]<key_val[j]):
				key_val[j]= weights[u][j]+key_val[u]
			
		
	
	prin(v,key_val)


print("Enter the no. of vertices:\n")
v=int(input())

weights=[]
for i in range(v):
	w=[]
	for j in range(v):
		print("Enter the weight of between "+str(i+1)+"-"+str(j+1)+" vertices :")
		w.append(int(input()))
		if(w[j]==-1):
			w[j]=sys.maxsize
	weights.append(w)
mst(weights,v,0)