let numero = 100; //Variable global,tipo number
console.log(numero);
let decimal = 100.5; //Variable global, tipo number decimal
console.log(decimal);

let texto = "Hola mundo"; 
let texto2 = 'Hola mundo';

let boolean = true;
let arreglo = [1,2,3,4,5];
let arreglo2 = ["a", "b", "c", "d", "e"];
console.log(arreglo2);
console.log(arreglo2[3]);
console.log(arreglo2[-2]);
console.log(arreglo2[30]);

let arregloMixto = [1,2,3,4,5,"a","b","c","d","e",true,false];
console.log(arregloMixto);
arregloMixto[0] = "hola"
console.log(arregloMixto);

let objeto = {
    nombre : "Juan",
    edad : 30,
    telefono : "123456789",
    direccion: {
        calle: "Av. 123",
        numero: 123,
        colonia: "Centro",
        ciudad: "CDMX"
    }
}
console.log(objeto);
console.log(objeto.telefono);
console.log(objeto["edad"]);
console.log("Nombre del objeto: " + objeto.nombre);

let estudiante = {
    nombre : "Greys Almanza",
    matricula : "77465",
    carrera : "Ing. de Software y Sistemas",
    materias : ["Matematicas", "Base de datos","Progracion"],
    amigos: [
        {
            nombre : "Pedro",
            telefono : "123456789",
        },
        {
            nombre : "Maria",
            telefono : "987654321",
        }
    ]
}

console.log(estudiante.materias[2]);
console.log(estudiante.amigos[1].nombre);

let variable = 10.5;
console.log(typeof variable)
let variable2 = "10.5";
console.log(typeof variable2);
let variable3 = true;
console.log(typeof variable3);
let variable4 = [1,2,3,4];
console.log(typeof variable4);

let variable5 = {nombre : "Juan", edad : 30,telefono : "12345"};
console.log(typeof variable5);
console.log(typeof variable5.telefono);

let saludo, nombre ="juan";
console.log(nombre);