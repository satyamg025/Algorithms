#include<stdio.h>
#include<malloc.h>
#include<math.h>

int hsize;

void maxheapify(int arr[],int i){
int l=2*i;
int r=2*i+1;
int largest,t;


if(l<=hsize && arr[l]>arr[i]){
largest=l;
}
else{
largest=i;
}

if(r<=hsize && arr[r]>arr[largest]){
largest=r;
}

if(largest!=i){

t=arr[i];
arr[i]=arr[largest];
arr[largest]=t;


maxheapify(arr,largest);
}
}

void buildmaxheap(int arr[],int n){

hsize=n;
for(int i=floor(n/2);i>=0;i--){

maxheapify(arr,i);
}

}
void heap(int arr[],int n){

buildmaxheap(arr,n);
int i,t;

for(i=n;i>0;i--){

t=arr[i];
arr[i]=arr[0];
arr[0]=t;

hsize-=1;
maxheapify(arr,0);
}
}
int main(){
int i,n,*arr=(int *)malloc(51200*sizeof(int));

printf("Enter the number of elements:\n");
scanf("%d",&n);

printf("Enter %d elements:\n",n);

for(i=0;i<n;i++)
scanf("%d",&arr[i]);

heap(arr,n-1);

printf("Elements after heap sort:\n");

for(i=0;i<n;i++)
{
printf("%d ",arr[i]);
}


return 0;
}


