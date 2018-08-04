package linh.vn.domain.interactor

import io.reactivex.Single
import linh.vn.domain.entity.User
import linh.vn.domain.repository.UserRepository
import linh.vn.domain.scheduler.SchedulerProvider
import vn.linh.domain.interactor.input.SingleUseCase
import vn.linh.domain.interactor.input.UseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(scheduler: SchedulerProvider, private val userRepository: UserRepository)
    : SingleUseCase<LoginUseCase.Input, User>(scheduler) {

    override fun buildUseCaseObservable(input: Input): Single<User> {
        return userRepository.login(input.name, input.password)
    }

    data class Input(var name: String, var password: String) : UseCase.Input()
}