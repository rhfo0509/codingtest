def solution(food_times, k):
    answer = 0
    food_length = len(food_times)
    
    idx = 0
    cnt = 0
    while k > 0:
        # 인덱스를 1씩 증가시키다가 음식의 길이만큼 도달하면 다시 처음 음식으로 돌아간다.
        if idx == food_length:
            idx = idx % food_length
        # 음식을 다 먹었다면 다음 음식을 선택하되, 모든 음식이 다 먹었는지를 확인하는 cnt 변수도 같이 1 증가한다.
        if food_times[idx] == 0:
            idx += 1
            cnt += 1
            # 만약 모든 음식을 다 먹었다면 -1을 리턴, 아니면 continue
            if cnt == food_length:
                return -1
            else:
                continue
        # 해당 인덱스에 음식을 다 먹지 않은 상태면 음식의 양을 1 감소, 인덱스 1 증가, 시간(k) 1초 감소, cnt 변수 0으로 초기화
        food_times[idx] -= 1
        idx += 1
        k -= 1
        cnt = 0
    
    # k초 후에 지연 발생, 이 때도 음식을 다 먹은 상태인지 확인이 필요하다.
    while True:
        if food_times[idx % food_length] == 0:
            idx += 1
            cnt += 1
            # 만약 모든 음식을 다 먹었다면 -1을 리턴
            if cnt == food_length:
                return -1
        else:
            idx = idx % food_length
            break
            
    answer = idx + 1
    return answer