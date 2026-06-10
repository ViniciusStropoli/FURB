document.addEventListener("DOMContentLoaded", function() {
    const palavraSecreta = "TERMO"; // Palavra oculta de 5 letras
    let jogoFinalizado = false;

    const inputWordle = document.getElementById('inputWordle');
    const btnSubmeter = document.getElementById('btnSubmeter');
    const btnReiniciar = document.getElementById('btnReiniciar');
    const board = document.getElementById('boardWordle');
    const msgVitoria = document.getElementById('msgVitoria');

    function processarTentativa() {
        if (jogoFinalizado) return;

        let tentativa = inputWordle.value.toUpperCase();

        if (tentativa.length !== 5) {
            alert("Por favor, digite exatamente 5 letras.");
            return;
        }

        const linha = document.createElement('div');
        linha.className = 'wordle-row';

        let acertos = 0;
        let letrasRestantes = palavraSecreta.split('');
        let statusLetras = Array(5).fill('wrong-letter');

        // Primeira passagem: Verificar posições corretas (VERDE)
        for (let i = 0; i < 5; i++) {
            if (tentativa[i] === palavraSecreta[i]) {
                statusLetras[i] = 'correct-pos';
                letrasRestantes[i] = null;
                acertos++;
            }
        }

        // Segunda passagem: Verificar posições erradas (AMARELO)
        for (let i = 0; i < 5; i++) {
            if (statusLetras[i] !== 'correct-pos' && letrasRestantes.includes(tentativa[i])) {
                statusLetras[i] = 'wrong-pos';
                letrasRestantes[letrasRestantes.indexOf(tentativa[i])] = null;
            }
        }

        // Renderizar as letras
        for (let i = 0; i < 5; i++) {
            const box = document.createElement('div');
            box.className = `wordle-box ${statusLetras[i]}`;
            box.innerText = tentativa[i];
            linha.appendChild(box);
        }

        board.appendChild(linha);
        inputWordle.value = "";
        inputWordle.focus();

        if (acertos === 5) {
            msgVitoria.innerText = "Parabéns! Você adivinhou a palavra!";
            jogoFinalizado = true;
        }
    }

    btnSubmeter.addEventListener('click', processarTentativa);

    // Permite usar a tecla 'Enter' para submeter
    inputWordle.addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            processarTentativa();
        }
    });

    btnReiniciar.addEventListener('click', function() {
        board.innerHTML = "";
        msgVitoria.innerText = "";
        inputWordle.value = "";
        jogoFinalizado = false;
        inputWordle.focus();
    });
});