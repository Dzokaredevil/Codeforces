s = '\n'.join([input() for i in range(int(input()))])
pos = s.find('OO')
if pos >= 0:
	print("YES\n"+s[:pos]+"++"+s[pos+2:])
else:
	print("NO\n")