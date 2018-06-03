n = int(input())
i = 1

while n>=0:
    n-=i*(i+1)/2
    i+=1
 
print(i-2)
