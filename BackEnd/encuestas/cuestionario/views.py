from django.shortcuts import render

# Create your views here.
from django.contrib.auth.mixins import LoginRequiredMixin
from django.contrib.auth.decorators import login_required

from django.db.models import F
from django.http import HttpResponse, Http404, HttpResponseRedirect
from django.shortcuts import render, get_object_or_404
from django.urls import reverse
from django.template import loader
from django.views import generic
from .models import Pregunta, Respuesta

# Lista de las preguntas
def index(request):
    #lista_preguntas = Pregunta.objects.all()
    #plantilla = loader.get_template("cuestionario/index.html")
    
    lista_preguntas_reciente = Pregunta.objects.order_by("-fecha_publicacion")[:5]
    contexto = {
        'lista_preguntas': lista_preguntas_reciente,
    }
    #return HttpResponse(plantilla.render(contexto, request))
    return render(request, "cuestionario/index.html", contexto)

class IndexView(LoginRequiredMixin, generic.ListView):
    template_name = "cuestionario/index.html"
    context_object_name = "lista_preguntas"

    def get_queryset(self):
        return Pregunta.objects.order_by("-fecha_publicacion")[:5]



#Detalle de la pregunta
def detail(request, pregunta_id):
    # return HttpResponse(f"Estas viendo la pregunta {pregunta_id}.")
    # return HttpResponse("Estas viendo una pregunta en especifico.")
    # try:
    #     pregunta = Pregunta.objects.get(id=pregunta_id)
    # except Pregunta.DoesNotExist:
    #     raise Http404("Pregunta no encontrada.")
    pregunta = get_object_or_404(Pregunta, pk = pregunta_id)
    return render(request, "cuestionario/detail.html", {'pregunta': pregunta})

class DetailView(LoginRequiredMixin, generic.DetailView):
    model = Pregunta
    template_name = "cuestionario/detail.html"




def results(request, pregunta_id):
    # return HttpResponse("Estas viendo los resultados de la pregunta.")
    # return HttpResponse(f"Estas viendo los resultados de la pregunta {pregunta_id}.")
    pregunta = get_object_or_404(Pregunta, pk = pregunta_id)
    return render(request, "cuestionario/results.html", {'pregunta': pregunta})

class ResultsView(LoginRequiredMixin, generic.DetailView):
    model = Pregunta
    template_name = "cuestionario/results.html"


@login_required
def vote(request, pregunta_id):
    #return HttpResponse("Esta es la seccion ara votar con una respuesta.")
    pregunta = get_object_or_404(Pregunta, pk=pregunta_id)
    try:
        respuesta_seleccionada = pregunta.respuesta_set.get(pk=request.POST['respuesta'])
    except(KeyError, Respuesta.DoesNotExist):
        return render(
            request,
            "cuestionario/detail.html",
            {"pregunta": pregunta,
            "error_message": "No has seleccionado una respuesta"}
        )
    else:
        respuesta_seleccionada.votos = F('votos') + 1
        respuesta_seleccionada.save()
        return HttpResponseRedirect(reverse("cuestionario:results", args=(pregunta.id,)))