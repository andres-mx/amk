package com.amk.examen.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
