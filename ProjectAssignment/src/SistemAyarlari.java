import java.io.*;
import java.util.*;

public class SistemAyarlari extends Kizilay implements OrtakFonksiyonlar
{
	Scanner klavye = new Scanner(System.in);
	
	private boolean kontrol = true;
	private boolean kontrol2 = true;
	private boolean kontrol3 = true;
	
	private int sifre;
	
	private ArrayList<String> kanBagisListesi = new ArrayList<String>();
	private ArrayList<String> kanIhtiyacListesi = new ArrayList<String>();
	
	@Override
	public void girisYazisi()
	{
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t    S�STEM AYARLARI");
	}
	
	@Override
	public void secimYapma()
	{
		KanBagisi kanBagisi = new KanBagisi();
		
		do
		{
			try
			{
				System.out.println();
				System.out.println("Ne yapmak istiyorsunuz?");
				System.out.println("1: Veri Silme ");
				System.out.println("2: Ana Men�ye Geri D�n");
				System.out.print("Se�iminiz: ");
				setSecim(klavye.nextInt());
				switch(getSecim())
				{
					case 1:
						kontrol = false;
						do
						{
							System.out.println();
							System.out.println("Ne yapmak istiyorsunuz?");
							System.out.println("1: Ba���lanan Kan Grubu Listesinden Veri Silme");
							System.out.println("2: �htiya� Duyulan Kan Grubu Listesinden Veri Silme");
							System.out.println("3: Sistem Ayarlar� Men�s�ne Geri D�n");
							System.out.println("4: Ana Men�ye Geri D�n");
							System.out.print("Se�iminiz: ");
							setSecim(klavye.nextInt());
							switch(getSecim())
							{
								case 1:
									System.out.println();
									System.out.println("*****KAN BA�I� GRUBU L�STES�*****");
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
										System.out.print("Kan Ba��� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
									}
									
									for(int i = 0; i < kanBagisListesi.size(); i++)
									{
										System.out.println("0: " + kanBagisListesi.get(i));
									}
									do
									{
										kontrol3 = true;
										
										System.out.println();
										System.out.println("L�tfen silmek istedi�iniz kan ba��� verisinin numaras�n� tu�lay�n�z.");
										System.out.println("NOT: Silme i�leminden vazge�ip Sistem Ayarlar� men�s�ne d�nme i�in ise l�tfen /'99/'� t��lay�n�z.");
										System.out.print("Se�iminiz: ");
										setSecim(klavye.nextInt());
										if(getSecim() < 0 || getSecim() > kanBagisListesi.size() - 1)
										{
											System.out.println();
											System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
											System.out.println();
										}
										else if(getSecim() == 99)
										{
											kontrol2 = false;
											kontrol3 = false;
											System.out.println();
										}
										else
										{
											kontrol2 = false;
											kontrol3 = false;
											
											kanBagisListesi.remove(getSecim());
											kanBagisListesi.trimToSize();
											
											PrintWriter ciktiAkimi1 = null;
											String dosya1 = "Kan Ba��� Listesi.txt";
											
											try
											{
												ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
											}
											catch(FileNotFoundException hata)
											{
												System.out.println("\'Kan Ba��� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
												System.exit(0);
											}    
											for(int i = 0; i < kanBagisListesi.size(); i++)
											{
												ciktiAkimi1.println(kanBagisListesi.get(i));
											}
											System.out.println();
											System.out.println("Veri silme i�lemi ba�ar�yla ger�ekle�tirildi.");
											ciktiAkimi1.close();
										}
									}
									while(kontrol3);
									break;
								case 2:
									System.out.println();
									System.out.println("*****KAN �HT�YA� GRUBU L�STES�*****");
									try
									{
										BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan �htiya� Listesi.txt"));
										
										String satir = null;
										kanBagisi.setSayac(0);
										satir = girisAkimi.readLine();
										
										while(satir != null)
										{
											kanBagisi.setSayac(kanBagisi.getSayac() + 1);
											kanIhtiyacListesi.add(satir.trim());
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
										System.out.print("Kan �htiya� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
									}
									
									for(int i = 0; i < kanIhtiyacListesi.size(); i++)
									{
										System.out.println(i + ": " + kanIhtiyacListesi.get(i));
									}
									do
									{
										kontrol3 = true;
										
										System.out.println();
										System.out.println("L�tfen silmek istedi�iniz kan ba��� verisinin numaras�n� tu�lay�n�z.");
										System.out.println("NOT: Silme i�leminden vazge�ip Sistem Ayarlar� men�s�ne d�nme i�in ise l�tfen /'99/'� t��lay�n�z.");
										System.out.print("Se�iminiz: ");
										setSecim(klavye.nextInt());
										if(getSecim() < 0 || getSecim() > kanIhtiyacListesi.size() - 1)
										{
											System.out.println();
											System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
											System.out.println();
										}
										else if(getSecim() == 99)
										{
											kontrol2 = false;
											kontrol3 = false;
											System.out.println();
										}
										else if(getSecim() >= 0 || getSecim() <= kanIhtiyacListesi.size() - 1)
										{
											kontrol2 = false;
											kontrol3 = false;
											
											kanIhtiyacListesi.remove(getSecim());
											kanIhtiyacListesi.trimToSize();
											
											System.out.println();
											System.out.println("Veri silme i�lemi ba�ar�yla ger�ekle�tirildi.");
											
											PrintWriter ciktiAkimi1 = null;
											String dosya1 = "Kan �htiya� Listesi.txt";
											
											try
											{
												ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
											}
											catch(FileNotFoundException hata)
											{
												System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
												System.exit(0);
											}
											for(int i = 0; i < kanIhtiyacListesi.size(); i++)
											{
												ciktiAkimi1.println(kanIhtiyacListesi.get(i));
											}
											ciktiAkimi1.close();
										}
									}
									while(kontrol3);
									break;
								case 3:
									kontrol2 = false;
									System.out.println();
									break;
								case 4:
									setKontrol1(true);
									kontrol = false;
									kontrol2 = false;
									System.out.println();
									break;
								default:
									System.out.println();
									System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
									System.out.println();
									break;
							}
							break;
						}
						while(kontrol2);
					case 2:
						setKontrol1(true);
						kontrol = false;
						System.out.println();
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
		while(kontrol);
	}
	
	@Override
	public void kayitFormu()
	{
		KanBagisi kanBagisi = new KanBagisi();
		
		SistemAyarlari sistemAyarlari = new SistemAyarlari();
		
		System.out.println("Sistem ayarlar�na yaln�zca yetkili ki�iler giri� yapabilir.");
		System.out.println("Devam edebilmek i�in l�tfen �ifreyi giriniz.");
		System.out.println("NOT: Ana men�ye d�nebilmek i�in �ifreyi /'99/' olarak tu�lay�n�z.");
		do
		{	
			try
			{
				System.out.print("�ifre: ");
				sifre = klavye.nextInt();
				if(sifre == 10711453)
				{
					kontrol = false;
					 
					sistemAyarlari.secimYapma();
				}
				else if(sifre == 99)
				{
					kontrol = false;
				}
				else
				{
					System.out.println();
					System.out.println("�ifre yanl��. L�tfen tekrar deneyiniz...");
					System.out.println();
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
		while(kontrol);
	}
}
