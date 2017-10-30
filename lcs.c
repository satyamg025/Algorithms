#include<stdio.h>
#include<malloc.h>

int c[100][100];
int b[100][100];

void lcs_length(char x[],int n,char y[],int m){
	int i,j;
	for(i=0;i<n;i++)
	       c[i][0]=0;
	       
	for(j=0;j<m;j++)
	       c[0][j]=0;
	       
	for(i=0;i<n;i++){
		for(j=0;j<m;j++){
			if(x[i]==y[j]){
				c[i][j]=c[i-1][j-1]+1;
				b[i][j]=0;
			}
			else if(c[i-1][j]>=c[i][j-1]){
				c[i][j]=c[i-1][j];
				b[i][j]=1;
			}
			else{
				c[i][j]=c[i][j-1];
				b[i][j]=2;
			}
		}
	}
}

void print_lsc(int b[][100],char x[],int i,int j){

	if(i==-1 || j==-1)
		return;
	if(b[i][j]==0){
		print_lsc(b,x,i-1,j-1);
		printf("%c",x[i]);
	}
	else if(b[i][j]==1){
		print_lsc(b,x,i-1,j);
	}
	else{
		print_lsc(b,x,i,j-1);
	}
}

int main(){

	int i,j,n,m;
	char *x=(char *)malloc(51200*sizeof(char)),*y=(char *)malloc(51200*sizeof(char));
	printf("Enter the size of 2 strings:\n");
	scanf("%d %d",&n,&m);
	printf("Enter 2 strings\n");
	scanf("%s %s",x,y);

	lcs_length(x,n,y,m);

	printf("\n\n");
	for(i=0;i<n;i++){
		for(j=0;j<m;j++){
			printf("%d \t",c[i][j]);
		}
		printf("\n");
	}
	printf("\n\n");
	for(i=0;i<n;i++){
		for(j=0;j<m;j++){
			if(b[i][j]==0)
				printf("NW\t");
			else if(b[i][j]==1)
				printf("N\t");
			else
				printf("W\t");
		}
		printf("\n");
	}
	print_lsc(b,x,n,m);

}

