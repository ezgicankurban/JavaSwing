package ecankurban.stream.sample.list;

import java.util.ArrayList;
import java.util.List;

public class ListeOrnek {
	
	public static void main(String[] args) {
		List<Integer> sayilar=new ArrayList<Integer>();//sayilar listesinin stream e d�n��mesi List in collection framework i�inde olmas�d�r.
		for (int i = 0; i < 10; i++) {
			sayilar.add(i);
		}
		sayilar.stream().mapToInt(n -> n).average().ifPresent(System.out::println);//sayilar-average aras�nda olan sonucu ifPresent sysout a parametre olarak g�nderiyor.
		sayilar.stream().mapToInt(n->n).average().ifPresent((a)->{//lampda ile kendi methodumu yazd�m.
			System.out.println("Ortalma:"+a);
		});
		
		sayilar.stream().forEach(System.out::println);
		sayilar.stream().forEach((s)->{
			System.out.println("Elemanlar�n iki kat�:"+s*2);
		});
	}
	

}
