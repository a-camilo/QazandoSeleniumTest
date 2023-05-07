# language:pt

Funcionalidade: Cadastrar usuários

  Contexto:
    Dado que estou na home do Qazando Shop
    E acessar a tela de cadastro

  @Cadastro
  Esquema do Cenario: Registrar um novo usuário <nome>
    Quando preencher o formulario "<Nome>" "<E-mail>" "<Senha>"
    Entao visualizo a mensagenm de cadastro com "<tipo>"
    Exemplos:
      | Nome         | E-mail               | Senha  | tipo                                           | nome                                  |
      | Peter Parker | p.parker@gmail.com   | 123456 | Cadastro realizado!                            | campo com sucesso                     |
      |              | b.waynne@gmail.com   | 123456 | O campo nome deve ser prenchido                | campo nome vazio                      |
      | Clark Kent   |                      | 123456 | O campo e-mail deve ser prenchido corretamente | campo email vazio                     |
      | Tony Stark   | tony_stark@gmail.com |        | O campo senha deve ter pelo menos 6 dígitos    | campo senha vazia                     |
      | Tony Stark   | tony_stark@gmail.com | 12345  | O campo senha deve ter pelo menos 6 dígitos    | campo senha deve ter minimo 6 digitos |
      | Peter Parker | p.parkergmail.com    | 123456 | O campo e-mail deve ser prenchido corretamente | campo email inválido                  |
      |              |                      |        | O campo nome deve ser prenchido                | todos os campos vazios                |