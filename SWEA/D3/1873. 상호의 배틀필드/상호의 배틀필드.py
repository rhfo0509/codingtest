T=int(input())
d={
  '^':(-1,0),
  'v':(1,0),
  '<':(0,-1),
  '>':(0,1),
}
for C in range(1,T+1):
  H,W=map(int,input().split())
  data=[list(input()) for _ in range(H)]
  tank_x=None
  tank_y=None
  pos=None
  for i in range(H):
    for j in range(W):
      if data[i][j] in '^v<>':
        tank_x,tank_y=i,j
        pos=data[i][j]
  N=int(input())
  commands=list(input())

  for cmd in commands:
    if cmd=='U':
      pos='^'
      if tank_x-1>=0 and data[tank_x-1][tank_y]=='.':
        data[tank_x-1][tank_y]=pos
        data[tank_x][tank_y]='.'
        tank_x+=d[pos][0]
        tank_y+=d[pos][1]
      else:
        data[tank_x][tank_y]=pos
    elif cmd=='D':
      pos='v'
      if tank_x+1<H and data[tank_x+1][tank_y]=='.':
        data[tank_x+1][tank_y]=pos
        data[tank_x][tank_y]='.'
        tank_x+=d[pos][0]
        tank_y+=d[pos][1]
      else:
        data[tank_x][tank_y]=pos
    elif cmd=='L':
      pos='<'
      if tank_y-1>=0 and data[tank_x][tank_y-1]=='.':
        data[tank_x][tank_y-1]=pos
        data[tank_x][tank_y]='.'
        tank_x+=d[pos][0]
        tank_y+=d[pos][1]
      else:
        data[tank_x][tank_y]=pos
    elif cmd=='R':
      pos='>'
      if tank_y+1<W and data[tank_x][tank_y+1]=='.':
        data[tank_x][tank_y+1]=pos
        data[tank_x][tank_y]='.'
        tank_x+=d[pos][0]
        tank_y+=d[pos][1]
      else:
        data[tank_x][tank_y]=pos
    else:
      nx,ny=tank_x,tank_y
      while True:
        nx+=d[pos][0]
        ny+=d[pos][1]
        if nx<0 or nx>=H or ny<0 or ny>=W:
          break
        if data[nx][ny]=='*':
          data[nx][ny]='.'
          break
        if data[nx][ny]=='#':
          break
  
  print(f'#{C}',end=' ')
  for i in range(H):
    for j in range(W):
      print(data[i][j],end='')
    print()
