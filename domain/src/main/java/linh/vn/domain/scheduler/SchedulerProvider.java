package linh.vn.domain.scheduler;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
