import sys
input=sys.stdin.readline

M=int(input())
S=set()
A=[str(i) for i in range(1,21)]
for _ in range(M):
  cmd=input().split()

  if cmd[0]=='add':
    if cmd[1] not in S:
      S.add(cmd[1])

  elif cmd[0]=='check':
    print(1 if cmd[1] in S else 0)

  elif cmd[0]=='remove':
    if cmd[1] in S: 
      S.remove(cmd[1])

  elif cmd[0]=='toggle':
    S.remove(cmd[1]) if cmd[1] in S else S.add(cmd[1])

  elif cmd[0]=='all':
    S=set(A[:])
  
  else:
    S.clear()