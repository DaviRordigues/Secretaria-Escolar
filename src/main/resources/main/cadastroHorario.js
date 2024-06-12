const apiUrlHorario = 'URL_DO_SEU_BACKEND/api/horarios';

async function addHorario() {
    const diaSemana = document.getElementById('diaSemana').value;
    const horarioInicio = document.getElementById('horarioInicio').value;
    const horarioTermino = document.getElementById('horarioTermino').value;

    const horario = { diaSemana, horarioInicio, horarioTermino };

    const response = await fetch(apiUrlHorario, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(horario)
    });

    if (response.ok) {
        alert('Horário adicionado com sucesso!');
        fetchHorarios();
    } else {
        alert('Erro ao adicionar horário.');
    }
}

async function fetchHorarios() {
    const response = await fetch(apiUrlHorario);
    const horarios = await response.json();
    const horarioList = document.getElementById('horarioList');
    horarioList.innerHTML = '';
    horarios.forEach(horario => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${horario.diaSemana}</td>
            <td>${horario.horarioInicio}</td>
            <td>${horario.horarioTermino}</td>
            <td>
                <button onclick="deleteHorario('${horario.id}')">Excluir</button>
            </td>
        `;
        horarioList.appendChild(row);
    });
}

async function deleteHorario(id) {
    const response = await fetch(`${apiUrlHorario}/${id}`, {
        method: 'DELETE'
    });

    if (response.ok) {
        alert('Horário excluído com sucesso!');
        fetchHorarios();
    } else {
        alert('Erro ao excluir horário.');
    }
}

document.addEventListener('DOMContentLoaded', fetchHorarios);
