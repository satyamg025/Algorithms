#include<stdio.h>
#include<malloc.h>

int ls_nr(int arr[],int k,int n){

int i,ind=-1;
for(i=0;i<n;i++){
if(arr[i]==k){
ind=i;
break;
}
}

return ind;
}

int ls_r(int arr[],int k,int i,int n){
if(arr[i]==k)
	return i;
else{
	if(i==n-1){
	
		return -1;
	}
	else
		return ls_r(arr,k,i+1,n);
}
}

int main(){

int n,i,k,ind,*arr=(int *)malloc(51200*sizeof(int));
printf("Enter the number of elements:\n");
scanf("%d",&n);

printf("Enter %d elements:\n",n);
for(i=0;i<n;i++){
	scanf("%d",&arr[i]);
}
printf("Enter the element to be searched:\n");

scanf("%d",&k);

printf("Index of element to be searched (non recursive)=%d\n",ls_nr(arr,k,n));
printf("Index of element to be searched (recursive)=%d\n",ls_r(arr,k,0,n));

return 0;

}
