import java.util.*;

class matrix_chain{

	public static void mcs(int p[],int n,int m[][],int s[][]){
		int i,j,l,q,k;
		for(i=1;i<n;i++){
			m[i][i]=0;
			s[i][i]=1;
		}
		for(l=2;l<n;l++){
			for(i=1;i<n-l+1;i++){
				j=i+l-1;

				m[i][j]=Integer.MAX_VALUE;
				for(k=i;k<=j-1;k++){
					q=m[i][k]+m[k+1][j]+(p[i-1]*p[k]*p[j]);
					if(q<m[i][j]){
						m[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}
	}


	public static void print(int s[][],int i,int j){

		if(i==j){
			System.out.print("A"+i);
		}
		else{
			System.out.print("(");
			print(s,i,s[i][j]);
			print(s,s[i][j]+1,j);
			System.out.print(")");
		}
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the number of elements:\n");
		
		int n=sc.nextInt();
		System.out.println("Enter "+n+" elements:\n");
		int p[]=new int[n];
		int m[][]=new int[n+1][n+1];
		int s[][]=new int[n+1][n+1];
		
		for(int i=0;i<n;i++){
			p[i]=sc.nextInt();
		}
		int i,j;
		
		mcs(p,n,m,s);

		for(i=1;i<n;i++){
			for(j=1;j<n;j++)
				System.out.print(""+m[i][j]+"\t");
			System.out.print("\n");
		}

		System.out.println("\n\n");
		for(i=1;i<n;i++){
			for(j=1;j<n;j++)
				System.out.print(""+s[i][j]+"\t");
			System.out.print("\n");
		}

		print(s,1,n-1);
	}

}