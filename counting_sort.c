#include<stdio.h>
#include<malloc.h>

void counting_sort(int arr[],int n,int k){
	int i,j;
	int *c=(int *)malloc(51200*sizeof(int)),*b=(int *)malloc(51200*sizeof(int));

	for(i=0;i<=k;i++){
		c[i]=0;
	}
	for(j=0;j<n;j++){
		c[arr[j]]+=1;
	}
	for(i=1;i<=k;i++){
		c[i]+=c[i-1];
	}
	for(j=0;j<n;j++){
		b[c[arr[j]]-1]=arr[j];
		c[arr[j]]-=1;
	}
	printf("Elements after counting sort:\n");
	for(i=0;i<n;i++){
		printf("%d\t",b[i]);
	}
}


int main(){

	int n,*arr=(int *)malloc(51200*sizeof(int)),i,max=0;
	
	printf("Enter the number of elements:\n");
	scanf("%d",&n);
	
	printf("Enter %d elements:\n",n);
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
		if(max<arr[i]){
			max=arr[i];
		}
	}

	counting_sort(arr,n,max);

	return 0;
}