const express = require('express');
var cors = require('cors');
const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use(require('./routes/productos'));

app.listen (port, () => {
    console.log(`Escuchando en puerto ${port}`);
})