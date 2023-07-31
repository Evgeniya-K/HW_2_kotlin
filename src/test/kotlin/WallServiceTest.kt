import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

   @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
      val result = WallService.add(Post(ownerId = 16, fromId = 1,))
      assertEquals(1, result.id)

    }

    @Test
    fun updateExisting() {
       WallService.add(Post(ownerId = 16, fromId = 1, text = "первый пост"))
       WallService.add(Post(ownerId = 20, fromId = 7, text = "второй пост"))
       val result = WallService.update(Post(id = 2, ownerId = 87, fromId = 16, text = "изменения" , comments = Comments(6)))
       assertTrue(result)


    }

    @Test
    fun updateNotExisting() {
        WallService.add(Post(ownerId = 16, fromId = 1, text = "первый пост", comments = Comments()))
        WallService.add(Post(ownerId = 20, fromId = 7, text = "второй пост", comments = Comments()))
        val result = WallService.update(Post(id = 9, ownerId = 87, fromId = 16, text = "изменения" , comments = Comments(6)))
        assertFalse(result)

    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.add(Post(ownerId = 16, fromId = 1, text = "первый пост", comments = Comments()))
        WallService.add(Post(ownerId = 20, fromId = 7, text = "второй пост", comments = Comments()))
        val resalt = WallService.createComment(15, Comment(text = "это провал")) ?: throw PostNotFoundException ("пост не найден")
    }

    @Test
    fun createComment(){
        val comment: Comment = Comment(text = "тут должен добавиться комментарий")
        WallService.add(Post(ownerId = 16, fromId = 1, text = "первый пост", comments = Comments()))
        WallService.add(Post(ownerId = 20, fromId = 7, text = "второй пост", comments = Comments()))
        WallService.createComment(1,comment)
        val result = WallService.get(0).comment.equals(comment)

        assertTrue(result)
    }

}