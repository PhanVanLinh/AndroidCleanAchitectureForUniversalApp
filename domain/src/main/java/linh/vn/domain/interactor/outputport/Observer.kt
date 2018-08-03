package linh.vn.domain.interactor.outputport

import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

abstract class Observer {

    internal fun onErrorConsumer(): Consumer<in Throwable> {
        return Consumer { onError(it) }
    }

    internal fun onSubscribeConsumer(): Consumer<Any> {
        return Consumer { onSubscribe() }
    }

    internal fun doAfterTerminateAction(): Action {
        return Action { doAfterTerminate() }
    }

    open fun onError(throwable: Throwable) {}

    open fun onSubscribe() {}

    open fun doAfterTerminate() {}

}