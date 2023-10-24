package uz.gita.lesson40.data.source

import uz.gita.lesson40.data.api.AuthApi
import uz.gita.lesson40.data.settings.Settings
import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResponse
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi, private val settings: Settings
) : AuthDataSource {
    override var temporaryToken: String?
        get() = settings.temporaryToken
        set(value) {
            settings.temporaryToken = value
        }
    override var code: String?
        get() = settings.code
        set(value) {
            settings.code = value
        }

    override suspend fun signUp(signUpEntity: SignUpEntity): SignUpResponse {
        return authApi.signUp(signUpEntity)
    }
}