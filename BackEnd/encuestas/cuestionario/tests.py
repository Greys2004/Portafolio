from django.urls import reverse
from django.utils import timezone
from django.test import TestCase
from .models import Pregunta,Respuesta
import datetime

# Create your tests here.

# Funcion Compartida

def crear_pregunta(texto_pregunta, dias):
    fecha = timezone.now() + datetime.timedelta(days= dias)
    return Pregunta.objects.create(
        texto_pregunta = texto_pregunta,
        fecha_publicacion = fecha
    )




class RespuestaModelTest(TestCase):
    def test_crear_respuesta_para_pregunta(self):
        pregunta = Pregunta(texto_pregunta = "¿Como estas?", fecha_publicacion = timezone.now())
        pregunta.save()
        
        respuesta = Respuesta(pregunta = pregunta, texto_respuesta = "Estoy bien", votos = 0)
        respuesta.save()
        
        self.assertEqual(respuesta.pregunta, pregunta)
        
    def test_eliminar_pregunta_con_sus_respuestas(self):
        pregunta = Pregunta(texto_pregunta = "¿Qué  te parece la universidad?", fecha_publicacion = timezone.now() )
        pregunta.save()
        
        respuesta_1 = Respuesta(pregunta = pregunta, texto_respuesta = "Me parece bien", votos = 0)
        respuesta_1.save()
        respuesta_2 = Respuesta(pregunta = pregunta, texto_respuesta = "Puede mejorar", votos = 0)
        respuesta_2.save()
        
        pregunta_id = pregunta.id
        respuesta_1_id = respuesta_1.id
        respuesta_2_id = respuesta_2.id
        pregunta.delete()
        
        with self.assertRaises(Pregunta.DoesNotExist):
            Pregunta.objects.get(pk = pregunta_id)
            
        with self.assertRaises(Respuesta.DoesNotExist):
            Respuesta.objects.get(pk = respuesta_1_id)
            
        with self.assertRaises(Respuesta.DoesNotExist):
            Respuesta.objects.get(pk = respuesta_2_id)




class PreguntaIndexView(TestCase):
    def test_listar_preguntas_vacias(self):
        consulta = self.client.get(reverse ("cuestionario:index"))
        self.assertEqual(consulta.status_code, 200)
        self.assertQuerySetEqual(consulta.context["lista_preguntas"], [])
    
    def test_listar_una_pregunta(self):
        pregunta = crear_pregunta(texto_pregunta = "¿Como estas?", dias = 0)

        consulta = self.client.get(reverse ("cuestionario:index"))
        self.assertEqual(consulta.status_code, 200)
        self.assertQuerySetEqual(consulta.context["lista_preguntas"], [pregunta])




class PreguntaDetailViewTest(TestCase):
    def test_detalle_pregunta(self):
        pregunta = crear_pregunta(texto_pregunta = "¿Te gusta la carrera?", dias = -2)
        
        url = reverse("cuestionario:detail", args = (pregunta.id,))
        consulta = self.client.get(url)
        self.assertContains(consulta, pregunta.texto_pregunta)
        
    def test_detalle_no_pregunta(self):
        pregunta_no_existente = 9999
        url = reverse("cuestionario:detail", args = (pregunta_no_existente,))
        consulta = self.client.get(url)
        self.assertEqual(consulta.status_code, 404)
        