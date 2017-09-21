package com.amk.examen.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by andresaleman on 9/21/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiInfo {
}
