#include<stdio.h>
#include<malloc.h>
#include<limits.h>

void floyd_warshall(int weights[][100],int v){
	for(int k=0;k<v;k++){
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				if(weights[i][k]+weights[k][j]<weights[i][j] && weights[i][k]+weights[k][j]>0){
					weights[i][j]=weights[i][k]+weights[k][j];
				}
			}
		}
	}
}

int main(){

	int v,i,j,weights[100][100];

	printf("Enter the no. of vertices:\n");
	scanf("%d",&v);

	for(i=0;i<v;i++){
		for(j=0;j<v;j++){
			printf("Enter the weight of between %d-%d vertices (-1 if not connecting):",i+1,j+1);
			scanf("%d",&weights[i][j]);
			if(weights[i][j]==-1){
				weights[i][j]=INT_MAX;
			}
		}
	}
	floyd_warshall(weights,v);

	printf("\nResultant matrix:\n");

	for(int i=0;i<v;i++){
		for(int j=0;j<v;j++){
			if(weights[i][j]==INT_MAX){
				printf("INF\t");
			}
			else{
				printf("%d\t",weights[i][j]);
			}
		}
		printf("\n");
	}
	return 0;

}