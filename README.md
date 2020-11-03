![logo-provisória](https://github.com/caionog/MusicManager/blob/master/Music%20Manager/src/gui/resources/music-manager-logo.png)

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

Os arquivos mp3 que são usados para gerar a classe música estão em data/mp3Storage.
Os arquivos txt que são usados para armazenar as informações geradas estão em data/txt storage

Os arquivos fxml estão no pacote gui.view e seus respectivos controladores estão no pacote gui.controller

Para testar os métodos, utilize o gui/BackendTeste 

Funcionalidades implementadas no javaFX:
Criação e edição de usuários
Sistema de Login
Criação de músicas
Criação e edição de playlists
Adicionar músicas novas por meio de um arquivo .mp3
Gerar relatório de uma música







