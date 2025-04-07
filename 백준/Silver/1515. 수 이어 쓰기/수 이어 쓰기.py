s=input()
N=1
i=0
while i<len(s):
  for n in str(N):
    if i<len(s) and s[i]==n:
      i+=1
  N+=1
print(N-1)