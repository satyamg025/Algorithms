import java.util.*;

class insertion_sort{

	public static void insertion(int arr[],int n){

		int i,j,key;
		for(j=1;j<n;j++){
			key=arr[j];
			i=j-1;
			while(i>=0 && arr[i]>key){
				arr[i+1]=arr[i];
				i-=1;
			}
			arr[i+1]=key;
		}
		System.out.println("Elements after insertion sort:");
		for(i=0;i<n;i++){
			System.out.print(arr[i]+"\t");
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

		insertion(arr,n);
	}
}