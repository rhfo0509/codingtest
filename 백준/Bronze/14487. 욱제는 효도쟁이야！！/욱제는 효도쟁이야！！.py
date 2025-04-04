n=int(input())
li=list(map(int,input().split()))
li.sort()
print(sum(li)-li[-1])