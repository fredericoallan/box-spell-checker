### Box Spell Checker

Box Speel Checker é uma ferramenta feita em java para verificar a correta grafia em qualquer tipo de arquivo. Ela utiliza arquivos de configuração para determinar que diretórios e extensões de arquivos devem ser validados usando [regex].


## Arquivos necessários

<b>Para um teste rápido, faça download:</b>
- box-spell-checker.jar
- config.json
- dicionario_pt_BR.json

Após isso, leia a sessão de execução no final deste readme


## Pré-requisitos

```
java version 1.8.0

```

## Instalação

Garanta que o java esteja instalado no seu servidor/PC.

```
$ java -version

Openjdk version "1.8.0_72-internal"
OpenJDK Runtime Environment (build 1.8.0_72-internal-b15)
OpenJDK 64-Bit Server VM (build 25.72-b15, mixed mode)
```

## config.json


Este arquivo contém as extensões e diretório raiz dos arquivos que devem ser validados. Caso preencha as informações de arquivos customizados ("files":["index.html","login.html"]) a ferramenta irá procurar somente por estes através do diretório configurado.

A propriedade 'regex' contém a expressão regular para captura de frases, ou conjunto de palavras, dentro dos arquivos encontrados. Após a listagem destas frases, elas serão quebradas em palavras e verificadas dentro de um dicionário. 

```
{
  "Extensions": [
    {
      "Extension": "html"
      "Path": "/home/user/temp"
      "Files": [ "index.html", "login.html"]
      "Regex": {
       "Expressions": [
                       "> ([A-zA-Z0-9] +) <\ /"
                       "<Div class = (w +) <\ / div>"
                      ]
       "Group": 1
     }
    },
    {
      "Extension": "java"
      "Path": "/root"
      "Files": [],
      "Regex": {
       "Expressions": [
                       "AB ([0-5] +)"
                      ]
       "Group": 1
     }
    }
  ]
 "DictionaryFile":"./dictionary/dictionary.json"
  }
```

<b>OBS: cuidados com os 'escapes' nas expressões regulares, dentro deste arquivo, pois serão utilizadas duas barras "\\" para que a ferramenta interprete a string de regex corretamente</b>

## Dicionário

Este arquivo contém todas as palavras conhecidas e com grafia correta que podem existir dentro do sistema que esteja verificando.

```
{
  "dicionario":[
    "cas(a|as)"
    "verifica(ção|ções)",
    "consulta(r|rem|riam)"
  ]
}
```

As palavras do dicionário também são escritas com expressões regulares ([regex]) e podem ter variações. Ex:

```
abrir
abriram
abrirem
```

No dicionário pode ser escrito desta forma:

```
abri(r|ram|rem)
```


## Execução

1) Abra o terminal no diterório do arquivo box-spell-checker.jar

```sh
user@machine~/box-spell-checker $

```

2) Execute o comando

```sh
java -jar box-spell-checker.jar

```

3) Valide o log de erros e estatísticas de resultados no próprio terminal. Ex:

```sh
LOG OF EXECUTION - 03/25/2016

1) /home/user/temp/test/text.txt:
- Line 1: 'housess', 'systenm'
- Line 10: 'programmmers'

2) /home/user/temp/test/index.html:
- Line 122: 'Faail'

Result: (2) files (35) words (4) errors

```

[//]: # (These are urls of references used in this document)

[regex]: <https://pt.wikipedia.org/wiki/Express%C3%A3o_regular>
