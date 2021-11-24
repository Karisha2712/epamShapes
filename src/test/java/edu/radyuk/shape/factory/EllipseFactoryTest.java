package edu.radyuk.shape.factory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.entity.Point;
import edu.radyuk.shape.exception.EllipseException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EllipseFactoryTest {
    private static final EllipseFactory ellipseFactory = EllipseFactory.getInstance();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ifPointsCoordinatesAreCorrectReturnsEllipse() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(14.0);
        pointsCoordinates.add(16.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertEquals(ellipse, new Ellipse(new Point(10.0, 10.0), new Point(14.0, 16.0)));
    }

    @Test
    public void ifEllipseExceptionThrown() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(14.0);
        thrown.expect(EllipseException.class);
        thrown.expectMessage("Invalid number of coordinates: " + pointsCoordinates);
        ellipseFactory.getEllipse(pointsCoordinates);
    }
}
