public class ex2 {
    class Skill{
        int index;
        int skill_len;
        int skill_score;

        Skill(int index, int skill_len, int skill_score){
            this.index = index;
            this.skill_len = skill_len;
            this.skill_score = skill_score;
        }
    }
    public int solution(String[] skill, int[] score, String user_cmd){
        ArrayList<Skill> check = new ArrayList<Skill>();

        for(int i=0; i<user_cmd.length(); i++) {
            for(int j=0; j<skill.length; j++){
                if(skill[j] == user_cmd.substring(i, i+skill[j].length())){
                    check.add(new Skill(i+skill[j].length()-1, skill[j].length(), socre[j]));
                }
            }
        }

    int[] dp = new int[user_cmd.length() + 1];
    dp[0] = 0

    for(int i=1; i<=user_cmd.length(); i++){
        dp[i] = dp[i-1] + 1;
        for(int j=0; j<check.size(); j++){
            if(i == check[j].index+1){
                dp[i] = Math.max(dp[i], dp[i- check[j].skill_len] + check[j].skill_score);
            }
        }
    }

        return dp[user_cmd.length()];

    }
}
