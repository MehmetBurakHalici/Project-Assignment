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
		System.out.println("\t\t\t\t\t\t\t    SÝSTEM AYARLARI");
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
				System.out.println("2: Ana Menüye Geri Dön");
				System.out.print("Seçiminiz: ");
				setSecim(klavye.nextInt());
				switch(getSecim())
				{
					case 1:
						kontrol = false;
						do
						{
							System.out.println();
							System.out.println("Ne yapmak istiyorsunuz?");
							System.out.println("1: Baðýþlanan Kan Grubu Listesinden Veri Silme");
							System.out.println("2: Ýhtiyaç Duyulan Kan Grubu Listesinden Veri Silme");
							System.out.println("3: Sistem Ayarlarý Menüsüne Geri Dön");
							System.out.println("4: Ana Menüye Geri Dön");
							System.out.print("Seçiminiz: ");
							setSecim(klavye.nextInt());
							switch(getSecim())
							{
								case 1:
									System.out.println();
									System.out.println("*****KAN BAÐIÞ GRUBU LÝSTESÝ*****");
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
										System.out.print("Kan Baðýþ Listesi.txt dosyasýndan veri giriþinde hata oluþtu.");
									}
									
									for(int i = 0; i < kanBagisListesi.size(); i++)
									{
										System.out.println("0: " + kanBagisListesi.get(i));
									}
									do
									{
										kontrol3 = true;
										
										System.out.println();
										System.out.println("Lütfen silmek istediðiniz kan baðýþ verisinin numarasýný tuþlayýnýz.");
										System.out.println("NOT: Silme iþleminden vazgeçip Sistem Ayarlarý menüsüne dönme için ise lütfen /'99/'ý týþlayýnýz.");
										System.out.print("Seçiminiz: ");
										setSecim(klavye.nextInt());
										if(getSecim() < 0 || getSecim() > kanBagisListesi.size() - 1)
										{
											System.out.println();
											System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
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
											System.out.println();
											System.out.println("Veri silme iþlemi baþarýyla gerçekleþtirildi.");
											ciktiAkimi1.close();
										}
									}
									while(kontrol3);
									break;
								case 2:
									System.out.println();
									System.out.println("*****KAN ÝHTÝYAÇ GRUBU LÝSTESÝ*****");
									try
									{
										BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Ýhtiyaç Listesi.txt"));
										
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
										//System.out.print("Kan Ýhtiyaç Listesi.txt dosyasý bulunamadý veya açýlamadý.");
									}
									catch(IOException e)
									{
										System.out.print("Kan Ýhtiyaç Listesi.txt dosyasýndan veri giriþinde hata oluþtu.");
									}
									
									for(int i = 0; i < kanIhtiyacListesi.size(); i++)
									{
										System.out.println(i + ": " + kanIhtiyacListesi.get(i));
									}
									do
									{
										kontrol3 = true;
										
										System.out.println();
										System.out.println("Lütfen silmek istediðiniz kan baðýþ verisinin numarasýný tuþlayýnýz.");
										System.out.println("NOT: Silme iþleminden vazgeçip Sistem Ayarlarý menüsüne dönme için ise lütfen /'99/'ý týþlayýnýz.");
										System.out.print("Seçiminiz: ");
										setSecim(klavye.nextInt());
										if(getSecim() < 0 || getSecim() > kanIhtiyacListesi.size() - 1)
										{
											System.out.println();
											System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
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
											System.out.println("Veri silme iþlemi baþarýyla gerçekleþtirildi.");
											
											PrintWriter ciktiAkimi1 = null;
											String dosya1 = "Kan Ýhtiyaç Listesi.txt";
											
											try
											{
												ciktiAkimi1 = new PrintWriter(new FileOutputStream(dosya1));
											}
											catch(FileNotFoundException hata)
											{
												System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
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
									System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
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
		while(kontrol);
	}
	
	@Override
	public void kayitFormu()
	{
		KanBagisi kanBagisi = new KanBagisi();
		
		SistemAyarlari sistemAyarlari = new SistemAyarlari();
		
		System.out.println("Sistem ayarlarýna yalnýzca yetkili kiþiler giriþ yapabilir.");
		System.out.println("Devam edebilmek için lütfen þifreyi giriniz.");
		System.out.println("NOT: Ana menüye dönebilmek için þifreyi /'99/' olarak tuþlayýnýz.");
		do
		{	
			try
			{
				System.out.print("Þifre: ");
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
					System.out.println("Þifre yanlýþ. Lütfen tekrar deneyiniz...");
					System.out.println();
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
		while(kontrol);
	}
}
