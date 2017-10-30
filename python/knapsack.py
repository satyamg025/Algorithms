def knap(w,weight,values,n):

	if(n==0 or w==0):
		return 0
	
	if(weight[n-1]>w):
		return knap(w,weight,values,n-1)
	else:
		return max( values[n-1] + knap(w-weight[n-1], weight, values, n-1),knap(w, weight, values, n-1))
	

print("Enter the value of n:")
n=int(input())

print("Enter "+str(n)+" values:")

values=[]
weight=[]
for i in range(n):
	values.append(int(input()))

print("Enter "+str(n)+" weights:")

for i in range(n):
	weight.append(int(input()))
print("Enter the value of W:")
w=int(input())

print(str(knap(w,weight,values,n)))