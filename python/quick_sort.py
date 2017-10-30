def partition(arr,p,r):
	i=p-1
	x=arr[r]
	for j in range(p,r):
		if arr[j]<=x:
			i+=1
			(arr[i],arr[j])=(arr[j],arr[i])
	(arr[i+1],arr[r])=(arr[r],arr[i+1])

	return i+1

def quick_sort(arr,p,r):
	if p<r:
		q=partition(arr,p,r)
		quick_sort(arr,p,q-1)
		quick_sort(arr,q+1,r)

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))
quick_sort(li,0,n-1)
print("Elements after quick sort:")
print(li)