public class AlgorithmTester2 {
    
    public static void main (String [] args){
        
        int points [][] = new int [100][3];

        // Initial random coordinates
        for (int i = 0; i < points.length; i++)
        {
            points[i][0] = (int)(Math.random() * 100);
            points[i][1] = (int)(Math.random() * 100);
        }

         GeneticAlgorithm2 GA = new GeneticAlgorithm2(points);
         int [] perfectValues = GA.computeMinFit();

         //print (x,y) coordinates of the best fitness value
         System.out.println("X and Y values: " + "("+ perfectValues[0]+ ", " + perfectValues[1] +")");
         System.out.println("Best fitness value: " + perfectValues[2]);
         System.out.println("Number of generations: " + GA.getCounter());
         
         System.out.println("The best fitness values for each generation:");
         System.out.println(GA.getBestInGen());
         //System.out.println(GA.getLength());
         //int fitnessPoints [][] = GA.getPoints();
        // System.out.println(Arrays.deepToString(fitnessPoints));

        //GeneticAlgorithm2.sortList(fitnessPoints);
        // System.out.println(Arrays.deepToString(fitnessPoints));

    }

}
