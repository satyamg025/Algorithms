#include<stdio.h>

int main()
{
	int n,arr[100],i,min,max;

	printf("Enter the value of n:");
	scanf("%d",&n);
	
	printf("Enter %d elements:",n);
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}

	if(n%2==0){
		if(arr[0]>arr[1]){
			max=arr[0];
			min=arr[1];
		}
		else{
			max=arr[1];
			min=arr[0];
		}
		i=2;
	}
	else{
		max=arr[0];
		min=arr[0];
		i=1;
	}
	while(i<n){
		if(arr[i]>arr[i+1]){
			if(arr[i]>max){
				max=arr[i];
			}
			if(arr[i+1]<min){
				min=arr[i+1];
			}
		}
		else{
			if(arr[i+1]>max){
				max=arr[i+1];
			}
			if(arr[i]<min){
				min=arr[i];
			}
		}
		i+=2;
	}
	printf("Max=%d\nMin=%d",max,min);
	return 0;
}