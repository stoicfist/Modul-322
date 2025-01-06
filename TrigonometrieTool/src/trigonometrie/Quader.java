package trigonometrie;

class Quader {
    private double length, width, height;

    public Quader(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
