#include<stdio.h>
#include<malloc.h>
#include<limits.h>

void mcs(int p[],int n,int m[100][100],int s[100][100]){
int i,j,l,q,k;
for(i=1;i<n;i++){
m[i][i]=0;
s[i][i]=1;
}

for(l=2;l<n;l++){
for(i=1;i<n-l+1;i++){
j=i+l-1;

m[i][j]=INT_MAX;
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


void print(int s[100][100],int i,int j){
if(i==j)
printf("A%d",i);
else{
printf("(");
print(s,i,s[i][j]);
print(s,s[i][j]+1,j);
printf(")");
}
}

int main(){

int n,i,j,*p=(int *)malloc(51200*sizeof(int)),m[100][100],s[100][100];
int min=INT_MAX;
printf("Enter the number of elements:\n");
scanf("%d",&n);

printf("Enter %d elements:\n",n);
for(i=0;i<n;i++){
	scanf("%d",&p[i]);
}
mcs(p,n,m,s);

for(i=1;i<n;i++){
for(j=1;j<n;j++)
	printf("%d\t",m[i][j]);
printf("\n");
}

printf("\n\n");
for(i=1;i<n;i++){
for(j=1;j<n;j++)
	printf("%d\t",s[i][j]);
printf("\n");
}

print(s,1,n-1);
return 0;
}
