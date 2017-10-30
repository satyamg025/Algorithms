import random

def partition(arr,p,r):
	i=p-1
	x=arr[r]
	for j in range(p,r):
		if arr[j]<=x:
			i+=1
			(arr[i],arr[j])=(arr[j],arr[i])
	(arr[i+1],arr[r])=(arr[r],arr[i+1])

	return i+1

def rand_partition(arr,p,r):
	i=random.randint(p,r)

	(arr[i],arr[r])=(arr[r],arr[i])
	return partition(arr,p,r)

def randomized_quick_sort(arr,p,r):
	if p<r:
		q=rand_partition(arr,p,r)
		randomized_quick_sort(arr,p,q-1)
		randomized_quick_sort(arr,q+1,r)

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))
randomized_quick_sort(li,0,n-1)
print("Elements after randomized quick sort:")
print(li)