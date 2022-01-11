package Lab01_0;

import java.util.Scanner;

public class LinearEquation {

    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getE() {
        return this.e;
    }

    public double getF() {
        return this.f;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getD() {
        return this.d;
    }

    public double getX() {
        return ((e * d) - (b * f) / (a * d) - (b * c));
    }

    public double getY() {
        return ((a * f) - (e * c) / (a * d) - (b * c));
    }

    public boolean isSolvable() {
        if (a * d - b * c != 0)
            return true;
        else
            return false;
    }

    public LinearEquation a(double a) {
        return this;
    }

    public LinearEquation b(double b) {
        return this;
    }

    public LinearEquation c(double c) {
        return this;
    }

    public LinearEquation d(double d) {
        return this;

    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LinearEquation)) {
            return false;
        }
        LinearEquation linearEquation = (LinearEquation) o;
        return a == linearEquation.a && b == linearEquation.b && c == linearEquation.c && d == linearEquation.d;
    }

    @Override
    public String toString() {
        return "{" +
                " a='" + getA() + "'" +
                ", b='" + getB() + "'" +
                ", c='" + getC() + "'" +
                ", d='" + getD() + "'" +
                "}";
    }

    public static LinearEquation readEquation() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter a, b, c, d, e, f:");

            LinearEquation le = new LinearEquation(input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble());

            return le;
        }
    }

    public static void printaAlllEquations(LinearEquation[] le) {
        for (LinearEquation e : le) {
            System.out.println(e);
        }
    }

    public static boolean linesIntersect(LinearEquation[] le) {
        if (le[0].getX() == le[1].getX() && le[0].getX() == le[2].getX() && le[0].getY() == le[1].getY()
                && le[0].getY() == le[2].getY()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        LinearEquation le[] = new LinearEquation[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter 3 Linear Equations:");
            le[i] = LinearEquation.readEquation();
        }
        if (linesIntersect(le)) {
            System.out.println("All lines intersect."
                    + "X: " + le[0].getX()
                    + "Y: " + le[0].getY());
        } else {
            System.out.println("No solution, lines do not all intersect.");
        }
        /*
         * if (le.isSolvable()) {
         * System.out.println("Equation is solvable: " + "X: " + Math.round(le.getX()) +
         * " Y: " + Math.round(le.getY()));
         * } else {
         * System.out.println("Not solvable");
         * }
         * 
         * 
         */
    }
}
