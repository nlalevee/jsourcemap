/*
 *  Copyright 2015 JSourceMap contributors
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.hibnet.jsourcemap;

import static org.junit.Assert.assertEquals;

import org.hibnet.jsourcemap.Base64VLQ.Base64VLQResult;
import org.junit.Test;

public class Base64VLQTest {

    @Test
    public void testNormalEncodingAndDecoding() throws Exception {
        Base64VLQResult result;
        for (int i = -255; i < 256; i++) {
            String str = Base64VLQ.encode(i);
            result = Base64VLQ.decode(str, 0);
            assertEquals(result.value, i);
            assertEquals(result.rest, str.length());
        }

    }
}
