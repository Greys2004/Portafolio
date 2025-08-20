document.addEventListener('DOMContentLoaded', function () {
    const themeSwitch = document.getElementById('theme-switch');
    const title = document.querySelector('h1');

    themeSwitch.addEventListener('change', function () {
        console.log("El interruptor de tema ha cambiado.");
        if (themeSwitch.checked) {
            document.body.classList.add('dark-theme');
            title.style.color = '#fff'; // Cambia el color del texto
            title.style.backgroundColor = '#333'; // Cambia el color de fondo
        } else {
            document.body.classList.remove('dark-theme');
            title.style.color = '#333'; // Cambia el color del texto
            title.style.backgroundColor = '#fff'; // Cambia el color de fondo
        }
    });
});
