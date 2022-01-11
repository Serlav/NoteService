fun main() {
    val original = Notes(noteId = 1)
    val original2 = Notes(noteId = 2)
    val original3 = Notes(noteId = 3)
    val original4 = Notes(noteId = 2)

    println(Notes())

    NoteService.add(original)
    NoteService.add(original2)
    NoteService.add(original3)
//    NoteService.read()
    NoteService.update(original4)

    NoteService.delete(original3)

    println(Notes())
}

object NoteService {
    private var notes = mutableListOf<Notes>()

    fun add(note: Notes): Notes {
        if (notes.isEmpty()) {
            note.noteId = 0
        } else {
            note.noteId = notes.last().noteId + 1
        }
        notes += note
        println(note.noteId)
        return notes.last()
    }

//    fun read() {
//        TODO()
//    }

    fun update(newNote: Notes) {
        for ((index, note) in notes.withIndex()) {
            if (newNote.noteId == note.noteId) {
                notes[index] = newNote.copy(noteId = note.noteId)
            }
        }
    }


    fun delete(removeNote: Notes) {
        for ((index, note) in notes.withIndex()) {
            if (removeNote.noteId == note.noteId) {
                notes.removeAt(index)
            }
        }
    }
}


data class Notes(
    var noteId: Int = 0,
    val add: Add = Add(),
    val createComment: CreateComment = CreateComment(),
    val delete: Delete = Delete(),
    val deleteComment: DeleteComment = DeleteComment(),
    val edit: Edit = Edit(),
    val editComment: EditComment = EditComment(),
    val get: Get = Get(),
    val getById: GetById = GetById(),
    val getComments: GetComments = GetComments(),
    val getFriendsNotes: GetFriendsNotes = GetFriendsNotes(),
    val restoreComment: RestoreComment = RestoreComment()
)

class Add(
    val title: String = "",
    val text: String = ""
)

class CreateComment(
    val noteId: Int = 0,
    val ownerId: Int = 0,
    val replayTo: Int = 0,
    val message: String = "",
    val guid: String = "",
)

class Delete(
    val noteId: Int = 0
)

class DeleteComment(
    val commentId: Int = 0,
    val ownerId: Int = 0
)

class Edit(
    val noteId: Int = 0,
    val title: String = "",
    val text: String = ""
)

class EditComment(
    val commentId: Int = 0,
    val ownerId: Int = 0,
    val message: String = ""
)

class Get(
    val noteIds: String = "",
    val userId: Int = 0,
    val offset: Int = 0,
    val count: Int = 0
)

class GetById(
    val noteId: Int = 0,
    val ownerId: Int = 0
)

class GetComments(
    val noteId: Int = 0,
    val ownerId: Int = 0,
    val sort: Int = 0,
    val offset: Int = 0,
    val count: Int = 0
)

class GetFriendsNotes(
    val offset: Int = 0,
    val count: Int = 0
)

class RestoreComment(
    val commentId: Int = 0,
    val ownerId: Int = 0
)