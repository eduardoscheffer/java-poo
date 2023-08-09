package introPOO.exercicioUm.entities;

public class Triangle {
    public Double a;
    public Double b;
    public Double c;
    public Double area;

    public Triangle(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        double p = ( this.a + this.b + this.c ) / 2.0;
        this.area = Math.sqrt( p * (p - this.a) * (p - this.b) * (p - this.c) );
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", Area=" + area +
                '}';
    }

    public void calculateLargerArea(Double areaX, Double areaY) {

    }
}
