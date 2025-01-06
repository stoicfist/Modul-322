package trigonometrie;

class Kreis {
    private double radius;

    public Kreis(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}