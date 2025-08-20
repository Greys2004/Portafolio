from django.db import models
from django.contrib.auth.models import User


# TABLA DE BASE DE DATOS PARA LAS NOTAS
class Note(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    title = models.CharField(max_length=200)
    content = models.TextField()
    creation_date = models.DateTimeField(auto_now_add=True)
    
    def __str__(self):
        return self.title

    # Le digo a django 
    class Meta:
        ordering = ['-creation_date']