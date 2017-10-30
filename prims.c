#include<stdio.h>
#include<limits.h>


void print(int parent[],int v,int weights[][100]){

	for(int i=1;i<v;i++){
		printf("%d-%d\tWeight: %d\n",parent[i],i,weights[i][parent[i]]);
	}
}

int min(int key[],int processed[],int v){
	int mi_val=INT_MAX,mi_index=-1;
	for(int i=0;i<v;i++){
		if(key[i]<mi_val && processed[i]==0){
			mi_val=key[i];
			mi_index=i;
		}
	}
	return mi_index;
}

void prim_mst(int weights[][100],int v){
	int parent[100];
	int key[100];
	int processed[100];

	for(int i=0;i<v;i++){
		key[i]=INT_MAX;
		processed[i]=0;
	}

	key[0]=0;
	parent[0]=-1;
	for(int i=0;i<v-1;i++){
		int u=min(key,processed,v);

		processed[u]=1;
		for(int j=0;j<v;j++){
			if(weights[u][j]!=0 && processed[j]==0 && weights[u][j]<key[j]){
				parent[j]=u;
				key[j]=weights[u][j];
			}
		}
	}

	print(parent,v,weights);
}

int main(){

	int v,i,j,weights[100][100];

	printf("Enter the no. of vertices:\n");
	scanf("%d",&v);

	for(i=0;i<v;i++){
		for(j=0;j<v;j++){
			printf("Enter the weight of between %d-%d vertices :",i+1,j+1);
			scanf("%d",&weights[i][j]);
			if(weights[i][j]==-1){
				weights[i][j]=INT_MAX;
			}
		}
	}
	prim_mst(weights,v);
	return 0;
}