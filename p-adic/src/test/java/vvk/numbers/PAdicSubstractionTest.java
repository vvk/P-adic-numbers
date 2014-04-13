/*
The MIT License (MIT)

Copyright (c) 2014 Vladislav Kaverin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package vvk.numbers;

import org.junit.Assert;
import org.junit.Test;

public class PAdicSubstractionTest {

    @Test
    public void testSubstraction() {
        final int base = 5;

        PAdic rat = new PAdic(1, 5, 5);
        PAdic point = new PAdic("0.1", 5);

        PAdic zero = new PAdic("0", 5);

        Assert.assertEquals(rat.substract(point), zero);
        Assert.assertEquals(point.substract(rat), zero);

        PAdic one = new PAdic("1", 5);
        Assert.assertEquals(one.substract(one).getOrder(), zero.getOrder());
        Assert.assertEquals(one.substract(one), zero);

        PAdic one3 = new PAdic("11.1", 5);
        PAdic one1 = new PAdic("10", 5);

        PAdic result = new PAdic("0.1", 5);
        Assert.assertEquals(one3.substract(one1).substract(one), result);

        PAdic point1 = new PAdic("1.0", 5);
        PAdic point2 = new PAdic("0.2", 5);
        PAdic point3 = new PAdic("0.3", 5);

        Assert.assertEquals(point2, point1.substract(point3));
        Assert.assertEquals(point3, point1.substract(point2));
        Assert.assertEquals(zero, zero.substract(zero));
        Assert.assertEquals(point1, point1.substract(zero));
        Assert.assertEquals(zero,point1.substract(point1));
        Assert.assertEquals(zero,point2.substract(point2));

        PAdic x = new PAdic("1231.0012", 5);
        PAdic y = new PAdic("13211", 5);
        result = new PAdic("444444444444444444444444444444444444444444444444444444433020.0012", base);

        Assert.assertEquals(result, x.substract(y));

        result = new PAdic("11424.4433", base);

        Assert.assertEquals(result, y.substract(x));

        y = new PAdic("1.23", base);
        result = new PAdic("444444444444444444444444444444444444444444444444444444443220.2233", base);

        Assert.assertEquals(result, y.substract(x));

        x = new PAdic("12321.1232", base);
        y = new PAdic("13.21", base);
        result = new PAdic("12302.4132", base);
        Assert.assertEquals(result, x.substract(y));

        x = new PAdic("0.1", base);
        y = new PAdic("0.0001", base);
        result = new PAdic("0.0444", base);

        Assert.assertEquals(result, x.substract(y));
  }
}
