abstract class Attachment(
    val type: String
)

class Photo(
    val id: Int,
    val ownerId: Int,
    val photo_130: String,
    val photo_604: String
) : Attachment("photo")

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


