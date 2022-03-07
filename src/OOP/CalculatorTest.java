package OOP;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void plus() {
//        fail("Not yet implemented. ");
        Calculator c = new Calculator();
        assertEquals(2, c.plus(1, 1));
    }
}