import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int l=id_list.length;
        int[] answer = new int[l];
        
        Set<String> set = new HashSet<String>(Arrays.asList(report));
        String[] arr=set.toArray(new String[0]);
        
        Map<String, Integer> map=new LinkedHashMap<>();
        int len = arr.length;
        for(int i=0;i<len;i++){
            StringTokenizer st=new StringTokenizer(arr[i]);
            st.nextToken();
            String name=st.nextToken();
            if(map.containsKey(name)){
                map.put(name, map.get(name)+1);
            }else{
                map.put(name, 1);
            }
        }
        
        for(int i=0;i<len;i++){
            StringTokenizer st=new StringTokenizer(arr[i]);
            String name1=st.nextToken();
            String name2=st.nextToken();
            
            if(map.get(name2)<k) continue;
            
            for(int j=0;j<l;j++){
                if(name1.equals(id_list[j])){
                    answer[j]++;
                    break;
                }
            }
        }
        
        return answer;
    }
}