import java.lang.RuntimeException

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int? = null,
    val date: Int = 1690382750,
    val text: String = "тестовый текст",
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val postType: String = "reply",
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val isFavorite: Boolean = true,
    val comments: Comments = Comments(),
    val copyright: Copyright? = null,
    val geo: Geo? = null,
    val attachments: Array<Attachment> = emptyArray(),
    val likes: Likes? = null,
    val reposts: Repost? = null,
    val views: Views = Views(),
    val signerId: Int? = null,
    val canPin : Boolean = true,
    val markedAsAds : Boolean = false,
    val postponedId: Int? = null,
    val comment : Comment = Comment()

)

data class Comments (
    val count : Int = 0,
    val can_post : Boolean = true,
    val groupsCanCost : Boolean = true,
    val canClose : Boolean = true,
    val canOpen : Boolean = true,
    )

data class Views( val count: Int = 0)
data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Repost(
    val count: Int,
    val user_reposted: Boolean
)

data class Place(val title: String = "марсово поле")

data class Geo(
    val place: Place? = null,
    val type: String,
    val coordinates: String
    )

data class Comment(
    val id: Int = 1,
    val fromId: Int = 13,
    val date: Int = 1690382750,
    val text: String = "",
    val attachments: Array<Attachment> = emptyArray()
)
class PostNotFoundException (message: String) : RuntimeException (message)
object WallService {
    private var posts = emptyArray<Post>()
    private var id = 1
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, mycomment: Comment): Comment? {
            for ((index, post) in posts.withIndex()) {
                if (post.id == postId) {
                    posts[index] = post.copy(comment = mycomment)
                    return posts[index].comment
                }
            }
        return null
    }



    fun add(post: Post): Post {
        posts += post.copy(id = id)
        id +=1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index,oldPost) in posts.withIndex()){
            if (oldPost.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        id = 1
    }

    fun get(index: Int): Post {
        return posts[index]
    }
}

fun main() {



}