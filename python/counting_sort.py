def counting_sort(arr,n,k):
	b=[]
	c=[]
	for i in range(k+1):
		c.append(0)
	for j in range(n):
		c[arr[j]]+=1
		b.append(0)
		
	for i in range(1,k+1):
		c[i]+=c[i-1]
	for j in range(n):
		b[c[arr[j]]-1]=arr[j]
		c[arr[j]]-=1
	print("Elements after counting sort:")
	print(b)

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))
counting_sort(li,n,max(li))
