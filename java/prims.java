import java.util.*;

class prims{

	public static int min(int key[],int processed[],int v){
		int mi_val=Integer.MAX_VALUE,mi_index=-1;
		for(int i=0;i<v;i++){
			if(key[i]<mi_val && processed[i]==0){
				mi_val=key[i];
				mi_index=i;
			}
		}
		return mi_index;
	}

	public static void prim_mst(int weights[][],int v){
		int parent[]=new int[v];
		int key[]=new int[v];
		int processed[]=new int[v];

		for(int i=0;i<v;i++){
			key[i]=Integer.MAX_VALUE;
			processed[i]=0;
		}

		key[0]=0;
		parent[0]=-1;
		for(int i=0;i<v-1;i++){
			int u=min(key,processed,v);

			processed[u]=1;
			for(int j=0;j<v;j++){
				if(weights[u][j]!=0 && processed[j]==0 && weights[u][j]<key[j]){
					parent[j]=u;
					key[j]=weights[u][j];
				}
			}
		}

		print(parent,v,weights);
	}

	public static void print(int parent[],int v,int weights[][]){

		for(int i=1;i<v;i++){
			System.out.println(""+parent[i]+"-"+i+"\tWeight: "+weights[i][parent[i]]);
		}
	}

	public static void main(String args[]){

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of vertices:");
		int v=sc.nextInt();

		int weights[][]=new int[v][v];

		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				System.out.println("Enter the weight of between "+(i+1)+"-"+(j+1)+" vertices:");
				weights[i][j]=sc.nextInt();
			}
		}

		prim_mst(weights,v);
	}
}