import java.util.Arrays;

public class chromosome {
    private boolean isFitnessChanged = true;
    private int genes[];
    private int fitness = 0;

    public chromosome(int length) {
        genes = new int[length];
    }

    public chromosome initializeChromosome() {
        for (int x = 0; x < genes.length; x++) {
            if (Math.random() >= 0.5) genes[x] = 1;
            else genes[x] = 0;
        }
        return this;
    }

    public int[] getGenes() {
        isFitnessChanged = true;
        return genes;
    }

    public int getFitness() {
        if (isFitnessChanged) {
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    public int recalculateFitness() {
        int chromosomeFitness = 0;
        for (int x = 0; x < genes.length; x++) {
            if (genes[x] == geneticAlgo.target_chromosome[x]) chromosomeFitness++;
        }
        return chromosomeFitness;
    }

    public String toString() {
        return Arrays.toString(this.genes);
    }
}
