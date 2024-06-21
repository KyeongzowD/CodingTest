import java.util.*;
import java.io.*;

public class Main {
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력을 읽어들이는 부분
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 노드 수
    M = Integer.parseInt(st.nextToken()); // 간선 수

    Graph graph = new Graph(N); // 그래프 객체 생성

    // 간선 정보를 입력받아 그래프에 추가하는 부분
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()) - 1; // 입력을 0-based 인덱스로 변환
      int m = Integer.parseInt(st.nextToken()) - 1; // 입력을 0-based 인덱스로 변환
      graph.addEdge(n, m);
    }

    int ans = graph.getNodeNumber(); // 가장 작은 케빈 베이컨 수를 가진 노드 번호 계산

    bw.write(String.valueOf(ans + 1)); // 결과를 1-based 인덱스로 변환하여 출력
    bw.flush();
    bw.close();
    br.close();
  }

  static class Graph {
    int node;
    LinkedList<Integer>[] adj; // 인접 리스트
    int[] cnt; // 각 노드의 케빈 베이컨 수를 저장하는 배열

    Graph(int node) {
      this.node = node;
      adj = new LinkedList[node]; // 인접 리스트 초기화
      cnt = new int[node]; // 케빈 베이컨 수를 저장할 배열 초기화

      for (int i = 0; i < node; i++) {
        adj[i] = new LinkedList<Integer>();
      }
    }

    void addEdge(int n, int m) {
      adj[n].add(m); // 무방향 그래프이므로 양방향 간선을 추가
      adj[m].add(n);
    }

    void BFS(int num) {
      boolean visited[] = new boolean[node]; // 방문 여부를 저장할 배열
      int[] dist = new int[node]; // 각 노드까지의 거리를 저장할 배열
      Arrays.fill(dist, Integer.MAX_VALUE); // 거리 배열을 무한대로 초기화

      LinkedList<Integer> queue = new LinkedList<Integer>();

      visited[num] = true;
      dist[num] = 0; // 시작 노드의 거리를 0으로 설정
      queue.add(num);

      while (!queue.isEmpty()) {
        int current = queue.poll(); // 현재 노드를 큐에서 제거

        for (int neighbor : adj[current]) {
          if (!visited[neighbor]) { // 방문하지 않은 인접 노드에 대해서만 처리
            visited[neighbor] = true;
            dist[neighbor] = dist[current] + 1; // 거리를 현재 노드의 거리 + 1로 설정
            queue.add(neighbor); // 인접 노드를 큐에 추가
          }
        }
      }

      // 시작 노드에서 모든 다른 노드까지의 거리 합을 cnt 배열에 저장
      for (int i = 0; i < node; i++) {
        if (dist[i] != Integer.MAX_VALUE) { // 방문하지 않은 노드는 제외
          cnt[num] += dist[i];
        }
      }
    }

    int getNodeNumber() {
      for (int i = 0; i < node; i++) {
        BFS(i); // 각 노드에 대해 BFS 실행하여 케빈 베이컨 수 계산
      }

      int min = cnt[0]; // 첫 번째 노드를 기준으로 초기화
      int idx = 0;
      for (int i = 1; i < node; i++) {
        if (min > cnt[i]) { // 현재 최소값보다 작은 값을 찾으면 갱신
          min = cnt[i];
          idx = i;
        }
      }

      return idx; // 가장 작은 케빈 베이컨 수를 가진 노드 번호 반환
    }
  }
}
