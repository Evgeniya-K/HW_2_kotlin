data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
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
    val count : Int = 1,
    val groupsCanCost : Boolean = true,
    val canClose : Boolean = true,
    val canOpen : Boolean = true
    )

object WallService {
    private val post = emptyArray<Post>()

}

fun main() {
    val post = Post(id = 15, ownerId = 16, fromId = 1, comments = Comments())
}