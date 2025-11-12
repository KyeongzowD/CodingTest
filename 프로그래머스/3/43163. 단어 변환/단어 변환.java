import java.util.*;

class Solution {
    
    static class Word{
        String word;
        int len; // 시작 지점에서 얼마나 먼지
        
        public Word(String word, int len){
            this.word=word;
            this.len=len;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int count=words.length;
        
        List<Word> list=new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add(new Word(words[i], 0));
        }
        
        return bfs(list, begin, target);
    }
    
    public static int bfs(List<Word> list, String begin, String target){
        Queue<Word> que=new ArrayDeque<>();
        que.offer(new Word(begin, 0));
        
        int ans=0;
        while(!que.isEmpty()){
            Word word=que.poll();
            
            for(int i=0;i<list.size();i++){
                if(oneDiff(word.word, list.get(i).word)){
                    if(list.get(i).word.equals(target)) return word.len+1;
                    
                    list.get(i).len=word.len+1;
                    que.offer(list.get(i));
                    list.remove(i--);
                }
            }
        }
        
        return ans;
    }
    
    // 하나의 알파벳만 다르면 true를 출력
    public static boolean oneDiff(String s1, String s2){
        int len=s1.length();
        int diff=0;
        for(int i=0;i<len;i++){
            if(s1.charAt(i)!=s2.charAt(i)) diff++;
        }
        
        if(diff==1) return true;
        else return false;
    }
    
    
}