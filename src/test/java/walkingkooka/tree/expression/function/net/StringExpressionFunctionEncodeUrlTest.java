/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.tree.expression.function.net;

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.tree.expression.ExpressionEvaluationContext;

public final class StringExpressionFunctionEncodeUrlTest extends StringExpressionFunctionTestCase<StringExpressionFunctionEncodeUrl<ExpressionEvaluationContext>, String> {

    @Test
    public void testEncodedUnnecessary() {
        this.applyAndCheck2(
            parameters("abc123"),
            "abc123"
        );
    }

    @Test
    public void testEncodedSpaceWithPlus() {
        this.applyAndCheck2(
            parameters("abc def"),
            "abc+def"
        );
    }

    @Test
    public void testEncoded() {
        this.applyAndCheck2(
            parameters("x+123"),
            "x%2B123"
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(
            this.createBiFunction(),
            "encodeUrl"
        );
    }

    @Override
    public StringExpressionFunctionEncodeUrl<ExpressionEvaluationContext> createBiFunction() {
        return StringExpressionFunctionEncodeUrl.instance();
    }

    @Override
    public int minimumParameterCount() {
        return 1;
    }

    @Override
    public Class<StringExpressionFunctionEncodeUrl<ExpressionEvaluationContext>> type() {
        return Cast.to(StringExpressionFunctionEncodeUrl.class);
    }
}
