package edu.radyuk.shape.service;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.entity.Point;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.factory.EllipseFactory;
import edu.radyuk.shape.service.impl.EllipseServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EllipseServiceImplTest {
    private static final EllipseFactory ellipseFactory = EllipseFactory.getInstance();
    private static final EllipseServiceImpl ellipseServiceImpl = new EllipseServiceImpl();

    @Test
    public void ifIsCircleReturnsTrue() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(16.0);
        pointsCoordinates.add(16.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertTrue(ellipseServiceImpl.isCircle(ellipse));
    }

    @Test
    public void ifIsCircleReturnsFalse() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(16.0);
        pointsCoordinates.add(17.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertFalse(ellipseServiceImpl.isCircle(ellipse));
    }

    @Test
    public void ifIsCircleThrowsNullException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseServiceImpl.isCircle(null));
        assertEquals("Invalid ellipse", expectedException.getMessage());
    }

    @Test
    public void ifIsEllipseReturnsTrue() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(16.0);
        pointsCoordinates.add(17.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertTrue(ellipseServiceImpl.isEllipse(ellipse));
    }

    @Test
    public void ifIsEllipseReturnsFalse() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(16.0);
        pointsCoordinates.add(16.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertFalse(ellipseServiceImpl.isEllipse(ellipse));
    }

    @Test
    public void ifIsEllipseThrowsNullException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseServiceImpl.isEllipse(null));
        assertEquals("Invalid ellipse", expectedException.getMessage());
    }

    @Test
    public void ifIsEllipseValidReturnsTrue() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(16.0);
        pointsCoordinates.add(16.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertTrue(ellipseServiceImpl.isEllipseValid(ellipse));
    }

    @Test
    public void ifIsEllipseValidReturnsFalse() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(16.0);
        pointsCoordinates.add(16.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        ellipse.setSecondPoint(new Point(10.0, 16.0));
        assertFalse(ellipseServiceImpl.isEllipseValid(ellipse));
    }

    @Test
    public void ifIsEllipseValidThrowsNullException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseServiceImpl.isEllipseValid(null));
        assertEquals("Invalid ellipse", expectedException.getMessage());
    }

    @Test
    public void ifCalculateAreaReturnsValidValue() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(20.0);
        pointsCoordinates.add(20.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertEquals(0, Double.compare(ellipseServiceImpl.calculateArea(ellipse), 78.53981633974483));
    }

    @Test
    public void ifCalculateAreaThrowsNullException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseServiceImpl.calculateArea(null));
        assertEquals("Invalid ellipse", expectedException.getMessage());
    }

    @Test
    public void ifCalculatePerimeterReturnsValidValue() throws EllipseException {
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(20.0);
        pointsCoordinates.add(20.0);
        Ellipse ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        assertEquals(0, Double.compare(ellipseServiceImpl.calculatePerimeter(ellipse), 31.41592653589793));
    }

    @Test
    public void ifCalculatePerimeterThrowsNullException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseServiceImpl.calculatePerimeter(null));
        assertEquals("Invalid ellipse", expectedException.getMessage());
    }

}
