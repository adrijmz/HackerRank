package Algorithms.Implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
        static List<Integer> toReturn = new ArrayList<>();
        static int cursor = 0;
        static int place = 0;
        static int minValue = Integer.MAX_VALUE;
        static boolean finished = false;
        
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
            // Write your code here
        player.sort(Collections.reverseOrder());
        
        for(Integer data : player){
            finished = false;
            calculatePos(ranked, data);
        }
        toReturn.sort(Collections.reverseOrder());
        return toReturn;
    }

    private static void calculatePos(List<Integer> ranked, int data){
        
        while(cursor<ranked.size() && !finished){
            if(ranked.get(cursor)<minValue){
                place++;
                minValue = ranked.get(cursor);
            }
            if(data>ranked.get(cursor)){
                toReturn.add(place);
                finished = true;
            }
            else if(data<ranked.get(cursor)){
                if(cursor == ranked.size()-1){
                    toReturn.add(place+1);
                    finished = true;
                }
                else cursor++;
            }
            else{
                toReturn.add(place);
                finished = true;
            }
        }
    }

}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
