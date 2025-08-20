from django.contrib import admin

# Register your models here.
from . models import Pregunta, Respuesta

# class RespuestaInline(admin.StackedInline):
    
class RespuestaInline(admin.TabularInline):
    model = Respuesta
    extra = 3

class PreguntaAdmin(admin.ModelAdmin):
    # fields = [ 'fecha_publicacion','texto_pregunta']
    fieldsets = [
        ('Informacion de la pregunta', {'fields': ['texto_pregunta']}),
        ('Informacion de la fecha', {'fields': ['fecha_publicacion']})
    ]
    inlines = [RespuestaInline]
    list_display = ('texto_pregunta', 'fecha_publicacion','fue_publicada_recientemente')
    list_filter = ['fecha_publicacion']
    search_fields = ['texto_pregunta']
    
admin.site.register(Pregunta, PreguntaAdmin)
# admin.site.register(Respuesta)