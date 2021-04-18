# gazin-api
A continuação insiro detalhes de configuração e especificação da API implementada e usada no projeto.
Foi desenvolvida uma API REST JSON conforme orientado usando o framework Spring boot, foi usado o banco em memória H2 para este teste, mas disponibilizo dentro da pasta gazin-api o script sql para a criação do banco de dados e a tabela no SGBD Mysql casso deseje ser usado em futuras versões.
Criei uma API usando o Spring boot pois considero uma ótima opção para o desenvolvimento de software pela sua rapidez de resposta e outras vantagens.  
Baixe os arquivos fontes da API REST desenvolvida a partir da seguinte URL: 
https://github.com/silveiraSoft/gazin-api
O Toncat vai usar a porta 8080, assegure que no Docker não esteja sendo usado esta porta.
Tenha em conta a especificação da porta e domínio para que o sistema cliente possa acessar aos Endpoint da API sem ter que realizar modificações no código do sistema cliente.
Passos para criar imagem e container usando docker.
1 - Abra a linha de Comando de Windows ou Shell e entre na pasta gazin-api, raiz do arquivo Dockerfile que vamos usar para criar o container onde vai estar a máquina virtual de java, etc, usados para o funcionamento da API desenvolvida.
Passos para a criação da imagem e container usando docker. 
1-	 Baixe localmente a API usada para o projeto a partir da seguinte URL:
https://github.com/silveiraSoft/gazin-api
2-	Execute os seguintes comandos para criar a imagem e o container que permitão o funcionamento da API. 
Nos comandos seguintes pode substitui o nome adalbertosn pelo seu login no Docker.
..> docker build -t adalbertosn/gazin-api:0.0.1-SNAPSHOT .
..> docker run -d -p 8080:8080 adalbertosn/gazin-api:0.0.1-SNAPSHOT
..> docker ps
O comando anterior permite validar se está iniciado o container e permite visualizar o comando que está sendo executado.

