Q = [int(x) for x in input().split()]
N = Q[0]
M = Q[1]

B = []
for i in range(N):
	B.append(list(input()))
C = [[0 for _ in range(M)] for i in range(N)]
for i in range(N):
	for j in range(M):
		if B[i][j]!='.' and B[i][j]!='*':
			C[i][j]+=int(B[i][j])
		elif B[i][j]=='*':
			for i1 in range(max(0,i-1),min(i+2,N)):
				for j1 in range(max(0,j-1),min(j+2,M)):
					C[i1][j1]-=1
ok=1
for i in range(N):
	for j in range(M):
		if B[i][j]!='*' and C[i][j]!=0: 
			ok=0
			break
if(ok==1):
	print("YES")
else:
	print("NO")
