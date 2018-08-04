package vn.linh.domain.interactor.input

import io.reactivex.Completable
import linh.vn.domain.interactor.outputport.CustomCompletableCustomObserver
import linh.vn.domain.scheduler.SchedulerProvider

abstract class CompleteableUseCase<in I : UseCase.Input>(schedulerProvider: SchedulerProvider)
    : UseCase<I, Completable>(schedulerProvider) {

    fun execute(input: I, observerCustom: CustomCompletableCustomObserver) {
        val observable = this.buildUseCaseObservable(input)
                .subscribeOn(getSubscribeOnScheduler())
                .observeOn(getObserveOnScheduler())
                .doOnSubscribe(observerCustom.onSubscribeConsumer())
                .doAfterTerminate(observerCustom.doAfterTerminateAction())
        subscribe(observable.subscribe(observerCustom.onCompleteAction(), observerCustom.onErrorConsumer()))
    }
}