package com.amk.examen.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by andresaleman on 9/21/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}