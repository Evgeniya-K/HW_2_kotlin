abstract class Attachment(
    open val type: String
)

class Photo(
    val id: Int,
    val ownerId: Int,
    val photo_130: String,
    val photo_604: String
) // сделала класс фото не наследуемым
// возможно по заданию нужно так
data class PhotoAttachment(val photo: Photo, override val type: String): Attachment("photo")
// возможно по заданию нужно так

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
) : Attachment("video")

class Audio(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val artist: String
) : Attachment("audio")

class Graffiti(
    val id: Int,
    val ownerId: Int,
    val photo_130: String,
    val photo_604: String
) : Attachment("graffiti")

class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int
) : Attachment("doc")


