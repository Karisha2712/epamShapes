package radyuk.edu.shape.parser;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import radyuk.edu.shape.exception.EllipseException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EllipseLineParserTest {
    private static final EllipseLineParser ELLIPSE_LINE_PARSER = new EllipseLineParser();
    private static final String LINE = "10.0 12.0 12.0 14.0";
    private static final List<Double> DOUBLE_LIST = new ArrayList<>();

    @Before
    public void setUp() {
        DOUBLE_LIST.add(10.0);
        DOUBLE_LIST.add(12.0);
        DOUBLE_LIST.add(12.0);
        DOUBLE_LIST.add(14.0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ifParseEllipseLinesReturnsValidValues() throws EllipseException {
        List<Double> doubleList = ELLIPSE_LINE_PARSER.parseEllipseLine(LINE);
        assertEquals(doubleList, DOUBLE_LIST);
    }

}
