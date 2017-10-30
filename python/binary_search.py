def bs(arr,k,i,mid,n):
	if(arr[mid]==k):
			return mid
	else:
		if(k<arr[mid]):
			return bs(arr,k,i,(i+mid)//2,mid)
		else:
			return bs(arr,k,mid,(n+mid)//2,n)
		

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))

print("Enter the element to be searched:")
k=int(input())
print("Index of element to be searched (non recursive)= "+str(bs(li,k,0,(0+n)//2,n)))