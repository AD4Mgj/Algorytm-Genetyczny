import java.util.Stack;
import java.util.Random;

public class GeneticOperations {
    public static Stack<PlaceOnMap> getCrossed(PlaceOnMap a, PlaceOnMap b) {
        String[] aGenotype = a.getGenotype();
        String[] bGenotype = b.getGenotype();

        int locus = aGenotype[0].length() / 2;
        Stack<PlaceOnMap> stack = new Stack<>();

        for (int i = 0; i <= 1; i++) {
            String newCoordinateX = aGenotype[i].substring(0, locus) + bGenotype[i].substring(locus);
            String newCoordinateY = bGenotype[i].substring(0, locus) + aGenotype[i].substring(locus);
            stack.add(fromBinaryToInt(generateMutation(newCoordinateX), generateMutation(newCoordinateY)));
        }

        return stack;
    }

    public static PlaceOnMap fromBinaryToInt(String coordinateX, String coordinateY) {
        return new PlaceOnMap(Integer.valueOf(coordinateX, 2), Integer.valueOf(coordinateY, 2));
    }

    public static String generateMutation(String gene) {
        double chance = 0.4d;

        if (new Random().nextDouble() < chance) {
            int index = new Random().nextInt(gene.length());
            char ret = (gene.charAt(index) == '1') ? '0' : '1';
            return gene.substring(0, index) + ret + gene.substring(index + 1);
        } else
            return gene;
    }
}
