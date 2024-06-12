const apiUrl = 'http://localhost:8080/api/alunos';

async function addAluno() {
    const nome = document.getElementById('alunoNome').value;
    const idade = document.getElementById('alunoIdade').value;

    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nome, idade })
    });

    if (response.ok) {
        alert('Aluno adicionado com sucesso!');
        fetchAlunos();
    } else {
        alert('Erro ao adicionar aluno.');
    }
}

async function fetchAlunos() {
    const response = await fetch(apiUrl);
    const alunos = await response.json();
    const alunoList = document.getElementById('alunoList');
    alunoList.innerHTML = '';
    alunos.forEach(aluno => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${aluno.nome}</td>
            <td>${aluno.idade}</td>
            <td>
                <button onclick="deleteAluno('${aluno.id}')">Excluir</button>
            </td>
        `;
        alunoList.appendChild(row);
    });
}

async function deleteAluno(id) {
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    });

    if (response.ok) {
        alert('Aluno excluído com sucesso!');
        fetchAlunos();
    } else {
        alert('Erro ao excluir aluno.');
    }
}

document.addEventListener('DOMContentLoaded', fetchAlunos);
