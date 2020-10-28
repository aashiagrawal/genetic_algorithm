import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class GeneticAlgorithm2 { 

    public int points[][];
    public int bestScore[] = new int[3];
    public int generationCounter;
    public ArrayList <Integer> bestInGen;

    public GeneticAlgorithm2 (int[][] pointList){
        points = pointList;
        // bestScore = new int[] {9999,9999,9999};
        bestInGen = new ArrayList <Integer>();
    }

    public int[][] getPoints() {
        return points;
    }

    public static void sortList(int points[][]) {
        //System.out.println(Arrays.deepToString(points));
        Arrays.sort(points, new Comparator <int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                if (entry1[2] > entry2[2]) 
                    return 1;
                else if (entry1[2] < entry2[2]) {
                    return -1;
                } 
                else {
                    return 0;
                } 
            }
        });
    }
    
    public int[] computeMinFit() {
        // Populate fitness scores
        for(int i = 0; i < 100; i++) {
            points[i][2] = Math.abs((int)(Math.pow(points[i][0], 2) + points[i][0] - points[i][1]));
         }
        
        // Sort based on fitness score
        sortList(points);

        int [][] newArray = new int [100][3];
        ArrayList <Integer> shuffledX = new ArrayList <Integer>();
        ArrayList <Integer> shuffledY = new ArrayList <Integer>();


        // 100 Generations
        // outer: 
        int bestTuple[] = new int[] {999,999,Integer.MAX_VALUE};
        int bestInGenScore = Integer.MAX_VALUE;
        for(int i = 0; i < 100; i++) {

            generationCounter++;
            //System.out.println(Arrays.deepToString(newArray));
            for(int j = 0; j <50; j++) {
                newArray[j] = points[j];
                shuffledX.add(newArray[j][0]);
                shuffledY.add(newArray[j][1]);
            }

            Collections.shuffle(shuffledX);
            Collections.shuffle(shuffledY);

            for(int k = 50; k < 100; k++) {
                newArray[k][0] = shuffledX.get(k-50);
                newArray[k][1] = shuffledY.get(k-50);
            }

            for(int l = 0; l < 100; l++) {
                int fitnessScore = Math.abs((int)(Math.pow(newArray[l][0], 2) + newArray[l][0] - newArray[l][1]));
                newArray[l][2] = fitnessScore;
                if (fitnessScore < bestInGenScore) {
                    bestInGenScore = fitnessScore;
                    bestTuple[0] = newArray[l][0];
                    bestTuple[1] = newArray[l][1];
                    bestTuple[2] = fitnessScore;
                }
            }

            bestInGen.add(bestInGenScore);
            if (bestInGenScore == 0) {
                break;
            }

            sortList(newArray);
        
            // for(int m = 0; m < newArray.length; m++) {
            //     if(newArray[m][2] == 0)
            //     {
            //         bestScore = newArray[m];
            //         bestInGen.add(newArray[m][2]);
            //         break outer;

            //     }
            //     else if (newArray[m][2] <= bestScore[2])
            //     {
            //         bestScore = newArray[m];
            //         bestInGen.add(newArray[m][2]);
            //     }
            // }
        }
        bestScore = bestTuple;
        return bestScore;
    }

    public int getCounter()
    {
        return generationCounter;
    }
    
    public ArrayList <Integer> getBestInGen()
    {
        return bestInGen;
    }

    public int getLength()
    {
        return bestInGen.size();
    }
}
