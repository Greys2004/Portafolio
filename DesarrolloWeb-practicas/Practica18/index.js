let hora = 12;
if(hora < 12){
    console.log("Buenos dias");
}else if (hora < 19){
    console.log("Buenas tardes");
}else{
    console.log("Buenas noches");
}

let diaDeLaSemana = new Date().getDay();
console.log(diaDeLaSemana);

switch(diaDeLaSemana){
    case 0:
        console.log("Hoy es Domingo");
        break;
    case 1:
        console.log("Hoy es Lunes");
        break;
    case 2:
        console.log("Hoy es Martes");
        break;
    case 3:
        console.log("Hoy es Miercoles");
        break;
    case 4:
        console.log("Hoy es Jueves");
        break;
    case 5:
        console.log("Hoy es Viernes");
        break;
    case 6:
        console.log("Hoy es Sabado");
        break;
    default:
        console.log("Error");
        break;
}