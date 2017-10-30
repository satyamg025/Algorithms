print("Enter the value of n:")
n=int(input())
arr=[]
print("Enter "+str(n)+" elements:")
for i in range(n):
	arr.append(int(input()))


if(n%2==0):
	if(arr[0]>arr[1]):
		maxi=arr[0]
		mini=arr[1]
	
	else:
		maxi=arr[1]
		mini=arr[0]
	
	i=2

else:
	maxi=arr[0]
	mini=arr[0]
	i=1

while(i<n):
	if(arr[i]>arr[i+1]):
		if(arr[i]>maxi):
			maxi=arr[i]
		
		if(arr[i+1]<mini):
			mini=arr[i+1]
		
	
	else:
		if(arr[i+1]>maxi):
			maxi=arr[i+1]
		
		if(arr[i]<mini):
			mini=arr[i]
		
	
	i+=2

print("Max="+str(maxi)+"\nMin="+str(mini))