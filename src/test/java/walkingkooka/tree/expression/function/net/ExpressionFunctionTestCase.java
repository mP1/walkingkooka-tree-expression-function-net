/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.TypeNameTesting;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionEvaluationContexts;
import walkingkooka.tree.expression.ExpressionFunctionName;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.ExpressionPurityContext;
import walkingkooka.tree.expression.ExpressionPurityTesting;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionTesting;

public abstract class ExpressionFunctionTestCase<F extends ExpressionFunction<T, ExpressionEvaluationContext>, T> implements ExpressionFunctionTesting<F, T, ExpressionEvaluationContext>,
    ExpressionPurityTesting,
    TypeNameTesting<F>,
    ClassTesting2<F> {

    final static ExpressionNumberKind KIND = ExpressionNumberKind.DEFAULT;

    ExpressionFunctionTestCase() {
        super();
    }

    @Test
    public final void testIsPureTrue() {
        this.isPureAndCheck(
            this.createBiFunction(),
            new ExpressionPurityContext() {
                @Override
                public boolean isPure(final ExpressionFunctionName name) {
                    throw new UnsupportedOperationException();
                }
            },
            true
        );
    }

    @Override
    public ExpressionEvaluationContext createContext() {
        return ExpressionEvaluationContexts.fake();
    }

    @Override
    public final JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }

    @Override
    public final String typeNameSuffix() {
        return "";
    }
}
