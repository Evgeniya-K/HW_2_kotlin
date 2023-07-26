

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val created_by: Int? = null,
    val date: Int = 1690382750,
    val text: String = "тестовый текст",
    val reply_owner_id: Int? = null,
    val reply_post_id: Int? = null,
    val friendsOnly: Boolean = false,
    val postType: String = "reply",
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val isFavorite: Boolean = true,
    val comments: Comments,
    val copyright: Copyright? = null,
    val geo: Geo? = null,
    val attachments: Array<Attachment> = emptyArray()

)

data class Comments (
    val count : Int = 0,
    val can_post : Boolean = true,
    val groupsCanCost : Boolean = true,
    val canClose : Boolean = true,
    val canOpen : Boolean = true
    )

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Place(val title: String = "марсово поле")

data class Geo(
    val place: Place? = null,
    val type: String,
    val coordinates: String
    )


object WallService {
    private var posts = emptyArray<Post>()
    private var id = 1
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
}

fun main() {


}