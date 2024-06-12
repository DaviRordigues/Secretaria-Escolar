const apiUrlProfessor = 'http://localhost:8080/api/professores';

async function addProfessor() {
    const nome = document.getElementById('professorNome').value;
    const matricula = document.getElementById('professorMatricula').value;
    const cpf = document.getElementById('professorCpf').value;
    const uc = document.getElementById('professorUc').value;

    const response = await fetch(apiUrlProfessor, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nome, matricula, cpf, uc })
    });

    if (response.ok) {
        alert('Professor adicionado com sucesso!');
        fetchProfessores();
    } else {
        alert('Erro ao adicionar professor.');
    }
}

async function fetchProfessores() {
    const response = await fetch(apiUrlProfessor);
    const data = await response.json();

    if (response.ok) {
        // Processar a resposta e exibir os professores, por exemplo:
        const listaProfessores = document.getElementById('listaProfessores');
        listaProfessores.innerHTML = ''; // Limpar a lista antes de adicionar novos professores

        data.forEach(professor => {
            const professorItem = document.createElement('li');
            professorItem.textContent = `Nome: ${professor.nome}, Matrícula: ${professor.matricula}, CPF: ${professor.cpf}, UC: ${professor.uc}`;
            listaProfessores.appendChild(professorItem);
        });
    } else {
        alert('Erro ao buscar professores.');
    }
}
