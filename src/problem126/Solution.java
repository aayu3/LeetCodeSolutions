package problem126;

import java.util.*;


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        HashSet<String> words = new HashSet<String>(wordList);
        words.add(beginWord);
        bfs(beginWord, endWord, graph, distance, words);
        dfs(res, new ArrayList<>(), beginWord, endWord, graph, distance);

        return res;
    }

    private void bfs(String start, String end, Map<String, List<String>> graph, Map<String, Integer> distance, Set<String> words) {
        for(String w:  words) {
            graph.put(w, new ArrayList<>());
        }

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int level = 1;
        distance.put(start, level);
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                String curr = q.poll();
                List<String> neis = getNeighbors(curr, words);
                for(String n: neis) {
                    graph.get(curr).add(n);
                    if(!distance.containsKey(n)) {
                        distance.put(n, level+1);
                        if(n.equals(end)) break;
                        q.offer(n);
                    }
                }
            }
            level++;
        }

        return;
    }

    private void dfs(List<List<String>> res, List<String> list, String curr, String end, Map<String, List<String>> graph, Map<String, Integer> distance){
        list.add(curr);

        if(curr.equals(end)) {
            res.add(new ArrayList(list));
        } else {
            for(String n: graph.get(curr)) {
                if(distance.get(curr)+1 == distance.get(n)) dfs(res, list, n, end, graph, distance);
            }
        }
        list.remove(list.size()-1);
    };

    private List<String> getNeighbors(String s, Set<String> words) {
        char[] arr = s.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            for(char c='a'; c<='z'; c++) {
                if(c == arr[i]) continue;
                char old = arr[i];
                arr[i] = c;
                String temp = new String(arr);
                if(words.contains(temp)) res.add(temp);
                arr[i] = old;
            }
        }

        return res;
    }
}