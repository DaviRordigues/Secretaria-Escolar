const apiUrlTurma = 'http://localhost:8080/api/turmas';

async function addTurma() {
    const sala = document.getElementById('turmaSala').value;
    const horario = document.getElementById('turmaHorario').value;
    const uc = document.getElementById('turmaUc').value;

    const response = await fetch(apiUrlTurma, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ sala, horario, uc })
    });

    if (response.ok) {
        alert('Turma adicionada com sucesso!');
        fetchTurmas();
    } else {
        alert('Erro ao adicionar turma.');
    }
}

async function fetchTurmas() {
    const response = await fetch(apiUrlTurma);
    const turmas = await response.json();
    const turmaList = document.getElementById('turmaList');
    turmaList.innerHTML = '';
    turmas.forEach(turma => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${turma.sala}</td>
            <td>${turma.horario}</td>
            <td>${turma.uc}</td>
            <td>
                <button onclick="deleteTurma('${turma.id}')">Excluir</button>
            </td>
        `;
        turmaList.appendChild(row);
    });
}

async function deleteTurma(id) {
    const response = await fetch(`${apiUrlTurma}/${id}`, {
        method: 'DELETE'
    });

    if (response.ok) {
        alert('Turma excluída com sucesso!');
        fetchTurmas();
    } else {
        alert('Erro ao excluir turma.');
    }
}

document.addEventListener('DOMContentLoaded', fetchTurmas);
