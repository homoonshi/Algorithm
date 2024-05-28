
import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Boolean> person = new HashMap<>();
    static Set<Integer> party = new HashSet<>();
    static Set<Integer>[] enterParty;
    static Set<Integer>[] personParty;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M;

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i=1; i<=N; i++){
            person.put(i,false);
        }

        int factNum = 0;

        input = br.readLine().split(" ");
        factNum = Integer.parseInt(input[0]);

        for(int i=0; i<factNum; i++){
            person.put(Integer.parseInt(input[i+1]),true);
        }

        enterParty = new Set[N+1]; // 거짓말을 모르는 사람의 참가한 파티 저장
        personParty = new Set[M+1]; // 거짓말이 통한 파티의 참석 인원
        int partyNum; // 파티 참석 인원
        int client; // 파티 참석한 사람 인덱스
        boolean expose; // 파티가 진실을 알게됨

        for(int i=0; i<M; i++){

            expose = false;
            input = br.readLine().split(" ");
            partyNum = Integer.parseInt(input[0]);
            party.add(i);

            for(int j=0; j<partyNum; j++){

                client = Integer.parseInt(input[j+1]);

                if(person.get(client)){ // 진실을 앎
                    party.remove(i);
                    expose = true;
                    break;
                }else{

                    if(personParty[i]==null){
                        personParty[i] = new HashSet<>();
                    }

                    if(enterParty[client]==null){
                        enterParty[client] = new HashSet<>();
                    }

                    if(party.contains(i)){
                        enterParty[client].add(i);
                        personParty[i].add(client);
                    }
                }
            }

            if(expose) {
                for (int j = 0; j < partyNum; j++) {
                    client = Integer.parseInt(input[j+1]);

                    if(!person.get(client)){
                        person.put(client,true);
                        if(enterParty[client]!=null) {
                            Iterator<Integer> iterSet = enterParty[client].iterator(); // 거짓말을 몰랐던 사람이 참석한 파티들
                            while(iterSet.hasNext()) {
                                partyKnow(iterSet.next());
                            }
                        }
                    }

                }
            }

        }

        bw.write(party.size()+"");
        bw.flush();
    }

    public static void partyKnow(int index){

        party.remove(index);

        Iterator<Integer> iterSet = personParty[index].iterator(); // 이 파티 참석자들을 돌기 시작함

        while(iterSet.hasNext()){
            int personIndex = iterSet.next();
            person.put(personIndex,true);
            if(enterParty[personIndex]!=null){
                Iterator<Integer> enter = enterParty[personIndex].iterator();
                while(enter.hasNext()){
                    int partyIndex = enter.next();
                    if(party.contains(partyIndex)) {
                        partyKnow(partyIndex);
                    }
                }
            }
        }

    }

}
