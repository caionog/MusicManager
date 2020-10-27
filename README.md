![logo-provisória](https://github.com/caionog/MusicManager/blob/master/music-manager-logo.png)

# MusicManager

Projeto feito utilizando:
Java jdk 13.0.2
Apache Maven 3.6.3
Eclipse IDE for Java Developers 4.15.0
Construa o projeto antes de rodar para baixar as dependências pelo maven.

O main do código está em gui/Applications.java

As classes base estão no pacote negócio.
Os repositórios das classes base estão no pacote data/MusicRepo, data/PlaylistRepo e data/UserRepo.
Os métodos das classes base como por exemplo: Criar música, criar playlist, registrar ou logar usuário, editar playlist, gerar metadados, etc
estão no pacote negócio.controllers

Os arquivos mp3 que são usados para gerar a classe música está em data/mp3Storage.
Os arquivos txt que são usados para armazenar as informações geradas estão em data/txt storage

Os arquivos fxml estão no pacote gui.view e seus respectivos controladores estão no pacote gui.controller

As funcionalidades principais do sistema como CRUDS de músicas,playlists e usuários, extração de informações e metadados de um arquivo .mp3, sistema de login e
geração de arquivos txts com informações da música estão funcionando em linha de comando mas nem todas as funcionalidades estão implementadas na interface gráfica.

Para testar os métodos, utilize o gui/BackendTeste 

Funcionalidades implementadas no javaFX:
Criação de usuários
Sistema de Login
Criação de músicas

Funcionalidades que ainda faltam implementer no javaFX:
Edição de usuários
Criação e edição de playlists
Gerar metadados de uma música
Gerar relatório de uma música
Adicionar músicas novas por meio de um arquivo .mp3





