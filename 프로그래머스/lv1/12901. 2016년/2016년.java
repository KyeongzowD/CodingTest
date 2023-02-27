import java.time.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day={"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        if(dayOfWeek.getValue()==7){
            answer=day[0];
        }else{
            answer=day[dayOfWeek.getValue()];
        }
        
        
        return answer;
    }
    
}