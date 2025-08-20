const dotenv = require('dotenv');
//Lee el .env
dotenv.config();

const mysql = require('mysql');
let conecction;

try{
    conecction = mysql.createConnection({
        host: process.env.DB_HOST,
        user: process.env.DB_USER,
        password: process.env.DB_PASSWORD,
        database: process.env.DB_DATABASE
    });
}catch(error){
    console.log(error);
}

module.exports = {conecction};