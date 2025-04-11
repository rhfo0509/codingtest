import sys
input=sys.stdin.readline
N=int(input())
stk=[]
for _ in range(N):
  cmd=input().rstrip()
  if cmd=='pop':
    print(stk.pop()) if stk else print(-1)
  elif cmd=='size':
    print(len(stk))
  elif cmd=='empty':
    print(1) if not stk else print(0)
  elif cmd=='top':
    print(stk[-1]) if stk else print(-1)
  else:
    _,data=cmd.split()
    stk.append(int(data))