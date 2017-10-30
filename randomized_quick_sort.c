#include<stdio.h>
#include<malloc.h>

int rand_partition(int arr[],int p,int r){
	int i=p+(rand()%(r-p+1));
	int t=arr[i];
	arr[i]=arr[r];
	arr[r]=t;

	return partition(arr,p,r);
}

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

void randomized_quick_sort(int arr[],int p,int r){
	if(p<r){
		int q=rand_partition(arr,p,r);
		randomized_quick_sort(arr,p,q-1);
		randomized_quick_sort(arr,q+1,r);
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

	randomized_quick_sort(arr,0,n-1);

	printf("Elements after randomized quick sort:\n");
	for(i=0;i<n;i++){
		printf("%d\t",arr[i]);
	}

	return 0;
}