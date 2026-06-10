document.addEventListener("DOMContentLoaded", function() {
    // --- Tabela ---
    const btnAdicionarLinha = document.getElementById('btnAdicionarLinha');
    const tabela = document.getElementById('minhaTabela');

    btnAdicionarLinha.addEventListener('click', function() {
        const novaLinha = tabela.insertRow();
        for (let i = 0; i < 3; i++) {
            const novaCelula = novaLinha.insertCell();
            novaCelula.innerText = "Nova Linha, Col " + (i + 1);
        }
    });

    // --- Contador ---
    let tempo = 0;
    const divContador = document.getElementById('contador');
    
    setInterval(function() {
        tempo++;
        divContador.innerText = tempo;
    }, 1000);

    // --- Lista de Atividades ---
    const itensLista = document.querySelectorAll('.atividade');
    
    itensLista.forEach(function(item) {
        item.addEventListener('click', function() {
            this.innerText = "Concluído";
            this.style.color = "gray";
            this.style.textDecoration = "line-through";
            this.style.cursor = "default";
            // Remove a classe para tirar o efeito de hover
            this.classList.remove('atividade');
        }, { once: true }); // O evento ocorre apenas uma vez por item
    });
});