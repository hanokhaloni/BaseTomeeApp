/**
 * Created by IntelliJ IDEA.
 * User: Aviram Dayan
 * Date: 16/02/13
 * Time: 16:54
 *
 *<a href=mailto:avdayan@cs.bgu.ac.il>avdayan@cs.bgu.ac.il</a>
 */
package com.scouter.commons.instrument;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@InterceptorBinding
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface TimeOf {
}