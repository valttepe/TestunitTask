package com.example.valtteri.testunittask;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/* Pencil class models a ball point pencil with two colors,
 * Pencil.PenColor.RED and Pencil.PenColor.BLACK. Initially we use black color.
 * There is also a cap and it is initially on.
 * The amount of ink is limited to 100 units. Drawing consumes ink at the
 * rate of 1/100 units per one millimeter. DrawLine has one integer parameter
 * which specifies the length of line to be drawn in millimeters.
 */
public class ExampleUnitTest {
    private Pencil pen;

    @Before
    public void start_testing() {
        pen = new Pencil();
    }

    @Test
    public void drawWhenCapIsOn() throws Exception {
        assertThat(pen.DrawLine(0), is(false));
    }

    @Test
    public void drawWhenCapIsOff() throws Exception {
        pen.PenCap(false);
        assertThat(pen.DrawLine(0), is(true));
    }

    @Test
    public void drawNormalLine() throws Exception {
        pen.PenCap(false);
        assertThat(pen.DrawLine(100), is(true));
    }

    @Test
    public void drawLongLine() throws Exception {
        pen.PenCap(false);
        assertThat(pen.DrawLine(10010), is(false));
    }

    @Test
    public void drawMultipleLines() throws Exception {
        pen.PenCap(false);
        assertThat(pen.DrawLine(9990), is(true));
        assertThat(pen.DrawLine(10), is(true));
        assertThat(pen.DrawLine(10), is(false));
    }

    @Test
    public void drawDifferentColorLines() throws Exception {
        pen.PenCap(false);

        assertThat(pen.DrawLine(9990), is(true));

        pen.ChangeColor(Pencil.PenColor.RED);
        assertThat(pen.DrawLine(10000), is(true));

        pen.ChangeColor(Pencil.PenColor.BLACK);
        assertThat(pen.DrawLine(10), is(true));
    }
}