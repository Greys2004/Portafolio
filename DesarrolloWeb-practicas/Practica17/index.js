/*Aqui va el codigo en js*/

let a = 10;
let b = 20;
let sumar = a + b;
console.log("La suma de a + b es: ", sumar);

let restar = a - b;
console.log("La resta de a - b es: ", restar);

let multiplicar = a * b;
console.log("La multiplicacion de a * b es: ", multiplicar);

let dividir = a / b;
console.log("La division de a / b es: ", dividir);

let modulo = b % a;
console.log("El residuo de b%a es:", modulo);
let modulo2 = a % b;
console.log("El residuo de a%ab es:", modulo);

let mayor = a > b;
console.log("a es mayor que b:", mayor);

let menor = a < b;
console.log("a es menor que b:", menor);

let mayorIgual = a >= b;
console.log("a es mayor o igual que b:", mayorIgual);

let menorIgual = a <= b;
console.log("a es menor o igual que b:", menorIgual);

let igual = a == b;
console.log("a es igual que b:", igual);




a = -50;
b = 10*(-1);

if (a != b){
    console.log("a es diferente de b");
}else {
    console.log("a es igual a b");
}



//OPERADOR TERNARIO
let comparacion = a > b ? "a es mayor que b" : "a es menor o igual que b";
console.log(comparacion);

let d = 19;
let edad = d <18 ? "Eres menor de edad" : "Eres mayor de edad";
console.log(edad);

//FUNCIONES
let x = 100;
let y = 200;

function multiplicarNumeros(x,y){
    return x * y
}

let resultado = multiplicarNumeros(x,y);
console.log("El resultado de la multiplicacion con funciones es de: " , resultado);

//FUNCION 2

function calcularAreaCirculo (radio){
    //const PI = 3.1416;
    //let area = PI * radio **2;
    let area = Math.PI * Math.pow(radio,2);
    return area
}

console.log("Area del circulo ", calcularAreaCirculo(10));

//FUNCIONES 3
function toCelsius(farenheit){
    return (5/9) * (farenheit - 32);
}

let temperatura = toCelsius(77);
console.log("Temparatura del farenheit a celsius es de: ", temperatura);

//FUNCIONES 4

function edadX2(edad){
    return edad * 2;
}
console.log("La edad multiplicada x2 es de: ", edadX2(20));

//FUNCION FLECHA
let hello = function() {
    return "Hello World!";
}
console.log(hello());

hi = () => {
    return "Hello World!";
}
console.log(hi());

//FUNCION FLECHA EDAD
let edadx2 = (edad) =>  edad * 2;

console.log(edadx2(30));