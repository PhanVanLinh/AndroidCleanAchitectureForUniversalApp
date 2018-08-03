package vn.linh.domain.interactor.input

import io.reactivex.Single
import linh.vn.domain.interactor.outputport.SingleObserver
import linh.vn.domain.scheduler.SchedulerProvider

abstract class SingleUseCase<in I : UseCase.Input, O>(schedulerProvider: SchedulerProvider) : UseCase<I, Single<O>>(schedulerProvider) {

    fun execute(input: I, observer: SingleObserver<O>) {
        val observable = this.buildUseCaseObservable(input)
                .subscribeOn(getSubscribeOnScheduler())
                .observeOn(getObserveOnScheduler())
                .doOnSubscribe(observer.onSubscribeConsumer())
                .doAfterTerminate(observer.doAfterTerminateAction())
        subscribe(observable.subscribe(observer.getSuccessConsumer(), observer.onErrorConsumer()))
    }
}