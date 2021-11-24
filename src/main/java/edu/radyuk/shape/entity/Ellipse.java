package edu.radyuk.shape.entity;

import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.observer.EllipseEvent;
import edu.radyuk.shape.observer.EllipseObservable;
import edu.radyuk.shape.observer.EllipseObserver;
import edu.radyuk.shape.util.ShapeIdGenerator;
import edu.radyuk.shape.validator.impl.EllipseParametersValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class Ellipse implements EllipseObservable {
    private final int ellipseId;
    private Point firstPoint;
    private Point secondPoint;
    List<EllipseObserver> observers = new ArrayList<>();

    public Ellipse(Point firstPoint, Point secondPoint) throws EllipseException {
        EllipseParametersValidatorImpl ellipseParametersValidator = new EllipseParametersValidatorImpl();
        if (!ellipseParametersValidator.areParametersValid(firstPoint, secondPoint)) {
            throw new EllipseException("Invalid ellipse: points can't belong to a horizontal or vertical line");
        }
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
        notifyObservers();
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
        notifyObservers();
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

    @Override
    public void attach(EllipseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(EllipseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (EllipseObserver observer : observers) {
            if (observer != null) {
                EllipseEvent event = new EllipseEvent(this);
                observer.updateParameters(event);
            }
        }
    }
}
