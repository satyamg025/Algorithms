import java.util.*;

class knapsack{

	public static int max(int a,int b){
		if(a>b)
			return a;
		else
			return b;
	}

	public static int knap(int w,int weight[],int values[],int n){

		if(n==0 || w==0)
			return 0;
		
		if(weight[n-1]>w)
			return knap(w,weight,values,n-1);
		else{
			return max( values[n-1] + knap(w-weight[n-1], weight, values, n-1),knap(w, weight, values, n-1));
		}
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		
		int values[]=new int[n];
		int weight[]=new int[n];
		int w;
		
		System.out.println("Enter "+n+" values:");
		
		for(int i=0;i<n;i++){
			values[i]=sc.nextInt();
		}

		System.out.println("Enter "+n+" weights:");
		
		for(int i=0;i<n;i++){
			weight[i]=sc.nextInt();
		}
		System.out.println("Enter the value of W:");
		w=sc.nextInt();

		System.out.println(""+knap(w,weight,values,n));
	}
}