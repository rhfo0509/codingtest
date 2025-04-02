N=int(input())
T=list(map(int, input().split()))

T.sort(reverse=True)
result = max([t + i + 1 for i, t in enumerate(T)])
print(result + 1)