package test;

import com.google.gwt.junit.client.GWTTestCase;

import walkingkooka.collect.list.Lists;
import walkingkooka.j2cl.locale.LocaleAware;
import walkingkooka.tree.expression.ExpressionEvaluationContexts;
import walkingkooka.tree.expression.function.net.NetExpressionFunctions;

@LocaleAware
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
