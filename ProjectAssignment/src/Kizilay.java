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
		System.out.println("\t\t\t\t\t\t\t KIZILAY'A HOÞ GELDÝNÝZ");
		
		do
		{
			kontrol1 = true;
			
			System.out.println("Ne yapmak istiyorsunuz?");
			System.out.println("1: Kan Baðýþ Sistemine Giriþ");
			System.out.println("2: Kan Ýhtiyaç Sistemine Giriþ");
			System.out.println("YA DA");
			System.out.println("3: Sistem Ayarlarý");
			System.out.println("4: Sistemden Çýkýþ");
			System.out.print("Seçiminiz: ");
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
					System.out.println("Sistemden çýkýþ yapýldý.");
					System.out.println("GÜLE GÜLE...");
					System.exit(0);
					break;
				default:
					System.out.println();
					System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
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
			System.out.println("Maalesef ihtiyaç duyulan " + kanGrubu + " kan grubu þu anda mevcut deðil.");
			System.out.println("YA DA");
			System.out.println(kanGrubu + " kan gurubuna þu anda ihtiyaç yok.");
		}
		else
		{
			System.out.println();
			System.out.println("Aranan \'" + kanGrubu + "\' kanýndan " + mevcutKanTorbasi + " kan ünitesi þu anda sistemde mevcut.");
			do
			{
				System.out.println("Hastanýn kaç ünite kana ihtiyacý var?");
				System.out.print("Ýhtiyaç Olan Ünite Sayýsý: ");
				ihtiyacOlanKanTorbasi = klavye.nextInt();
				if(ihtiyacOlanKanTorbasi < 0)
				{
					System.out.println();
					System.out.println("Hastanýn ihtiyaç duyduðu ünitesi sayýsý 0'dan küçük olamaz.");
					System.out.println("Lütfen tekrar deneyiniz.");
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
				System.out.println("Kaç adet kan  ünitesi hastaya baðýþlanacak?");
				System.out.print("Hastaya Baðýþlanacak Kan Ünitesi Sayýsý: ");
				bagislananKanTorbasi = klavye.nextInt();
				if(bagislananKanTorbasi > mevcutKanTorbasi || bagislananKanTorbasi > ihtiyacOlanKanTorbasi)
				{
					System.out.println();
					System.out.println("Baðýþlanan kan ünitesi mevcut kan ünitesinden veya ihtiyaç duyulan kan ünitesinden daha çok olamaz.");
					System.out.println("Lütfen tekrar deneyiniz.");
					System.out.println();
				}
				else if(bagislananKanTorbasi == mevcutKanTorbasi && bagislananKanTorbasi == ihtiyacOlanKanTorbasi)
				{
					kontrol = false;
					System.out.println();
					System.out.println("Hastanýn bütün kan ihtiyacý karþýlanmýþtýr.");
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
					String dosya1 = "Kan Baðýþ Listesi.txt";
					
					try
					{
						ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanBagisListesi.size(); i++)
					{
						ciktiAkimi1.println(kanBagisListesi.get(i));
					}
					ciktiAkimi1.close();
					
					PrintWriter ciktiAkimi2 = null;
					String dosya2 = "Kan Ýhtiyaç Listesi.txt";
					
					try
					{
						ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
					System.out.println("Hastanýn bütün kan ihtiyacý karþýlanmýþtýr.");
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
					String dosya1 = "Kan Baðýþ Listesi.txt";
					
					try
					{
						ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
						System.exit(0);
					}
					
					for(int i = 0; i < kanBagisListesi.size(); i++)
					{
						ciktiAkimi1.println(kanBagisListesi.get(i));
					}
					ciktiAkimi1.close();
					
					PrintWriter ciktiAkimi2 = null;
					String dosya2 = "Kan Ýhtiyaç Listesi.txt";
					
					try
					{
						ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
					System.out.println("Ýhtiyaç olan " + ihtiyacOlanKanTorbasi + " adet kan ünitesinden " + bagislananKanTorbasi + " adedi karþýlanmýþtýr.");
					System.out.println("Hasta için " + (ihtiyacOlanKanTorbasi - bagislananKanTorbasi) + " adet kan ünitesine daha ihtiyaç vardýr.");
					
					for(int i = 0; i < kanBagisListesi.size(); i++)
					{
						if(kanGrubu.equals(kanBagisListesi.get(i)))
						{
							kanBagisListesi.remove(i);
						}
					}
					
					kanBagisListesi.trimToSize();
					
					PrintWriter ciktiAkimi1 = null;
					String dosya1 = "Kan Baðýþ Listesi.txt";
					
					try
					{
						ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
					}
					catch(FileNotFoundException hata)
					{
						System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
					System.out.println("Ýhtiyaç olan " + ihtiyacOlanKanTorbasi + " adet kan ünitesinden " + bagislananKanTorbasi + " adedi karþýlanmýþtýr.");
					
					for(int i = 0; i < bagislananKanTorbasi; i++)
					{
						if(kanGrubu.equals(kanBagisListesi.get(i)))
						{
							kanBagisListesi.remove(i);
						}
					}
					
					kanBagisListesi.trimToSize();
					
					System.out.println("Kalan mevctur " + kanGrubu + " kan ünitesi: " + (mevcutKanTorbasi - bagislananKanTorbasi));
					System.out.println("Geriye kalan kan ünitesi ihtiyacý: " + (ihtiyacOlanKanTorbasi - bagislananKanTorbasi));
					System.out.println("Kalan kan ünitelerinden de baðýþlanacak mý?");
					System.out.println("1: Evet");
					System.out.println("2: Hayýr, geri kalaný diðer kan merkezlerinden karþýlandý.");
					System.out.print("Seçiminiz: ");
					secim = klavye.nextInt();
					switch(secim)
					{
						case 1:
							System.out.println("Kaç adet daha kan ünitesi hastaya baðýþlanacak?");
							System.out.print("Hastaya Baðýþlanacak Kan Ünitesi Sayýsý: ");
							bagislananKanTorbasi = klavye.nextInt();
							if(bagislananKanTorbasi > mevcutKanTorbasi || bagislananKanTorbasi > ihtiyacOlanKanTorbasi)
							{
								System.out.println();
								System.out.println("Baðýþlanan kan ünitesi mevcut kan ünitesinden veya ihtiyaç duyulan kan ünitesinden daha çok olamaz.");
								System.out.println("Lütfen tekrar deneyiniz.");
								System.out.println();
							}
							else if(bagislananKanTorbasi == mevcutKanTorbasi && bagislananKanTorbasi == ihtiyacOlanKanTorbasi)
							{
								kontrol = false;
								System.out.println();
								System.out.println("Hastanýn bütün kan ihtiyacý karþýlanmýþtýr.");
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
								String dosya1 = "Kan Baðýþ Listesi.txt";
								
								try
								{
									ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
									System.exit(0);
								}
								
								for(int i = 0; i < kanBagisListesi.size(); i++)
								{
									ciktiAkimi1.println(kanBagisListesi.get(i));
								}
								ciktiAkimi1.close();
								
								PrintWriter ciktiAkimi2 = null;
								String dosya2 = "Kan Ýhtiyaç Listesi.txt";
								
								try
								{
									ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
								System.out.println("Hastanýn bütün kan ihtiyacý karþýlanmýþtýr.");
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
								String dosya1 = "Kan Baðýþ Listesi.txt";
								
								try
								{
									ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
									System.exit(0);
								}
								
								for(int i = 0; i < kanBagisListesi.size(); i++)
								{
									ciktiAkimi1.println(kanBagisListesi.get(i));
								}
								ciktiAkimi1.close();
								
								PrintWriter ciktiAkimi2 = null;
								String dosya2 = "Kan Ýhtiyaç Listesi.txt";
								
								try
								{
									ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
								System.out.println("Ýhtiyaç olan " + ihtiyacOlanKanTorbasi + " adet kan ünitesinden " + bagislananKanTorbasi + " adedi karþýlanmýþtýr.");
								System.out.println("Hasta için " + (ihtiyacOlanKanTorbasi - bagislananKanTorbasi) + " adet kan ünitesine daha ihtiyaç vardýr.");
								
								for(int i = 0; i < kanBagisListesi.size(); i++)
								{
									if(kanGrubu.equals(kanBagisListesi.get(i)))
									{
										kanBagisListesi.remove(i);
									}
								}
								
								kanBagisListesi.trimToSize();
								
								PrintWriter ciktiAkimi1 = null;
								String dosya1 = "Kan Baðýþ Listesi.txt";
								
								try
								{
									ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
								System.out.println("Hastanýn kan ihtiyacý karþýlanmýþtýr.");
								
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
								String dosya1 = "Kan Baðýþ Listesi.txt";
								
								try
								{
									ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
									System.exit(0);
								}
								
								for(int i = 0; i < kanBagisListesi.size(); i++)
								{
									ciktiAkimi1.println(kanBagisListesi.get(i));
								}
								ciktiAkimi1.close();
								
								PrintWriter ciktiAkimi2 = null;
								String dosya2 = "Kan Ýhtiyaç Listesi.txt";
								
								try
								{
									ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
								}
								catch(FileNotFoundException hata)
								{
									System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
							System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
							System.out.println();
							break;
					}
				}
			}
			while(kontrol);
		}
	}
}