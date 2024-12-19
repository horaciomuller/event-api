# Desafio: Implementação de Caso de Uso com Arquitetura Limpa

## Contexto

Você está desenvolvendo uma aplicação utilizando **Clean Architecture**, onde os casos de uso (use cases) encapsulam a lógica de negócios. O objetivo deste desafio é implementar um caso de uso para buscar eventos. A principal exigência é que o **EventoGateway** seja injetado na implementação do caso de uso (`BuscarEventoCaseImpl`), enquanto sua implementação concreta será feita na camada de infraestrutura (`EventoRepositoryGateway`).

---

## Passos para Resolver o Desafio

### 1. **Definir o Caso de Uso**
Crie uma interface `BuscarEventoCase` no módulo do core. Esta interface será o contrato para o caso de uso de buscar eventos.

- **Método sugerido:** `List<Evento> buscarTodos()`.
- Essa interface deve ser independente de detalhes de implementação.

---

### 2. **Implementar o Caso de Uso**
Crie uma classe `BuscarEventoCaseImpl` no core. Essa classe deve:

- Implementar a interface `BuscarEventoCase`.
- Receber uma instância de `EventoGateway` por injeção de dependência (constructor injection).
- Delegar ao `EventoGateway` a responsabilidade de buscar os dados no método `buscarTodos`.

---

### 3. **Criar o Gateway de Evento**
No core, crie uma interface `EventoGateway` para definir como a camada de aplicação interage com a infraestrutura. Esse gateway será implementado posteriormente no repositório.

- **Método sugerido:** `List<Evento> listarEventos()`.

---

### 4. **Implementar o Gateway na Infraestrutura**
Na camada de infraestrutura, crie uma classe `EventoRepositoryGateway` que implementa a interface `EventoGateway`.

- Essa classe será responsável por buscar os eventos de uma fonte de dados, como um banco de dados, um serviço externo, ou mesmo um arquivo local.

---

### 5. **Configurar a Injeção de Dependência**
Garanta que o `BuscarEventoCaseImpl` recebe a instância concreta de `EventoRepositoryGateway` ao ser configurado.

- **Exemplo com Spring:** Use as anotações `@Component` e `@Autowired` para configurar os beans.
- Caso não esteja usando um framework, configure manualmente na inicialização da aplicação.

---

### 6. **Expor os Dados no Controlador**
Crie um controlador na camada de entrada para expor a funcionalidade de listar eventos.

- Injete o `BuscarEventoCase` no controlador.
- Chame o método `buscarTodos` para retornar a lista de eventos na resposta da API.

---

## Restrições e Requisitos Específicos

1. **EventoGateway no Core:** O `EventoGateway` **deve estar no core** e ser injetado na implementação do caso de uso.
2. **Implementação na Infra:** O `EventoRepositoryGateway` **deve estar na camada de infraestrutura** e implementar o `EventoGateway`.

---

## Benefícios

1. **Flexibilidade:** Alterar a implementação do gateway (como trocar o repositório) não impactará o core.
2. **Manutenção:** Cada camada tem responsabilidades claras, reduzindo o impacto de mudanças.
3. **Testabilidade:** As dependências podem ser mockadas, permitindo testes isolados.

---

Boa sorte com o desafio! 🎯
