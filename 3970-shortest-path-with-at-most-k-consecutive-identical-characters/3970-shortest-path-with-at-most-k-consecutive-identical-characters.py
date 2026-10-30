import heapq

class Solution(object):
    def shortestPath(self, n, edges, labels, k):
        """
        :type n: int
        :type edges: List[List[int]]
        :type labels: str
        :type k: int
        :rtype: int
        """
        if k < 1:
            return -1

        adj = [[] for _ in range(n)]
        for u, v, w in edges:
            adj[u].append((v, w))

        # dist[u][cnt] tracks the minimum distance to reach node u
        # with cnt consecutive occurrences of labels[u]
        dist = [[float('inf')] * (k + 1) for _ in range(n)]
        dist[0][1] = 0

        # Min-heap stores: (current_cost, u, consecutive_count)
        pq = [(0, 0, 1)]

        while pq:
            d, u, count = heapq.heappop(pq)

            if d > dist[u][count]:
                continue

            if u == n - 1:
                return d

            for v, w in adj[u]:
                if labels[v] == labels[u]:
                    next_count = count + 1
                    if next_count > k:
                        continue
                else:
                    next_count = 1

                new_dist = d + w
                if new_dist < dist[v][next_count]:
                    dist[v][next_count] = new_dist
                    heapq.heappush(pq, (new_dist, v, next_count))

        return -1