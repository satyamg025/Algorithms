import java.util.*;

class warshall_algo{

	public static void floyd_warshall(int weights[][],int v){
		for(int k=0;k<v;k++){
			for(int i=0;i<v;i++){
				for(int j=0;j<v;j++){
					if(weights[i][k]+weights[k][j]<weights[i][j] && weights[i][k]+weights[k][j]>0){
						weights[i][j]=weights[i][k]+weights[k][j];
					}
				}
			}
		}
	}

	public static void main(String args[]){

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of vertices:");
		int v=sc.nextInt();

		int weights[][]=new int[v][v];

		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				System.out.println("Enter the weight of between "+(i+1)+"-"+(j+1)+" vertices (-1 if not connecting):");
				weights[i][j]=sc.nextInt();
				if(weights[i][j]==-1){
					weights[i][j]=Integer.MAX_VALUE;
				}
			}
		}

		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				if(weights[i][j]==-1 || weights[i][j]==Integer.MAX_VALUE){
					System.out.print("INF\t");
				}
				else{
					System.out.print(""+weights[i][j]+"\t");
				}
			}
			System.out.println("");
		}
		floyd_warshall(weights,v);
		System.out.println("\nResultant matrix:\n");

		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				if(weights[i][j]==Integer.MAX_VALUE){
					System.out.print("INF\t");
				}
				else{
					System.out.print(""+weights[i][j]+"\t");
				}
			}
			System.out.println("");
		}
	}
}