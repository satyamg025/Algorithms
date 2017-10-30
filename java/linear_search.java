import java.util.*;

class linear_search{

	public static int ls_nr(int arr[],int k,int n){

		int i,ind=-1;
		for(i=0;i<n;i++){
		if(arr[i]==k){
		ind=i;
		break;
		}
		}

		return ind;
	}

	public static int ls_r(int arr[],int k,int i,int n){
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
		
		System.out.println("\nIndex of element to be searched (non recursive)= "+ls_nr(arr,k,n));
		System.out.println("\nIndex of element to be searched (recursive)= "+ls_r(arr,k,0,n));	
	}
}