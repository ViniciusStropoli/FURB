document.addEventListener("DOMContentLoaded", function() {
    const campoTexto = document.getElementById('campoTexto');
    const textoEspelho = document.getElementById('textoEspelho');
    const btnTamanho = document.getElementById('btnTamanho');
    const textoTamanho = document.getElementById('textoTamanho');

    // Evento disparado a cada tecla digitada
    campoTexto.addEventListener('input', function() {
        textoEspelho.innerText = campoTexto.value;
    });

    // Evento disparado ao clicar no botão
    btnTamanho.addEventListener('click', function() {
        const tamanho = campoTexto.value.length;
        textoTamanho.innerText = "O tamanho atual do campo é de: " + tamanho;
    });
});