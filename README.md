Aqui vai um **README bem organizado e pronto pra GitHub**, resumindo tudo que vocês fizeram e explicando como testar o sistema.

---

# 🧱 Calculadora de Obra (Spring Boot)

Projeto desenvolvido para cálculo de materiais de construção, incluindo:

* 🧱 Quantidade de tijolos
* 🧱 Volume de concreto
* 🚪 Descontos de portas e janelas
* 📏 Cálculos baseados em áreas e volumes reais

---

# 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Maven
* Swagger (Springdoc OpenAPI)
* REST API

---

# 📦 Estrutura do projeto

O projeto está dividido em:

```
controller/
service/
model/
dto/
```

### Principais services:

* `TijoloService` → cálculo de quantidade de tijolos (m²)
* `ConcretoService` → cálculo de volume (m³)

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
      "comprimento": 5.0,
      "espessura": 0.2,
      "temPorta": true,
      "alturaPorta": 2.1,
      "larguraPorta": 0.9,
      "temJanela": true,
      "alturaJanela": 1.2,
      "larguraJanela": 1.5,
      "largura": 3.0
    },
    {
      "comprimento": 4.0,
      "espessura": 0.2,
      "temPorta": false,
      "temJanela": true,
      "alturaJanela": 1.0,
      "larguraJanela": 1.2,
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
comprimento × altura × espessura
```

---

## 🧪 Service atual

```java
volumeParede = a.getComprimento() * altura * a.getEspessura();
```

---

## 🧪 Exemplo de teste

```json
{
  "arestas": [
    {
      "comprimento": 5.0,
      "espessura": 0.2,
      "largura": 3.0
    },
    {
      "comprimento": 4.0,
      "espessura": 0.2,
      "largura": 2.8
    }
  ],
  "altura": 3.0
}
```

---

## 📊 Resultado esperado

```
~5.24 m³ (aprox. 5.4 no Swagger)
```

---

# ⚙️ Swagger (como testar a API)

## 📍 Acesse:

```
http://localhost:8080/swagger-ui/index.html
```

ou:

```
http://localhost:8080/swagger-ui.html
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

# 🧠 Lógica do sistema

## ✔ Tijolos:

* calcula área
* desconta portas e janelas
* divide pela área do tijolo
* arredonda para cima

## ✔ Volume:

* calcula volume da parede
* usa espessura estrutural
* soma todas as paredes


