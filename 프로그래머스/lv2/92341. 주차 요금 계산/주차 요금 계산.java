import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int lastTime = getMin("23:59");
        //주차 시각
        Map<Integer, Integer> parking = new HashMap<>();
        
        //요금 정보
        Map<Integer, Integer> pay = new TreeMap<>();
        
        for(String record : records) {
            String[] r = record.split(" ");
            int time = getMin(r[0]);
            int car = Integer.parseInt(r[1]);
            
            if(r[2].equals("OUT")){
                pay.put(car, pay.getOrDefault(car, 0) + time - parking.get(car));
                parking.remove(car);
            } else{
                parking.put(car, time);
            }
        }
            
        for(int num : parking.keySet()) {
            int d = parking.get(num);
            int use_time = lastTime - d;

            pay.put(num, pay.getOrDefault(num, 0) + use_time);
        }
        
        int[] answer = new int[pay.size()];
        int idx = 0;           
        for(int data : pay.keySet()) {
            int total_time = pay.get(data);
            if(total_time <= fees[0]) answer[idx] = fees[1];
            else{
                answer[idx] = fees[1] + (int)Math.ceil((double)(total_time-fees[0])/fees[2]) * fees[3];
            }   
            idx++;
        }
        
        return answer;
    }
    
    public int getMin(String time) {
        String[] t = time.split(":");
        int count = 60 * Integer.parseInt(t[0]) + Integer.parseInt(t[1]);
        return count;
    }
}