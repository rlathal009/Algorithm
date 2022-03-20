import java.util.*;

class 완전탐색_1 {
    public int[] solution(int[] answers) {
        int[] score = {0,0,0};
        int len = answers.length;

        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        for(int i=0; i<len; i++){
            if(answers[i] == person1[i%5]) score[0]++;
            if(answers[i] == person2[i%8]) score[1]++;
            if(answers[i] == person3[i%10]) score[2]++;
        }

        int max = 0;
        for(int i=0; i<3; i++){
            if(score[i] >= max)
                max = score[i];
        }

        ArrayList<Integer> winner = new ArrayList<Integer>();

        for(int i=0; i<3; i++){
            if(score[i] == max) winner.add(i+1);
        }

        int[] answer = new int[winner.size()];
        for(int i=0; i< winner.size(); i++){
            answer[i] = winner.get(i);
        }

        Arrays.sort(answer);


        return answer;
    }
}