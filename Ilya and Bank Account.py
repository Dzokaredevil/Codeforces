n=input();
print(max(map(int,(n,n[:-1],n[:-2]+n[-1]))))