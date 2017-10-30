import java.util.*;

class counting_sort{

	public static void cs(int arr[],int n,int k){
		int c[]=new int[k+1];
		int b[]=new int[n];
		for(int i=0;i<=k;i++){
			c[i]=0;
		}

		for(int j=0;j<n;j++){
			c[arr[j]]=c[arr[j]]+1;
		}
		for(int i=1;i<=k;i++){
			c[i]=c[i]+c[i-1];
		}
		for(int j=0;j<n;j++){
			b[c[arr[j]]-1]=arr[j];
			c[arr[j]]=c[arr[j]]-1;
		}

		System.out.println("Elements after counting sort:");
		for(int i=0;i<n;i++){
			System.out.print(b[i]+"\t");
		}
	}

	public static void main(String args[]){
		int n,max=0;
		int arr[]=new int[100];

		System.out.println("Enter the value  of n:");
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();
		System.out.println("Enter "+n+" elements:");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
			if(max<=arr[i]){
				max=arr[i];
			}
		}
		
		cs(arr,n,max);
		
	}
}