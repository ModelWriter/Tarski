/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.recognizer;

class AnnotationSources{
    public final static String BASE = "http://www.modelwriter.eu/AlloyInEcore";
    public final static String IMPORT = AnnotationSources.BASE + "/import";
    public static final String MODULE = AnnotationSources.BASE + "/module";
    public static final String OPTIONS = AnnotationSources.BASE + "/options";

    public final static String VISIBILITY = AnnotationSources.BASE + "/visibility";
    public final static String STATIC = AnnotationSources.BASE + "/static";
    public final static String QUALIFIER = AnnotationSources.BASE + "/qualifier";
    public final static String NULLABLE = AnnotationSources.BASE + "/nullable";
    public final static String MODEL = AnnotationSources.BASE + "/model";
    public final static String GHOST = AnnotationSources.BASE + "/ghost";

    public final static String ATTR_EXPRESSIONS = AnnotationSources.BASE + "/attribute/expressions";
    public final static String REF_EXPRESSIONS = AnnotationSources.BASE + "/reference/expressions";

    public final static String INVARIANT = AnnotationSources.BASE + "/expression/invariant";
    public static final String INITIAL = AnnotationSources.BASE + "/expression/initial";
    public static final String DERIVATION = AnnotationSources.BASE + "/expression/derivation";

    public final static String PRECONDITION = AnnotationSources.BASE + "/operation/precondition";
    public final static String POSTCONDITION = AnnotationSources.BASE + "/operation/postcondition";
    public final static String BODY = AnnotationSources.BASE + "/operation/body";

    public final static String DATATYPE_PRIMITIVE = AnnotationSources.BASE + "/dataType/primitive";

    public static final String EXCEPTION = AnnotationSources.BASE + "/exception";
}