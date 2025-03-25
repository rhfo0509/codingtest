N=int(input())
M=int(input())
S=input()

P="IO"*N+"I"
i=0
cnt=0
while i<len(S):
  idx=S.find(P, i)
  if idx==-1:
    break
  cnt+=1
  i=idx+2
print(cnt)