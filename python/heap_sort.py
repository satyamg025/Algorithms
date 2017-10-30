hsize=0
def maxheapify(arr,i):
	l=2*i
	r=2*i+1
	if l<=hsize and arr[l]>arr[i]:
		largest=l
	else:
		largest=i
	
	if r<=hsize and arr[r]>arr[largest]:
		largest=r

	if largest!=i:
		(arr[i],arr[largest])=(arr[largest],arr[i])
		maxheapify(arr,largest)

def build_max(arr,n):
	global hsize
	hsize=n
	for i in range(n//2,-1,-1):
		maxheapify(arr,i)

def heapsort(arr,n):
	global hsize
	build_max(arr,n)
	for i in range(n,0,-1):
		(arr[i],arr[1])=(arr[1],arr[i])
		maxheapify(arr,1)
		hsize-=1

n=int(input())
arr=[]
for i in range(n):
	arr.append(int(input())
heapsort(arr,n-1)
print(arr)
