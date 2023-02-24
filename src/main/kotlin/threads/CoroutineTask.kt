package threads

import kotlinx.coroutines.*
import java.io.Closeable

class AggregateUserDataUseCase(
    private val resolveCurrentUser: suspend () -> UserEntity,
    private val fetchUserComments: suspend (UserId) -> List<CommentEntity>,
    private val fetchSuggestedFriends: suspend (UserId) -> List<FriendEntity>
) : Closeable {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    suspend fun aggregateDataForCurrentUser(): AggregatedData {
        val userEntity = withContext(Dispatchers.IO) {
            resolveCurrentUser.invoke()
        }

        val userCommentsDeferred = scope.async {
            fetchUserComments.invoke(userEntity.id)
        }

        val suggestedFriendsDeferred = scope.async {
            fetchSuggestedFriends.invoke(userEntity.id)
        }

        val userComments = withTimeout(2000L) {
            try {
                userCommentsDeferred.await()
            } catch (e: TimeoutCancellationException) {
                listOf()
            }
        }

        val suggestedFriends = withTimeout(2000L) {
            try {
                suggestedFriendsDeferred.await()
            } catch (e: TimeoutCancellationException) {
                listOf()
            }
        }

        return AggregatedData(userEntity, userComments, suggestedFriends)
    }

    override fun close() {
        scope.cancel()
    }
}

/**
 *
 * The following is already available on classpath.
 * Please do not uncomment this code or modify.
 * This is only for your convenience to copy-paste code into the IDE
 **/

data class AggregatedData(
    val user: UserEntity,
    val comments: List<CommentEntity>,
    val suggestedFriends: List<FriendEntity>
)

typealias UserId = String

data class UserEntity(val id: UserId, val name: String)

data class CommentEntity(val id: String, val content: String)

data class FriendEntity(val id: String, val name: String)

