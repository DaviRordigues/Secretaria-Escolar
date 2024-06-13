Passo a Passo para Testar a API com Postman
Este guia fornece instruções detalhadas para usar o Postman para testar as funcionalidades CRUD da sua API.

Pré-requisitos
Postman instalado em sua máquina.
Sua aplicação Spring Boot rodando. Inicie-a com o comando:
bash
Copiar código
mvn spring-boot:run
1. Criar uma Turma
   Passo 1: Configurar a Requisição
   Abra o Postman.
   Clique em "New" e selecione "Request".
   Nomeie a requisição como "Criar Turma" e adicione-a a uma coleção, se desejar.
   Passo 2: Configurar os Detalhes da Requisição
   Selecione o método POST.
   Insira a URL da API: http://localhost:8080/api/turmas.
   Vá para a aba Body e selecione raw e JSON.
   Insira o seguinte JSON no corpo da requisição:
   json
   Copiar código
   {
   "sala": "101",
   "horario": "08:00 - 10:00",
   "uc": "Matemática"
   }
   Passo 3: Enviar a Requisição
   Clique em Send.
   Verifique a resposta para garantir que a turma foi criada corretamente.
2. Criar um Aluno e Associá-lo a uma Turma
   Passo 1: Configurar a Requisição
   Clique em "New" e selecione "Request".
   Nomeie a requisição como "Criar Aluno" e adicione-a a uma coleção, se desejar.
   Passo 2: Configurar os Detalhes da Requisição
   Selecione o método POST.
   Insira a URL da API: http://localhost:8080/alunos?turmaId=1 (substitua 1 pelo ID da turma criada).
   Vá para a aba Body e selecione raw e JSON.
   Insira o seguinte JSON no corpo da requisição:
   json
   Copiar código
   {
   "nome": "João",
   "cpf": "12345678901",
   "matricula": "2021001",
   "idade": 20
   }
   Passo 3: Enviar a Requisição
   Clique em Send.
   Verifique a resposta para garantir que o aluno foi criado e associado à turma corretamente.
3. Obter Todos os Alunos
   Passo 1: Configurar a Requisição
   Clique em "New" e selecione "Request".
   Nomeie a requisição como "Obter Todos os Alunos" e adicione-a a uma coleção, se desejar.
   Passo 2: Configurar os Detalhes da Requisição
   Selecione o método GET.
   Insira a URL da API: http://localhost:8080/alunos.
   Passo 3: Enviar a Requisição
   Clique em Send.
   Verifique a resposta para listar todos os alunos.
4. Criar um Professor e Associá-lo a uma Turma
   Passo 1: Configurar a Requisição
   Clique em "New" e selecione "Request".
   Nomeie a requisição como "Criar Professor" e adicione-a a uma coleção, se desejar.
   Passo 2: Configurar os Detalhes da Requisição
   Selecione o método POST.
   Insira a URL da API: http://localhost:8080/api/professores?turmaId=1 (substitua 1 pelo ID da turma criada).
   Vá para a aba Body e selecione raw e JSON.
   Insira o seguinte JSON no corpo da requisição:
   json
   Copiar código
   {
   "nome": "Maria",
   "matricula": "P2021001",
   "cpf": "98765432101",
   "uc": "Matemática"
   }
   Passo 3: Enviar a Requisição
   Clique em Send.
   Verifique a resposta para garantir que o professor foi criado e associado à turma corretamente.
5. Criar um Horário e Associá-lo a uma Turma
   Passo 1: Configurar a Requisição
   Clique em "New" e selecione "Request".
   Nomeie a requisição como "Criar Horário" e adicione-a a uma coleção, se desejar.
   Passo 2: Configurar os Detalhes da Requisição
   Selecione o método POST.
   Insira a URL da API: http://localhost:8080/api/horarios?turmaId=1 (substitua 1 pelo ID da turma criada).
   Vá para a aba Body e selecione raw e JSON.
   Insira o seguinte JSON no corpo da requisição:
   json
   Copiar código
   {
   "diaSemana": "Segunda-feira",
   "horarioInicio": "08:00",
   "horarioTermino": "10:00"
   }
   Passo 3: Enviar a Requisição
   Clique em Send.
   Verifique a resposta para garantir que o horário foi criado e associado à turma corretamente.
6. Atualizar um Aluno
   Passo 1: Configurar a Requisição
   Clique em "New" e selecione "Request".
   Nomeie a requisição como "Atualizar Aluno" e adicione-a a uma coleção, se desejar.
   Passo 2: Configurar os Detalhes da Requisição
   Selecione o método PUT.
   Insira a URL da API: http://localhost:8080/alunos/{id} (substitua {id} pelo ID do aluno a ser atualizado).
   Vá para a aba Body e selecione raw e JSON.
   Insira o seguinte JSON no corpo da requisição:
   json
   Copiar código
   {
   "nome": "João Atualizado",
   "cpf": "12345678901",
   "matricula": "2021001",
   "idade": 21,
   "turma": {
   "id": 1
   }
   }
   Passo 3: Enviar a Requisição
   Clique em Send.
   Verifique a resposta para garantir que o aluno foi atualizado corretamente.
7. Deletar um Aluno
   Passo 1: Configurar a Requisição
   Clique em "New" e selecione "Request".
   Nomeie a requisição como "Deletar Aluno" e adicione-a a uma coleção, se desejar.
   Passo 2: Configurar os Detalhes da Requisição
   Selecione o método DELETE.
   Insira a URL da API: http://localhost:8080/alunos/{id} (substitua {id} pelo ID do aluno a ser deletado).
   Passo 3: Enviar a Requisição
   Clique em Send.
   Verifique a resposta para garantir que o aluno foi deletado corretamente.