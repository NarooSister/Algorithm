n = int(input())
hint = [list(map(str, input().split())) for _ in range(n)]

answer = 0

for a in range(1,10):
  for b in range(1,10):
    for c in range(1,10):
      
      if( a == b or b == c or c == a):
        continue

      cnt = 0
      for arr in hint:
        number = list(arr[0]) # [1, 2, 3], [3, 5, 6] ...
        strike = int(arr[1]) # [1], [1] ...
        ball = int(arr[2])   # [1], [0] ...
        
        ball_count = 0
        strike_count = 0
        
        # 스트라이크 계산
        if a == int(number[0]):
            strike_count += 1
        if b == int(number[1]):
            strike_count += 1
        if c == int(number[2]):
            strike_count += 1
        
        # 볼 계산
        if a == int(number[1]) or a == int(number[2]):
            ball_count += 1
        if b == int(number[0]) or b == int(number[2]):
            ball_count += 1
        if c == int(number[0]) or c == int(number[1]):
            ball_count += 1
        
        if strike_count == strike and ball_count == ball :
          cnt += 1 
        else:
          break
   
      
      if cnt == n:
        answer += 1
        
print(answer)