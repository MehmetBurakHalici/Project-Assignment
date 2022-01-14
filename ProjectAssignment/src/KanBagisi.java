import java.io.*;
import java.util.*;

public class KanBagisi extends Kizilay implements OrtakFonksiyonlar
{
	Scanner klavye = new Scanner(System.in);
	
	private int sayac;
	
	private boolean kontrol;
	private boolean kontrol1;
	private boolean kontrol2;
	private boolean kontrol3; 
	private boolean kontrol4; 
	private boolean kontrol5;
	private boolean kontrol6;
	private boolean kontrol7;
	private boolean kontrol8;
	private boolean kontrol9;
	private boolean kontrol10;
	private boolean kontrol11;
	private boolean kontrolEkstra1;
	private boolean kontrolEkstra2;
	private boolean kontrolEkstra3;
	
	private String duzeltme;
	
	private int gun1;
	private int gun2;
	private int ay1;
	private int ay2;
	private int yil1;
	private int yil2;
	private String tarih;
	
	private String TCKimlikNo;
	private String adSoyad;
	private String babaAdi;
	private String dogumTarihi;
	private String dogumYeri;
	
	private String cinsiyet;
	private String medeniHal;
	private String egitimDurumu;
	private String meslek;
	private String kanBagisiGecmisi;
	
	private String adres;
	private String telefonNumarasi;
	private String ePostaAdresi;
	private String kanHizmetleriBilgilendirme;
	private String digerBilgilendirme;
	
	private String boy;
	private int vucutAgirligi;
	private int vucutSicakligi; 
	private int kucukTansiyon;
	private int buyukTansiyon;
	private String tansiyon;
	private String kanGrubu;
	
	private ArrayList<String> kanBagisListesi = new ArrayList<String>();
	private ArrayList<String> kanIhtiyacListesi = new ArrayList<String>();
	
	private ArrayList<String> sorgulamaFormuSorulariListesi = new ArrayList<String>();
	private ArrayList<String> ekFormSorulariListesi = new ArrayList<String>();
	
	private String[] sorgulamaFormuSorulariCevaplari = new String[43];
	private String[] ekFormSorulariCevaplari = new String[5];
	
	@Override
	public void girisYazisi()
	{
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t    KAN BAÐIÞ SÝSTEMÝ");
	}
	
	@Override
	public void secimYapma()
	{
		kontrol = true;
		
		do
		{	
			try
			{
				System.out.println("Ne yapmak istiyorsunuz?");
				System.out.println("1: Yeni Kayýt Formu Doldur");
				System.out.println("2: Ana Menüye Geri Dön");
				System.out.print("Seçiminiz: ");
				setSecim(klavye.nextInt());
				switch(getSecim())
				{
					case 1:
						kayitFormu();
						System.out.println();
						break;
					case 2:
						kontrol = false;
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
			catch(Exception e)
			{
				System.out.println("HATA: " + e.getMessage());
				System.out.println();
				System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
				duzeltme = klavye.nextLine();
			}
		}
		while(kontrol);
	}
	
	@Override
	public void kayitFormu()
	{	
		try
		{
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Baðýþ Listesi.txt"));
			
			String satir = null;
			setSayac(0);
			satir = girisAkimi.readLine();
			
			while(satir != null)
			{
				setSayac(getSayac() + 1);
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
		
		PrintWriter ciktiAkimi3 = null;
		String dosya3 = "Kan Baðýþ Listesi.txt";
		
		try
		{
			ciktiAkimi3 = new PrintWriter(new FileOutputStream(dosya3));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
			System.exit(0);
		}
		ciktiAkimi3.close();
		
		for(int i = 0; i < kanBagisListesi.size(); i++)
		{
			ciktiAkimi3.println(kanBagisListesi.get(i));
		}
		
		try
		{
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Ýhtiyaç Listesi.txt"));
			
			String satir = null;
			setSayac(0);
			satir = girisAkimi.readLine();
			
			while(satir != null)
			{
				setSayac(getSayac() + 1);
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
		
		PrintWriter ciktiAkimi4 = null;
		String dosya4 = "Kan Ýhtiyaç Listesi.txt";
		
		try
		{
			ciktiAkimi4 = new PrintWriter(new FileOutputStream(dosya4));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
			System.exit(0);
		}
		
		for(int i = 0; i < kanIhtiyacListesi.size(); i++)
		{
			ciktiAkimi4.println(kanIhtiyacListesi.get(i));
		}
		ciktiAkimi4.close();
		
		kontrol1 = true;
		kontrol2 = true;
		kontrol3 = true; 
		kontrol4 = true; 
		kontrol5 = true;
		kontrol6 = true;
		kontrol7 = true;
		kontrol8 = true;
		kontrol9 = true;
		kontrol10 = true;
		kontrol11 = true;
		kontrolEkstra1 = true;
		kontrolEkstra2 = true;
		setKontrolEkstra3(true);
			
		System.out.println();
		System.out.print("*****BUGÜNÜN TARÝHÝ*****");
		System.out.println();
		do
		{	
			try
			{
				kontrolEkstra1 = true;
				kontrolEkstra2 = true;
				kontrolEkstra3 = true;
				
				System.out.print("Gün : ");
				gun1 = klavye.nextInt();
				if(gun1 < 0 || gun1 > 31)
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
						ay1 = klavye.nextInt();
						if(ay1 < 0 || ay1 > 12)
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
								yil1 = klavye.nextInt();
								if(yil1 < 0)
								{
									System.out.println();
									System.out.println("Yýl deðeri 0'dan küçük olamaz. Lütfen tekrar deneyiniz...");
									System.out.println();
								}
								else
								{
									kontrolEkstra1 = false;
									kontrolEkstra2 = false;
									kontrolEkstra3 = false;
									
									tarih = gun1 + "." + ay1 + "." + yil1;
								}
							}
							while(kontrolEkstra3);
						}
					}
					while(kontrolEkstra2);
				}
			}
			catch(Exception e)
			{
				System.out.println("HATA: " + e.getMessage());
				System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
				System.out.println();
				duzeltme = klavye.nextLine();
			}
		}
		while(kontrolEkstra1);
		
		
		do
		{
			kontrolEkstra1 = true;
			kontrolEkstra2 = true;
			kontrolEkstra3 = true;
			
			System.out.println();
			System.out.println("\"Kimlik Bilgileri\" sorularýna geçilsin mi?");
			System.out.println("1: Evet");
			System.out.println("2: Hayýr");
			System.out.print("Seçiminiz: ");
			setSecim(klavye.nextInt());
			switch(getSecim())
			{
				case 1:
					System.out.println();
					System.out.print("*****KAN BAÐIÞÇISI ADAYININ KÝMLÝK BÝLGÝLERÝ*****");
					System.out.println();
				
					duzeltme = klavye.nextLine();
					
					System.out.print("T.C. Kimlik Numaranýz : ");
					TCKimlikNo = klavye.nextLine();
					
					System.out.print("Adýnýz Soyadýnýz : ");
					adSoyad = klavye.nextLine();
					
					System.out.print("Baba Adýnýz : ");
					babaAdi = klavye.nextLine();
					
					System.out.println("Doðum Tarihiniz");
					
					do
					{	
						kontrolEkstra1 = true;
						kontrolEkstra2 = true;
						kontrolEkstra3 = true;
						
						System.out.print("Gün : ");
						gun2 = klavye.nextInt();
						if(gun2 < 0 || gun2 > 31)
						{
							System.out.println();
							System.out.println("Gün deðeri 0'dan küçük ya da 31'den büyük olamaz. Lütfen tekrar deneyiniz...");
							System.out.println();
						}
						else
						{
							do
							{
								System.out.print("Ay (Örneðin \"Þubat\" ayý için \"2\") : ");
								ay2 = klavye.nextInt();
								if(ay2 < 0 || ay2 > 12)
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
										yil2 = klavye.nextInt();
										if(yil2 < 0)
										{
											System.out.println();
											System.out.println("Yýl deðeri 0'dan küçük olamaz. Lütfen tekrar deneyiniz...");
											System.out.println();
										}
										else
										{
											kontrolEkstra1 = false;
											kontrolEkstra2 = false;
											kontrolEkstra3 = false;
											
											dogumTarihi = gun2 + "." + ay2 + "." + yil2;
										}
									}
									while(kontrolEkstra3);
								}
							}
							while(kontrolEkstra2);
						}
					}
					while(kontrolEkstra1);
						
					if((yil1 - yil2) < 18 || (yil1 - yil2) > 65)
					{
						kontrolEkstra1 = false;
					}
					else if((yil1 - yil2) == 18 || (yil1 - yil2) == 65)
					{
						if(ay1 < ay2)
						{
							kontrolEkstra1 = false;
						}
						else if(ay1 == ay2)
						{
							if(gun1 <= gun2)
							{
								kontrolEkstra1 = false;
							}
							else
							{
								duzeltme = klavye.nextLine();
								System.out.print("Doðum Yeriniz (Ýl) : ");
								dogumYeri = klavye.nextLine();
							}
						}
						else
						{
							duzeltme = klavye.nextLine();
							
							System.out.print("Doðum Yeriniz (Ýl) : ");
							dogumYeri = klavye.nextLine();
						}
					}
					else
					{
						duzeltme = klavye.nextLine();
						
						System.out.print("Doðum Yeriniz (Ýl) : ");
						dogumYeri = klavye.nextLine();
					}
					
					if(kontrolEkstra1 == true)
					{
						do
						{
							System.out.println();
							System.out.println("\"Kiþisel Bilgiler\" sorularýna geçilsin mi?");
							System.out.println("1: Evet");
							System.out.println("2: Hayýr");
							System.out.print("Seçiminiz: ");
							setSecim(klavye.nextInt());
							switch(getSecim())
							{
								case 1:
									System.out.println();
									System.out.print("*****KAN BAÐIÞÇISI ADAYININ KÝÞÝSEL BÝLGÝLERÝ*****");
									System.out.println(); 
									
									do
									{
										try
										{
											System.out.println("Cinsiyetiniz");
											System.out.println("1: Erkek");
											System.out.println("2: Kadýn");
											System.out.print("Cevabýnýz: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													kontrolEkstra1 = false;
													cinsiyet = "Erkek";
													break;
												case 2:
													kontrolEkstra1 = false;
													cinsiyet = "Kadýn";
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
											duzeltme = klavye.nextLine();
										}
									}
									while(kontrolEkstra1);
									
									do
									{
										try
										{
											kontrolEkstra1 = true;
											
											System.out.println("Medeni Haliniz");
											System.out.println("1: Evli");
											System.out.println("2: Bekar");
											System.out.print("Cevabýnýz: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													kontrolEkstra1 = false;
													medeniHal = "Evli";
													break;
												case 2:
													kontrolEkstra1 = false;
													medeniHal = "Bekar";
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
											duzeltme = klavye.nextLine();
										}
									}
									while(kontrolEkstra1);
									
									do
									{
										try
										{
											kontrolEkstra1 = true;
											
											System.out.println("Eðitim Durumunuz");
											System.out.println("1: Yok");
											System.out.println("2: Ýlkokul");
											System.out.println("3: Ortaokul");
											System.out.println("4: Lise");
											System.out.println("5: Önlisans");
											System.out.println("6: Lisans");
											System.out.println("7: Yüksek Lisans");
											System.out.println("8: Doktora");
											System.out.print("Cevabýnýz: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													kontrolEkstra1 = false;
													egitimDurumu = "Yok";
													break;
												case 2:
													kontrolEkstra1 = false;
													egitimDurumu = "Ýlkokul";
													break;
												case 3:
													kontrolEkstra1 = false;
													egitimDurumu = "Ortaokul";
													break;
												case 4:
													kontrolEkstra1 = false;
													egitimDurumu = "Lise";
													break;
												case 5:
													kontrolEkstra1 = false;
													egitimDurumu = "Önlisans";
													break;
												case 6:
													kontrolEkstra1 = false;
													egitimDurumu = "Lisans";
													break;
												case 7:
													kontrolEkstra1 = false;
													egitimDurumu = "Yüksek Lisans";
													break;
												case 8:
													kontrolEkstra1 = false;
													egitimDurumu = "Doktora";
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
											duzeltme = klavye.nextLine();
										}
									}
									while(kontrolEkstra1);
									
									duzeltme = klavye.nextLine();
									
									System.out.print("Mesleðiniz : ");
									meslek = klavye.nextLine();
									
									do
									{
										try
										{
											kontrolEkstra1 = true;
											
											System.out.println("Kan Baðýþý Geçmiþiniz");
											System.out.println("1: Hayatýmda Ýlk Kez Kan Baðýþlýyorum.");
											System.out.println("2: Daha Önce Kan Baðýþý Yaptým.");
											System.out.print("Cevabýnýz: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													kontrolEkstra1 = false;
													kanBagisiGecmisi = "Hayatýmda Ýlk Kez Kan Baðýþlýyorum.";
													break;
												case 2:
													kontrolEkstra1 = false;
													kanBagisiGecmisi = "Daha Önce Kan Baðýþý Yaptým.";
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
											duzeltme = klavye.nextLine();
										}
									}
									while(kontrolEkstra1);
									
									do
									{
										try
										{
											System.out.println();
											System.out.println("\"Adres ve Diðer Ýletiþim Bilgileri\" sorularýna geçilsin mi?");
											System.out.println("1: Evet");
											System.out.println("2: Hayýr");
											System.out.print("Seçiminiz: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													System.out.println();
													System.out.print("*****KAN BAÐIÞÇISI ADAYININ ADRES VE DÝÐER ÝLETÝÞÝM BÝLGÝLERÝ*****");
													System.out.println(); 
													
													duzeltme = klavye.nextLine();
													
													System.out.print("Adresiniz : ");
													adres = klavye.nextLine();
													
													System.out.print("Telefon Numaranýz : ");
													telefonNumarasi = klavye.nextLine();
													
													System.out.print("E-posta Adresiniz : ");
													ePostaAdresi = klavye.nextLine();
													
													do
													{
														try
														{
															System.out.println();
															System.out.println("\"Bilgilendirme\" sorularýna geçilsin mi?");
															System.out.println("1: Evet");
															System.out.println("2: Hayýr");
															System.out.print("Seçiminiz: ");
															setSecim(klavye.nextInt());
															switch(getSecim())
															{
																case 1:
																	kontrolEkstra1 = true;
																	System.out.println();
																	System.out.println("*****FAALÝYETLERÝMÝZ HAKKINDA BÝLGÝLENDÝRÝLME*****");
																	do
																	{
																		try
																		{
																			System.out.println("Türk Kýzýlayýnýn kan hizmetleri hakkýnda bilgilendirilmek istiyor musunuz?");
																			System.out.println("1: Evet (Sadece \"SMS\" ile)");
																			System.out.println("2: Evet (Sadece \"Telefon\" ile)");
																			System.out.println("3: Evet (Sadece \"E-posta\" ile)");
																			System.out.println("4: Evet (\"SMS\" ve \"Telefon\" ile)");
																			System.out.println("5: Evet (\"SMS\" ve \"E-posta\" ile)");
																			System.out.println("6: Evet (\"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("7: Evet (\"SMS\", \"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("8: Hayýr, istemiyorum.");
																			System.out.print("Cevabýnýz: ");
																			setSecim(klavye.nextInt());
																			switch(getSecim())
																			{
																				case 1:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Sadece \"SMS\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda \"SMS\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 2:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Sadece \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 3:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Sadece \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 4:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"SMS\" ve \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda \"SMS\" ve \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 5:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"SMS\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda \"SMS\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 6:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 7:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda \"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 8:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Bilgilendirme Yok";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakkýnda herhangi bir bilgilendirme almayacaksýnýz.");
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
																			duzeltme = klavye.nextLine();
																		}
																	}
																	while(kontrolEkstra1);
																	kontrolEkstra1 = true;
																	do
																	{
																		try
																		{
																			System.out.println("Türk Kýzýlayýnýn diðer faaliyet alanlarý hakkýnda bilgilendirilmek istiyor musunuz?");
																			System.out.println("1: Evet (Sadece \"SMS\" ile)");
																			System.out.println("2: Evet (Sadece \"Telefon\" ile)");
																			System.out.println("3: Evet (Sadece \"E-posta\" ile)");
																			System.out.println("4: Evet (\"SMS\" ve \"Telefon\" ile)");
																			System.out.println("5: Evet (\"SMS\" ve \"E-posta\" ile");
																			System.out.println("6: Evet (\"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("7: Evet (\"SMS\", \"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("8: Hayýr, istemiyorum.");
																			System.out.print("Cevabýnýz: ");
																			setSecim(klavye.nextInt());
																			switch(getSecim())
																			{
																				case 1:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Sadece \"SMS\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda \"SMS\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 2:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Sadece \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 3:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Sadece \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 4:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"SMS\" ve \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda \"SMS\" ve \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 5:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"SMS\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda \"SMS\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 6:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 7:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda \"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 8:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Bilgilendirme Yok";
																					System.out.println();
																					System.out.println("Diðer faaliyet alanlarý hakkýnda herhangi bir bilgilendirme almayacaksýnýz.");
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
																			duzeltme = klavye.nextLine();
																		}
																	}
																	while(kontrolEkstra1);
																	
																	do
																	{
																		try
																		{
																			System.out.println("Yukarýda belirtmiþ olduðunuz kimlik, iletiþim ve diðer bilgilerin doðru olduðunu beyan ediyor musunuz?");
																			System.out.println("1: Evet, beyan ediyorum.");
																			System.out.println("2: Hayýr, beyan etmiyorum.");
																			System.out.print("Cevabýnýz: ");
																			setSecim(klavye.nextInt());
																			switch(getSecim())
																			{
																				case 1:
																					System.out.println();
																					System.out.println("Beyanýnýz sistem tarafýndan kabul edilmiþtir.");
																					
																					do
																					{
																						try
																						{
																							kontrolEkstra1 = true;
																							
																							System.out.println();
																							System.out.println("\"Ölçüm ve Ýnceleme Deðerleri\" kýsmýna geçilsin mi?");
																							System.out.println("1: Evet");
																							System.out.println("2: Hayýr");
																							System.out.print("Seçiminiz: ");
																							setSecim(klavye.nextInt());
																							switch(getSecim())
																							{
																								case 1:
																									System.out.println();
																									System.out.print("*****KAN BAÐIÞÇISI ADAYININ ÖLÇÜM VE ÝNCELEME DEÐERLERÝ*****");
																									System.out.println();
																								
																									duzeltme = klavye.nextLine();
																									
																									System.out.println("Boy ölçümü yapýlýyor...");
																									System.out.println();
																									System.out.print("Ölçüm Sonucu Boy = ");
																									boy = klavye.nextLine();
																									
																									System.out.println();
																									System.out.println("Vücut aðýrlýðý hesaplanýyor...");
																									System.out.println();
																									System.out.print("Hesaplama Sonucu Vücut Aðýrlýðý = ");
																									vucutAgirligi = klavye.nextInt();
																									if(vucutAgirligi < 50)
																									{
																										kontrolEkstra1 = false;
																										System.out.println();
																										System.out.println("Kilosu 50'den az olan bireyler kan baðýþýnda bulunamazlar.");
																										System.out.println("Kayýt formu sonlandýrýlýyor...");
																									}
																									else
																									{
																										System.out.println();
																										System.out.println("Vücut sýcaklýðý ölçülüyor...");
																										System.out.println();
																										System.out.print("Ölçülen Vücut Sýcaklýðý = ");
																										vucutSicakligi = klavye.nextInt();
																										if(vucutSicakligi <=35 || vucutSicakligi >= 39)
																										{
																											kontrolEkstra1 = false;
																											System.out.println();
																											System.out.println("Vücut sýcaklýðýnýz normal deðerlerin dýþýnda olduðu için þu anda kan baðýþýnda bulunamazsýnýz.");
																											System.out.println("Kayýt formu sonlandýrýlýyor...");
																										}
																										else
																										{
																											System.out.println();
																											System.out.println("Tansiyon ölçülüyor...");
																											System.out.println();
																											System.out.println("Ölçülen Sonuca Göre");
																											System.out.print("Küçük Tansiyon Deðeri = ");
																											kucukTansiyon = klavye.nextInt();
																											System.out.print("Büyük Tansiyon Deðeri = ");
																											buyukTansiyon = klavye.nextInt();
																											
																											tansiyon = kucukTansiyon + "/" + buyukTansiyon;
																											
																											if(kucukTansiyon < 70 || kucukTansiyon > 90 || buyukTansiyon < 120 || buyukTansiyon > 130)
																											{
																												kontrolEkstra1 = false;
																												System.out.println();
																												System.out.println("Tansiyonunuz normal deðerlerin dýþýnda olduðu için þu anda kan baðýþýnda bulunamazsýnýz.");
																												System.out.println("Kayýt formu sonlandýrýlýyor...");
																											}
																											else
																											{
																												System.out.println();
																												System.out.println("Kan grubu inceleniyor...");
																												System.out.println();
																												do
																												{
																													try
																													{
																														System.out.println("1: ARh+");
																														System.out.println("2: ARh-");
																														System.out.println("3: BRh+");
																														System.out.println("4: BRh-");
																														System.out.println("5: ABRh+");
																														System.out.println("6: ABRh-");
																														System.out.println("7: 0Rh+");
																														System.out.println("8: 0Rh-");
																														System.out.print("Ýnceleme Sonucu: ");
																														setSecim(klavye.nextInt());
																														switch(getSecim())
																														{
																															case 1:
																																kontrolEkstra2 = false;
																																kanGrubu = "ARh+";
																																break;
																															case 2:
																																kontrolEkstra2 = false;
																																kanGrubu = "ARh-";
																																break;
																															case 3:
																																kontrolEkstra2 = false;
																																kanGrubu = "BRh+";
																																break;
																															case 4:
																																kontrolEkstra2 = false;
																																kanGrubu = "BRh-";
																																break;
																															case 5:
																																kontrolEkstra2 = false;
																																kanGrubu = "ABRh+";
																																break;
																															case 6:
																																kontrolEkstra2 = false;
																																kanGrubu = "ABRh-";
																																break;
																															case 7:
																																kontrolEkstra2 = false;
																																kanGrubu = "0Rh+";
																																break;
																															case 8:
																																kontrolEkstra2 = false;
																																kanGrubu = "0Rh+";
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
																														System.out.println();
																														System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
																														duzeltme = klavye.nextLine();
																													}
																													
																												}
																												while(kontrolEkstra2);
																											}
																										}
																									}
																									
																									if(kontrolEkstra1 == true)
																									{
																										do
																										{
																											kontrolEkstra1 = true;
																											kontrolEkstra2 = true;
																											
																											System.out.println();
																											System.out.println("\"Sorgulama Formu\" sorularýna geçilsin mi?");
																											System.out.println("1: Evet");
																											System.out.println("2: Hayýr");
																											System.out.print("Seçiminiz: ");
																											setSecim(klavye.nextInt());
																											switch(getSecim())
																											{
																												case 1:
																													sorgulamaFormuSorulari();
																													
																													System.out.println();
																													System.out.print("*****SORGULAMA FORMU*****");
																													System.out.println();
																													
																													for(int i = 0; i < sorgulamaFormuSorulariListesi.size(); i++)
																													{
																														kontrolEkstra1 = true;
																														kontrolEkstra2 = true;
																														if(i == 0 || i == 1)
																														{
																															do
																															{
																																kontrolEkstra1 = true;
																																kontrolEkstra2 = true;
																																
																																System.out.println(sorgulamaFormuSorulariListesi.get(i));
																																System.out.println("1: Evet");
																																System.out.println("2: Hayýr");
																																System.out.print("Cevabýnýz: ");
																																setSecim(klavye.nextInt());
																																switch(getSecim())
																																{
																																	case 1:
																																		kontrolEkstra1 = false;
																																		sorgulamaFormuSorulariCevaplari[i] = "Evet";
																																		break;
																																	case 2:
																																		sorgulamaFormuSorulariCevaplari[i] = "Hayýr";
																																		System.out.println();
																																		System.out.println("Durum inceleniyor...");
																																		System.out.println();
																																		do
																																		{	
																																			System.out.println("Forma devam edilsin mi?");
																																			System.out.println("1: Evet, kan vermeye uygun.");
																																			System.out.println("2: Hayýr, kan vermeye uygun deðil.");
																																			System.out.print("Seçiminiz: ");
																																			setSecim(klavye.nextInt());
																																			switch(getSecim())
																																			{
																																				case 1:
																																					kontrolEkstra1 = false;
																																					kontrolEkstra2 = false;
																																					break;
																																				case 2:
																																					kontrolEkstra1 = false;
																																					kontrolEkstra2 = false;
																																					kontrol8 = false;
																																					i = 1000;
																																					
																																					System.out.println();
																																					System.out.println("Þu anda kan vermek için uygun koþullarda deðilsiniz.");
																																					System.out.println("Uygun koþullar saðlandýktan sonra kan merkezimize tekrardan müracaat edebilirsiniz.");
																																					System.out.print("Ýyi günler dileriz...");
																																					break;
																																				default:
																																					System.out.println();
																																					System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																					System.out.println();
																																					break;
																																			}
																																		}
																																		while(kontrolEkstra2);
																																		break;
																																	default:
																																		System.out.println();
																																		System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																		System.out.println();
																																		break;
																																}
																															}
																															while(kontrolEkstra1);
																														}
																														else if(i == 13 || i == 15  || i == 16 || i == 19 || i == 21 || i == 25 || i == 27 || i == 28 || i == 29 || i == 33 || i == 35 || i == 42)
																														{
																															do
																															{
																																kontrolEkstra1 = true;
																																
																																System.out.println(sorgulamaFormuSorulariListesi.get(i));
																																System.out.println("1: Evet");
																																System.out.println("2: Hayýr");
																																System.out.print("Cevabýnýz: ");
																																setSecim(klavye.nextInt());
																																switch(getSecim())
																																{
																																	case 1:
																																		kontrolEkstra1 = false;
																																		kontrol8 = false;
																																		sorgulamaFormuSorulariCevaplari[i] = "Evet";
																																		i = 1000;
																																		
																																		System.out.println();
																																		System.out.println("Üzgünüz, bu durumda kan baðýþý yapamazsýnýz.");
																																		System.out.println("Mevcut durum ortadan kalkabilecek bir þey ise sonrasýnda kan merkezimize tekrardan müracaat edebilirsiniz.");
																																		System.out.println("Ýyi günler dileriz...");
																																		break;
																																	case 2:
																																		kontrolEkstra1 = false;
																																		sorgulamaFormuSorulariCevaplari[i] = "Hayýr";
																																		break;
																																	default:
																																		System.out.println();
																																		System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																		System.out.println();
																																		break;
																																}
																															}
																															while(kontrolEkstra1);
																														}
																														else
																														{
																															kontrolEkstra1 = true;
																															kontrolEkstra2 = true;
																															do
																															{
																																System.out.println(sorgulamaFormuSorulariListesi.get(i));
																																System.out.println("1: Evet");
																																System.out.println("2: Hayýr");
																																System.out.print("Cevabýnýz: ");
																																setSecim(klavye.nextInt());
																																switch(getSecim())
																																{
																																	case 1:
																																		sorgulamaFormuSorulariCevaplari[i] = "Evet";
																																		System.out.println();
																																		System.out.println("Durum inceleniyor...");
																																		System.out.println();
																																		do
																																		{	
																																			kontrolEkstra1 = true;
																																			kontrolEkstra2 = true;
																																			
																																			System.out.println("Forma devam edilsin mi?");
																																			System.out.println("1: Evet, kan vermeye uygun.");
																																			System.out.println("2: Hayýr, kan vermeye uygun deðil.");
																																			System.out.print("Seçiminiz: ");
																																			setSecim(klavye.nextInt());
																																			switch(getSecim())
																																			{
																																				case 1:
																																					kontrolEkstra1 = false;
																																					kontrolEkstra2 = false;
																																					break;
																																				case 2:
																																					kontrolEkstra1 = false;
																																					kontrolEkstra2 = false;
																																					kontrol8 = false; 
																																					i = 1000;
																																					
																																					System.out.println();
																																					System.out.println("Þu anda kan vermek için uygun koþullarda deðilsiniz.");
																																					System.out.println("Uygun koþullar saðlandýktan sonra kan merkezimize tekrardan müracaat edebilirsiniz.");
																																					System.out.println("Ýyi günler dileriz...");
																																					break;
																																				default:
																																					System.out.println();
																																					System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																					System.out.println();
																																					break;
																																			}
																																		}
																																		while(kontrolEkstra2);
																																		
																																		break;
																																	case 2:
																																		sorgulamaFormuSorulariCevaplari[i] = "Hayýr";
																																		kontrolEkstra1 = false;
																																		break;
																																	default:
																																		System.out.println();
																																		System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																		System.out.println();
																																		break;
																																}
																															}
																															while(kontrolEkstra1);
																														}
																													}
																													
																													if(kontrol8 == true)
																													{
																														do
																														{	
																															System.out.println();
																															System.out.println("\"Sorgulama Formu'ndaki sorularý dikkatlice okudum ve anladým.");
																															System.out.println("Verilen bilgiler doðrultusunda kanýmý gönüllü ve karþýlýksýz olarak baðýþlamayý");
																															System.out.println("ve tarama testleri yapýldýktan sonra gereksinimi olan herhangi bir hasta için ve/veya diðer týbbi amaçlar için kullanýlmasýný,");
																															System.out.println("tarama testerinden herhangi birinin pozitif çýkmasý halinde tarafýma bildirilmesini kabul ediyorum.\"");
																															System.out.println("Yukarýdaki beyaný onaylýyor musunuz?");
																															System.out.println("1: Evet, onaylýyorum.");
																															System.out.println("2: Hayýr, onaylamýyorum.");
																															System.out.print("Cevabýnýz: ");
																															setSecim(klavye.nextInt());
																															switch(getSecim())
																															{
																																case 1:
																																	System.out.println();
																																	System.out.println("Beyanýnýz sistem tarafýndan onaylanmýþtýr.");
																																	
																																	do
																																	{
																																		kontrolEkstra1 = true;
																																		kontrolEkstra2 = true;
																																		setKontrolEkstra3(
																																				true);	
																																		
																																		System.out.println();
																																		System.out.println("\"Ek Form\" sorularýna geçilsin mi?");
																																		System.out.println("1: Evet");
																																		System.out.println("2: Hayýr");
																																		System.out.print("Seçiminiz: ");
																																		setSecim(klavye.nextInt());
																																		switch(getSecim())
																																		{
																																			case 1:
																																				ekFormSorulari();
																																				
																																				System.out.println();
																																				System.out.print("*****EK FORM*****");
																																				System.out.println();
																																				
																																				for(int i = 0; i < ekFormSorulariListesi.size(); i++)
																																				{
																																					kontrolEkstra1 = true;
																																					kontrolEkstra2 = true;
																																					setKontrolEkstra3(
																																							true);
																																					if(i == 0)
																																					{
																																						do
																																						{
																																							System.out.println(ekFormSorulariListesi.get(i));
																																							System.out.println("1: Evet");
																																							System.out.println("2: Hayýr");
																																							System.out.print("Cevabýnýz: ");
																																							setSecim(klavye.nextInt());
																																							switch(getSecim())
																																							{
																																								case 1:
																																									ekFormSorulariCevaplari[i] = "Evet";
																																									System.out.println();
																																									System.out.println("Son 28 gün içerisinde COVID-19 tanýsý almýþ bir kimsenin kan baðýþýnda bulunabilmesi için þu anda negatif olduðunu gösteren en fazla 3 gün öncesine ait PCR testi sonucu ile kan baðýþýna müracaat etmesi gereklidir.");
																																									
																																									do
																																									{
																																										System.out.println("En çok 3 gün öncesine ait PCR testiniz var mý?");
																																										System.out.println("1: Evet, var.");
																																										System.out.println("2: Hayýr, yok.");
																																										System.out.print("Cevabýnýz: ");
																																										setSecim(klavye.nextInt());
																																										switch(getSecim())
																																										{
																																											case 1:
																																												System.out.println();
																																												System.out.println("PCR testi inceleniyor...");
																																												System.out.println();
																																												do
																																												{	
																																													System.out.println("Forma devam edilsin mi?");
																																													System.out.println("1: Evet, kan vermeye uygun.");
																																													System.out.println("2: Hayýr, kan vermeye yine de uygun deðil.");
																																													System.out.print("Seçiminiz: ");
																																													setSecim(klavye.nextInt());
																																													switch(getSecim())
																																													{
																																														case 1:
																																															kontrolEkstra1 = false;
																																															kontrolEkstra2 = false;
																																															setKontrolEkstra3(
																																																	false);
																																															break;
																																														case 2:
																																															kontrolEkstra1 = false;
																																															kontrolEkstra2 = false;
																																															setKontrolEkstra3(
																																																	false);
																																															kontrol10 = false;
																																															i = 1000;
																																															
																																															System.out.println();
																																															System.out.println("Þu anda kan vermek için uygun koþullarda deðilsiniz.");
																																															System.out.println("Uygun koþullar saðlandýktan sonra kan merkezimize tekrardan müracaat edebilirsiniz.");
																																															System.out.println("Ýyi günler dileriz...");
																																															break;
																																														default:
																																															System.out.println();
																																															System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																															System.out.println();
																																															break;
																																													}
																																												}
																																												while(getKontrolEkstra3());
																																												break;
																																											case 2:
																																												kontrolEkstra1 = false;
																																												kontrolEkstra2 = false;
																																												setKontrolEkstra3(
																																														false);
																																												kontrol10 = false;
																																												i = 1000;
																																												
																																												System.out.println();
																																												System.out.println("Þu anda kan vermek için uygun koþullarda deðilsiniz.");
																																												System.out.println("En fazla 3 gün öncesine ait negatif PCR testi ile kan merkezimize tekrardan müracaat edebilirsiniz.");
																																												System.out.println("Ýyi günler dileriz...");
																																												break;
																																											default:
																																												System.out.println();
																																												System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																												System.out.println();
																																												break;
																																										}
																																									}
																																									while(kontrolEkstra2);
																																									
																																									break;
																																								case 2:
																																									ekFormSorulariCevaplari[i] = "Hayýr";
																																									kontrolEkstra1 = false;
																																									break;
																																								default:
																																									System.out.println();
																																									System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																									System.out.println();
																																									break;
																																							}
																																						}
																																						while(kontrolEkstra1);
																																					}
																																					else
																																					{
																																						do
																																						{
																																							System.out.println(ekFormSorulariListesi.get(i));
																																							System.out.println("1: Evet");
																																							System.out.println("2: Hayýr");
																																							System.out.print("Cevabýnýz: ");
																																							setSecim(klavye.nextInt());
																																							switch(getSecim())
																																							{
																																								case 1:
																																									ekFormSorulariCevaplari[i] = "Evet";
																																									System.out.println();
																																									System.out.println("COVID-19 olma riski taþýyan bir kimsenin kan baðýþýnda bulunabilmesi için þu anda negatif olduðunu gösteren en fazla 3 gün öncesine ait PCR testi sonucu ile kan baðýþýna müracaat etmesi gereklidir.");
																																									do
																																									{
																																										System.out.println("En fazla 3 gün öncesine ait PCR testiniz var mý?");
																																										System.out.println("1: Evet, var.");
																																										System.out.println("2: Hayýr, yok.");
																																										System.out.print("Cevabýnýz: ");
																																										setSecim(klavye.nextInt());
																																										switch(getSecim())
																																										{
																																											case 1:
																																												System.out.println();
																																												System.out.println("PCR testi inceleniyor...");
																																												System.out.println();
																																												do
																																												{	
																																													System.out.println("Forma devam edilsin mi?");
																																													System.out.println("1: Evet, kan vermeye uygun.");
																																													System.out.println("2: Hayýr, kan vermeye yine de uygun deðil.");
																																													System.out.print("Seçiminiz: ");
																																													setSecim(klavye.nextInt());
																																													switch(getSecim())
																																													{
																																														case 1:
																																															kontrolEkstra1 = false;
																																															kontrolEkstra2 = false;
																																															setKontrolEkstra3(
																																																	false);
																																															i = 1000;
																																															break;
																																														case 2:
																																															kontrolEkstra1 = false;
																																															kontrolEkstra2 = false;
																																															setKontrolEkstra3(
																																																	false);
																																															kontrol10 = false;
																																															i = 1000;
																																															
																																															System.out.println();
																																															System.out.println("Þu anda kan vermek için uygun koþullarda deðilsiniz.");
																																															System.out.println("Uygun koþullar saðlandýktan sonra kan merkezimize tekrardan müracaat edebilirsiniz.");
																																															System.out.println("Ýyi günler dileriz...");
																																															break;
																																														default:
																																															System.out.println();
																																															System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																															System.out.println();
																																															break;
																																													}
																																												}
																																												while(getKontrolEkstra3());
																																												break;
																																											case 2:
																																												kontrolEkstra1 = false;
																																												kontrolEkstra2 = false;
																																												setKontrolEkstra3(
																																														false);
																																												kontrol10 = false;
																																												i = 1000;
																																												
																																												System.out.println();
																																												System.out.println("Þu anda kan vermek için uygun koþullarda deðilsiniz.");
																																												System.out.println("En fazla 3 gün öncesine ait negatif PCR testi ile kan merkezimize tekrardan müracaat edebilirsiniz.");
																																												System.out.println("Ýyi günler dileriz...");
																																												break;
																																											default:
																																												System.out.println();
																																												System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																												System.out.println();
																																												break;
																																										}
																																									}
																																									while(kontrolEkstra2);
																																									
																																									break;
																																								case 2:
																																									ekFormSorulariCevaplari[i] = "Hayýr";
																																									kontrolEkstra1 = false;
																																									break;
																																								default:
																																									System.out.println();
																																									System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																									System.out.println();
																																									break;
																																							}
																																						}
																																						while(kontrolEkstra1);
																																					}
																																				}
																																				
																																				if(kontrol10 == true)
																																				{
																																					do
																																					{	
																																						System.out.println();
																																						System.out.println("Yukarýda vermiþ olduðunuz bilgilerin doðruluðu kabul ediyor ve");
																																						System.out.println("paylaþmýþ olduðunuz saðlýk verilerinin Kýzýlay tarafýndan iþlenmesine onay veriyor musunuz?");
																																						System.out.println("1: Evet, onay veriyorum.");
																																						System.out.println("2: Hayýr, onay vermiyorum.");
																																						System.out.print("Cevabýnýz: ");
																																						setSecim(klavye.nextInt());
																																						switch(getSecim())
																																						{
																																							case 1:
																																								System.out.println();
																																								System.out.println("Onayýnýz sistem tarafýndan kabul edilmiþtir.");
																																								System.out.println();
																																								
																																								do
																																								{
																																									System.out.println("Verilmiþ olan tüm bilgiler ve yapýlmýþ olan tüm kontroller sonucunda " + adSoyad + " kan vermeye uygun mudur?");
																																									System.out.println("1: Evet, uygundur.");
																																									System.out.println("2: Hayýr, yine de uygun deðildir.");
																																									System.out.print("Seçim: ");
																																									setSecim(klavye.nextInt());
																																									switch(getSecim())
																																									{
																																										case 1:
																																											System.out.println();
																																											System.out.println("Bütün kontrol iþlemleri baþarýyla gerçekleþtirilmiþtir.");
																																											System.out.println("Kan vermek üzere uygun bir yere geçebilirsiniz.");
																																											
																																											do
																																											{
																																												kontrolEkstra1 = true;
																																												
																																												System.out.println();
																																												System.out.println("Bilgiler sisteme kaydedilsin mi?");
																																												System.out.println("1: Evet");
																																												System.out.println("2: Hayýr");
																																												System.out.print("Seçiminiz: ");
																																												setSecim(klavye.nextInt());
																																												switch(getSecim())
																																												{
																																													case 1:
																																														kontrolEkstra1 = false;
																																														
																																														PrintWriter ciktiAkimi = null;
																																														String dosya = "Kan Baðýþý Kiþisel Veriler.txt";
																																														
																																														try
																																														{
																																															ciktiAkimi = new PrintWriter(new FileOutputStream(dosya, true));
																																														}
																																														catch(FileNotFoundException hata)
																																														{
																																															System.out.println("\'Kan Baðýþý Kiþisel Veriler.txt\' dosyasý oluþturulurken hata oldu.");
																																															System.exit(0);
																																														}
																																														
																																														ciktiAkimi.println(adSoyad + " KÝÞÝSÝNÝN KAN BAÐIÞ BÝLGÝLERÝ");
																																														ciktiAkimi.println("Kan Verdiði Tarih: " + tarih);
																																														ciktiAkimi.println("*****KÝMLÝK BÝLGÝLERÝ*****");
																																														ciktiAkimi.println("T.C. Kimlik Numarasý: " + TCKimlikNo);
																																														ciktiAkimi.println("Ad Soyad: " + adSoyad);
																																														ciktiAkimi.println("Baba Adý: " + babaAdi);
																																														ciktiAkimi.println("Doðum Tarihi: " + dogumTarihi);
																																														ciktiAkimi.println("Doðum Yeri (Ýl): " + dogumYeri);
																																														ciktiAkimi.println("*****KÝÞÝSEL BÝLGÝLERÝ*****");
																																														ciktiAkimi.println("Cinsiyet: " + cinsiyet);
																																														ciktiAkimi.println("Medeni Hal: " + medeniHal);
																																														ciktiAkimi.println("Eðitim Durumu: " + egitimDurumu);
																																														ciktiAkimi.println("Meslek: " + meslek);
																																														ciktiAkimi.println("Kan Baðýþý Geçmiþi: " + kanBagisiGecmisi);
																																														ciktiAkimi.println("*****ADRES VE DÝÐER ÝLETÝÞÝM BÝLGÝLERÝ*****");
																																														ciktiAkimi.println("Adres: " + adres);
																																														ciktiAkimi.println("Telefon Numarasý: " + telefonNumarasi);
																																														ciktiAkimi.println("E-posta Adresi: " + ePostaAdresi);
																																														ciktiAkimi.println("Kan Hizmetleri Hakkýnda Bilgilendirme: " + kanHizmetleriBilgilendirme);
																																														ciktiAkimi.println("Diðer Hizmetler Hakkýnda Bilgilendirme: " + digerBilgilendirme);
																																														ciktiAkimi.println("*****ÖLÇÜM DEÐERLERÝ*****");
																																														ciktiAkimi.println("Boy: " + boy);
																																														ciktiAkimi.println("Kilo: " + vucutAgirligi);
																																														ciktiAkimi.println("Vücut Sýcaklýðý: " + vucutSicakligi);
																																														ciktiAkimi.println("Tansiyon: " + tansiyon);
																																														ciktiAkimi.println("Kan Grubu: " + kanGrubu);
																																														ciktiAkimi.println("*****Sorgulama Formu Cevaplarý*****");
																																														for(int i = 0; i < sorgulamaFormuSorulariCevaplari.length; i++)
																																														{
																																															ciktiAkimi.print(i + ".Soru: "+ sorgulamaFormuSorulariCevaplari[i]);
																																															
																																															if(i % 5 == 0 && i != 0)
																																															{
																																																ciktiAkimi.println();
																																															}
																																															else
																																															{
																																																ciktiAkimi.print(" - ");
																																															}
																																														}
																																														ciktiAkimi.println();
																																														ciktiAkimi.println("*****Ek Form Cevaplarý*****");
																																														for(int i = 0; i < ekFormSorulariCevaplari.length; i++)
																																														{
																																															ciktiAkimi.print(i + ".Soru: "+ ekFormSorulariCevaplari[i]);
																																															
																																															if(i % 5 == 0 && i != 0)
																																															{
																																																ciktiAkimi.println();
																																															}
																																															else
																																															{
																																																ciktiAkimi.print(" - ");
																																															}
																																														}
																																														ciktiAkimi.println();
																																														ciktiAkimi.close();
																																														
																																														kanBagisListesi.add(kanGrubu);
																																														
																																														PrintWriter ciktiAkimi2 = null;
																																														String dosya2 = "Kan Baðýþ Listesi.txt";
																																														
																																														try
																																														{
																																															ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
																																														}
																																														catch(FileNotFoundException hata)
																																														{
																																															System.out.println();
																																															System.out.println("\'Kan Baðýþ Listesi.txt\' dosyasý oluþturulurken hata oldu.");
																																															System.exit(0);
																																														}
																																														
																																														for(int i = 0; i < kanBagisListesi.size(); i++)
																																														{
																																															ciktiAkimi2.println(kanBagisListesi.get(i));
																																														}
																																														ciktiAkimi2.close();
																																														
																																														System.out.println();
																																														System.out.println("Veriler \'Kan Baðýþý Kiþisel Veriler.txt\' ve \'Kan Baðýþ Listesi.txt\' dosyalarýna baþarýyla kaydedildi.");
																																														System.out.println();
																																														
																																														try
																																														{
																																															BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Ýhtiyaç Listesi.txt"));
																																															
																																															String satir = null;
																																															setSayac(0);
																																															satir = girisAkimi.readLine();
																																															
																																															while(satir != null)
																																															{
																																																setSayac(getSayac() + 1);
																																																kanIhtiyacListesi.add(satir.trim());
																																																satir = girisAkimi.readLine();
																																															}
																																															girisAkimi.close();
																																														}
																																														catch(FileNotFoundException e)
																																														{
																																															System.out.print("Kan Ýhtiyaç Listesi.txt dosyasý bulunamadý veya açýlamadý.");
																																														}
																																														catch(IOException e)
																																														{
																																															System.out.print("Kan Ýhtiyaç Listesi.txt dosyasýndan veri giriþinde hata oluþtu.");
																																														}
																																														
																																														PrintWriter ciktiAkimi5 = null;
																																														String dosya5 = "Kan Ýhtiyaç Listesi.txt";
																																														
																																														try
																																														{
																																															ciktiAkimi5 = new PrintWriter(new FileOutputStream(dosya5));
																																														}
																																														catch(FileNotFoundException hata)
																																														{
																																															System.out.println("\'Kan Ýhtiyaç Listesi.txt\' dosyasý oluþturulurken hata oldu.");
																																															System.exit(0);
																																														}
																																														
																																														for(int i = 0; i < kanIhtiyacListesi.size(); i++)
																																														{
																																															ciktiAkimi5.println(kanIhtiyacListesi.get(i));
																																														}
																																														ciktiAkimi5.close();
																																														
																																														kanKontrol(kanGrubu, kanBagisListesi, kanIhtiyacListesi);
																																														
																																														do
																																														{
																																															kontrolEkstra2 = true;
																																															
																																															System.out.println("Ne yapmak istiyorsunuz?");
																																															System.out.println("1: Kan Baðýþý Menüsüne Dön");
																																															System.out.println("2: Ana Menüye Dön");
																																															System.out.print("Seçiminiz: ");
																																															setSecim(klavye.nextInt());
																																															switch(getSecim())
																																															{
																																																case 1:
																																																	kontrol1 = false;
																																																	kontrol2 = false;
																																																	kontrol3 = false;
																																																	kontrol4 = false;
																																																	kontrol5 = false;
																																																	kontrol6 = false;
																																																	kontrol7 = false;
																																																	kontrol8 = false;
																																																	kontrol9 = false;
																																																	kontrol10 = false;
																																																	kontrol11 = false;
																																																	kontrolEkstra1 = false;
																																																	kontrolEkstra2 = false;
																																																	break;
																																																case 2:
																																																	setKontrol1(true);
																																																	kontrol = false;
																																																	kontrol1 = false;
																																																	kontrol2 = false;
																																																	kontrol3 = false;
																																																	kontrol4 = false;
																																																	kontrol5 = false;
																																																	kontrol6 = false;
																																																	kontrol7 = false;
																																																	kontrol8 = false;
																																																	kontrol9 = false;
																																																	kontrol10 = false;
																																																	kontrol11 = false;
																																																	kontrolEkstra1 = false;
																																																	kontrolEkstra2 = false;
																																																	break;
																																																default:
																																																	System.out.println();
																																																	System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																																	break;
																																															}
																																														}
																																														while(kontrolEkstra2);
																																														break;
																																													case 2:
																																														kontrol1 = false;
																																														kontrol2 = false;
																																														kontrol3 = false;
																																														kontrol4 = false;
																																														kontrol5 = false;
																																														kontrol6 = false;
																																														kontrol7 = false;
																																														kontrol8 = false;
																																														kontrol9 = false;
																																														kontrol10 = false;
																																														kontrol11 = false;
																																														kontrolEkstra1 = false;
																																														
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
																																											while(kontrolEkstra1);
																																											
																																											break;
																																										case 2:	
																																											kontrol1 = false;
																																											kontrol2 = false;
																																											kontrol3 = false;
																																											kontrol4 = false;
																																											kontrol5 = false;
																																											kontrol6 = false;
																																											kontrol7 = false;
																																											kontrol8 = false;
																																											kontrol9 = false;
																																											kontrol10 = false;
																																											kontrol11 = false;
																																											
																																											System.out.println();
																																											System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																																											break;
																																										default:
																																											System.out.println();
																																											System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																											break;
																																									}
																																								}
																																								while(kontrol11);
																																								
																																								break;
																																							case 2:
																																								kontrol1 = false;
																																								kontrol2 = false;
																																								kontrol3 = false;
																																								kontrol4 = false;
																																								kontrol5 = false;
																																								kontrol6 = false;
																																								kontrol7 = false;
																																								kontrol8 = false;
																																								kontrol9 = false;
																																								kontrol10 = false;
																																								
																																								System.out.println();
																																								System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																																								break;
																																							default:
																																								System.out.println();
																																								System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																								break;
																																						}
																																					}
																																					while(kontrol10);
																																				}
																																				else
																																				{
																																					kontrol1 = false;
																																					kontrol2 = false;
																																					kontrol3 = false;
																																					kontrol4 = false;
																																					kontrol5 = false;
																																					kontrol6 = false;
																																					kontrol7 = false;
																																					kontrol8 = false;
																																					kontrol9 = false;
																																					
																																					System.out.println();
																																					System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																																				}
																																				break;
																																			case 2:
																																				kontrol1 = false;
																																				kontrol2 = false;
																																				kontrol3 = false;
																																				kontrol4 = false;
																																				kontrol5 = false;
																																				kontrol6 = false;
																																				kontrol7 = false;
																																				kontrol8 = false;
																																				kontrol9 = false;
																																				
																																				System.out.println();
																																				System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																																				break;
																																			default:
																																				System.out.println();
																																				System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																				break;
																																		}
																																	}
																																	while(kontrol9);
																																	
																																	break;
																																case 2:
																																	kontrol1 = false;
																																	kontrol2 = false;
																																	kontrol3 = false;
																																	kontrol4 = false;
																																	kontrol5 = false;
																																	kontrol6 = false;
																																	kontrol7 = false;
																																	kontrol8 = false;
																																	
																																	System.out.println();
																																	System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																																	break;
																																default:
																																	System.out.println();
																																	System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																																	break;
																															}
																														}
																														while(kontrol8);
																													}
																													else
																													{
																														kontrol1 = false;
																														kontrol2 = false;
																														kontrol3 = false;
																														kontrol4 = false;
																														kontrol5 = false;
																														kontrol6 = false;
																														kontrol7 = false;
																														
																														System.out.println();
																														System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																													}
																													
																													break;
																												case 2:
																													kontrol1 = false;
																													kontrol2 = false;
																													kontrol3 = false;
																													kontrol4 = false;
																													kontrol5 = false;
																													kontrol6 = false;
																													kontrol7 = false;
						
																													System.out.println();
																													System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																													break;
																												default:
																													System.out.println();
																													System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																													break;
																											}
																										}
																										while(kontrol7);
																									}
																									else
																									{
																										kontrol1 = false;
																										kontrol2 = false;
																										kontrol3 = false;
																										kontrol4 = false;
																										kontrol5 = false;
																										kontrol6 = false;
																									}
																									break;
																								case 2:
																									kontrol1 = false;
																									kontrol2 = false;
																									kontrol3 = false;
																									kontrol4 = false;
																									kontrol5 = false;
																									kontrol6 = false;
					
																									System.out.println();
																									System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																									break;
																								default:
																									System.out.println();
																									System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																									break;
																							}
																						}
																						catch(Exception e)
																						{
																							System.out.println("HATA: " + e.getMessage());
																							System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
																							System.out.println();
																							duzeltme = klavye.nextLine();
																						}
																					}
																					while(kontrol6);
																					
																					break;
																				case 2:
																					kontrol1 = false;
																					kontrol2 = false;
																					kontrol3 = false;
																					kontrol4 = false;
																					kontrol5 = false;
				
																					System.out.println();
																					System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
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
																			duzeltme = klavye.nextLine();
																		}
																	}
																	while(kontrol5);
																	
																	break;
																case 2:
																	kontrol1 = false;
																	kontrol2 = false;
																	kontrol3 = false;
																	kontrol4 = false;
			
																	System.out.println();
																	System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
																	break;
																default:
																	System.out.println();
																	System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
																	break;
															}
														}
														catch(Exception e)
														{
															System.out.println("HATA: " + e.getMessage());
															System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
															System.out.println();
															duzeltme = klavye.nextLine();
														}
													}
													while(kontrol4);
													
													break;
												case 2:
													kontrol1 = false;
													kontrol2 = false;
													kontrol3 = false;
		
													System.out.println();
													System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
													break;
												default:
													System.out.println();
													System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
													break;
											}
										}
										catch(Exception e)
										{
											System.out.println("HATA: " + e.getMessage());
											System.out.println("Yanlýþ deðer girdiniz! Lütfen bir sayý deðeri giriniz.");
											System.out.println();
											duzeltme = klavye.nextLine();
										}	
									}
									while(kontrol3);
									
									break;
								case 2:
									kontrol1 = false;
									kontrol2 = false;
									System.out.println();
									System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
									break;
								default:
									System.out.println();
									System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
									break;
							}
						}
						while(kontrol2);
					}
					break;
				case 2:
					kontrol1 = false;
					
					System.out.println();
					System.out.println("Kayýt formu sonlandýrýlýyor... Maalesef kayýt baþarýsýz oldu.");
					break;
				default:
					System.out.println();
					System.out.println("Yanlýþ bir seçim yaptýnýz. Lütfen tekrar deneyiniz...");
					break;
			}
		}
		while(kontrol1);
	}
	
	public void sorgulamaFormuSorulari()
	{
		sorgulamaFormuSorulariListesi.add("\"Kan Baðýþçýsý Bilgilendirilmiþ Onam Formu\"nu okuyup anladýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Kendinizi saðlýklý ve iyi hissediyor musunuz?");
		sorgulamaFormuSorulariListesi.add("Tehlikeli bir iþte (aðýr iþ makinesi operatörlüðü, tren makinistliði, daðcýlýk, dalgýçlýk, paraþütçülük, iþleri gereði portatif merdiven veya þantiye iskelesine týrmanmak zorunda kalan kiþiler vb.) mi çalýþýyorsunuz?");
		sorgulamaFormuSorulariListesi.add("Daha önce yaptýðýnýz bir kan baðýþý müracaatý herhangi bir nedenle geri çevrildi mi?");
		sorgulamaFormuSorulariListesi.add("Prostat büyümesi, sivilce, sedef hastalýðý veya kellik için herhangi bir ilaç kullanýyor musunuz?");
		sorgulamaFormuSorulariListesi.add("Herhangi bir enfeksiyon hastalýðý için ilaç (antibiyotik, ateþ düþürücü vb.) aldýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Son 5 gün içinde aspirin, herhangi bir aðrý kesici veya romatizma ilacý aldýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Alerjik reaksiyon geçirdiniz mi, buna yönelik tedavi aldýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Yukarýda belirtilenler dýþýnda baþka bir ilaç kullanýyor musunuz?");
		sorgulamaFormuSorulariListesi.add("Son 1 hafta içinde ishal (diyare) oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 1 ay içinde herhangi bir aþý oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde diþ tedavisi oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Kronik (müzmin) bir hastalýðýnýz var mý?");
		sorgulamaFormuSorulariListesi.add("Para veya uyuþturucu karþýlýðýnda cinsel iliþkiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Frengi (sifiliz) veya bel soðukluðu (gonore) nedeni ile tedavi oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("AIDS hastalýðýnýz var mý, kendinize böyle bir hastalýk olduðuna dair bir þüpheniz var mý?");
		sorgulamaFormuSorulariListesi.add("AIDS hastasý olduðunu bildiðiniz biriyle cinsel iliþkiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Kan ve kan ürünü alan, diyalize giren veya hemofili hastasý biri ile cinsel iliþkiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Hiç uyuþturucu kullandýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Ýnsülin, büyüme hormonu, immünglobulin (gamaglobulin), tamoksifen kullandýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde ameliyat veya endoskopik muayene oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Kalp-damar, akciðer, mide-barsak, böbrek hastalýðýnýz var mý?");
		sorgulamaFormuSorulariListesi.add("Bugüne kadar hiç nöbet, sara (epilepsi) krizi veya felç geçirdiniz mi?");
		sorgulamaFormuSorulariListesi.add("Bugüne kadar hiç kanser tanýsý aldýnýz mý, kanser tedavisi gördünüz mü?");
		sorgulamaFormuSorulariListesi.add("Þeker hastalýðýnýz ya da yaygýn romatizmal bir hastalýðýnýz var mý?");
		sorgulamaFormuSorulariListesi.add("Kanamalý bir hastalýk veya kan hastalýðýnýz var mý?");
		sorgulamaFormuSorulariListesi.add("Sýtma (malarya), verem (tüberküloz), malta hummasý (peynir hastalýðý, brucella), kemik iltihabý (osteomyelit) veya Karahumma (kala-azar) geçirdiniz mi?");
		sorgulamaFormuSorulariListesi.add("Hepatit (sarýlýk hastalýðý) geçirdiniz mi, taþýyýcýsý mýsýnýz?");
		sorgulamaFormuSorulariListesi.add("Hepatit (sarýlýk hastalýðý) olan biri ile ayný evde yaþýyor musunuz veya cinsel iliþkiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Toksoplazma geçirdiniz mi? ( Toksoplazma Kedilerden bulaþan bir parazit türüdür.)");
		sorgulamaFormuSorulariListesi.add("Kamerun, Orta Afrika, Çad, Kongo, Ekvatoryal Gine, Gabon, Nijer yada Nijerya'da hiç bulundunuz mu?");
		sorgulamaFormuSorulariListesi.add("1980-1996 yýllarý arasýnda Ýngiltere, Kuzey Ýrlanda, Galler ya da Ýskoçya’da bulundunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 3 yýl içinde yukarýdaki ülkeler dýþýnda baþka ülkelerde bulundunuz mu?");
		sorgulamaFormuSorulariListesi.add("Ailenizde Deli Dana Hastalýðý (Creutzfeldt-Jakob) olan birisi oldu mu?");
		sorgulamaFormuSorulariListesi.add("Size Dura mater (beyin zarý) veya kornea nakli yapýldý mý?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde size kan, doku veya organ nakli yapýldý mý?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde bir baþkasýnýn kaný ile temasýnýz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde akupunktur, botoks, taký için cilt deldirme, saç ekimi veya estetik müdahaleler yaptýrdýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde dövme, hacamat yaptýrdýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde hayvan ýsýrýðý nedeni ile kuduz aþýsý oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay içinde üç günden fazla tutuklu kaldýnýz mý veya üç günden fazla tutuklu kalan birisiyle cinsel iliþkiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Erkekler için: Son 3 ay içinde kan baðýþý yaptýnýz mý?\nKadýnlar için: Son 4 ay içinde kan baðýþý yaptýnýz mý?");
		sorgulamaFormuSorulariListesi.add("Erkekler için: Bugüne dek hiç erkek erkeðe cinsel iliþkide bulundunuz mu?" + "\nKadýnlar için: Son 12 ayda hamilelik geçirdiniz mi veya düþük yaptýnýz mý? Þu an hamile misiniz?");
	}
	
	public void ekFormSorulari()
	{
		ekFormSorulariListesi.add("Son 28 gün içerisinde COVID-19 hastalýðý tanýsý aldýnýz mý?");
		ekFormSorulariListesi.add("Son 28 gün içerisinde klinik bir belirtiniz (ateþ, öksürük, solunum sýkýntýsý, boðaz aðrýsý vb.) oldu mu?");
		ekFormSorulariListesi.add("Son 28 gün içerisinde COVID-19 hastalýðý tanýsý almýþ (kesin vaka) veya COVID-19 hastalýðý þüphesi olan (olasý vaka) biriyle maskesiz veya aðzý ve burnu kapayacak þekilde kuralýna uygun maske takmayarak 2 metreden daha yakýn mesafede, tek seferde 10 dakikadan uzun süreyle, ayný ortamda (ev/ofis/oda vb.) bulundunuz mu?");
		ekFormSorulariListesi.add("Son 28 gün içerisinde yurt dýþý seyahatiniz oldu mu?");
		ekFormSorulariListesi.add("Son 28 gün içerisinde yurt dýþýndan dönen biriyle maskesiz veya aðzý ve burnu kapayacak þekilde kuralýna uygun maske takmayarak 2 metreden daha yakýn mesafede, tek seferde 10 dakikadan uzun süreyle, ayný ortamda (ev/ofis/oda vb.) bulundunuz mu?");
	}
	
	public int getSayac()
	{
		return sayac;
	}

	public void setSayac(int sayac)
	{
		this.sayac = sayac;
	}
	
	public boolean getKontrol()
	{
		return kontrol;
	}

	public void setKontrol(boolean kontrol)
	{
		this.kontrol = kontrol;
	}

	public boolean getKontrolEkstra1()
	{
		return kontrolEkstra1;
	}

	public void setKontrolEkstra1(boolean kontrolEkstra1)
	{
		this.kontrolEkstra1 = kontrolEkstra1;
	}
	
	public boolean getKontrolEkstra2()
	{
		return kontrolEkstra2;
	}

	public void setKontrolEkstra2(boolean kontrolEkstra2)
	{
		this.kontrolEkstra2 = kontrolEkstra2;
	}
	
	public boolean getKontrolEkstra3()
	{
		return kontrolEkstra3;
	}

	public void setKontrolEkstra3(boolean kontrolEkstra3)
	{
		this.kontrolEkstra3 = kontrolEkstra3;
	}
	
	public String getDuzeltme()
	{
		return duzeltme;
	}

	public void setDuzeltme(String duzeltme)
	{
		this.duzeltme = duzeltme;
	}

	public int getGun1()
	{
		return gun1;
	}

	public void setGun1(int gun1)
	{
		this.gun1 = gun1;
	}

	public int getGun2()
	{
		return gun2;
	}

	public void setGun2(int gun2)
	{
		this.gun2 = gun2;
	}
	
	public int getAy1()
	{
		return ay1;
	}

	public void setAy1(int ay1)
	{
		this.ay1 = ay1;
	}

	public int getAy2()
	{
		return ay2;
	}

	public void setAy2(int ay2)
	{
		this.ay2 = ay2;
	}
	
	public int getYil1()
	{
		return yil1;
	}

	public void setYil1(int yil1)
	{
		this.yil1 = yil1;
	}
	
	public int getYil2()
	{
		return yil2;
	}

	public void setYil2(int yil2)
	{
		this.yil2 = yil2;
	}

	public String getTarih()
	{
		return tarih;
	}

	public void setTarih(String tarih)
	{
		this.tarih = tarih;
	}

	public String getTCKimlikNo()
	{
		return TCKimlikNo;
	}

	public void setTCKimlikNo(String tCKimlikNo)
	{
		TCKimlikNo = tCKimlikNo;
	}

	public String getAdSoyad()
	{
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad)
	{
		this.adSoyad = adSoyad;
	}

	public String getBabaAdi()
	{
		return babaAdi;
	}

	public void setBabaAdi(String babaAdi)
	{
		this.babaAdi = babaAdi;
	}

	public String getDogumTarihi()
	{
		return dogumTarihi;
	}

	public void setDogumTarihi(String dogumTarihi)
	{
		this.dogumTarihi = dogumTarihi;
	}

	public String getDogumYeri()
	{
		return dogumYeri;
	}

	public void setDogumYeri(String dogumYeri)
	{
		this.dogumYeri = dogumYeri;
	}
	
	public String getKanGrubu()
	{
		return kanGrubu;
	}

	public void setKanGrubu(String kanGrubu)
	{
		this.kanGrubu = kanGrubu;
	}
}