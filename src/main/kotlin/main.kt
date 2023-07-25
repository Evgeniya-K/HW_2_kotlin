

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val text: String = "тестовый текст",
    val friendsOnly: Boolean = false,
    val postType: String = "reply",
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val isFavorite: Boolean = true,
    val comments: Comments
)

data class Comments (
    val count : Int = 0,
    val groupsCanCost : Boolean = true,
    val canClose : Boolean = true,
    val canOpen : Boolean = true
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
}

fun main() {

    WallService.add(Post(ownerId = 16, fromId = 1, comments = Comments()))
    WallService.add(Post(ownerId = 16, fromId = 1, comments = Comments()))
    WallService.update(Post(id = 2, ownerId = 87, fromId = 16, text = "изменения" ,comments = Comments(6)))


}