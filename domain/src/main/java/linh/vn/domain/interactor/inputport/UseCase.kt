package vn.linh.domain.interactor.input

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import linh.vn.domain.scheduler.SchedulerProvider

abstract class UseCase<in I : UseCase.Input, O>(private val schedulerProvider: SchedulerProvider) {

    private val compositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(input: I): O

    fun subscribe(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun dispose() {
        compositeDisposable.clear()
    }

    protected open fun getSubscribeOnScheduler(): Scheduler {
        return schedulerProvider.io()
    }

    protected open fun getObserveOnScheduler(): Scheduler {
        return schedulerProvider.ui()
    }

    abstract class Input

    open class EmptyInput private constructor() : Input() {

        companion object {

            fun instance(): EmptyInput {
                return EmptyInput()
            }
        }
    }
}