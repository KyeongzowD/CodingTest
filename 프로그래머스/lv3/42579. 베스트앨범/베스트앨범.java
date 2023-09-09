import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        int[] answer = {};
        ArrayList<Integer> list=new ArrayList<>();
        
        //재생 수의 합을 구하기 위한 맵
        HashMap<String,Integer> gen_map = new HashMap<String,Integer>();
        for(int i=0;i<genres.length;i++){
            if(gen_map.containsKey(genres[i]))
                gen_map.put(genres[i],gen_map.get(genres[i])+plays[i]);
            else
                gen_map.put(genres[i],gen_map.getOrDefault(genres[i],plays[i]));
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(gen_map.entrySet());//장르별 재생수 내림차순
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

	    for(Map.Entry<String, Integer> entry : entryList){
            HashMap<Integer,Integer> pla_map=new HashMap<Integer,Integer>();//인덱스 별 재생 횟수
            String s=entry.getKey();
            for(int j=0;j<plays.length;j++){
                if(genres[j].equals(s)){
                    pla_map.put(j,plays[j]);//각 장르별 노래를 맵에 저장
                }
            }
            
            List<Map.Entry<Integer, Integer>> sortedList = pla_map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
            
            int i=0;
            for (Map.Entry<Integer, Integer> entry2 : sortedList) {
                list.add(entry2.getKey());
                i++;
                if(i==2)
                    break;
            }
        }
        
        answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}