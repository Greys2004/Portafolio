from typing import List, Optional
from notes.domain.schemas import NoteEntity
from notes.persistence.repositories import NoteRepository

class NoteService:
    """Servicio para manejar operaciones con notas"""

    def __init__(self, repository=None):
        """Constructor del servicio de notas"""
        self.repository = repository or NoteRepository()
        
    def is_note_owner(self, user_id: int, note_id: int) -> bool:
        """Verifica si un usuario es dueño de una nota"""
        note_entity = self.repository.get_by_id(note_id)
        if not note_entity:
            return False
        return note_entity.user_id == user_id
    
    def get_all_notes_by_user(self, user_id: int) -> List[NoteEntity]:
        """Obtiene todas las notas de un usuario"""
        return self.repository.get_all_by_user(user_id)
    
    def get_note_by_id(self, note_id: int) -> Optional[NoteEntity]:
        """Obtiene una nota por su identificador"""
        return self.repository.get_by_id(note_id)
    
    def create_note(self, user_id: int, title: str, content: str) -> NoteEntity:
        """Crea una nueva nota"""
        note_entity = NoteEntity.create(user_id, title, content)
        return self.repository.create(note_entity)
    
    def update_note(self, note_id: int, title: str, content: str) -> Optional[NoteEntity]:
        """Actualiza una nota existente"""
        note_entity = self.repository.get_by_id(note_id)
        if not note_entity:
            return None
        note_entity.title = title
        note_entity.content = content
        return self.repository.update(note_entity)
    
    def delete_note(self, note_id: int) -> bool:
        """Elimina una nota por su ID"""
        return self.repository.delete(note_id)
