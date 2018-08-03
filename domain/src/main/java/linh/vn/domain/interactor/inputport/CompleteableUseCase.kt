package vn.linh.domain.interactor.input

import io.reactivex.Completable
import linh.vn.domain.interactor.outputport.CompletableObserver
import linh.vn.domain.scheduler.SchedulerProvider

abstract class CompleteableUseCase<in I : UseCase.Input>(schedulerProvider: SchedulerProvider)
    : UseCase<I, Completable>(schedulerProvider) {

    fun execute(input: I, observer: CompletableObserver) {
        val observable = this.buildUseCaseObservable(input)
                .subscribeOn(getSubscribeOnScheduler())
                .observeOn(getObserveOnScheduler())
                .doOnSubscribe(observer.onSubscribeConsumer())
                .doAfterTerminate(observer.doAfterTerminateAction())
        subscribe(observable.subscribe(observer.onCompleteAction(), observer.onErrorConsumer()))
    }
}