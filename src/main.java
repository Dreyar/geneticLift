import java.util.Arrays;

/**
 * Created by nikom on 20/4/2016.
 */
public class main {
    public static void main(String[] args) {
        population pop = new population(geneticAlgo.population_size).initializePopulation();
        geneticAlgo geneticAlgorithm = new geneticAlgo();
        System.out.println("-----------------------------------------");
        System.out.println("Generation # 0 " + " |Fitness chromosome fitness: " + pop.getChromosomes()[0].getFitness());
        printPopulation(pop, "Target Chromosome: " + Arrays.toString(geneticAlgo.target_chromosome));

        int generationNumber = 0;

        while (pop.getChromosomes()[0].getFitness() < geneticAlgo.target_chromosome.length) {
            generationNumber++;
            System.out.println("\n-----------------------------------------");
            pop = geneticAlgorithm.evolve(pop);
            pop.sortChromosomeByFitness();
            System.out.println("Generation # "+generationNumber+" Fitness chromosome fitness: " +
                                pop.getChromosomes()[0].getFitness());
            printPopulation(pop,"Target Chromosome: "+Arrays.toString(geneticAlgorithm.target_chromosome));
        }
    }

    public static void printPopulation(population pop, String heading) {
        System.out.println(heading);
        System.out.println("-----------------------------------------");
        for (int x = 0; x < pop.getChromosomes().length; x++) {
            System.out.println("Chromosome # " + x + " : " + Arrays.toString(pop.getChromosomes()[x].getGenes())
                    + "| Fitness: " + pop.getChromosomes()[x].getFitness());
        }
    }
}
