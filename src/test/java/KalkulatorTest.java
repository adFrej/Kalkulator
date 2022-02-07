import junit.framework.Assert;
import junit.framework.TestCase;

public class KalkulatorTest extends TestCase {

    public void testGiven23WhenAddThen5() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(5, kalk.add(2,3));
    }

    public void testGiven00WhenAddThen0() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(0, kalk.add(0,0));
    }

    public void testGiven_55WhenAddThen0() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(0, kalk.add(-5,5));
    }

    public void testGiven52WhenSubstractThen3() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(3, kalk.substract(5,2));
    }

    public void testGiven510WhenSubstractThen_5() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(-5, kalk.substract(5,10));
    }

    public void testGiven55WhenSubstractThen0() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(0, kalk.substract(5,5));
    }

    public void testGiven52WhenMultiplyThen10() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(10, kalk.multiply(5,2));
    }

    public void testGiven50WhenMultiplyThen0() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(0, kalk.multiply(5,0));
    }

    public void testGiven_45WhenMultiplyThen_20() {
        Kalkulator kalk = new Kalkulator();
        Assert.assertEquals(-20, kalk.multiply(-4,5));
    }

    public void testGiven25WhenPowerThen32() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(32, kalk.power(2,5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven_25WhenPowerThen_32() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(-32, kalk.power(-2,5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven05WhenPowerThen0() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(0, kalk.power(0,5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven52WhenDivideThen2_5() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(2.5, kalk.divide(5,2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven11WhenDivideThen1() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(1.0, kalk.divide(1,1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven103WhenDivideThen3_333() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(3.334, kalk.divide(10,3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven3WhenFactorialThen6() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(6, kalk.factorial(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven5WhenFactorialThen120() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(120, kalk.factorial(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGiven0WhenFactorialThen1() {
        Kalkulator kalk = new Kalkulator();
        try {
            Assert.assertEquals(1, kalk.factorial(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}