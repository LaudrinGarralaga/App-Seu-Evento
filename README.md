![logo](http://sisdia.abmes.org.br/images/logo/5000_Logo.jpg)
# **App SeuEvento** 
## **Desenvolvedores do projeto** 
  
  - Caiã Ceron  
  - Láudrin Rei Garralaga  
  - Luiz Felipe

## **E-mail para contato** 

   - caiaceron@gmail.com  
   - laudrin.garralaga@outlook.com   
   - felipedelibra@hotmail.com
 
 ## **Objetivo** 
 
 O projeto que atualmente se encontra em desenvolvimento tem como o ojetivo a criação de um aplicativo de eventos que tem com foco a divulgação de eventos. 
 
 ## **Tecnologias utilizadas** 
 
  - [PHP 7.0](http://www.php.net/)
  - [MySQL 5.6](https://www.mysql.com/)
  - [Laravel 5.4](https://laravel.com/)
  - [Composer 1.4.2](https://getcomposer.org/)
  - [Java](https://developer.android.com/studio/index.html?hl=pt-br)
  
  
  ## **Clone do projeto Área adiministrativa**
  
   
 1. Faça um clone do projeto 
 > git clone https://github.com/luizpicoli/App_SeuEvento.git
 
 2. Crie um banco de dados com o nome que preferir (ex: app_seuevento), e feito isso abra o arquivo .env e insira nele as informações sobre o nome da banco criado, o nome de usuário e a senha 
 
 3. Abra o CMD (Windowns) e navegue até o diretório do projeto clonado  
 
 4. Para gerar as tabelas do banco será utilizada uma das facilidades do framework, as [_migrations_](https://laravel.com/docs/5.5/migrations), dentro do diretório do projeto no CMD use o comando `php artisan migrate` para que os scripts das tabelas dentro do projeto sejam executados e criem as tabelas no banco  
 
 5. Agora para executar o projeto execute o comando `php artisan serve` para iniciar o servidor de testes e acesse a url `localhost:8000` no navegador para visualizar o projeto
 
  ## **Clone do projeto Área do usuário**
  
  1. Faça um clone do projeto 
 > git clone https://github.com/LaudrinGarralaga/App_SeuEvento.git
 
  2. Copie os arquivos "insere_eventos" e "lista_eventos" que estão na pasta  app_eventos para dentro do xampp na pasata htdocs.
