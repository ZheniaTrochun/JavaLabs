package lab1;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by zhenia on 14.05.17.
 */
public class ArithmiticExprTest {

    @Test
    public void testExpressionCalculator() {
        Assert.assertThat(ArithmeticExpr.expressionCalculator(2, 1, 2, 1), equalTo(1.0));

        Assert.assertThat(ArithmeticExpr.expressionCalculator(1, 1, 1, 1), equalTo(0.0));

        Assert.assertThat(ArithmeticExpr.expressionCalculator(-5, 1, -5, 1), equalTo(0.0));
    }
}
