package edu.radyuk.shape.util;

public final class ShapeIdGenerator {
    private static int counter;

    private ShapeIdGenerator() {

    }

    public static int generateId() {
        return counter++;
    }
}
