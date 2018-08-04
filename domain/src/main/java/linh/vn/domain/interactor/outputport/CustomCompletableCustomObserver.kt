package linh.vn.domain.interactor.outputport

import io.reactivex.functions.Action

abstract class CustomCompletableCustomObserver : CustomObserver() {

    internal fun onCompleteAction(): Action {
        return Action { onCompleted() }
    }

    open fun onCompleted() {}

}