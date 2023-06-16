public class PlaceOnMap implements Comparable<PlaceOnMap>, IIndividual {
    private int coordinateX;
    private int coordinateY;

    public PlaceOnMap(final int coordinateX, final int coordinateY) {
        if (coordinateX > 1023 || coordinateX < 0 || coordinateY > 1023 || coordinateY < 0)
            throw new IllegalArgumentException();

        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    @Override
    public int compareTo(PlaceOnMap o) {
        return Double.compare(this.getFitnessValue(), o.getFitnessValue());
    }

    public double getFitnessValue() {
        return -Math.pow(475 - this.getCoordinateX(), 2) - Math.pow(500 - this.getCoordinateY(), 2) + 600000;
    }

    public String[] getGenotype() {
        String x = toEqalLenght(toBinary(coordinateX));
        String y = toEqalLenght(toBinary(coordinateY));
        return new String[] { x, y };
    }

    private String toEqalLenght(String chromosome) {
        while (chromosome.length() < 10) {
            chromosome = "0" + chromosome;
        }
        return chromosome;
    }

    private String toBinary(int chromosome) {
        return Integer.toBinaryString(chromosome);
    }

    public int getGenotypeLength() {
        return this.getGenotype()[0].length();
    }

    public int getId() {
        return this.hashCode();
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(final int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(final int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + coordinateX;
        result = prime * result + coordinateY;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final PlaceOnMap other = (PlaceOnMap) obj;
        if (coordinateX != other.coordinateX)
            return false;
        if (coordinateY != other.coordinateY)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PlaceOnMap [coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + "] "+"ID: "+getId();
    }

}
