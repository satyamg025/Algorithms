#include<stdio.h>
#include<malloc.h>
#include<limits.h>

void merge(int arr[],int p,int q,int r){
	
	int n1=q-p+1,n2=r-q;
	int *L=(int *)malloc(51200*sizeof(int)),*R=(int *)malloc(51200*sizeof(int)),i,j,k=0;

	for(i=0;i<n1;i++){
		L[i]=arr[p+i];
	}

	for(j=0;j<n2;j++){
		R[j]=arr[q+j+1];
	}

	i=0;
	j=0;

	for(k=p;k<r;k++){
		if(L[i]<=R[j]){
			arr[k]=L[i];
			i++;
		}
		else{
			arr[k]=R[j];
			j++;
		}
		k++;
	}

	while(i<n1){
		arr[k]=L[i];
		i++;
		k++;
	}

	while(j<n2){
		arr[k]=R[j];
		j++;
		k++;
	}
}

void merge_sort(int arr[],int p,int r){
	if(p<r){
		int q=(p+r-1)/2;
		merge_sort(arr,p,q);
		merge_sort(arr,q+1,r);
		merge(arr,p,q,r);
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

	merge_sort(arr,0,n);

	printf("Elements after merge sort:\n");
	for(i=0;i<n;i++){
		printf("%d\t",arr[i]);
	}

	return 0;
}