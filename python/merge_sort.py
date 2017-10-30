def merge(arr,p,q,r):
	n1=q-p+1
	n2=r-q
	l1=arr[p:p+n1]
	l2=arr[q+1:q+n2+1]

	i=0
	j=0
	k=p
	while i<n1 and j<n2:
		if l1[i]<=l2[j]:
			arr[k]=l1[i]
			i+=1
		else:
			arr[k]=l2[j]
			j+=1
		k+=1
	
	while i<n1:
		arr[k]=l1[i]
		i+=1
		k+=1

	while j<n2:
		arr[k]=l2[j]
		j+=1
		k+=1

def merge_sort(arr,p,r):
	if p<r:
		q=(p+r)//2
		merge_sort(arr,p,q)
		merge_sort(arr,q+1,r)
		merge(arr,p,q,r)

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))
merge_sort(li,0,n-1)
print("Elements after merge sort:")
print(li)