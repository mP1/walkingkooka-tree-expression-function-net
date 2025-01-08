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

import walkingkooka.collect.list.Lists;
import walkingkooka.collect.set.Sets;
import walkingkooka.net.Url;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.provider.ExpressionFunctionProvider;
import walkingkooka.tree.expression.function.provider.ExpressionFunctionProviders;

import java.util.function.Consumer;

/**
 * Collection of static factory methods for numerous {@link ExpressionFunction}.
 */
public final class NetExpressionFunctions implements PublicStaticHelper {

    /**
     * An {@link ExpressionFunctionProvider} with all the functions in this project.
     */
    public static ExpressionFunctionProvider expressionFunctionProvider(final CaseSensitivity nameCaseSensitivity) {
        return ExpressionFunctionProviders.basic(
            Url.parseAbsolute("https://github.com/mP1/walkingkooka-tree-expression-function-net/"),
            nameCaseSensitivity,
            Sets.of(
                encodeUrl()
            )
        );
    }

    /**
     * Visit all {@link ExpressionFunction functions}.
     */
    public static void visit(final Consumer<ExpressionFunction<?, ?>> consumer) {
        Lists.of(
            encodeUrl()
        ).forEach(consumer);
    }

    /**
     * {@see StringExpressionFunctionEncodeUrl}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<String, C> encodeUrl() {
        return StringExpressionFunctionEncodeUrl.instance();
    }

    /**
     * Stops creation
     */
    private NetExpressionFunctions() {
        throw new UnsupportedOperationException();
    }
}
