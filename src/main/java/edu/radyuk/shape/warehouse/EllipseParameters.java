package edu.radyuk.shape.warehouse;

import java.util.Objects;

public class EllipseParameters {
    private double area;
    private double perimeter;

    public EllipseParameters(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseParameters that = (EllipseParameters) o;
        return Double.compare(that.area, area) == 0
                && Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(area);
        result = 31 * result + Objects.hash(perimeter);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EllipseParameters{");
        sb.append("area=").append(area);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
