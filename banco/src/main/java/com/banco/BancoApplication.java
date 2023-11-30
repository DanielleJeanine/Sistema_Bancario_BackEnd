package com.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}
	/*
	 1-colocar anotaçoes para criar as tabelas no postgres
	 2-fazer as ligações entre chaves primarias e estrangeiras
	 3-mudar o arquivo properties
	 */
}
