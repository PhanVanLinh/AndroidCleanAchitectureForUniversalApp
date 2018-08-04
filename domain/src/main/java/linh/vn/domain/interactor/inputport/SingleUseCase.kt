package vn.linh.domain.interactor.input

import io.reactivex.Single
import linh.vn.domain.interactor.outputport.CustomSingleCustomObserver
import linh.vn.domain.scheduler.SchedulerProvider

abstract class SingleUseCase<in I : UseCase.Input, O>(schedulerProvider: SchedulerProvider) : UseCase<I, Single<O>>(schedulerProvider) {

    fun execute(input: I, observerCustom: CustomSingleCustomObserver<O>) {
        val observable = this.buildUseCaseObservable(input)
                .subscribeOn(getSubscribeOnScheduler())
                .observeOn(getObserveOnScheduler())
                .doOnSubscribe(observerCustom.onSubscribeConsumer())
                .doAfterTerminate(observerCustom.doAfterTerminateAction())
        subscribe(observable.subscribe(observerCustom.getSuccessConsumer(), observerCustom.onErrorConsumer()))
    }
}