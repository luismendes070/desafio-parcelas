package me.dio.credit.application.system

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CreditApplicationSystemApplication

fun main(args: Array<String>) {
	try{
		runApplication<CreditApplicationSystemApplication>(*args)
	}catch(e:Exception){

		e.printStackTrace()

	}finally{

	}
}
