"""
    Los esquemas representan las entidades que manejara la logica de negocios
"""
# Modelo = lo usa la base de datos
# Esquema = lo usa la logica de negocios (lado del software)
from dataclasses import dataclass
from datetime import datetime
from typing import Optional

"""
    Entidad que representa a la nota
"""
@dataclass
class NoteEntity:
    id: Optional[int]
    user_id: int
    title: str
    content: str
    creation_date: datetime
    
    # Manipular el metodo de create
    @classmethod
    def create(cls, user_id : int, title : str, content : str):
        "Se crea una instancia de la entidad de Note"
        
        return cls(
            id=None,
            user_id=user_id,
            title=title,
            content=content,
            creation_date=datetime.now()
        )
    
    