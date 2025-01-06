package trigonometrie;

class Dreieck {
    private double base, height;

    public Dreieck(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}
