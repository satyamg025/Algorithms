import sys

def mcs(p,n,m,s):
	for i in range(1,n):
		m[i][i]=0
		s[i][i]=1
	
	for l in range(2,n):
		for i in range(1,n-l+1):
			j=i+l-1

			m[i][j]=sys.maxsize
			for k in range(i,j):
				q=m[i][k]+m[k+1][j]+(p[i-1]*p[k]*p[j])
				if(q<m[i][j]):
					m[i][j]=q
					s[i][j]=k
				
			
def prin(s,i,j):
	if(i==j):
		print("A"+str(i),end="")
		
	else:
		print("(",end="")
		prin(s,i,s[i][j])
		prin(s,s[i][j]+1,j)
		print(")",end="")
				
	

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))

m=[]
s=[]
for i in range(n):
	q=[]
	p=[]
	for j in range(n):
		q.append(0)
		p.append(0)

	m.append(q)
	s.append(p)

mcs(li,n,m,s)
for i in range(1,n):
	for j in range(1,n):
		print(str(m[i][j])+"\t",end="")
	print("\n",end="")

print("\n\n")
for i in range(1,n):
	for j in range(1,n):
		print(str(s[i][j])+"\t",end="")
	print("\n",end="")
prin(s,1,n-1)