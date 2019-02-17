package ecankurban.stream.sample.list;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;



public class ListVeriOrnek {
	
	public static void main(String[] args) {
		List<String> liste=Arrays.asList(new String[] {"ezgi","beste","ali","ahmet","ferda"});
		liste.stream().filter(s->s.startsWith("e")).map(s-> s.toUpperCase()).sorted().forEach(System.out::println);
		String s1=liste.stream().filter(s->s.startsWith("e")).map(s-> s.toUpperCase()).sorted().toString();
		System.out.println("-------------------------------------------");
		//System.out.println(s1);
		liste.stream().filter((s)->{
			System.out.println("filtre: "+s);
			System.out.println("******************");
			return s.startsWith("a");
			
		}).map((s)->{
			System.out.println("#######################");
			System.out.println("map: "+s);
			return s.toUpperCase();
			
		}).forEach((s)->{
			System.out.println("SSSSSSSSSSSSSSSSSSS");
			System.out.println(s);
		});
		
		System.out.println("///////////////Int Stream Baþlangýcý///////////////");
		
		IntStream.range(1, 10).filter(new IntPredicate() {
			
			@Override
			public boolean test(int value) {//lampda olmadan da new ýntpredicate diyerek methodu eziyoruz.
				//System.out.println(value);bununla tüm sayýlarý da yazýyoruz.
				return value %2!=0;
			}
		}).forEach(System.out::println);
		
		System.out.println("***Lamdalý hali****");
		
		IntStream.range(1, 10).filter((i)->{//lampda ile yazdýk.
			return i%2==0;
			
			
		}).forEach(System.out::println);
		
		System.out.println("---------Lamdalý hali ortalmasý---------");
		IntStream.range(1, 1000).filter(i-> i%2!=0).average().ifPresent(System.out::println);
		
		Arrays.stream(IntStream.range(65, 96).toArray()).mapToObj(s->String.valueOf((char) s)).filter(s->s.compareTo("D")>0).findFirst().ifPresent(System.out::println);
		
	}
}
