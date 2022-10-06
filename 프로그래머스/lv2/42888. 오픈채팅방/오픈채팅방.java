import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> log = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        
        StringTokenizer st;
        for(String r : record){
            st = new StringTokenizer(r, " ");
            String act = st.nextToken();
            String id = st.nextToken();
            String nickname = "";
            
            //입장
            if(act.equals("Enter")) {
                nickname = st.nextToken();
                //유저 목록 추가
                user.put(id, nickname);
                //result 추가
                log.add(id + "님이 들어왔습니다.");
            }
            else if (act.equals("Leave")) {
                //result 추가
                log.add(id + "님이 나갔습니다.");
            }
            else {
                nickname = st.nextToken();
                user.replace(id, nickname);
            }
        }
        
        String[] answer = new String[log.size()];
        int logIdx = 0;
        for(String str : log) {
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);
            
            answer[logIdx++] = str.replace(userId, user.get(userId));
        }
        
        return answer;
    }
}