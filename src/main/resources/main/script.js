
document.addEventListener('DOMContentLoaded', function() {
    var form = document.getElementById('loginForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;

        if (email === '123@123' && password === '123') {
            window.location.href = 'menu.html';
        } else {
            var errorMessage = document.getElementById('errorMessage');
            errorMessage.textContent = 'Usuário ou senha incorretos. Tente novamente.';
        }
    });
});
