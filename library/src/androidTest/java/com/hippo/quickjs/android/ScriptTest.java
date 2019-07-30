/*
 * Copyright 2019 Hippo Seven
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
 */

package com.hippo.quickjs.android;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScriptTest {

  @Test
  public void fibonacci() {
    QuickJS quickJS = new QuickJS.Builder().build();
    try (JSRuntime runtime = quickJS.createJSRuntime()) {
      try (JSContext context = runtime.createJSContext()) {
        String script = "" +
            "function fibonacci(n) {" +
            "  if (n == 0 || n == 1) return n;" +
            "  return fibonacci(n - 1) + fibonacci(n - 2);" +
            "}" +
            "fibonacci(10);";
        int result = context.evaluate(script, "fibonacci.js", int.class);
        assertEquals(55, result);
      }
    }
  }
}
