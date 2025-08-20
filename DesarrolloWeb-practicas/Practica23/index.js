let formulario = document.getElementById('formularioAgregar');

let nombre = document.getElementById('nombre');
let fecha = document.getElementById('fecha');
let descripcion = document.getElementById('descripcion');
let video = document.getElementById('video');
let audio = document.getElementById('audio');

let listaTareas = document.getElementById('listaTareas');
let btnAgregar = document.getElementById('btnAgregar');
let listaTareasCompletadas = document.getElementById('listaTareasCompletadas');
let formularioEditar = document.getElementById('formularioEditar');

formulario.addEventListener("submit", (e) => {
    //previene que no se recargue la pagina
    e.preventDefault();
    agregarDatos();
    cerrarModal();
    mostrarTareas();
    formulario.reset();
});

let cerrarModal = () => {
    btnAgregar.setAttribute('data-bs-dismiss', 'modal');
    btnAgregar.click();
}

let tareas = [
    {
        nombre : "Julio",
        fecha : "2021-10-10",
        descripcion : "Hacer galletas",
        video :"https://videos.pexels.com/video-files/6942484/6942484-hd_1920_1080_25fps.mp4",
        audio : "https://s21.aconvert.com/convert/p3r68-cdx67/hn230-tjddn.mp3",
    },
    {
        nombre : "Maria",
        fecha : "2011-09-02",
        descripcion : "Hacer Bebidas",
        video : "https://videos.pexels.com/video-files/2345459/2345459-uhd_3840_2160_25fps.mp4",
        audio : "https://s19.aconvert.com/convert/p3r68-cdx67/f69xi-m1gd5.mp3"
    },
    {
        nombre : "Saray",
        fecha : "2010-18-01",
        descripcion : "Hacer postres",
        video : "https://videos.pexels.com/video-files/4109795/4109795-hd_1920_1080_25fps.mp4",
        audio : "https://s31.aconvert.com/convert/p3r68-cdx67/xqg64-cfv7n.mp3"
    }
];

let agregarDatos = () =>{
    tareas.push({
        nombre : nombre.value,
        fecha : fecha.value,
        descripcion : descripcion.value,
        video : video.value,
        audio : audio.value
    });
    console.log(tareas);
}

let mostrarTareas = () => {
    //Le agregare codigo html
    listaTareas.innerHTML = '';
    //Agarrar cada dato de mi arreglo tarea
    tareas.forEach((tarea, indice) => {
        listaTareas.innerHTML += `
        <div class="row" style="background-color: rgb(222, 171, 209); border: 2px darkgray; margin-bottom: 10px;">
            <div class = "col-12 col-md-2 border p-3">
                <strong>${tarea.nombre}</strong>
            </div>
            <div class = "col-12 col-md-2 border p-3">
                <strong>${tarea.fecha}</strong>
            </div>
            <div class = "col-12 col-md-2 border p-3">
                <strong>${tarea.descripcion}</strong>
            </div>
            <div class = "col-12 col-md-2 border p-3">
                <strong><i class="bi bi-film"></i> &nbsp Video: </strong>
                ${tarea.video ? 
                `<video width="160" height="90" controls>
                    <source src="${tarea.video}" type="video/mp4">
                </video>` : 
                '<p>Sin video</p>'}
            </div>
            <div class = "col-12 col-md-2 border p-3">
                <strong><i class="bi bi-music-note"></i>&nbsp Audio: </strong>
                ${tarea.audio ? 
                `<audio controls style="width: 100%; max-width: 500px;">
                    <source src="${tarea.audio}" type="audio/mpeg">
                </audio>` : 
                '<p>Sin audio</p>'}
            </div>
            <div class = "col-12 col-md-2 border p-5">
                <button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#editarModal" onClick="abrirModalEditar(${indice})"><i class="bi bi-pencil"></i> &nbsp Editar</button>
                <button class="btn btn-outline-danger" onClick="borrarTarea(this,${indice})" ><i class="bi bi-trash"></i> &nbsp Borrar</button>
            </div>
        </div>

        `;
    })
}

let indiceEditado;


let abrirModalEditar = (indice) => {
    indiceEditado = indice;
    
    let tarea = tareas[indice];
    
    //Aqui agrego los valores al modal, para que ya esten escritos
    document.getElementById('nombreEditar').value = tarea.nombre;
    document.getElementById('fechaEditar').value = tarea.fecha;
    document.getElementById('descripcionEditar').value = tarea.descripcion;
    document.getElementById('videoEditar').value = tarea.video;
    document.getElementById('audioEditar').value = tarea.audio;
}

formularioEditar.addEventListener("submit", (e) => {
    e.preventDefault();
    
    //Obteno los valores
    let nombreEditado = document.getElementById('nombreEditar').value;
    let fechaEditada = document.getElementById('fechaEditar').value;
    let descripcionEditada = document.getElementById('descripcionEditar').value;
    let videoEditado = document.getElementById('videoEditar').value; 
    let audioEditado = document.getElementById('audioEditar').value;
    
    tareas[indiceEditado] = {
        nombre: nombreEditado,
        fecha: fechaEditada,
        descripcion: descripcionEditada,
        video: videoEditado,
        audio: audioEditado
    };
    
    mostrarTareas();
    cerrarModalEditar();
});

let cerrarModalEditar = () => {
    btnGuardar.setAttribute('data-bs-dismiss', 'modal');
    btnGuardar.click();
}

let tareasCompletadas = [];

let borrarTarea = (boton,indice) => {
    if(confirm("¿Estas seguro de borrar esta tarea?")){
        //Lo quita de mi html
        boton.parentElement.parentElement.remove();
        //Quitar SOLO UN elemento de un arreglo  //Me lo quita de mi memoria
        let tareaEliminada = tareas.splice(indice, 1)[0];
        tareasCompletadas.push(tareaEliminada);
        mostrarTareasCompletadas();
        mostrarTareas()
    }else{
        alert("No se borro la tarea");
    }
}

let mostrarTareasCompletadas = () => {
    listaTareasCompletadas.innerHTML = '';
    tareasCompletadas.forEach((tarea) => {
        listaTareasCompletadas.innerHTML += `
        <div class="row" style="background-color: rgba(168, 232, 220, 0.721); margin-bottom: 10px;">
            <div class="col-12 col-md-2 border p-3">
                <strong>${tarea.nombre}</strong>
            </div>
            <div class="col-12 col-md-2 border p-3">
                <strong>${tarea.fecha}</strong>
            </div>
            <div class="col-12 col-md-2 border p-3">
                <strong>${tarea.descripcion}</strong>
            </div>
            <div class = "col-12 col-md-2 border p-3">
                <strong><i class="bi bi-film"></i> &nbsp Video: </strong>
                <video width="160" height="90" controls autoplay >
                    <source src="${tarea.video}" type="video/mp4">
                </video><br>
            </div>
            <div class = "col-12 col-md-2 border p-3">
            <strong><i class="bi bi-music-note"></i>&nbsp Audio: </strong>
                <audio controls style="width: 100%; max-width: 200px;">
                    <source src="${tarea.audio}" type="audio/mpeg">
                </audio><br>
            </div>
            <div class="col-12 col-md-2 border p-5">
                <strong><i class="bi bi-calendar2-check"></i>&nbsp &nbsp &nbsp Tarea completada</strong>
            </div>
        </div>
        `;
    });
}

mostrarTareas();