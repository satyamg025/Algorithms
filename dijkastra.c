#include<stdio.h>
#include<limits.h>


void print(int v,int key_val[]){

	printf("Vertex\tDistance\n");
	for(int i=1;i<v;i++){
		printf("%d\t%d\n",i,key_val[i]);
	}
}

int min(int key_val[],int processed[],int v){
	int mi_val=INT_MAX,mi_index=-1;
	for(int i=0;i<v;i++){
		if(key_val[i]<=mi_val && processed[i]==0){
			mi_val=key_val[i];
			mi_index=i;
		}
	}
	return mi_index;
}

void prim_mst(int weights[][100],int v,int o){
	int key_val[100];
	int processed[100];

	for(int i=0;i<v;i++){
		key_val[i]=INT_MAX;
		processed[i]=0;
	}

	key_val[o]=0;
	for(int i=0;i<v-1;i++){
		int u=min(key_val,processed,v);

		processed[u]=1;
		for(int j=0;j<v;j++){
			if(weights[u][j]!=0 && processed[j]==0 && weights[u][j]+key_val[u]<key_val[j]){
					key_val[j]= weights[u][j]+key_val[u];
			}
		}
	}

	print(v,key_val);
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
	prim_mst(weights,v,0);
	return 0;
}