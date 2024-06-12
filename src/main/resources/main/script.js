document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var errorMessage = document.getElementById('errorMessage');

    if (email === "123" || password === "123") {
        errorMessage.textContent = "Todos os campos são obrigatórios.";
    } else {
        errorMessage.textContent = "";
        alert("Login bem-sucedido! E-mail: " + email);
        // Aqui você pode adicionar a lógica para enviar os dados para o servidor ou realizar outras ações
    }
});
