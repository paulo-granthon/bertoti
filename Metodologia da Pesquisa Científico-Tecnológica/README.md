Portfolio
=========

<img alt="GitHub Profile Picture" src="https://avatars.githubusercontent.com/u/93501477?v=4" height="128" />

Paulo Granthon
--------------

Semestre Atual: 4

Backend developer intern at @gorilainvest | Database technologist student at FATEC | Self titled full-stack developer

Projects
--------

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
