// Aguarda o carregamento do HTML antes de vincular os eventos
document.addEventListener("DOMContentLoaded", function() {
    
    // Captura os botões
    const btnSomar = document.getElementById('btnSomar');
    const btnComparar = document.getElementById('btnComparar');

    // Evento de Soma
    btnSomar.addEventListener('click', function() {
        const n1 = parseFloat(document.getElementById('num1').value) || 0;
        const n2 = parseFloat(document.getElementById('num2').value) || 0;
        document.getElementById('resultadoSoma').innerText = "A soma é: " + (n1 + n2);
    });

    // Evento de Comparação
    btnComparar.addEventListener('click', function() {
        const n1 = parseFloat(document.getElementById('num1').value) || 0;
        const n2 = parseFloat(document.getElementById('num2').value) || 0;
        const div = document.getElementById('resultadoComparacao');
        
        if (n1 > n2) {
            div.innerText = "Primeiro número é maior";
            div.style.backgroundColor = "red";
            div.style.color = "white";
        } else if (n2 > n1) {
            div.innerText = "Segundo número é maior";
            div.style.backgroundColor = "green";
            div.style.color = "white";
        } else {
            div.innerText = "Ambos são iguais";
            div.style.backgroundColor = "yellow";
            div.style.color = "black";
        }
    });
});