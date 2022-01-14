import java.io.*;
import java.util.*;

public class KanIhtiyaci extends Kizilay implements OrtakFonksiyonlar
{	
	Scanner klavye = new Scanner(System.in);
	
	private ArrayList<String> kanIhtiyacListesi = new ArrayList<String>();
	private ArrayList<String> kanBagisListesi = new ArrayList<String>();
	
	@Override
	public void girisYazisi()
	{
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t   KAN ÝHTÝYAÇ SÝSTEMÝ");
	}
	
	@Override
	public void secimYapma()
	{
		KanBagisi kanBagisi = new KanBagisi();
		
		KanIhtiyaci kanIhtiyaci = new KanIhtiyaci();
		
		do
		{	
			System.out.println("Ne yapmak istiyorsunuz?");
			System.out.println("1: Yeni Kayýt Formu Doldur");
			System.out.println("2: Ana Menüye Geri Dön");
			System.out.print("Seçiminiz: ");
			setSecim(klavye.nextInt());
			switch(getSecim())
			{
				case 1:
					kanIhtiyaci.kayitFormu();
					System.out.println();
					break;
				case 2:
					kanBagisi.setKontrol(false);
					setKontrol1(true);
					System.out.println();
					break;
				default:
					System.out.println();
					System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
					System.out.println();
					break;
			}
		}
		while(kanBagisi.getKontrol());
	}
	
	@Override
	public void kayitFormu()
	{	
		KanBagisi kanBagisi = new KanBagisi();
		
		try
		{
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Baðýþ Listesi.txt"));
			
			String satir = null;
			kanBagisi.setSayac(0);
			satir = girisAkimi.readLine();
			
			while(satir != null)
			{
				kanBagisi.setSayac(kanBagisi.getSayac() + 1);
				kanBagisListesi.add(satir.trim());
				satir = girisAkimi.readLine();
			}
			girisAkimi.close();
		}
		catch(FileNotFoundException e)
		{
			//System.out.print("Kan Baðýþ Listesi.txt dosyasý bulunamadý veya açýlamadý.");
		}
		catch(IOException e)
		{
			System.out.println();
			System.out.print("Kan Baðýþ Listesi.txt dosyasýndan veri giriþinde hata oluþtu.");
			System.out.println();
		}
		
		PrintWriter ciktiAkimi3 = null;
		String dosya3 = "Kan Baðýþ Listesi.txt";
		
		try
		{
			ciktiAkimi3 = new PrintWriter(new FileOutputStream(dosya3));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println();
			System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
			System.exit(0);
		}
		
		for(int i = 0; i < kanBagisListesi.size(); i++)
		{
			ciktiAkimi3.println(kanBagisListesi.get(i));
		}
		ciktiAkimi3.close();
		
		try
		{
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Ýhtiyaç Listesi.txt"));
			
			String satir = null;
			kanBagisi.setSayac(0);
			satir = girisAkimi.readLine();
			
			while(satir != null)
			{
				kanBagisi.setSayac(kanBagisi.getSayac() + 1);
				kanIhtiyacListesi.add(satir);
				satir = girisAkimi.readLine();
			}
			girisAkimi.close();
		}
		catch(FileNotFoundException e)
		{
			//System.out.print("Kan Ýhtiyaç Listesi.txt dosyasý bulunamadý veya açýlamadý.");
		}
		catch(IOException e)
		{
			System.out.println();
			System.out.print("Kan Ýhtiyaç Listesi.txt dosyasýndan veri giriþinde hata oluþtu.");
			System.out.println();
		}
		
		PrintWriter ciktiAkimi4 = null;
		String dosya4 = "Kan Ýhtiyaç Listesi.txt";
		
		try
		{
			ciktiAkimi4 = new PrintWriter(new FileOutputStream(dosya4));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println();
			System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
			System.exit(0);
		}
		
		for(int i = 0; i < kanIhtiyacListesi.size(); i++)
		{
			ciktiAkimi4.println(kanIhtiyacListesi.get(i));
		}
		ciktiAkimi4.close();
		
		System.out.println();
		System.out.print("*****BUGÜNÜN TARÝHÝ*****");
		System.out.println();
		do
		{	
			try
			{
				kanBagisi.setKontrolEkstra1(true);
				kanBagisi.setKontrolEkstra2(true);
				kanBagisi.setKontrolEkstra3(true);
				
				System.out.print("Gün : ");
				kanBagisi.setGun1(klavye.nextInt());
				if(kanBagisi.getGun1() < 0 || kanBagisi.getGun1() > 31)
				{
					System.out.println();
					System.out.println("Gün deðeri 0'dan küçük ya da 31'den büyük olamaz. Lütfen tekrar deneyiniz...");
					System.out.println();
				}
				else
				{
					do
					{
						System.out.print("Ay (örneðin \"þubat\" ayý için \"2\") : ");
						kanBagisi.setAy1(klavye.nextInt());
						if(kanBagisi.getAy1() < 0 || kanBagisi.getAy1() > 12)
						{
							System.out.println();
							System.out.println("Ay deðeri 0'dan küçük ya da 12'den büyük olamaz. Lütfen tekrar deneyiniz...");
							System.out.println();
						}
						else
						{
							do
							{
								System.out.print("Yýl :  ");
								kanBagisi.setYil1(klavye.nextInt());
								if(kanBagisi.getYil1() < 0)
								{
									System.out.println();
									System.out.println("Yýly deðeri 0'dan küçük olamaz. Lütfen tekrar deneyiniz...");
									System.out.println();
								}
								else
								{
									kanBagisi.setKontrolEkstra1(false);
									kanBagisi.setKontrolEkstra2(false);
									kanBagisi.setKontrolEkstra3(false);
									
									kanBagisi.setTarih(kanBagisi.getGun1() + "." + kanBagisi.getAy1() + "." + kanBagisi.getYil1());
								}
							}
							while(kanBagisi.getKontrolEkstra3());
						}
					}
					while(kanBagisi.getKontrolEkstra2());
				}
			}
			catch(Exception e)
			{
				System.out.println("HATA: " + e.getMessage());
				System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
				System.out.println();
				kanBagisi.setDuzeltme(klavye.nextLine());
			}	
		}
		while(kanBagisi.getKontrolEkstra1());
		
		System.out.println();
		System.out.print("*****KAN BAÐIÞÇISI ADAYININ KÝMLÝK BÝLGÝLERÝ*****");
		System.out.println();
	
		kanBagisi.setDuzeltme(klavye.nextLine());
		
		System.out.print("T.C. Kimlik Numaranýz : ");
		kanBagisi.setTCKimlikNo(klavye.nextLine());
		
		System.out.print("Adýnýz Soyadýnýz : ");
		kanBagisi.setAdSoyad(klavye.nextLine());
		
		System.out.print("Baba Adýnýz : ");
		kanBagisi.setBabaAdi(klavye.nextLine());
		
		do
		{
			kanBagisi.setKontrolEkstra1(true);
			
			System.out.println("Doðum Tarihiniz");
			do
			{	
				kanBagisi.setKontrolEkstra1(true);
				kanBagisi.setKontrolEkstra2(true);
				kanBagisi.setKontrolEkstra3(true);
				
				System.out.print("Gün : ");
				kanBagisi.setGun2(klavye.nextInt());
				if(kanBagisi.getGun2() < 0 || kanBagisi.getGun2() > 31)
				{
					System.out.println();
					System.out.println("Gün deðeri 0'dan küçük ya da 31'den büyük olamaz. Lütfen tekrar deneyiniz...");
					System.out.println();
				}
				else
				{
					do
					{
						System.out.print("Ay (örneðin \"þubat\" ayý için \"2\") : ");
						kanBagisi.setAy2(klavye.nextInt());
						if(kanBagisi.getAy2() < 0 || kanBagisi.getAy2() > 12)
						{
							System.out.println();
							System.out.println("Ay deðeri 0'dan küçük ya da 12'den büyük olamaz. Lütfen tekrar deneyiniz...");
							System.out.println();
						}
						else
						{
							do
							{
								System.out.print("Yýl :  ");
								kanBagisi.setYil2(klavye.nextInt());
								if(kanBagisi.getYil2() < 0)
								{
									System.out.println();
									System.out.println("Yýly deðeri 0'dan küçük olamaz. Lütfen tekrar deneyiniz...");
									System.out.println();
								}
								else
								{
									kanBagisi.setKontrolEkstra1(false);
									kanBagisi.setKontrolEkstra2(false);
									kanBagisi.setKontrolEkstra3(false);
									
									kanBagisi.setDogumTarihi(kanBagisi.getGun2() + "." + kanBagisi.getAy2() + "." + kanBagisi.getYil2());
								}
							}
							while(kanBagisi.getKontrolEkstra3());
						}
					}
					while(kanBagisi.getKontrolEkstra2());
				}
			}
			while(kanBagisi.getKontrolEkstra1());
			
			if(kanBagisi.getYil1() - kanBagisi.getYil2() < 0)
			{
				System.out.println();
				System.out.println("Bireyin yaþý 0'dan küçük olamaz. Lütfen tekrar deneyiniz...");
				System.out.println();
			}
			else if(kanBagisi.getYil1() - kanBagisi.getYil2() == 0)
			{
				if(kanBagisi.getAy1() - kanBagisi.getAy2() < 0)
				{
					System.out.println();
					System.out.println("Bireyin yaþý 0'dan küçük olamaz. Lütfen tekrar deneyiniz...");
					System.out.println();
				}
				else if(kanBagisi.getAy1() - kanBagisi.getAy2() == 0)
				{
					if(kanBagisi.getGun1() - kanBagisi.getGun2() < 0)
					{
						System.out.println();
						System.out.println("Bireyin yaþý 0'dan küçük olamaz. Lütfen tekrar deneyiniz...");
						System.out.println();
					}
					else
					{
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setDogumTarihi(kanBagisi.getGun2() + "." + kanBagisi.getAy2() + "." + kanBagisi.getYil2());
					}
				}
				else
				{
					kanBagisi.setKontrolEkstra1(false);
					kanBagisi.setDogumTarihi(kanBagisi.getGun2() + "." + kanBagisi.getAy2() + "." + kanBagisi.getYil2());
				}
			}
			else
			{
				kanBagisi.setKontrolEkstra1(false);
				kanBagisi.setDogumTarihi(kanBagisi.getGun2() + "." + kanBagisi.getAy2() + "." + kanBagisi.getYil2());
			}
		}
		while(kanBagisi.getKontrolEkstra1());
		
		kanBagisi.setDuzeltme(klavye.nextLine());
		
		System.out.print("Doðum Yeriniz (Ýl) : ");
		kanBagisi.setDogumYeri(klavye.nextLine());
		
		System.out.println();
		
		do
		{
			try
			{
				kanBagisi.setKontrolEkstra1(true);
				
				System.out.println("1: ARh+");
				System.out.println("2: ARh-");
				System.out.println("3: BRh+");
				System.out.println("4: BRh-");
				System.out.println("5: ABRh+");
				System.out.println("6: ABRh-");
				System.out.println("7: 0Rh+");
				System.out.println("8: 0Rh-");
				System.out.print("Ýhtiyaç Duyulan Kan Grubu: ");
				setSecim(klavye.nextInt());
				switch(getSecim())
				{
					case 1:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("ARh+");
						break;
					case 2:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("ARh-");
						break;
					case 3:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("BRh+");
						break;
					case 4:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("BRh-");
						break;
					case 5:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("ABRh+");
						break;
					case 6:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("ABRh-");
						break;
					case 7:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("0Rh+");
						break;
					case 8:
						kanBagisi.setKontrolEkstra1(false);
						kanBagisi.setKanGrubu("0Rh+");
						break;
					default:
						System.out.println();
						System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
						System.out.println();
						break;
				}
			}
			catch(Exception e)
			{
				System.out.println("HATA: " + e.getMessage());
				System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
				System.out.println();
				kanBagisi.setDuzeltme(klavye.nextLine());
			}
		}
		while(kanBagisi.getKontrolEkstra1());
		
		do
		{
			kanBagisi.setKontrolEkstra1(true);
			
			System.out.println();
			System.out.println("Bilgiler sisteme kaydedilsin mi?");
			System.out.println("1: Evet");
			System.out.println("2: Hayýr");
			System.out.print("Seçiminiz: ");
			setSecim(klavye.nextInt());
			switch(getSecim())
			{
				case 1:
					kanBagisi.setKontrolEkstra1(false);
					
					PrintWriter ciktiAkimi = null;
					String dosya = "Kan Ýhtiyacý Kiþisel Veriler.txt";
					
					try
					{
						ciktiAkimi = new PrintWriter(new FileOutputStream(dosya, true));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println();
						System.out.println("\'Kan Ýhtiyacý Kiþisel Veriler.txt\' dosyasý oluþturulurken hata oldu.");
						System.exit(0);
					}
					
					ciktiAkimi.println(kanBagisi.getAdSoyad() + " KÝÞÝSÝNÝN BÝLGÝLERÝ");
					ciktiAkimi.println("Tarih: " + kanBagisi.getTarih());
					ciktiAkimi.println("*****KÝMLÝK BÝLGÝLERÝ*****");
					ciktiAkimi.println("T.C. Kimlik Numarasý: " + kanBagisi.getTCKimlikNo());
					ciktiAkimi.println("Ad Soyad: " + kanBagisi.getAdSoyad());
					ciktiAkimi.println("Baba Adý: " + kanBagisi.getBabaAdi());
					ciktiAkimi.println("Doðum Tarihi: " + kanBagisi.getDogumTarihi());
					ciktiAkimi.println("Doðum Yeri (Ýl): " + kanBagisi.getDogumYeri());
					ciktiAkimi.println("Kan Grubu: " + kanBagisi.getKanGrubu());
					ciktiAkimi.println();
					ciktiAkimi.close();
					
					try
					{
						BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Baðýþ Listesi.txt"));
						
						String satir = null;
						kanBagisi.setSayac(0);
						satir = girisAkimi.readLine();
						
						kanBagisListesi.clear();
						
						while(satir != null)
						{
							kanBagisi.setSayac(kanBagisi.getSayac() + 1);
							kanBagisListesi.add(satir.trim());
							satir = girisAkimi.readLine();
						}
						girisAkimi.close();
					}
					catch(FileNotFoundException e)
					{
						System.out.println();
						System.out.print("Kan Baðýþ Listesi.txt dosyasý bulunamadý veya açýlamadý.");
						System.out.println();
					}
					catch(IOException e)
					{
						System.out.println();
						System.out.print("Kan Baðýþ Listesi.txt dosyasýndan veri giriþinde hata oluþtu.");
						System.out.println();
					}
					
					PrintWriter ciktiAkimi5 = null;
					String dosya5 = "Kan Baðýþ Listesi.txt";
					
					try
					{
						ciktiAkimi5 = new PrintWriter(new FileOutputStream(dosya5));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println();
						System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanBagisListesi.size(); i++)
					{
						ciktiAkimi5.println(kanBagisListesi.get(i));
					}
					ciktiAkimi5.close();
					
					kanIhtiyacListesi.add(kanBagisi.getKanGrubu());
					
					PrintWriter ciktiAkimi2 = null;
					String dosya2 = "Kan Ýhtiyaç Listesi.txt";
					
					try
					{
						ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println();
						System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanIhtiyacListesi.size(); i++)
					{
						ciktiAkimi2.println(kanIhtiyacListesi.get(i));
					}
					ciktiAkimi2.close();
					
					System.out.println();
					System.out.println("Veriler \'Kan Ýhtiyacý Kiþisel Veriler.txt\' ve \'Kan Ýhtiyaç Listesi.txt\' dosyalarýna baþarýyla kaydedildi.");
					
					kanKontrol(kanBagisi.getKanGrubu(), kanBagisListesi, kanIhtiyacListesi);
					
					do
					{
						kanBagisi.setKontrolEkstra2(true);
						
						System.out.println("Ne yapmak istiyorsunuz?");
						System.out.println("1: Kan Ýhtiyacý Menüsüne Dön");
						System.out.println("2: Ana Menüye Dön");
						System.out.print("Seçiminiz: ");
						setSecim(klavye.nextInt());
						switch(getSecim())
						{
							case 1:
								kanBagisi.setKontrolEkstra1(false);
								kanBagisi.setKontrolEkstra2(false);
								break;
							case 2:
								setKontrol1(true);
								kanBagisi.setKontrol(false);
								kanBagisi.setKontrolEkstra1(false);
								kanBagisi.setKontrolEkstra2(false);
								break;
							default:
								System.out.println();
								System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
								break;
						}
					}
					while(kanBagisi.getKontrolEkstra2());
					break;
				case 2:
					setKontrol1(true);
					kanBagisi.setKontrolEkstra1(false);
					
					System.out.println();
					System.out.println("Bilgiler Kaydedilmedi!");
					System.out.println("Kayýt formu sonlandýrýlýyor...");
					break;
				default:
					System.out.println();
					System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
					break;
			}
		}
		while(kanBagisi.getKontrolEkstra1());
	}
}