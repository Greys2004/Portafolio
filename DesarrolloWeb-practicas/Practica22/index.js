let resultado = document.getElementById("resultado");

let asignar = (valor)=> resultado.value += valor;

let historialCalculos = [];
function calcular(){
    if (resultado.value != '') {
        let ecuacion = resultado.value;

        let resultadoCalculo = eval(ecuacion);
        resultado.value = resultadoCalculo;

        let historialCalculo = { ecuacion: ecuacion, resultado: resultadoCalculo };
        historialCalculos.push(historialCalculo);

        let historialBody = document.querySelector('#historialModal .modal-body');
        historialBody.innerHTML = '';

        historialCalculos.forEach(calculo => {
            historialBody.innerHTML += `<p>${calculo.ecuacion} = ${calculo.resultado}</p>`;
        });
    } else {
        alert('Ingrese un valor');
    }
}

let limpiar = () => resultado.value = '';


function raiz(){
    //Agarrar lo que esta en la pantalla
    var expresion = document.getElementById("resultado").value;

    //sacar raiz
    var resultadoRaiz = Math.sqrt(eval(expresion));
    //Poner el resultado en la pantalla
    document.getElementById("resultado").value = resultadoRaiz;

}

function exponenciar(){
    var expresion = document.getElementById("resultado").value;

    var resultadoExponente = Math.pow(expresion,2);
    document.getElementById("resultado").value = resultadoExponente;
}

function seno() {
    var expresion = document.getElementById("resultado").value;

    var resultadoSeno = Math.sin(expresion);
    document.getElementById("resultado").value = resultadoSeno;
}

function coseno(){
    var expresion = document.getElementById("resultado").value;

    var resultadoCoseno = Math.cos(expresion);
    document.getElementById("resultado").value = resultadoCoseno;
}
///RETO DE HACER CALCULADORA CIENTIFICA 3 OPERACIONES CON HISTORIAL---Potencia, raiz y sin,cos,tan
