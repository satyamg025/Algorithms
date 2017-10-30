def ls_nr(arr,k,n):

	ind=-1
	for i in range(n):
		if(arr[i]==k):
			ind=i;
			break;

	return ind;


def ls_r(arr,k,i,n):
	if(arr[i]==k):
		return i;
	else:
		if(i==n-1):
			return -1;
		else:
			return ls_r(arr,k,i+1,n);
	

print("Enter the value of n:")
n=int(input())
li=[]

print("Enter "+str(n)+" elements:")
for i in range(n):
	li.append(int(input()))

print("Enter the element to be searched:")
k=int(input())
print("Index of element to be searched (non recursive)= "+str(ls_nr(li,k,n)))
print("Index of element to be searched (recursive)= "+str(ls_r(li,k,0,n)))