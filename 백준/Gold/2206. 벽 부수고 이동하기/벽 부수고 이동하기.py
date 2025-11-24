from collections import deque

def solve():
  n,m = map(int, input().split())
  graph = [list(map(int,input())) for _ in range(n)]

  visited = [[[False] * 2 for _ in range(m)] for _ in range(n)]

  q = deque()
  q.append((0,0,1,0))
  visited[0][0][0] = True

  dx = [0,0,1,-1]
  dy = [1,-1,0,0]

  while q:
    x,y,dist,broken = q.popleft()

    if x == n-1 and y == m-1:
      print(dist)
      return

    for i in range(4):
      nx = dx[i] + x
      ny = dy[i] + y

      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue

      if graph[nx][ny] == 0 and not visited[nx][ny][broken]:
        visited[nx][ny][broken] = True
        q.append((nx,ny,dist+1,broken))

      if graph[nx][ny] == 1 and broken == 0 and not visited[nx][ny][1]:
        visited[nx][ny][1] = True
        q.append((nx,ny,dist+1,1))

  print(-1)

solve()