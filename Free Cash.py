from collections import *
import sys 
print(Counter(sys.stdin.readlines()).most_common(1)[0][1])
