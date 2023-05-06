# language: pt

@Login
Funcionalidade: Logar shop Qazando

  Contexto:
    Dado que estou na home do Qazando Shop
    E acessar a tela de login

  Esquema do Cenario: Efetuar login <cenario>
    Quando inserir minhas credenciais "<E-mail>", "<Senha>"
    Entao devo visualizar a mensagem na tela "<statusSenha>"
    Exemplos:
      | E-mail            | Senha  | statusSenha            | cenario              |
      | example@gmail.com | 123456 | Olá, example@gmail.com | com sucesso          |
      | example@gmail.com | 12345  | Senha inválida.        | com a senha inválida |
      | example@gmail.com |        | Senha inválida.        | com a senha vazia    |
      | examplegmail.com  | 123456 | E-mail inválido.       | com o email inválido |
      |                   |        | E-mail inválido.       | com o email vazio    |