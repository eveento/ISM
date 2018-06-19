	  create table Canoe(
      id int not null primary key,
      url varchar_ignorecase(50) not null,
      status int,
      size varchar_ignorecase(50) not null,
      number int
      );
      
      create table User(
      id int not null primary key,
      name varchar_ignorecase(50) not null,
      login varchar_ignorecase(50) not null,
      password varchar_ignorecase(50) not null,
      email varchar_ignorecase(50) not null
      );

