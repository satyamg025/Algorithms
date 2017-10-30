import java.util.*;

class quick_sort{

	public static int partition(int arr[],int p,int r){
		int i=p-1;
		int x=arr[r];
		for(int j=p;j<r;j++){
			if(arr[j]<=x){
				i++;

				int t=arr[j];
				arr[j]=arr[i];
				arr[i]=t;
			}
		}
		int t=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=t;

		return i+1;
	}

	public static void qs(int arr[],int p,int r){
		if(p<r){
			int q=partition(arr,p,r);
			qs(arr,p,q-1);
			qs(arr,q+1,r);
		}
	}

	public static void main(String args[]){
		int n;
		int arr[]=new int[100];

		System.out.println("Enter the value  of n:");
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();
		System.out.println("Enter "+n+" elements:");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		qs(arr,0,n-1);
		System.out.println("Elements after quick sort:");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+"\t");
		}
	}
}