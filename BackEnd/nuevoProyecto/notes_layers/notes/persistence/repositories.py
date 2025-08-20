from django.contrib.auth.models import User
from notes.persistence.models import Note
from notes.domain.schemas import NoteEntity
from typing import Optional

class NoteRepository:
    
    """Obtener las notas de un usuario."""
    @staticmethod
    def get_all_by_user(user_id : int) -> list[NoteEntity]:
        notes = Note.objects.filter(user_id=user_id)
        return [NoteEntity(
            id=note.id,
            user_id=note.user.id,
            title=note.title,
            content=note.content,
            creation_date=note.creation_date
        ) for note in notes]
    
    """Obtener una nota por su ID."""
    def get_by_id(self, note_id: int) -> Optional[NoteEntity]:
        try:
            note = Note.objects.get(id=note_id)
            return NoteEntity(
                id=note.id,
                user_id=note.user.id,
                title=note.title,
                content=note.content,
                creation_date=note.creation_date
            )
        except Note.DoesNotExist:
            return None

    
    """Crear una nueva nota en la base de datos"""
    @staticmethod
    def create(note_entity: NoteEntity) -> NoteEntity:
        user = User.objects.get(id=note_entity.user_id)
        note = Note.objects.create(
            user =user,
            title=note_entity.title,
            content=note_entity.content,
            creation_date=note_entity.creation_date
        )
        note_entity.id = note.id
        return note_entity
    
    """Actualizar una nota existente en la base de datos"""
    @staticmethod
    def update(note_entity: NoteEntity) -> NoteEntity:
        note = Note.objects.get(id=note_entity.id)
        
        note.title = note_entity.title
        note.content = note_entity.content
        note.save()
        
        return note_entity
    
    """Eliminar una nota de la base de datos"""
    @staticmethod
    def delete(note_id: int) -> bool:
        try:
            note = Note.objects.get(id=note_id)
            note.delete()
            return True
        except Note.DoesNotExist:
            return False