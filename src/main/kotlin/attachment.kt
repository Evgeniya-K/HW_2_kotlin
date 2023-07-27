abstract class Attachment(
    open val type: String
)

class Photo(
    val id: Int,
    val ownerId: Int,
    val photo_130: String,
    val photo_604: String
)
data class PhotoAttachment(val photo: Photo, override val type: String): Attachment("photo")


class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
)

data class VideoAttachment(val video:Video, override val type: String): Attachment("video")

class Audio(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val artist: String
)

data class AudioAttachment(val audio:Audio, override val type: String): Attachment("audio")
class Graffiti(
    val id: Int,
    val ownerId: Int,
    val photo_130: String,
    val photo_604: String
)

data class GraffitiAttachment(val graffiti:Graffiti, override val type: String): Attachment("graffiti")


class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int
)

data class DocAttachment(val doc:Doc, override val type: String): Attachment("doc")
