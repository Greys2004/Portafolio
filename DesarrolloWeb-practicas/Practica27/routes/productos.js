const express = require('express');
const app = express();

const dotenv = require('dotenv');
dotenv.config();

const {coneccion} = require('../config.db');

const getProductos = (request,response) => {
    coneccion.query('SELECT * FROM productos', 
        (error, results) => {
            if (error) 
                throw error;
            response.status(200).json(results);
        }
    );
}

app.route('/productos').get(getProductos);
module.exports = app;