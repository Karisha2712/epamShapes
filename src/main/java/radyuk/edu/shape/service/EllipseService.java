package radyuk.edu.shape.service;

import radyuk.edu.shape.entity.Ellipse;

public interface EllipseService {
    boolean isEllipse(Ellipse ellipse);

    boolean isCircle(Ellipse ellipse);

    boolean isEllipseValid(Ellipse ellipse);

    boolean doesIntersectAxis(Ellipse ellipse, float distance);

    double calculateArea(Ellipse ellipse);

    double calculatePerimeter(Ellipse ellipse);

}
