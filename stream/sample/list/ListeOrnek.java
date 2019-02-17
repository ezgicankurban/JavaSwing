package ecankurban.stream.sample.list;

import java.util.ArrayList;
import java.util.List;

public class ListeOrnek {
	
	public static void main(String[] args) {
		List<Integer> sayilar=new ArrayList<Integer>();//sayilar listesinin stream e dönüþmesi List in collection framework içinde olmasýdýr.
		for (int i = 0; i < 10; i++) {
			sayilar.add(i);
		}
		sayilar.stream().mapToInt(n -> n).average().ifPresent(System.out::println);//sayilar-average arasýnda olan sonucu ifPresent sysout a parametre olarak gönderiyor.
		sayilar.stream().mapToInt(n->n).average().ifPresent((a)->{//lampda ile kendi methodumu yazdým.
			System.out.println("Ortalma:"+a);
		});
		
		sayilar.stream().forEach(System.out::println);
		sayilar.stream().forEach((s)->{
			System.out.println("Elemanlarýn iki katý:"+s*2);
		});
	}
	

}
