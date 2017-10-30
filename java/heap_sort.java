import java.util.*;

class heap_sort{
static int hsize;

public static void maxheapify(int arr[],int i){
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

public static void buildmaxheap(int arr[],int n){

hsize=n;
for(int i=(n/2);i>=0;i--){

maxheapify(arr,i);
}

}
public static void heap(int arr[],int n){

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
public static void main(String args[]){
int i,n;

System.out.println("Enter the number of elements:");
Scanner sc=new Scanner(System.in);
n=sc.nextInt();

int arr[]=new int[n];
System.out.println("Enter "+n+" elements:");

for(i=0;i<n;i++)
arr[i]=sc.nextInt();

heap(arr,n-1);

System.out.println("Elements after heap sort:");

for(i=0;i<n;i++)
{
System.out.println(arr[i]);
}

}

}
