#include<stdio.h>
#include<malloc.h>

void insertion_sort(int arr[],int n){
	int key,i;
	for(int j=1;j<n;j++){
		key=arr[j];
		i=j-1;
		while(i>=0 && arr[i]>key){
			arr[i+1]=arr[i];
			i-=1;
		}
		arr[i+1]=key;
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

	insertion_sort(arr,n);

	printf("Elements after insertion sort:\n");
	for(i=0;i<n;i++){
		printf("%d\t",arr[i]);
	}

	return 0;
}