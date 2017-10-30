#include<stdio.h>
#include<malloc.h>

int partition(int arr[],int p,int r){
	int i=p-1,t,x;
	x=arr[r];
	for(int j=p;j<r;j++){
		if(arr[j]<=x){
			i++;

			t=arr[i];
			arr[i]=arr[j];
			arr[j]=t;
		}
	}
	t=arr[i+1];
	arr[i+1]=arr[r];
	arr[r]=t;

	return i+1;
}

void quick_sort(int arr[],int p,int r){
	if(p<r){
		int q=partition(arr,p,r);
		quick_sort(arr,p,q-1);
		quick_sort(arr,q+1,r);
	}
}

int main(){

	int n,*arr=(int *)malloc(51200*sizeof(int)),i;
	
	printf("Enter the number of elements:\n");
	scanf("%d",&n);
	
	printf("Enter %d elements:\n",n);
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}

	quick_sort(arr,0,n-1);

	printf("Elements after quick sort:\n");
	for(i=0;i<n;i++){
		printf("%d\t",arr[i]);
	}

	return 0;
}