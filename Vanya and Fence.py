k=lambda:map(int,input().split()) 
_,h=k()
print(sum([1,2][x>h] for x in k()))
