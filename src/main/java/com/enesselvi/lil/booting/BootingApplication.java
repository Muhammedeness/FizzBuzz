package com.enesselvi.lil.booting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@SpringBootApplication
public class BootingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootingApplication.class, args);
	}
//FizzBuzz Yaz
//3 ile bölünüyorsa Fizz
//5 ile bölünüyorsa Buzz
	@Bean
	public CommandLineRunner run(){
		//Klasik Yöntem
		/*String f = "Fizz";
		String b="Buzz";
		String fb="FizzBuzz";
		return args -> {
				for (int i = 0; i <= 100; i++) {
					if (i % 3 == 0 &&  i % 5 == 0) {
						System.out.println(fb);
					} else if (i % 5 == 0) {
						System.out.println(b);
					}else if (i % 3 == 0) {
						System.out.println(f);
					}else
					 System.out.println(i);
				}
			};*/

		//Stream api
		return args -> {
			AtomicInteger count = new AtomicInteger(0);
			IntStream.rangeClosed(1,100)
					.mapToObj( i -> {
						if (i%3==0 && i%5==0) return "FizzBuzz";
						else if  (i%3==0) return "Fizz";
						else if  (i%5==0) return "Buzz";
						else return String.valueOf(i);
					}).forEach( s -> {
						System.out.print(s + " ");
						count.set(count.get() + 1);
						if (count.get() % 5==0) {
							System.out.println();
						}
					});
		};
	}
}
