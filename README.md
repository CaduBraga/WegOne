<p align="center">
  <img src="/src/main/webapp/imagens/logoTransparente.png" alt="Logo do Projeto" width="300">
</p>

# 📝 Descrição

Este repositório contém o projeto desenvolvido como parte da **Situação de Aprendizagem Interdisciplinar** do **CentroWeg - MIDS 77**. O objetivo foi integrar os conhecimentos adquiridos nas disciplinas de:

- **Lógica da Programação**
- **Implementação de Banco de Dados**
- **Inglês Técnico**
- **Metodologias Ágeis e Versionamento**

Além disso, utilizamos também conhecimentos de outras disciplinas, como **Técnicas de Programação**, **Web Design UI/UX** e **Programação Front-End**, entre outras.

## 🎯 Objetivo

O WegOne é um sistema de gerenciamento de manuais técnicos que permite:
- Cadastro e gerenciamento de diferentes tipos de manuais
- Suporte a múltiplos idiomas (Português, Inglês, Espanhol, Francês e Alemão)
- Interface intuitiva para usuários
- Armazenamento seguro dos dados através de um banco de dados na nuvem

---

# 📂 Estrutura do Projeto

```
WegOne/
├── src/
│   ├── main/
│   │   ├── java/                   # Código fonte Java
│   │   └── resources/
│   │       └── translate/          # Arquivos de tradução
│   └── test/                       # Testes unitários
├── .vscode/                        # Configurações do VS Code
├── target/                         # Arquivos compilados
├── pom.xml                         # Configuração Maven
├── README.md                       # Documentação
└── Relatorio de acompanhamento.pdf # Relatório de atividades
```

---

# 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal de desenvolvimento
- **Maven**: Gerenciamento de dependências e build
- **JSON**: Arquivos de tradução
- **Git**: Controle de versão
- **[Jira](https://wegone.atlassian.net/jira/software/projects/SCRUM/summary)**: Gerenciamento ágil do projeto (Scrum)
- **[Railway](https://railway.com/project/d14c7361-63e6-470e-9e43-4707af562791?environmentId=6efe2ce2-5ce4-40b2-9129-1f8a9e87c5c0)**: Plataforma de hospedagem e integração com banco de dados
- **HTML/CSS**: Desenvolvimento do frontend

---

# 📱 Versão Atual

Na versão atual do projeto, implementamos:
- Frontend completo com interface moderna e responsiva
- Integração com banco de dados através do Railway
- Sistema de tradução multi-idioma

> **⚠️ Nota:** O frontend foi desenvolvido como um protótipo funcional, mas devido a limitações de tempo, não foi possível realizar a integração completa com o backend. O sistema está pronto para receber as integrações necessárias em futuras versões.

---

# ▶️ Como Executar

## Pré-requisitos
- Java JDK 17 ou superior
- Maven 3.6 ou superior
- IDE de sua preferência (recomendado: VS Code, IntelliJ IDEA ou Eclipse)

## Passos para Execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/CaduBraga/WegOne.git
   cd WegOne
   ```

2. **Compile o projeto**
   ```bash
   mvn clean install
   ```

3. **Execute o programa**
   ```bash
   mvn exec:java -Dexec.mainClass="com.wegone.Main"
   ```

## Executando na IDE

1. Abra o projeto na sua IDE
2. Localize a classe `WegOne.java`
3. Execute a classe principal

> **💡 Dica:** Para verificar se o Java está instalado corretamente:
> ```bash
> java -version
> mvn -version
> ```

---

# 🤝 Contribuição

Este projeto foi desenvolvido como parte de um aprendizado em equipe. Futuras melhorias e integrações podem incluir, por exemplo, a integração completa do front-end com o back-end.

## 👨‍💻 **Equipe**
- **Equipe Dev**:
  - <a href="https://github.com/andrMiotto" target="_blank">André Luis Miotto Pereira</a> - **Product Owner e Traduções (JSON)**
  - <a href="https://github.com/CaduBraga" target="_blank">Carlos Eduardo Braga</a> - **DBA**
  - <a href="https://github.com/lucasschlei" target="_blank">Lucas Schlei</a> - **Scrum Master e Dev Front-End**
  - <a href="https://github.com/Murilo2901" target="_blank">Murilo Kerschbaum</a> - **Dev Front-End**

## 📚 **Agradecimentos**
Gostaríamos de agradecer aos professores que disponibilizaram tempo de aula para trabalharmos no projeto:

- **Professores Orientadores**:
  - Bruno da Silva Andrade
  - João Pedro Silva Valentim
  - Matheus Quost

E aos demais professores que nos apoiaram em outras etapas do projeto:

- Kristian Erdmann 
- Vinicius Matheus Jacobowski Trindade
- Willer Rezende Motti

---

## 💡 Observação Final

Este projeto foi desenvolvido com foco em boas práticas de programação, documentação clara e código limpo. A estrutura modular permite fácil manutenção e expansão futura. 