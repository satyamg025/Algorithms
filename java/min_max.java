import java.util.*;

class min_max{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		int arr[]=new int[n];

		System.out.println("Enter "+n+" elements:");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int min,max,i;

		if(n%2==0){
			if(arr[0]>arr[1]){
				max=arr[0];
				min=arr[1];
			}
			else{
				max=arr[1];
				min=arr[0];
			}
			i=2;
		}
		else{
			max=arr[0];
			min=arr[0];
			i=1;
		}
		while(i<n){
			if(arr[i]>arr[i+1]){
				if(arr[i]>max){
					max=arr[i];
				}
				if(arr[i+1]<min){
					min=arr[i+1];
				}
			}
			else{
				if(arr[i+1]>max){
					max=arr[i+1];
				}
				if(arr[i]<min){
					min=arr[i];
				}
			}
			i+=2;
		}
		System.out.println("Max="+max+"\nMin="+min);
		
	}
}