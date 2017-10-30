import java.util.*;

class merge_sort{

	public static void merge(int arr[],int p,int q,int r){

		int n1=q-p+1,n2=r-q;
		int l[]=new int[n1];
		int rr[]=new int[n2];
		int i,j,k=0;
		
		for(i=0;i<n1;i++){
			l[i]=arr[p+i];
		}

		for(j=0;j<n2;j++){
			rr[j]=arr[q+j+1];
		}

		i=0;
		j=0;

		k=p;
		while(i<n1 && j<n2){
			if(l[i]<=rr[j]){
				arr[k]=l[i];
				i++;
			}
			else{
				arr[k]=rr[j];
				j++;
			}
			k++;
		}

		while(i<n1){
			arr[k]=l[i];
			i++;
			k++;
		}

		while(j<n2){
			arr[k]=rr[j];
			j++;
			k++;
		}
	}

	public static void ms(int arr[],int p,int r){
		if(p<r){
			int q=(p+r)/2;
			ms(arr,p,q);
			ms(arr,q+1,r);
			merge(arr,p,q,r);
		}
		
	}

	public static void main(String args[]){
		int n;
		
		System.out.println("Enter the value  of n:");
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt();
		int arr[]=new int[n];

		System.out.println("Enter "+n+" elements:");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		ms(arr,0,arr.length-1);
		System.out.println("Elements after merge sort:");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+"\t");
		}

	}
}