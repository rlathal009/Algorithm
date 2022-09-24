import java.util.*;

public class bestAlbum {
    static class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx){
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }

    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genres_ordered = new ArrayList<>();
        for(String key : map.keySet()){
            genres_ordered.add(key);
        }
        Collections.sort(genres_ordered, (o1, o2) -> map.get(o2) - map.get(o1));

        ArrayList<Music> result = new ArrayList<>();
        for(String genre : genres_ordered){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    list.add(new Music(genre, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            result.add(list.get(0));
            if(list.size()!=1){
                result.add(list.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;
    }    
}
