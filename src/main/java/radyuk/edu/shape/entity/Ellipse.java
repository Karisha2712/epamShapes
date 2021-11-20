package radyuk.edu.shape.entity;

import radyuk.edu.shape.util.ShapeIdGenerator;

public class Ellipse {
    private final int ellipseId;
    private Point firstPoint;
    private Point secondPoint;

    public Ellipse(Point firstPoint, Point secondPoint) {
        ellipseId = ShapeIdGenerator.generateId();
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public int getEllipseId() {
        return ellipseId;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return ellipse.firstPoint.equals(firstPoint)
                && ellipse.secondPoint.equals(secondPoint);
    }

    @Override
    public int hashCode() {
        int result = firstPoint.hashCode();
        result += 31 * result + secondPoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ellipse{");
        sb.append("ellipseId=").append(ellipseId);
        sb.append(", firstPoint=").append(firstPoint);
        sb.append(", secondPoint=").append(secondPoint);
        sb.append('}');
        return sb.toString();
    }
}
