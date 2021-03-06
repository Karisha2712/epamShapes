package edu.radyuk.shape.factory;


import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.entity.Point;
import edu.radyuk.shape.exception.EllipseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EllipseFactoryTest {
    private final EllipseFactory ellipseFactory = EllipseFactory.getInstance();

    @Test
    public void ifPointsCoordinatesAreCorrectReturnsEllipse() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(14.0);
        pointsCoordinates.add(16.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        Ellipse expectedEllipse = new Ellipse(new Point(10.0, 10.0), new Point(14.0, 16.0));
        assertEquals(expectedEllipse, ellipse);
    }

    @Test
    public void ifEllipseExceptionThrown() {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(14.0);
        String expectedMessage = "Invalid number of coordinates: " + pointsCoordinates;
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseFactory.getEllipse(pointsCoordinates));
        assertEquals(expectedMessage, expectedException.getMessage());
    }
}
