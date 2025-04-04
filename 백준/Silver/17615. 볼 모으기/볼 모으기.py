N = int(input())
S = input()

start = end = -1
start_cnt = end_cnt = 0

if S[0] == "R":
  start = S.find("B")
else:
  start = S.find("R")

if S[-1] == "R":
  end = S.rfind("B")
else:
  end = S.rfind("R")

# R 또는 B 중 한 종류만 주어지는 경우
if start == -1:
  print(0)
  exit()

start_cnt_B = S[start:].count("B")
start_cnt_R = S[start:].count("R")
end_cnt_B = S[:end+1].count("B")
end_cnt_R = S[:end+1].count("R")

print(min(start_cnt_B, start_cnt_R, end_cnt_B, end_cnt_R))