#include<stdio.h>

int max(int a,int b){
	if(a>b)
		return a;
	else
		return b;
}

int knap(int w,int weight[],int values[],int n){

	if(n==0 || w==0)
		return 0;
	
	if(weight[n-1]>w)
		return knap(w,weight,values,n-1);
	else{
		return max( values[n-1] + knap(w-weight[n-1], weight, values, n-1),knap(w, weight, values, n-1));
	}
}


int main(){

	int n,values[100],weight[100],w;
	printf("Enter the value of n:\n");
	scanf("%d",&n);
	
	printf("Enter %d values:",n);
	
	for(int i=0;i<n;i++){
		scanf("%d",&values[i]);
	}

	printf("Enter %d weights:",n);
	
	for(int i=0;i<n;i++){
		scanf("%d",&weight[i]);
	}
	printf("Enter the value of W:");
	scanf("%d",&w);

	printf("%d\n",knap(w,weight,values,n));
	return 0;
}