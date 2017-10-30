import java.util.*;

class dijkastra{

	public static int min(int key_val[],int processed[],int v){
		int mi_val=Integer.MAX_VALUE,mi_index=-1;
		for(int i=0;i<v;i++){
			if(key_val[i]<=mi_val && processed[i]==0){
				mi_val=key_val[i];
				mi_index=i;
			}
		}
		return mi_index;
	}

	public static void mst(int weights[][],int v,int o){
		int key_val[]=new int[v];
		int processed[]=new int[v];

		for(int i=0;i<v;i++){
			key_val[i]=Integer.MAX_VALUE;
			processed[i]=0;
		}

		key_val[o]=0;
		for(int i=0;i<v-1;i++){
			int u=min(key_val,processed,v);

			processed[u]=1;
			for(int j=0;j<v;j++){
				if(weights[u][j]!=0 && processed[j]==0 && weights[u][j]+key_val[u]<key_val[j]){
					key_val[j]= weights[u][j]+key_val[u];
				}
			}
		}

		print(v,key_val);
	}

	public static void print(int v,int key_val[]){
		System.out.println("Vertex\tDistance");
		for(int i=1;i<v;i++){
			System.out.println(i+"\tWeight: "+key_val[i]);
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

		mst(weights,v,0);
	}
}