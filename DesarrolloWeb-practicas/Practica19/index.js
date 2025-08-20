let j = 500;
let nombre = "Greys";

// Si no ponempos let adentro del for agarrará el de afuera
for(let i = 10; i <= 20; i++) {
    console.log(i);
    let nombre2 = "Denisse";
    console.log("Nombre dentro del ciclo: ", nombre2);
}

console.log("El valor de j despues del ciclo es: " + j);
console.log("Nombre fuera del ciclo: ", nombre);

const PI = Math.PI;
console.log(PI);

const persona = {
    nombre:"Diego", 
    edad : 20, 
    sexo : "M", 
    casado : true
}

console.log("Todo completo:",persona);
console.log(persona.nombre);
console.log(persona.edad);
console.log(persona.sexo);
console.log(persona.casado);

for (let propiedad in persona){
    console.log(propiedad + ":",persona[propiedad]);
}

let marcas = ["Toyota", "Nissan", "Honda", "Porsche"];

let listaDeAutos = document.getElementById("lista");

for(let marca of marcas) {
    console.log(marca);
    listaDeAutos.innerHTML += "<li>" + marca + "</li>";
}

let peliculas = [
    {
        nombre : "Harry Potter y el cáliz de fuego",
        imagen : "https://es.web.img2.acsta.net/pictures/14/04/30/11/29/268191.jpg"
    },
    {
        nombre : "Mazze Runner",
        imagen : "https://m.media-amazon.com/images/I/71fwo9096LL._AC_UF894,1000_QL80_.jpg"
    },
    {
        nombre : "Los juegos del hambre",
        imagen : "https://www.aceprensa.com/wp-content/uploads/2015/11/131634-0-683x1024.jpg"
    },
    {
        nombre : "Spiderman no way home",
        imagen : "https://pics.filmaffinity.com/Spider_Man_No_Way_Home-642739124-large.jpg"
    }
];

let listaPeliculas = document.getElementById('listaPeliculas');

// Variable para almacenar el HTML de las películas


for (let pelicula of peliculas) {
    console.log(pelicula.nombre);
    listaPeliculas.innerHTML +=
    "<div class= 'col-12 col-md-4 text-center'>" +
    "<h1 class='titulo-pelicula'>" + pelicula.nombre + "</h1>" +
    "<img src='" + pelicula.imagen + "'class = 'w-75'>"+
    "</div>";
}


/////////////////////////////////////////////////////////
j=1;

while (j <= 30){
    console.log(j);
    j++;
}

let result = '';
let i = 0;

do{
    i = i + 1;
    result = result + 1;

} while (i < 5)

console.log(result);