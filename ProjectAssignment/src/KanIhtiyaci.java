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
		System.out.println("\t\t\t\t\t\t\t   KAN �HT�YA� S�STEM�");
	}
	
	@Override
	public void secimYapma()
	{
		KanBagisi kanBagisi = new KanBagisi();
		
		KanIhtiyaci kanIhtiyaci = new KanIhtiyaci();
		
		do
		{	
			System.out.println("Ne yapmak istiyorsunuz?");
			System.out.println("1: Yeni Kay�t Formu Doldur");
			System.out.println("2: Ana Men�ye Geri D�n");
			System.out.print("Se�iminiz: ");
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
					System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Ba��� Listesi.txt"));
			
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
			//System.out.print("Kan Ba��� Listesi.txt dosyas� bulunamad� veya a��lamad�.");
		}
		catch(IOException e)
		{
			System.out.println();
			System.out.print("Kan Ba��� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
			System.out.println();
		}
		
		PrintWriter ciktiAkimi3 = null;
		String dosya3 = "Kan Ba��� Listesi.txt";
		
		try
		{
			ciktiAkimi3 = new PrintWriter(new FileOutputStream(dosya3));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println();
			System.out.println("\'Kan Ba��� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
			System.exit(0);
		}
		
		for(int i = 0; i < kanBagisListesi.size(); i++)
		{
			ciktiAkimi3.println(kanBagisListesi.get(i));
		}
		ciktiAkimi3.close();
		
		try
		{
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan �htiya� Listesi.txt"));
			
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
			//System.out.print("Kan �htiya� Listesi.txt dosyas� bulunamad� veya a��lamad�.");
		}
		catch(IOException e)
		{
			System.out.println();
			System.out.print("Kan �htiya� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
			System.out.println();
		}
		
		PrintWriter ciktiAkimi4 = null;
		String dosya4 = "Kan �htiya� Listesi.txt";
		
		try
		{
			ciktiAkimi4 = new PrintWriter(new FileOutputStream(dosya4));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println();
			System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
			System.exit(0);
		}
		
		for(int i = 0; i < kanIhtiyacListesi.size(); i++)
		{
			ciktiAkimi4.println(kanIhtiyacListesi.get(i));
		}
		ciktiAkimi4.close();
		
		System.out.println();
		System.out.print("*****BUG�N�N TAR�H�*****");
		System.out.println();
		do
		{	
			try
			{
				kanBagisi.setKontrolEkstra1(true);
				kanBagisi.setKontrolEkstra2(true);
				kanBagisi.setKontrolEkstra3(true);
				
				System.out.print("G�n : ");
				kanBagisi.setGun1(klavye.nextInt());
				if(kanBagisi.getGun1() < 0 || kanBagisi.getGun1() > 31)
				{
					System.out.println();
					System.out.println("G�n de�eri 0'dan k���k ya da 31'den b�y�k olamaz. L�tfen tekrar deneyiniz...");
					System.out.println();
				}
				else
				{
					do
					{
						System.out.print("Ay (�rne�in \"�ubat\" ay� i�in \"2\") : ");
						kanBagisi.setAy1(klavye.nextInt());
						if(kanBagisi.getAy1() < 0 || kanBagisi.getAy1() > 12)
						{
							System.out.println();
							System.out.println("Ay de�eri 0'dan k���k ya da 12'den b�y�k olamaz. L�tfen tekrar deneyiniz...");
							System.out.println();
						}
						else
						{
							do
							{
								System.out.print("Y�l :  ");
								kanBagisi.setYil1(klavye.nextInt());
								if(kanBagisi.getYil1() < 0)
								{
									System.out.println();
									System.out.println("Y�ly de�eri 0'dan k���k olamaz. L�tfen tekrar deneyiniz...");
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
				System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
				System.out.println();
				kanBagisi.setDuzeltme(klavye.nextLine());
			}	
		}
		while(kanBagisi.getKontrolEkstra1());
		
		System.out.println();
		System.out.print("*****KAN BA�I��ISI ADAYININ K�ML�K B�LG�LER�*****");
		System.out.println();
	
		kanBagisi.setDuzeltme(klavye.nextLine());
		
		System.out.print("T.C. Kimlik Numaran�z : ");
		kanBagisi.setTCKimlikNo(klavye.nextLine());
		
		System.out.print("Ad�n�z Soyad�n�z : ");
		kanBagisi.setAdSoyad(klavye.nextLine());
		
		System.out.print("Baba Ad�n�z : ");
		kanBagisi.setBabaAdi(klavye.nextLine());
		
		do
		{
			kanBagisi.setKontrolEkstra1(true);
			
			System.out.println("Do�um Tarihiniz");
			do
			{	
				kanBagisi.setKontrolEkstra1(true);
				kanBagisi.setKontrolEkstra2(true);
				kanBagisi.setKontrolEkstra3(true);
				
				System.out.print("G�n : ");
				kanBagisi.setGun2(klavye.nextInt());
				if(kanBagisi.getGun2() < 0 || kanBagisi.getGun2() > 31)
				{
					System.out.println();
					System.out.println("G�n de�eri 0'dan k���k ya da 31'den b�y�k olamaz. L�tfen tekrar deneyiniz...");
					System.out.println();
				}
				else
				{
					do
					{
						System.out.print("Ay (�rne�in \"�ubat\" ay� i�in \"2\") : ");
						kanBagisi.setAy2(klavye.nextInt());
						if(kanBagisi.getAy2() < 0 || kanBagisi.getAy2() > 12)
						{
							System.out.println();
							System.out.println("Ay de�eri 0'dan k���k ya da 12'den b�y�k olamaz. L�tfen tekrar deneyiniz...");
							System.out.println();
						}
						else
						{
							do
							{
								System.out.print("Y�l :  ");
								kanBagisi.setYil2(klavye.nextInt());
								if(kanBagisi.getYil2() < 0)
								{
									System.out.println();
									System.out.println("Y�ly de�eri 0'dan k���k olamaz. L�tfen tekrar deneyiniz...");
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
				System.out.println("Bireyin ya�� 0'dan k���k olamaz. L�tfen tekrar deneyiniz...");
				System.out.println();
			}
			else if(kanBagisi.getYil1() - kanBagisi.getYil2() == 0)
			{
				if(kanBagisi.getAy1() - kanBagisi.getAy2() < 0)
				{
					System.out.println();
					System.out.println("Bireyin ya�� 0'dan k���k olamaz. L�tfen tekrar deneyiniz...");
					System.out.println();
				}
				else if(kanBagisi.getAy1() - kanBagisi.getAy2() == 0)
				{
					if(kanBagisi.getGun1() - kanBagisi.getGun2() < 0)
					{
						System.out.println();
						System.out.println("Bireyin ya�� 0'dan k���k olamaz. L�tfen tekrar deneyiniz...");
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
		
		System.out.print("Do�um Yeriniz (�l) : ");
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
				System.out.print("�htiya� Duyulan Kan Grubu: ");
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
						System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
						System.out.println();
						break;
				}
			}
			catch(Exception e)
			{
				System.out.println("HATA: " + e.getMessage());
				System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
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
			System.out.println("2: Hay�r");
			System.out.print("Se�iminiz: ");
			setSecim(klavye.nextInt());
			switch(getSecim())
			{
				case 1:
					kanBagisi.setKontrolEkstra1(false);
					
					PrintWriter ciktiAkimi = null;
					String dosya = "Kan �htiyac� Ki�isel Veriler.txt";
					
					try
					{
						ciktiAkimi = new PrintWriter(new FileOutputStream(dosya, true));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println();
						System.out.println("\'Kan �htiyac� Ki�isel Veriler.txt\' dosyas� olu�turulurken hata oldu.");
						System.exit(0);
					}
					
					ciktiAkimi.println(kanBagisi.getAdSoyad() + " K���S�N�N B�LG�LER�");
					ciktiAkimi.println("Tarih: " + kanBagisi.getTarih());
					ciktiAkimi.println("*****K�ML�K B�LG�LER�*****");
					ciktiAkimi.println("T.C. Kimlik Numaras�: " + kanBagisi.getTCKimlikNo());
					ciktiAkimi.println("Ad Soyad: " + kanBagisi.getAdSoyad());
					ciktiAkimi.println("Baba Ad�: " + kanBagisi.getBabaAdi());
					ciktiAkimi.println("Do�um Tarihi: " + kanBagisi.getDogumTarihi());
					ciktiAkimi.println("Do�um Yeri (�l): " + kanBagisi.getDogumYeri());
					ciktiAkimi.println("Kan Grubu: " + kanBagisi.getKanGrubu());
					ciktiAkimi.println();
					ciktiAkimi.close();
					
					try
					{
						BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Ba��� Listesi.txt"));
						
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
						System.out.print("Kan Ba��� Listesi.txt dosyas� bulunamad� veya a��lamad�.");
						System.out.println();
					}
					catch(IOException e)
					{
						System.out.println();
						System.out.print("Kan Ba��� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
						System.out.println();
					}
					
					PrintWriter ciktiAkimi5 = null;
					String dosya5 = "Kan Ba��� Listesi.txt";
					
					try
					{
						ciktiAkimi5 = new PrintWriter(new FileOutputStream(dosya5));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println();
						System.out.println("\'Kan Ba��� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanBagisListesi.size(); i++)
					{
						ciktiAkimi5.println(kanBagisListesi.get(i));
					}
					ciktiAkimi5.close();
					
					kanIhtiyacListesi.add(kanBagisi.getKanGrubu());
					
					PrintWriter ciktiAkimi2 = null;
					String dosya2 = "Kan �htiya� Listesi.txt";
					
					try
					{
						ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println();
						System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanIhtiyacListesi.size(); i++)
					{
						ciktiAkimi2.println(kanIhtiyacListesi.get(i));
					}
					ciktiAkimi2.close();
					
					System.out.println();
					System.out.println("Veriler \'Kan �htiyac� Ki�isel Veriler.txt\' ve \'Kan �htiya� Listesi.txt\' dosyalar�na ba�ar�yla kaydedildi.");
					
					kanKontrol(kanBagisi.getKanGrubu(), kanBagisListesi, kanIhtiyacListesi);
					
					do
					{
						kanBagisi.setKontrolEkstra2(true);
						
						System.out.println("Ne yapmak istiyorsunuz?");
						System.out.println("1: Kan �htiyac� Men�s�ne D�n");
						System.out.println("2: Ana Men�ye D�n");
						System.out.print("Se�iminiz: ");
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
								System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
					System.out.println("Kay�t formu sonland�r�l�yor...");
					break;
				default:
					System.out.println();
					System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
					break;
			}
		}
		while(kanBagisi.getKontrolEkstra1());
	}
}