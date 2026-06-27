# 🧱 Calculadora de Obra (Spring Boot + Jakarta Faces)

Projeto desenvolvido para cálculo de materiais de construção, incluindo:

* 🧱 Quantidade de tijolos
* 🧱 Volume de concreto
* 🚪 Descontos de portas e janelas
* 📏 Cálculos baseados em áreas e volumes reais
* 🖥️ Frontend em Jakarta Faces (JSF) integrado ao backend
* 📋 Geração e busca de orçamentos

---

# 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Maven
* Jakarta Faces (JSF) via JoinFaces (Mojarra)
* Swagger (Springdoc OpenAPI)
* REST API
* H2 Database (em memória)
* JUnit 5 (Testes automatizados)
* Spring Boot Test (MockMvc)

---

# 📦 Estrutura do projeto

O projeto está dividido em:

```
controller/
service/
model/
dto/
repository/
bean/
test/
webapp/
resources/static/
```

### Principais services:

* `TijoloService` → cálculo de quantidade de tijolos (m²)
* `ConcretoService` → cálculo de volume (m³)

### Principais beans (frontend JSF):

* `PlantaBean` → cadastro de cômodos e paredes, e cálculo do orçamento
* `OrcamentoBean` → busca de orçamentos por número ou nome do usuário

---

# 🖥️ Frontend (Jakarta Faces)

O frontend foi desenvolvido em Jakarta Faces (JSF), rodando junto com o Spring Boot através do JoinFaces.

## 📄 Telas

* **`index.xhtml`** → tela principal: cadastro de solicitante, cômodos e paredes (com porta/janela opcionais), tijolo de referência, e exibição do resultado do orçamento calculado
* **`buscaOrcamento.xhtml`** → tela de busca de orçamentos já salvos, por número ou por nome do usuário

## 🎨 Estilização

O layout usa um CSS próprio em `src/main/resources/static/style.css`, servido pelo Spring Boot e referenciado nas páginas via:

```xml
<link rel="stylesheet" type="text/css" href="/style.css" />
```

> ⚠️ Não usar `<h:outputStylesheet>` apontando para `webapp/resources`, pois o Spring Boot não serve essa pasta — os arquivos estáticos devem ficar em `src/main/resources/static/`.

## 📋 Fluxo de uso

1. Informar o nome do solicitante
2. Cadastrar um cômodo (nome, largura, comprimento, altura)
3. Adicionar uma ou mais paredes ao cômodo (com ou sem porta/janela)
4. Finalizar o cômodo e repetir para os demais ambientes da planta
5. Informar as dimensões do tijolo de referência
6. Clicar em **Calcular Obra** → o sistema gera a área total, volume de concreto e quantidade de tijolos, além de um **número de orçamento**
7. O orçamento é salvo no banco e pode ser consultado depois na tela de busca

---

# 📋 Orçamentos

Cada cálculo gera um registro de orçamento persistido no banco H2, contendo:

* Número do orçamento (gerado automaticamente)
* Nome do usuário solicitante
* Data de criação
* Área total, volume de concreto e quantidade de tijolos calculados

A entidade `Orcamento` é gerenciada pelo `OrcamentoRepository`, com busca por:

* Número exato (`findByNumero`)
* Nome do usuário, parcial e case-insensitive (`findByNomeUsuarioContainingIgnoreCase`)

---

# 🧪 Testes Automatizados

O projeto possui testes automatizados para garantir o funcionamento correto da API e das regras de negócio.

## ⚙️ Tecnologias utilizadas nos testes

* JUnit 5
* Spring Boot Test
* MockMvc
* H2 Database (em memória)

---

## 📦 Estrutura dos testes

Os testes estão localizados em:

```
src/test/java/
```

Organizados por camada:

```
controller/
service/
CalculadoraObraApplicationTests.java
```

---

## 🚀 Tipos de testes implementados

### ✔ Teste de contexto da aplicação

Valida se o Spring Boot sobe corretamente.

```
@SpringBootTest
class CalculadoraObraApplicationTests {

    @Test
    void contextLoads() {
    }
}
```

---

### ✔ Testes de Service (regras de negócio)

Validam os cálculos de forma isolada.

* TijoloService → cálculo de quantidade de tijolos
* ConcretoService → cálculo de volume de concreto

---

### ✔ Testes de Controller (API REST)

Utilizam MockMvc para simular requisições HTTP reais.

Exemplo:

```
mockMvc.perform(post("/comodos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.nome").value("Sala"));
```

---

### ✔ Testes manuais de fluxo (Frontend)

Além dos testes automatizados, foi elaborado um **Plano de Teste** cobrindo o fluxo completo via interface JSF (cadastro de cômodo/parede, cálculo, geração e busca de orçamento), com evidências de execução. Documento disponível junto à entrega da atividade.

---

## 🧪 Como executar os testes

Via IntelliJ:

* Botão direito na pasta `test`
* Run Tests

---

# 🧠 Modelagem do sistema (Grafo da planta)

O sistema representa a planta da casa como um **grafo**:

* 🔵 Vértices → pontos da planta (cantos/pilares)
* 🧱 Arestas → paredes entre os vértices
* 🏠 Cômodos → conjunto de paredes formando um espaço fechado

### 📌 Entidades principais:

* `Vertice` → nós do grafo
* `Aresta` → paredes ligando dois vértices
* `Comodo` → conjunto de arestas formando um ambiente
* `Orcamento` → registro do cálculo final, vinculado a um usuário

---

# 🧱 1. Cálculo de Tijolos

## 📌 Como funciona

O sistema calcula a área das paredes e desconta:

* portas
* janelas

Depois divide pela área de um tijolo.

### 📐 Fórmula:

```
área líquida / área do tijolo
```

---

## 🧪 Exemplo de teste (Swagger)

```json
{
  "arestas": [
    {
      "id": 1,
      "comprimento": 5.0,
      "espessura": 0.2,
      "temPorta": true,
      "alturaPorta": 2.1,
      "larguraPorta": 0.9,
      "temJanela": true,
      "alturaJanela": 1.2,
      "larguraJanela": 1.5,
      "inicio": {
        "id": 1,
        "nome": "Sala"
      },
      "fim": {
        "id": 2,
        "nome": "Cozinha"
      },
      "largura": 3.0
    },
    {
      "id": 2,
      "comprimento": 4.0,
      "espessura": 0.2,
      "temPorta": false,
      "temJanela": true,
      "alturaJanela": 1.0,
      "larguraJanela": 1.2,
      "inicio": {
        "id": 2,
        "nome": "Cozinha"
      },
      "fim": {
        "id": 3,
        "nome": "Quarto"
      },
      "largura": 2.8
    }
  ],
  "altura": 3.0,
  "comprimentoTijolo": 0.29,
  "larguraTijolo": 0.14
}
```

---

## 📊 Resultado esperado aproximado

```
~545 tijolos
```

---

# 🧱 2. Cálculo de Concreto (Volume)

## 📌 Como funciona

O volume é calculado usando:

### 📐 Fórmula:

```
comprimento × altura × espessura da viga
```

---

## 🧪 Exemplo de teste

```json
{
  "arestas": [
    {
      "id": 1,
      "comprimento": 5.0,
      "espessura": 0.2,
      "inicio": {
        "id": 1,
        "nome": "Sala"
      },
      "fim": {
        "id": 2,
        "nome": "Cozinha"
      }
    },
    {
      "id": 2,
      "comprimento": 4.0,
      "espessura": 0.2,
      "inicio": {
        "id": 2,
        "nome": "Cozinha"
      },
      "fim": {
        "id": 3,
        "nome": "Quarto"
      }
    }
  ],
  "altura": 0.3
}
```

---

## 📊 Resultado esperado

```
~5.24 m³ (aprox. 5.4 no Swagger)
```

---

# 🧪 Exemplo de teste (Frontend / Tela JSF)

Cenário simples para validar o fluxo completo pela interface:

**Cômodo:** Sala — Largura 4m, Comprimento 5m, Altura 2.8m
**Parede:** Comprimento 5m, Espessura 0.15m, sem porta/janela
**Tijolo de referência:** 0.19m x 0.09m

## 📊 Resultado esperado

```
Área total: 20 m²
Volume de concreto: 2.1 m³
Quantidade de tijolos: 819
```

---

# ⚙️ Swagger (como testar a API)

## 📍 Acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 Passo a passo de teste

1. Abrir Swagger
2. Escolher endpoint (`/tijolo` ou `/concreto`)
3. Clicar em **Try it out**
4. Colar o JSON
5. Clicar em **Execute**
6. Ver resultado no response

---

# 🌐 Frontend (como testar)

## 📍 Acesse:

```
http://localhost:8080/index.xhtml
```

## 🧪 Passo a passo de teste

1. Informar nome do solicitante
2. Cadastrar cômodo e suas paredes
3. Clicar em **Calcular Obra**
4. Conferir o número do orçamento gerado e os totais calculados
5. Acessar **Buscar orçamentos existentes** para localizar pelo número ou nome do usuário

---