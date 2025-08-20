let lista = document.getElementById("lista");

let texto = "Hola mi nombre es Greys y voy a cumplor 21 años";
console.log(texto);
lista.innerHTML = texto;

let texto2 = 'Esta es otra cadena';
lista.innerHTML = texto2;

let texto3 = `Esta es otra cadena2`;
lista.innerHTML = texto3;

let text = `
    Cadena multilinea 
    Alumnos 301 
    Esta semana es de examenes
`;
console.log(text);

let a = 5;
let b = 10;
let resultado = `El resultado de la suma es ${a} + ${b} = ${a+b}
<ul>
    <li>Multiplica ${ a * b}</li>
    <li>Divivde ${ a / b}</li>
    <li>Resta ${ a - b}</li>
</ul>
`;
console.log(resultado);
lista.innerHTML = resultado;



let persona = 'Alexa';
let edad = 20;
let cadena = 'mi name is'

function miFuncion(cadena, personaX, edadExp){
    let resultado = '';
    //resultado += cadena + personaX + ' Tiene una edad de : ' + edadExp + ' años';

    resultado = `${cadena} ${personaX} tiene una edad de ${edadExp} años`

    console.log(resultado);
    return resultado;
}

miFuncion("Nombre: ", persona, edad);

//let resultado2 = miFuncion `Hola ${persona} , buenos dias tienes una edad de ${edad} años`
//console.log(resultado2);


function mostrarNombre(name) {
    console.log(name);
    return name;
}


let resultado3 = mostrarNombre  `Raul`;

let titulo = "Ganadores de los Oscares 2024";
let cantantes = ["Billie Eilish", "Lady Gaga", "Adele"];
let cadenaHTML = `<h1> ${titulo} </h1>`

cadenaHTML += `<ul>`;
for (let cantante of cantantes){
    cadenaHTML += `<li> ${cantante} </li>`;
}
cadenaHTML += `</ul>`;
lista.innerHTML = cadenaHTML;



x = 3.14;
otraFuncion();

function otraFuncion(){
    "use strict";
    let y = 3.14;
}



