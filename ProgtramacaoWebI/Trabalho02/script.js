window.onload = function() {
    verificarLogin();
};

function verificarLogin() {
    var divUsuario = document.getElementById("info-usuario");
    var estaLogado = localStorage.getItem("autenticado");
    var nomeLogin = localStorage.getItem("loginDoUsuario");

    if (estaLogado == "sim") {
        divUsuario.innerHTML = "Olá, " + nomeLogin + " <a href='cadastro.html'><img src='img/usericon.png' alt='Foto'></a>";
    } else {
        divUsuario.innerHTML = "Usuário não autenticado";
    }
}

function fazerLogin() {
    var campoLogin = document.getElementById("login").value;
    var campoSenha = document.getElementById("senha").value;

    if (campoLogin != "" && campoSenha != "") {
        localStorage.setItem("autenticado", "sim");
        localStorage.setItem("loginDoUsuario", campoLogin);
        
        window.location.href = "index.html";
    } else {
        alert("Erro: Você precisa digitar o Login e a Senha!");
    }
}

function mudarTema() {
    var temaSelecionado = document.getElementById("seletorEstilo").value;
    
    var labels = document.querySelectorAll("#form-cadastro .form-label");
    var inputs = document.querySelectorAll("#form-cadastro .form-input");

    if (temaSelecionado === "custom") {
        labels.forEach(function(label) {
            label.style.fontFamily = "'Courier New', Courier, monospace";
        });
        inputs.forEach(function(input) {
            input.style.backgroundColor = "#cce5ff";
        });
    } else {
        labels.forEach(function(label) {
            label.style.fontFamily = "";
        });
        inputs.forEach(function(input) {
            input.style.backgroundColor = "";
        });
    }
}