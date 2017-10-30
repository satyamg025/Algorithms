def insertion(arr,n):
	for j in range(1,n):
		key=arr[j]
		i=j-1
		while i>=0 and arr[i]>key:
			arr[i+1]=arr[i]
			i-=1
		arr[i+1]=key

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))
insertion(li,n)
print("Elements after insertion sort:")
print(li)