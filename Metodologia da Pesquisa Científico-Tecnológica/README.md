Portfolio
=========

<img alt="GitHub Profile Picture" src="https://avatars.githubusercontent.com/u/93501477?v=4" height="128" />

Paulo Granthon
--------------

Semestre Atual: 4

Backend developer intern at @gorilainvest | Database technologist student at FATEC | Self titled full-stack developer

Projects
--------

### [Khali](https://github.com/projetoKhali/Khali)

**Empresa:** FATEC

**Semestre:** 1º Sem

#### Descrição

Plataforma Khali, que possibilita a aplicação do método de Avaliação 360° à Instituição de Ensino fictícia PBLTeX

#### Tecnologias

- Python
- Tkinter
- Git
- GitHub
- Bcrypt
- Numpy

#### Contribuições

##### CSVHandler

Módulo responsável por manipular arquivos CSV, permitindo a leitura e escrita de dados em arquivos CSV. O módulo foi desenvolvido para facilitar a importação e exportação de dados do sistema, permitindo a persistência de dados em arquivos CSV.

##### ModulesManager

Módulo responsável por gerenciar os módulos do sistema, permitindo a definição de telas do sistema, navegação entre telas e permissionamento de acesso. O módulo foi desenvolvido para facilitar a adição de novas telas ao sistema, permitindo a criação de forma modular.

##### Charts

Implementei os tipos básicos de gráfico para serem instanciados no sistema, permitindo a visualização de dados de forma gráfica. Com base neles, desenvolvi funções que instanciam gráficos específicos exibindo diversas métricas.

##### EditTeam

Tela responsável pela edição de equipes, permitindo a inclusão, edição e exclusão de equipes. A tela permite a inclusão e exclusão de membros de uma equipe, bem como a definição de um líder para a equipe e utiliza uma lista temporária no formulário de criação contendo os membros a serem incluídos ao criar a equipe.

##### Profile

Tela responsável por exibir o perfil do usuário logado, permitindo a visualização dos gráficos de avaliação 360° do usuário. A tela exibe a média das pontuações recebidas pelo usuário em cada uma das dimensões avaliadas, a lista de feedbacks recebidos e a evolução das pontuações do usuário ao longo do tempo.

#### Aprendizados Efetivos

- Desenvolvimento de aplicações desktop
- Manipulação de arquivos CSV
- Modularização e arquitetura de sistemas
- Desenvolvimento de gráficos
- Desenvolvimento de telas de edição e visualização de dados

### [API2Semestre](https://github.com/projetoKhali/API2Semestre)

**Empresa:** 2RP

**Semestre:** 2º Sem

Sistema desktop para apontamento de horas extras e sobreavisos pelo colaborador, e controle pelo gestor (PO) e administrador (RH e Financeiro). 

#### Tecnologias

- Java
- JavaFX
- SceneBuilder
- PostgreSQL
- Git
- GitHub
- Railway

#### Contribuições

##### Classe Query & QueryLibs

Biblioteca de queries SQL para o banco de dados PostgreSQL, contendo as queries necessárias para a execução das operações do sistema. A biblioteca foi desenvolvida para suprir a necessidade que o sistema tinha de realizar operações no banco de dados por não possuir um ORM ou um framework de persistência de dados dedicado (conforme orientação).

A implementação foi feita de forma modular e estáticamente tipada, utilizando Enums para a definição das operações, tabelas e colunas dessas tabelas e a classe Query para a construção de queries parametrizadas.

##### Sistema de permissões e controle de acesso às telas

Implementei um sistema de permissões de acesso às telas do sistema, baseado em regras de acesso por perfil de usuário. As permissões de acesso são definidas pelo perfil do usuário e também por uma análise dos dados do usuário. Por exemplo, o usuário de nível Colaborador, só pode efetuar apontamentos caso pertença a um ResultCenter, enquanto um usuário de nível Administrador pode acessar todas as telas do sistema.

##### Tela de Avaliação de Apontamentos

Desenvolvi a tela de Avaliação de Apontamentos do sistema, incluindo a tabela responsável pela listagem dos apontamentos efetuados pelos colaboradores. A tela permite a visualização dos apontamentos efetuados, a aprovação ou rejeição dos apontamentos e a inclusão de feedbacks para o colaborador do apontamento avaliado.

##### Tela de Relatório

Desenvolvi a tela de Relatório do sistema, incluindo a tabela responsável pela listagem dos apontamentos efetuados pelos colaboradores. A tela permite a visualização dos apontamentos efetuados, a filtragem dos apontamentos por data, a seleção de colunas a serem incluídas assim como a exportação dos dados para um arquivo CSV contendo apenas as colunas selecionadas dos apontamentos filtrados.

##### Tela de Parametrização

Desenvolvi a tela de Parametrização do sistema, responsável pela exibição e edição dos parâmetros do sistema, que residem em uma tabela de linha única no banco de dados. A tela permite a edição dos parâmetros do sistema, a visualização dos valores atuais e a persistência das alterações realizadas, garantindo a sincronização das regras de cálculo de horas extras e sobreavisos.

##### LookUpTextField

Desenvolvi o componente LookUpTextField, que permite a pesquisa em uma lista e reduzindo a quantidade de opções exibidas ao usuário ao selecionar um valor dentro de uma lista finita. A pesquisa é realizada em tempo real, filtrando os resultados conforme o usuário digita. O componente foi utilizado em diversas telas do sistema aonde a seleção de um valor existente entre muitos disponíveis é necessária.

#### Aprendizados Efetivos

- Desenvolvimento de aplicações desktop
- Manipulação de banco de dados PostgreSQL
- Desenvolvimento front-end com JavaFX
- Arquitetura de sistemas

### api3

**Empresa:** 2RP

**Semestre:** 3º Sem

Controle de Horas-Extras e Sobreavisos (web)

[github.com/projetoKhali/api3](https://github.com/projetoKhali/api3)

Sistema desenvolvido para auxiliar na gestão eficiente das horas trabalhadas pelos colaboradores de uma empresa. Ele automatiza a identificação e classificação de horas extras e sobreavisos, simplificando os processos de controle para os departamentos pessoal e financeiro.

### Contribuições

#### Inclusão das entidades iniciais

**Conhecimentos exercitados:** `Java` `Spring`

Adicionei as entidades: User, Client, Appointment, PayRateRule, e os enums necessários. Essa contribuição foi composta por uma revisão do código JavaFX do semestre anterior para garantir a compatibilidade com a arquitetura do terceiro semestre. Alguns pontos foram atualizados para seguir a nova arquitetura.

#### Dockerização do projeto

**Conhecimentos exercitados:** `Docker` `Bash` `Batch`

Efetuei a dockerização do projeto, criando arquivos Dockerfile e docker-compose.yml para facilitar a execução do projeto em qualquer ambiente. Ao todo foram incluidos 3 containers no \`docker-compose\` principal do projeto: um para o banco de dados, um para o back-end e um para o front-end. Para o back-end e front-end, foram criados arquivos \`Dockerfile\` específicos para cada um, com as dependências necessárias para a execução do projeto.

#### Sistema de permissões de acesso às telas

**Conhecimentos exercitados:** `Java` `Spring` `TypeScript` `React`

Implementei um sistema de permissões de acesso às telas do sistema, baseado em regras de acesso por perfil de usuário. As permissões de acesso são definidas pelo perfil do usuário e também por uma análise dos dados do usuário. Por exemplo, o usuário de nível Colaborador, só pode efetuar apontamentos caso pertença a um ResultCenter, caso contrário não faz sentido possuir acesso à tela de apontamentos.

#### Tela de Apontamentos

**Conhecimentos exercitados:** `TypeScript` `React`

Desenvolvi da tela de apontamentos do sistema, incluindo o formulário que permite ao usuário registrar as horas trabalhadas e os sobreavisos, assim como a tabela responsável pela listagem dos apontamentos efetuados previamente. A tela se comunica com o back-end através das funções service do front-end.

#### Backend e tela de Clientes

**Conhecimentos exercitados:** `TypeScript` `React`

Desenvolvi a tela de Clientes do sistema, incluindo o formulário que permite ao usuário cadastrar novos clientes e a tabela responsável pela listagem dos clientes cadastrados. A tela se comunica com o back-end através das funções service do front-end.

#### Componentes personalizado de Dropdown

**Conhecimentos exercitados:** `TypeScript` `React`

Desenvolvi componentes personalizados de Dropdown que integram com o funcionamento das telas para disponibilizar abstrações, facilitando a implementação de novas funcionalidades.

#### Componente de LookUpTextField

**Conhecimentos exercitados:** `TypeScript` `React`

Desenvolvi o componente \`LookUpTextField\`, que permite a pesquisa em uma lista e reduzindo a quantidade de opções exibidas ao usuário ao selecionar um valor dentro de uma lista finita. A pesquisa é realizada em tempo real, filtrando os resultados conforme o usuário digita. O componente foi utilizado em diversas telas do sistema aonde a seleção de um valor existente entre muitos disponíveis é necessária.

#### Componentes de Célula de Tabela Editável e Célula de Tabela Botão

**Conhecimentos exercitados:** `TypeScript` `React`

Desenvolvi o componente \`EditableTableCell\`, que permite a edição de células de uma tabela diretamente na célula, sem a necessidade de abrir um formulário de edição. O componente \`ButtonTableCell\` foi desenvolvido para permitir a inclusão de botões em células de uma tabela, facilitando a execução de ações específicas como exibir detalhes, editar ou excluir um registro.

#### Fluxo de inclusão de usuários à ResultCenter

**Conhecimentos exercitados:** `Java` `Spring` `TypeScript` `React`

Desenvolvi o fluxo de inclusão de usuários à ResultCenter, permitindo que um usuário seja vinculado a uma ResultCenter. Para isso, foi desenvolvido o \`MemberController\` no back-end, responsável pela definição dos endpoints utilizados durante a associação, desassociação e listagem de membros de uma ResultCenter. No front-end, durante a criação de um \`ResultCenter\` é possível utilizar a \`LookUpTextField\` para a pesquisa de usuários existentes para a associação. Os usuários podem ser incluídos ou excluídos de uma lista temporária de membros, que é persistida ao concluir o registro.
