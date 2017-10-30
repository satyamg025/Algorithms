import java.util.*;

class randomized_quick_sort{

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

	public static int rand_partition(int arr[],int p,int r){
		Random rand=new Random();
		int i=rand.nextInt(r)+p;

		int t=arr[i];
		arr[i]=arr[r];
		arr[r]=t;

		return partition(arr,p,r);
	}

	public static void rqs(int arr[],int p,int r){
		if(p<r){
			int q=rand_partition(arr,p,r);
			rqs(arr,p,q-1);
			rqs(arr,q+1,r);
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

		rqs(arr,0,n-1);
		System.out.println("Elements after randomized quick sort:");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+"\t");
		}
	}
}