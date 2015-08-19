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

public class ConsumerMapping {

    public Integer generatedLine;

    public Integer generatedColumn;

    public Integer originalLine;

    public Integer originalColumn;

    public Integer source;

    public Integer name;

    public Integer lastGeneratedColumn;

    public ConsumerMapping() {
        // TODO Auto-generated constructor stub
    }

    public ConsumerMapping(Integer generatedLine, Integer generatedColumn) {
        this.generatedLine = generatedLine;
        this.generatedColumn = generatedColumn;
    }

    public ConsumerMapping(Integer generatedLine, Integer generatedColumn, Integer originalLine, Integer originalColumn, Integer source) {
        this.generatedLine = generatedLine;
        this.generatedColumn = generatedColumn;
        this.originalLine = originalLine;
        this.originalColumn = originalColumn;
        this.source = source;
    }

    public ConsumerMapping(Integer generatedLine, Integer generatedColumn, Integer originalLine, Integer originalColumn, Integer source,
            Integer name) {
        this.generatedLine = generatedLine;
        this.generatedColumn = generatedColumn;
        this.originalLine = originalLine;
        this.originalColumn = originalColumn;
        this.source = source;
        this.name = name;
    }

    public ConsumerMapping(Integer generatedLine, Integer generatedColumn, Integer lastGeneratedColumn) {
        this.generatedLine = generatedLine;
        this.generatedColumn = generatedColumn;
        this.lastGeneratedColumn = lastGeneratedColumn;
    }

}
