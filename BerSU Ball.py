i=lambda:iter(sorted(map(int,input().split())))
i();a=i();i();b=i();v=0;x,y=next(a),next(b)
try:
 while 1:
  if abs(x-y)<2:v+=1;x=next(a);y=next(b)
  elif x<y:x=next(a)
  else:y=next(b)
except:
 print(v)