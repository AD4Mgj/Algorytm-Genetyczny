public interface IIndividual {
    double getFitnessValue();

    String[] getGenotype();

    int getGenotypeLength();

    int getId();
}