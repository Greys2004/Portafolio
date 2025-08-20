const fruits = ["apple", "orange", "banana", "Kiwi"];

let size = fruits.length;
console.log(size);

let contenido = "";
for (let i = 0; i < size; i++) {
    console.log(fruits[i]);
    contenido += fruits[i] + ",";
}

lista1 = document.getElementById("lista1");
lista1.innerHTML = contenido;
console.log(lista1);
console.warn("La fruta es:", fruits);
console.error("La fruta es:", fruits);
console.info("La fruta es:", fruits);
console.table(fruits);
console.debug("La fruta es:",fruits);

let lista2 = document.getElementById("lista2");
lista2.innerHTML = fruits.join (" ***** ");

let lista3 = document.getElementById("lista3");
fruits.pop(); //elimina el ultimo elemento del arreglo
fruits.pop(); 
console.log (fruits);
lista3.innerHTML = "lista3: " + fruits.join (" ----- ");

let lista4 = document.getElementById("lista4");
fruits.push("Melon");
fruits.push("Fresa");
lista4.innerHTML = "lista4: " + fruits.join (" ----- ");

let lista5 = document.getElementById("lista5");
fruits.shift();//Quita primer elemento
lista5.innerHTML = "lista5: " + fruits.join (" ----- ");

let lista6 = document.getElementById("lista6");
//Agrega primer elemento
fruits.unshift("pera");
fruits.unshift("Uva");
console.log(fruits);
lista6.innerHTML = "lista6: " + fruits.join (" ----- ");

const nombreMujeres = ["Greys","Denisse","Saray"];
const nombreHombres = ["Juan", "Luis","Pipe"];
let listaNombres = nombreMujeres.concat(nombreHombres);
console.log (listaNombres);
let lista7 = document.getElementById("lista7");
lista7.innerHTML = "Lista de nombres:" + listaNombres.join(" , ");






