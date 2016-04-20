import java.util.Arrays;

/**
 * Created by nikom on 20/4/2016.
 */
public class population {
    private chromosome[] chromosomes;

    public population(int length) {
        chromosomes = new chromosome[length];
    }

    public population initializePopulation() {
        for (int x = 0; x < chromosomes.length; x++) {
            chromosomes[x] = new chromosome(geneticAlgo.target_chromosome.length).initializeChromosome();
        }
        sortChromosomeByFitness();
        return this;
    }

    public chromosome[] getChromosomes() {
        return chromosomes;
    }

    public void sortChromosomeByFitness() {
        Arrays.sort(chromosomes, (chromosome1, chromosome2) -> {
            int flag = 0;
            if (chromosome1.getFitness() > chromosome2.getFitness()) flag = -1;
            else if (chromosome1.getFitness() < chromosome2.getFitness()) flag = 1;
            return flag;
        });
    }
}
