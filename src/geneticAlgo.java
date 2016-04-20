/**
 * Created by nikom on 20/4/2016.
 */
public class geneticAlgo {

    public static final int population_size = 8;
    public static final int[] target_chromosome = {1, 1, 0, 1, 0, 0, 1, 1, 1, 0};
    private static final double mutation_rate = 0.01;
    public static final int numb_of_elite_chromosomes = 1;
    public static final int tournamet_selection_size = 4;

    public population evolve(population pop) {
        return mutatePopulation(crossoverPopulation(pop));
    }

    private population crossoverPopulation(population pop) {
        population crossoverPopulation = new population(pop.getChromosomes().length);
        for (int x = 0; x < numb_of_elite_chromosomes; x++) {
            crossoverPopulation.getChromosomes()[x] = pop.getChromosomes()[x];
        }
        for (int x = numb_of_elite_chromosomes; x < pop.getChromosomes().length; x++) {
            chromosome chromosome1 = selectTournamentPopulation(pop).getChromosomes()[0];
            chromosome chromosome2 = selectTournamentPopulation(pop).getChromosomes()[0];
            crossoverPopulation.getChromosomes()[x] = crossoverChromosome(chromosome1, chromosome2);
        }
        return crossoverPopulation;
    }

    private population mutatePopulation(population pop) {
        population mutatePopulation = new population(pop.getChromosomes().length);
        for (int x = 0; x < numb_of_elite_chromosomes; x++) {
            mutatePopulation.getChromosomes()[x] = pop.getChromosomes()[x];
        }
        for (int x = numb_of_elite_chromosomes; x < pop.getChromosomes().length; x++) {
            mutatePopulation.getChromosomes()[x] = mutateChromosome(pop.getChromosomes()[x]);
        }
        return mutatePopulation;
    }

    private chromosome crossoverChromosome(chromosome chromosome1, chromosome chromosome2) {
        chromosome crossoverChromosome = new chromosome(target_chromosome.length);
        for (int x = 0; x < chromosome1.getGenes().length; x++) {
            if (Math.random() < 0.5) crossoverChromosome.getGenes()[x] = chromosome1.getGenes()[x];
            else {
                crossoverChromosome.getGenes()[x] = chromosome2.getGenes()[x];
            }
        }
        return crossoverChromosome;
    }

    private chromosome mutateChromosome(chromosome chromosome) {
        chromosome mutateChromosome = new chromosome(target_chromosome.length);
        for (int x = 0; x < chromosome.getGenes().length; x++) {
            if (Math.random() < mutation_rate) {
                if (Math.random() < 0.5) mutateChromosome.getGenes()[x] = 1;
                else mutateChromosome.getGenes()[x] = 0;
            } else mutateChromosome.getGenes()[x] = chromosome.getGenes()[x];
        }
        return mutateChromosome;
    }

    private population selectTournamentPopulation(population pop) {
        population tournamentPopulation = new population(tournamet_selection_size);
        for (int x = 0; x < tournamet_selection_size; x++) {
            tournamentPopulation.getChromosomes()[x] =
                    pop.getChromosomes()[(int) (Math.random() * pop.getChromosomes().length)];
        }
        tournamentPopulation.sortChromosomeByFitness();
        return tournamentPopulation;
    }
}
