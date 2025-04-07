s=input()
N=1
idx=0
while idx<len(s):
  for n in str(N):
    if idx<len(s) and s[idx]==n:
      idx+=1
  N+=1
print(N-1)