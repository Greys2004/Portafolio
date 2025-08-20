from django.contrib.auth.decorators import login_required
from django.http import HttpResponseForbidden
from django.shortcuts import render, redirect
from notes.service.note_service import NoteService

note_service = NoteService()

""" 
    Mostrar el inicio de la pagina. Redirecciona si ya esta iniciada la sesion
    O manda a la vista para iniciar sesion
"""
def index(request):
    if request.user.is_authenticated:
        return redirect('note_list')
    else:
        return redirect('login')
    
    

""" Mostrar el listado de las notas del usuario"""
@login_required
def note_list(request):
    notes = note_service.get_all_notes_by_user(request.user.id)
    return render(request, 'notes/note_list.html', {'notes': notes})



@login_required
def note_detail(request, note_id):
    """Muestra los detalles de una nota específica."""
    note = note_service.get_note_by_id(note_id)

    if not note or note.user_id != request.user.id:
        return HttpResponseForbidden()

    return render(request, 'notes/note_detail.html', {'note': note})


@login_required
def note_new(request):
    """Crea una nueva nota."""
    if request.method == "POST":
        title = request.POST.get('title')
        content = request.POST.get('content')

        note = note_service.create_note(
            user_id=request.user.id,
            title=title,
            content=content
        )

        return redirect('note_detail', note_id=note.id)

    return render(request, 'notes/note_edit.html', {})


@login_required
def note_edit(request, note_id):
    """Edita una nota existente."""
    note = note_service.get_note_by_id(note_id)

    # Verificar que la nota existe y pertenece al usuario
    if not note or note.user_id != request.user.id:
        return HttpResponseForbidden()

    if request.method == "POST":
        title = request.POST.get('title')
        content = request.POST.get('content')

        note_service.update_note(
            note_id=note_id,
            title=title,
            content=content
        )

        return redirect('note_detail', note_id=note_id)

    return render(request, 'notes/note_edit.html', {'note': note})


@login_required
def note_delete(request, note_id):
    """Elimina una nota desde un enlace GET (menos seguro)."""
    # Verifica si el usuario es el dueño de la nota
    if not note_service.is_note_owner(request.user.id, note_id):
        return HttpResponseForbidden("No tienes permiso para eliminar esta nota.")

    note_service.delete_note(note_id)
    return redirect('note_list')
    