import sys, bisect
input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))
cards.sort()

M = int(input())

for i in list(map(int,input().split())):
  cnt = bisect.bisect_right(cards, i) - bisect.bisect_left(cards, i)
  print(cnt, end=' ')