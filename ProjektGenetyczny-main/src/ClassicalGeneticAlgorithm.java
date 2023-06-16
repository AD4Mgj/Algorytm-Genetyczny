import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Random;

public class ClassicalGeneticAlgorithm {
    public static final Double DEFAULT_MAX_DIFFERENCE = 1700.0;
    public static final Double DEFAULT_COEFFICIENT_POPULATION_CHECK = 0.90;


    public static Stack<PlaceOnMap> createPopulation(int amount) {
        Stack<PlaceOnMap> stack = new Stack<>();
        for (int i = 0; i < amount; i++) {
            stack.add(new PlaceOnMap(new Random().nextInt(1023), new Random().nextInt(1023)));
        }
        return stack;
    }

    public static void CGM(Stack<PlaceOnMap> stack) {
        PlaceOnMap best = stack.pop();
        PlaceOnMap second = stack.pop();
        int generation = 0;
        do {
            System.out.println("Generacja: " + generation);
            Stack<PlaceOnMap> currentPopulation = new Stack<>();
            currentPopulation.addAll(stack);

            System.out.println("Populacja:");
            displayPopulation(currentPopulation);

            while (!currentPopulation.isEmpty()) {
                PlaceOnMap current = currentPopulation.pop();
                if (current.getFitnessValue() > best.getFitnessValue()) {
                    second = best;
                    best = current;
                } else if (current.getFitnessValue() > second.getFitnessValue()) {
                    second = current;
                }
            }

            stack = GeneticOperations.getCrossed(best, second);
            generation++;
        } while (!isStopConditionSatisfied(stack));
        System.out.println();
        System.out.println("Najlepsze współrzędne znalezione:");
        System.out.println("x: " + best.getCoordinateX() + ", y: " + best.getCoordinateY());
        System.out.println("Fitness: " + best.getFitnessValue());

    }
    public static void displayPopulation(Stack<PlaceOnMap> stack) {
        for (PlaceOnMap place : stack) {
            System.out.println(place.toString() + " Fitness: " + place.getFitnessValue());
        }
    }
    public static boolean isStopConditionSatisfied(Stack<PlaceOnMap> stack) {
        int partToCheck = (int) (stack.size()+stack.size() * DEFAULT_COEFFICIENT_POPULATION_CHECK);
        int result = numberOfIndividualsConditionSatisfied(stack);
        return result >= partToCheck;
    }


    public static PlaceOnMap[] findBest(Stack<PlaceOnMap> stack) {
        List<PlaceOnMap> bestIndividuals = new ArrayList<>();
        double bestValue = stack.get(0).getFitnessValue();
        bestIndividuals.add(stack.get(0));

        for (int i = 0; i < stack.size(); i++) {
            PlaceOnMap individual = stack.get(i);
            if (individual.getFitnessValue() == bestValue) {
                bestIndividuals.add(individual);
            } else if (individual.getFitnessValue() > bestValue) {
                bestValue = individual.getFitnessValue();
                bestIndividuals.clear();
                bestIndividuals.add(individual);
            }
        }

        return bestIndividuals.toArray(new PlaceOnMap[0]);
    }
    public static int numberOfIndividualsConditionSatisfied(Stack<PlaceOnMap> stack) {
        int numberOfPositiveIndividuals = 0;
        PlaceOnMap[] bestIndividuals = findBest(stack);
        double bestValue = bestIndividuals[0].getFitnessValue();

        for (PlaceOnMap individual : bestIndividuals) {
            if (Math.abs(bestValue - individual.getFitnessValue()) < DEFAULT_MAX_DIFFERENCE) {
                numberOfPositiveIndividuals++;
            }
        }

        return numberOfPositiveIndividuals;
    }




}
