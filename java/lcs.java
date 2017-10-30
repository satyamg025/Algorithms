import java.util.*;

class lcs{

	static int c[][]=new int[100][100];
	static int b[][]=new int[100][100];

	public static void lcs_length(char x[],int n,char y[],int m){
		int i,j;
		for(i=1;i<=n;i++)
		       c[i][0]=0;
		       
		for(j=0;j<=m;j++)
		       c[0][j]=0;
		       
		for(i=1;i<=n;i++){
			for(j=1;j<=m;j++){
				if(x[i]==y[j]){
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=0;
				}
				else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=1;
				}
				else{
					c[i][j]=c[i][j-1];
					b[i][j]=2;
				}
			}
		}
	}

	public static void print_lsc(int b[][],char x[],int i,int j){

		if(i==0 || j==0)
			return;
		if(b[i][j]==0){
			print_lsc(b,x,i-1,j-1);
			System.out.print(""+x[i]);
		}
		else if(b[i][j]==1){
			print_lsc(b,x,i-1,j);
		}
		else{
			print_lsc(b,x,i,j-1);
		}
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the length of 2 strings:");
		int n=sc.nextInt();
		int m=sc.nextInt();

		System.out.println("Enter characters of first string (each char followed by enter):");
		char x[]=new char[n+1];
		for (int i=1;i<=n;i++ ) {
			x[i]=sc.next().charAt(0);
		}
		System.out.println("Enter characters of second string (each char followed by enter):");
		
		char y[]=new char[m+1];
		for (int i=1;i<=m;i++ ) {
			y[i]=sc.next().charAt(0);
		}
		lcs_length(x,n,y,m);

		System.out.print("\n\n");
		for(int i=0;i<=n;i++){
			for(int j=0;j<=	m;j++){
				System.out.print(""+c[i][j]+"\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(b[i][j]==0)
					System.out.print("NW\t");
				else if(b[i][j]==1)
					System.out.print("N\t");
				else
					System.out.print("W\t");
			}
			System.out.print("\n");
		}

		print_lsc(b,x,n,m);
	}
}