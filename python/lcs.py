def lcs_length(x,n,y,m,b,c):

	for i in range(1,n+1):
	       c[i][0]=0
	       
	for j in range(m+1):
	       c[0][j]=0
	       
	for i in range(1,n+1):
		for j in range(1,m+1):
			if(x[i]==y[j]):
				c[i][j]=c[i-1][j-1]+1
				b[i][j]=0
			
			elif(c[i-1][j]>=c[i][j-1]):
				c[i][j]=c[i-1][j]
				b[i][j]=1
			
			else:
				c[i][j]=c[i][j-1]
				b[i][j]=2
			
		
	
def print_lcs(b,x,i,j):
	if(i==0 or j==0):
			return
	if(b[i][j]==0):
		print_lcs(b,x,i-1,j-1)
		print(""+x[i],end="")
	
	elif(b[i][j]==1):
		print_lcs(b,x,i-1,j)
	
	else:
		print_lcs(b,x,i,j-1)
	

print("Enter the length of 2 strings")
n=int(input())
m=int(input())

print("Enter 2 strings:")
print("Enter characters of first string (each char followed by enter):")
x=[]
x.append("0")
for i in range(1,n+1):
	x.append(input())

print("Enter characters of second string (each char followed by enter):")

y=[]
y.append("0")
for i in range(1,m+1):
	y.append(input())

b=[]
c=[]
for i in range(n+1):
	w=[]
	e=[]
	for j in range(m+1):
		w.append(0)
		e.append(0)
	b.append(w)
	c.append(e)

lcs_length(x,n,y,m,b,c)

print("\n\n")
for i in range(n+1):
	for j in range(m+1):
		print(""+str(c[i][j])+"\t",end="")
	print("")
print("\n\n")
for i in range(n+1):
	for j in range(m+1):
		if(b[i][j]==0):
			print("NW\t",end="")
		elif(b[i][j]==1):
			print("N\t",end="")
		else:
			print("W\t",end="")
	print("")


print_lcs(b,x,n,m)
