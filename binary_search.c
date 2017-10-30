#include<stdio.h>
#include<malloc.h>
#include<time.h>

int bs(int arr[],int k,int i,int mi,int n){

if(arr[mi]==k){
	return mi;
}
else{
	if(k<arr[mi])
		return bs(arr,k,i,(i+mi)/2,mi);
	else
		return bs(arr,k,mi,(n+mi)/2,n);
}
}
int main(){

int n,i,k,ind,*arr=(int *)malloc(51200*sizeof(int));
double time;
clock_t t1,t2;

printf("Enter the number of elements:\n");
scanf("%d",&n);

printf("Enter %d elements:\n",n);
for(i=0;i<n;i++){
	scanf("%d",&arr[i]);
}
printf("Enter the element to be searchedt:\n");

scanf("%d",&k);
t1=clock();
ind=bs(arr,k,0,(0+n)/2,n);
printf("Index of element to be searched (binary search)=%d\n",ind);
t2=clock();
printf("Time=%lf",(double)(t2-t1));
return 0;
}
