package test;

import com.google.gwt.junit.client.GWTTestCase;

import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionEvaluationContexts;
import walkingkooka.tree.expression.function.net.NetExpressionFunctions;

public class TestGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
                1,
                1
        );
    }

    public void testEncodeUrl() {
        assertEquals(
                "Hello+Goodbye",
                NetExpressionFunctions.encodeUrl()
                        .apply(
                                Lists.of(
                                        "Hello Goodbye"
                                ),
                                ExpressionEvaluationContexts.fake()
                        )
        );
    }
}
