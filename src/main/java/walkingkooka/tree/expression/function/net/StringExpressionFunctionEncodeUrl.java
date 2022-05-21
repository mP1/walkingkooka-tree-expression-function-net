
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

import walkingkooka.Cast;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * A function that cleans (removes unprintable control characters from the given {@link String}.
 */
final class StringExpressionFunctionEncodeUrl<C extends ExpressionEvaluationContext> extends StringExpressionFunction<C> {
    /**
     * Instance getter.
     */
    static <C extends ExpressionEvaluationContext> StringExpressionFunctionEncodeUrl<C> instance() {
        return Cast.to(INSTANCE);
    }

    /**
     * Singleton
     */
    private static final StringExpressionFunctionEncodeUrl<?> INSTANCE = new StringExpressionFunctionEncodeUrl<>();

    /**
     * Private ctor
     */
    private StringExpressionFunctionEncodeUrl() {
        super("encodeUrl");
    }

    @Override
    public String apply(final List<Object> parameters,
                        final C context) {
        this.checkParameterCount(parameters);

        try {
            return URLEncoder.encode(
                    TEXT.getOrFail(parameters, 0),
                    "UTF-8"
            );
        } catch (final UnsupportedEncodingException e) {
            throw new Error("Unable to encode with UTF-8", e); // shouldnt happen
        }
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(TEXT);
}
