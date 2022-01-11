import org.junit.Test
import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        //arrange
        val note = Notes(noteId = 1)

        //act
        val result = NoteService.add(
            note = note
        )

        //assert
        assertEquals(note, result)
    }

    @Test
    fun update() {
        //arrange
        val service = NoteService

        service.add(Notes(noteId = 1))
        service.add(Notes(noteId = 2))
        service.add(Notes(noteId = 3))

        //act
        val update = Notes(noteId = 2)
        val result = service.update(update)

        //  assert
        assertEquals(update, result)
    }
}