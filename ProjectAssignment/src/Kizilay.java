import java.io.*;
import java.util.*;

public class Kizilay
{
	static Scanner klavye = new Scanner(System.in);
	
	private static int secim;
	private static boolean kontrol1 = true;
	
	public static int getSecim()
	{
		return secim;
	}

	public static void setSecim(int secim)
	{
		Kizilay.secim = secim;
	}
	
	public static boolean getKontrol1()
	{
		return kontrol1;
	}

	public static void setKontrol1(boolean kontrol1)
	{
		Kizilay.kontrol1 = kontrol1;
	}
	
	public static void main(String[] args)
	{	
		System.out.println("\t\t\t\t\t\t\t KIZILAY'A HO� GELD�N�Z");
		
		do
		{
			kontrol1 = true;
			
			System.out.println("Ne yapmak istiyorsunuz?");
			System.out.println("1: Kan Ba��� Sistemine Giri�");
			System.out.println("2: Kan �htiya� Sistemine Giri�");
			System.out.println("YA DA");
			System.out.println("3: Sistem Ayarlar�");
			System.out.println("4: Sistemden ��k��");
			System.out.print("Se�iminiz: ");
			setSecim(klavye.nextInt());
			
			switch(getSecim())
			{
				case 1:
					setKontrol1(false);
					KanBagisi kanBagisi = new KanBagisi();
					
					kanBagisi.girisYazisi();
					kanBagisi.secimYapma();
					break;
				case 2:
					setKontrol1(false);
					KanIhtiyaci kanIhtiyaci = new KanIhtiyaci();
					
					kanIhtiyaci.girisYazisi();
					kanIhtiyaci.secimYapma();
					break;
				case 3:
					setKontrol1(false);
					SistemAyarlari sistemAyarlari = new SistemAyarlari();
					
					sistemAyarlari.girisYazisi();
					sistemAyarlari.kayitFormu();
					break;
				case 4:
					setKontrol1(false);
					System.out.println();
					System.out.println("Sistemden ��k�� yap�ld�.");
					System.out.println("G�LE G�LE...");
					System.exit(0);
					break;
				default:
					System.out.println();
					System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
					System.out.println();
					break;
			}
		}
		while(kontrol1);
	}
	
	public void kanKontrol(String kanGrubu, ArrayList<String> kanBagisListesi, ArrayList<String> kanIhtiyacListesi)
	{	
		boolean kontrol = true;
		
		int mevcutKanTorbasi = 0;
		int bagislananKanTorbasi;
		int ihtiyacOlanKanTorbasi;
		
		for(int i = 0; i < kanBagisListesi.size(); i++)
		{
			for(int j = 0; j < kanIhtiyacListesi.size(); j++)
			{	
				if(kanBagisListesi.get(i).equalsIgnoreCase(kanIhtiyacListesi.get(j)))
				{
					mevcutKanTorbasi++;
				}
			}
		}
		
		if(mevcutKanTorbasi == 0)
		{
			System.out.println("Maalesef ihtiya� duyulan " + kanGrubu + " kan grubu �u anda mevcut de�il.");
			System.out.println("YA DA");
			System.out.println(kanGrubu + " kan gurubuna �u anda ihtiya� yok.");
		}
		else
		{
			System.out.println();
			System.out.println("Aranan \'" + kanGrubu + "\' kan�ndan " + mevcutKanTorbasi + " kan �nitesi �u anda sistemde mevcut.");
			do
			{
				System.out.println("Hastan�n ka� �nite kana ihtiyac� var?");
				System.out.print("�htiya� Olan �nite Say�s�: ");
				ihtiyacOlanKanTorbasi = klavye.nextInt();
				if(ihtiyacOlanKanTorbasi < 0)
				{
					System.out.println();
					System.out.println("Hastan�n ihtiya� duydu�u �nitesi say�s� 0'dan k���k olamaz.");
					System.out.println("L�tfen tekrar deneyiniz.");
					System.out.println();
				}
				else
				{
					kontrol = false;
				}
			}
			while(kontrol);
			kontrol = true;
			do
			{
				System.out.println("Ka� adet kan  �nitesi hastaya ba���lanacak?");
				System.out.print("Hastaya Ba���lanacak Kan �nitesi Say�s�: ");
				bagislananKanTorbasi = klavye.nextInt();
				if(bagislananKanTorbasi > mevcutKanTorbasi || bagislananKanTorbasi > ihtiyacOlanKanTorbasi)
				{
					System.out.println();
					System.out.println("Ba���lanan kan �nitesi mevcut kan �nitesinden veya ihtiya� duyulan kan �nitesinden daha �ok olamaz.");
					System.out.println("L�tfen tekrar deneyiniz.");
					System.out.println();
				}
				else if(bagislananKanTorbasi == mevcutKanTorbasi && bagislananKanTorbasi == ihtiyacOlanKanTorbasi)
				{
					kontrol = false;
					System.out.println();
					System.out.println("Hastan�n b�t�n kan ihtiyac� kar��lanm��t�r.");
					System.out.println();
					
					for(int i = 0; i < kanBagisListesi.size(); i++)
					{
						if(kanGrubu.equalsIgnoreCase(kanBagisListesi.get(i)))
						{
							kanBagisListesi.remove(i);
						}
					}
					
					kanBagisListesi.trimToSize();
					
					for(int i = 0; i < kanIhtiyacListesi.size(); i++)
					{
						if(kanGrubu.equalsIgnoreCase(kanIhtiyacListesi.get(i)))
						{
							kanIhtiyacListesi.remove(i);
							break;
						}
					}
					
					kanIhtiyacListesi.trimToSize();
					
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
					ciktiAkimi1.close();
					
					PrintWriter ciktiAkimi2 = null;
					String dosya2 = "Kan �htiya� Listesi.txt";
					
					try
					{
						ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanIhtiyacListesi.size(); i++)
					{
						ciktiAkimi2.println(kanIhtiyacListesi.get(i));
					}
					ciktiAkimi2.close();
					
				}
				else if(bagislananKanTorbasi < mevcutKanTorbasi && bagislananKanTorbasi == ihtiyacOlanKanTorbasi)
				{
					kontrol = false;
					System.out.println();
					System.out.println("Hastan�n b�t�n kan ihtiyac� kar��lanm��t�r.");
					System.out.println();
					
					for(int i = 0; i < bagislananKanTorbasi; i++)
					{
						if(kanGrubu.equals(kanBagisListesi.get(i)))
						{
							kanBagisListesi.remove(i);
						}
					}
					
					kanBagisListesi.trimToSize();
					
					for(int i = 0; i < kanIhtiyacListesi.size(); i++)
					{
						if(kanGrubu.equals(kanIhtiyacListesi.get(i)))
						{
							kanIhtiyacListesi.remove(i);
							break;
						}
					}
					
					kanIhtiyacListesi.trimToSize();
					
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
					ciktiAkimi1.close();
					
					PrintWriter ciktiAkimi2 = null;
					String dosya2 = "Kan �htiya� Listesi.txt";
					
					try
					{
						ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanIhtiyacListesi.size(); i++)
					{
						ciktiAkimi2.println(kanIhtiyacListesi.get(i));
					}
					ciktiAkimi2.close();
					
				}
				else if(bagislananKanTorbasi == mevcutKanTorbasi && bagislananKanTorbasi < ihtiyacOlanKanTorbasi)
				{
					System.out.println("�htiya� olan " + ihtiyacOlanKanTorbasi + " adet kan �nitesinden " + bagislananKanTorbasi + " adedi kar��lanm��t�r.");
					System.out.println("Hasta i�in " + (ihtiyacOlanKanTorbasi - bagislananKanTorbasi) + " adet kan �nitesine daha ihtiya� vard�r.");
					
					for(int i = 0; i < kanBagisListesi.size(); i++)
					{
						if(kanGrubu.equals(kanBagisListesi.get(i)))
						{
							kanBagisListesi.remove(i);
						}
					}
					
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
					ciktiAkimi1.close();
					
				}
				else if(bagislananKanTorbasi < mevcutKanTorbasi && bagislananKanTorbasi < ihtiyacOlanKanTorbasi)
				{
					System.out.println("�htiya� olan " + ihtiyacOlanKanTorbasi + " adet kan �nitesinden " + bagislananKanTorbasi + " adedi kar��lanm��t�r.");
					
					for(int i = 0; i < bagislananKanTorbasi; i++)
					{
						if(kanGrubu.equals(kanBagisListesi.get(i)))
						{
							kanBagisListesi.remove(i);
						}
					}
					
					kanBagisListesi.trimToSize();
					
					System.out.println("Kalan mevctur " + kanGrubu + " kan �nitesi: " + (mevcutKanTorbasi - bagislananKanTorbasi));
					System.out.println("Geriye kalan kan �nitesi ihtiyac�: " + (ihtiyacOlanKanTorbasi - bagislananKanTorbasi));
					System.out.println("Kalan kan �nitelerinden de ba���lanacak m�?");
					System.out.println("1: Evet");
					System.out.println("2: Hay�r, geri kalan� di�er kan merkezlerinden kar��land�.");
					System.out.print("Se�iminiz: ");
					secim = klavye.nextInt();
					switch(secim)
					{
						case 1:
							System.out.println("Ka� adet daha kan �nitesi hastaya ba���lanacak?");
							System.out.print("Hastaya Ba���lanacak Kan �nitesi Say�s�: ");
							bagislananKanTorbasi = klavye.nextInt();
							if(bagislananKanTorbasi > mevcutKanTorbasi || bagislananKanTorbasi > ihtiyacOlanKanTorbasi)
							{
								System.out.println();
								System.out.println("Ba���lanan kan �nitesi mevcut kan �nitesinden veya ihtiya� duyulan kan �nitesinden daha �ok olamaz.");
								System.out.println("L�tfen tekrar deneyiniz.");
								System.out.println();
							}
							else if(bagislananKanTorbasi == mevcutKanTorbasi && bagislananKanTorbasi == ihtiyacOlanKanTorbasi)
							{
								kontrol = false;
								System.out.println();
								System.out.println("Hastan�n b�t�n kan ihtiyac� kar��lanm��t�r.");
								System.out.println();
								
								for(int i = 0; i < kanBagisListesi.size(); i++)
								{
									if(kanGrubu.equals(kanBagisListesi.get(i)))
									{
										kanBagisListesi.remove(i);
									}
								}
								
								kanBagisListesi.trimToSize();
								
								for(int i = 0; i < kanIhtiyacListesi.size(); i++)
								{
									if(kanGrubu.equals(kanIhtiyacListesi.get(i)))
									{
										kanIhtiyacListesi.remove(i);
										break;
									}
								}
								
								kanIhtiyacListesi.trimToSize();
								
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
								ciktiAkimi1.close();
								
								PrintWriter ciktiAkimi2 = null;
								String dosya2 = "Kan �htiya� Listesi.txt";
								
								try
								{
									ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
									System.exit(0);
								}
								
								for(int i = 0; i < kanIhtiyacListesi.size(); i++)
								{
									ciktiAkimi2.println(kanIhtiyacListesi.get(i));
								}
								ciktiAkimi2.close();
								
							}
							else if(bagislananKanTorbasi < mevcutKanTorbasi && bagislananKanTorbasi == ihtiyacOlanKanTorbasi)
							{
								kontrol = false;
								System.out.println();
								System.out.println("Hastan�n b�t�n kan ihtiyac� kar��lanm��t�r.");
								System.out.println();
								
								for(int i = 0; i < bagislananKanTorbasi; i++)
								{
									if(kanGrubu.equals(kanBagisListesi.get(i)))
									{
										kanBagisListesi.remove(i);
									}
								}
								
								kanBagisListesi.trimToSize();
								
								for(int i = 0; i < kanIhtiyacListesi.size(); i++)
								{
									if(kanGrubu.equals(kanIhtiyacListesi.get(i)))
									{
										kanIhtiyacListesi.remove(i);
										break;
									}
								}
								
								kanIhtiyacListesi.trimToSize();
								
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
								ciktiAkimi1.close();
								
								PrintWriter ciktiAkimi2 = null;
								String dosya2 = "Kan �htiya� Listesi.txt";
								
								try
								{
									ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
									System.exit(0);
								}
								
								for(int i = 0; i < kanIhtiyacListesi.size(); i++)
								{
									ciktiAkimi2.println(kanIhtiyacListesi.get(i));
								}
								ciktiAkimi2.close();
								
							}
							else if(bagislananKanTorbasi == mevcutKanTorbasi && bagislananKanTorbasi < ihtiyacOlanKanTorbasi)
							{
								System.out.println("�htiya� olan " + ihtiyacOlanKanTorbasi + " adet kan �nitesinden " + bagislananKanTorbasi + " adedi kar��lanm��t�r.");
								System.out.println("Hasta i�in " + (ihtiyacOlanKanTorbasi - bagislananKanTorbasi) + " adet kan �nitesine daha ihtiya� vard�r.");
								
								for(int i = 0; i < kanBagisListesi.size(); i++)
								{
									if(kanGrubu.equals(kanBagisListesi.get(i)))
									{
										kanBagisListesi.remove(i);
									}
								}
								
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
								ciktiAkimi1.close();
							}
							else if(bagislananKanTorbasi < mevcutKanTorbasi && bagislananKanTorbasi < ihtiyacOlanKanTorbasi)
							{
								System.out.println("Hastan�n kan ihtiyac� kar��lanm��t�r.");
								
								for(int i = 0; i < bagislananKanTorbasi; i++)
								{
									if(kanGrubu.equals(kanBagisListesi.get(i)))
									{
										kanBagisListesi.remove(i);
									}
								}
								
								kanBagisListesi.trimToSize();
								
								for(int i = 0; i < kanIhtiyacListesi.size(); i++)
								{
									if(kanGrubu.equals(kanIhtiyacListesi.get(i)))
									{
										kanBagisListesi.remove(i);
										break;
									}
								}
								
								kanIhtiyacListesi.trimToSize();
								
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
								ciktiAkimi1.close();
								
								PrintWriter ciktiAkimi2 = null;
								String dosya2 = "Kan �htiya� Listesi.txt";
								
								try
								{
									ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
									System.exit(0);
								}
								
								for(int i = 0; i < kanIhtiyacListesi.size(); i++)
								{
									ciktiAkimi2.println(kanIhtiyacListesi.get(i));
								}
								ciktiAkimi2.close();
							}	
							break;
						case 2:
							
							break;
						default:
							System.out.println();
							System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
							System.out.println();
							break;
					}
				}
			}
			while(kontrol);
		}
	}
}