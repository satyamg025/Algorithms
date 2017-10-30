import java.util.*;

class binary_search{

	public static int bs(int arr[],int k,int i,int mid,int n){
		
		if(arr[mid]==k){
			return mid;
		}
		else{
			if(k<arr[mid])
				return bs(arr,k,i,(i+mid)/2,mid);
			else
				return bs(arr,k,mid,(n+mid)/2,n);
		}
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the number of elements:\n");
		int n=sc.nextInt();
		System.out.println("Enter "+n+" elements:\n");
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter the element to be searchedt:\n");
		int k=sc.nextInt();
		int ind=bs(arr,k,0,(0+n)/2,n);

		System.out.println("\nIndex of element to be searched (binary search)= "+ind);
	}
}