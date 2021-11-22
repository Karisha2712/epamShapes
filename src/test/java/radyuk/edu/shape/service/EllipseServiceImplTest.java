package radyuk.edu.shape.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import radyuk.edu.shape.entity.Ellipse;
import radyuk.edu.shape.exception.EllipseException;
import radyuk.edu.shape.factory.EllipseFactory;
import radyuk.edu.shape.service.impl.EllipseServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EllipseServiceImplTest {
    private static final EllipseFactory ellipseFactory = EllipseFactory.getInstance();
    private static final EllipseServiceImpl ellipseServiceImpl = new EllipseServiceImpl();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

}
