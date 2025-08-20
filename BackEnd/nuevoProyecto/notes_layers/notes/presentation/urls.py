from django.urls import path
from notes.presentation import views

urlpatterns = [
    path('', views.index, name='index'),
    path('notes/', views.note_list, name='note_list'),
    path('notes/<int:note_id>', views.note_detail, name='note_detail'),
    path('notes/new', views.note_new, name='note_new'),
    path('notes/<int:note_id>/edit', views.note_edit, name='note_edit'),
    path('notes/<int:note_id>/delete', views.note_delete, name='note_delete'),
]