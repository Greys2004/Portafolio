let listaProductos = document.querySelector("#listaProductos");
let listaCategorias = document.querySelector("#listaCategorias");
let contenidoCarrito = document.querySelector("#contenidoCarrito");
let totalCarritoElement = document.querySelector("#totalCarrito");
let carrito = [];

const URLProductos = "https://fakestoreapi.com/products";
const URLCategorias = "https://fakestoreapi.com/products/categories";

// Fetch de productos
fetch(URLProductos)
    .then(res => res.json())
    .then(productosObtenidos => {
        listaProductos.innerHTML = "";

        productosObtenidos.forEach((producto, indice) => {
            listaProductos.innerHTML += `
                <div class="col-12 col-md-3 py-5">
                    <div class="card">
                        <img src="${producto.image}" class="p-3 imagenProducto card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${producto.title.slice(0, 20)}</h5>
                            <p class="card-text">${producto.description.slice(0, 70)}</p>
                            <p class="card-text text-danger">$${producto.price}</p>
                            <button class="btn btn-primary" onclick="agregarAlCarrito(${indice})">Agregar al carrito</button>
                        </div>
                    </div>
                </div>
            `;
        });
    });

// Fetch de categorías
fetch(URLCategorias)
    .then(res => res.json())
    .then(categoriasObtenidas => {
        listaCategorias.innerHTML = "";
        categoriasObtenidas.forEach(categoria => {
            categoria = categoria.replace("'", "");
            listaCategorias.innerHTML += `
                <li class="nav-item">
                    <a href="#" onclick="muestraProductos('${categoria}')" class="nav-link">
                        ${categoria.toUpperCase()}
                    </a>
                </li>
            `;
        });
    });

function agregarAlCarrito(indiceProducto) {
    fetch(URLProductos)
        .then(res => res.json())
        .then(productosObtenidos => {
            const producto = productosObtenidos[indiceProducto];
            carrito.push(producto);
            actualizarCarrito();
            mostrarNotificacion("Producto agregado al carrito");
        });
}

function actualizarCarrito() {
    contenidoCarrito.innerHTML = "";
    if (carrito.length === 0) {
        contenidoCarrito.innerHTML = "<p>No hay productos en el carrito</p>";
        totalCarritoElement.textContent = "0";
    } else {
        let total = 0;
        carrito.forEach((producto, indice) => {
            total += producto.price;
            contenidoCarrito.innerHTML += `
                <div class="d-flex justify-content-between align-items-center">
                    <img src="${producto.image}" alt="${producto.title}" style="width: 50px; height: 50px;">
                    <div>
                        <h5>${producto.title}</h5>
                        <p>$${producto.price}</p>
                    </div>
                    <button class="btn btn-danger" onclick="eliminarDelCarrito(${indice})">Eliminar</button>
                </div>
                <hr>
            `;
        });
        totalCarritoElement.textContent = total.toFixed(2);
    }
}

function eliminarDelCarrito(indiceProducto) {
    carrito.splice(indiceProducto, 1);
    actualizarCarrito();
}

function mostrarNotificacion(mensaje) {
    let notificacion = document.createElement("div");
    notificacion.className = "alert alert-success position-fixed top-0 end-0 m-3";
    notificacion.style.zIndex = "1050";
    notificacion.textContent = mensaje;
    document.body.appendChild(notificacion);
    setTimeout(() => {
        document.body.removeChild(notificacion);
    }, 2000);
}
