const express = require('express');
var cors = require('cors');
const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

// Cuando entren a la raíz, mando un hola mundo
app.get('/', async (req, res) => {
    try {
        const response = await fetch('https://fakestoreapi.com/products');
        const productos = await response.json();

        let htmlContent = '<table border="1" width="100%">';
        productos.forEach((producto) => {
            htmlContent += `
            <tr> 
                <td>${producto.title}</td>
                <td>${producto.price}</td>
            </tr>`;
        });
        htmlContent += `</table>`;

        res.send(htmlContent);
    } catch (error) {
        res.status(500).send('Error al obtener los productos');
    }
});

app.listen(port, () => {
    console.log(`Escuchando en puerto ${port}`);
});
