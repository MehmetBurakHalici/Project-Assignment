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
		System.out.println("\t\t\t\t\t\t\t    KAN BA�I� S�STEM�");
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
				System.out.println("1: Yeni Kay�t Formu Doldur");
				System.out.println("2: Ana Men�ye Geri D�n");
				System.out.print("Se�iminiz: ");
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
						System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
						System.out.println();
						break;
				}
			}
			catch(Exception e)
			{
				System.out.println("HATA: " + e.getMessage());
				System.out.println();
				System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
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
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan Ba��� Listesi.txt"));
			
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
			//System.out.print("Kan Ba��� Listesi.txt dosyas� bulunamad� veya a��lamad�.");
		}
		catch(IOException e)
		{
			System.out.print("Kan Ba��� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
		}
		
		PrintWriter ciktiAkimi3 = null;
		String dosya3 = "Kan Ba��� Listesi.txt";
		
		try
		{
			ciktiAkimi3 = new PrintWriter(new FileOutputStream(dosya3));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println("\'Kan Ba��� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
			System.exit(0);
		}
		ciktiAkimi3.close();
		
		for(int i = 0; i < kanBagisListesi.size(); i++)
		{
			ciktiAkimi3.println(kanBagisListesi.get(i));
		}
		
		try
		{
			BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan �htiya� Listesi.txt"));
			
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
			//System.out.print("Kan �htiya� Listesi.txt dosyas� bulunamad� veya a��lamad�.");
		}
		catch(IOException e)
		{
			System.out.print("Kan �htiya� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
		}
		
		PrintWriter ciktiAkimi4 = null;
		String dosya4 = "Kan �htiya� Listesi.txt";
		
		try
		{
			ciktiAkimi4 = new PrintWriter(new FileOutputStream(dosya4));
		}
		catch(FileNotFoundException hata)
		{
			System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
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
		System.out.print("*****BUG�N�N TAR�H�*****");
		System.out.println();
		do
		{	
			try
			{
				kontrolEkstra1 = true;
				kontrolEkstra2 = true;
				kontrolEkstra3 = true;
				
				System.out.print("G�n : ");
				gun1 = klavye.nextInt();
				if(gun1 < 0 || gun1 > 31)
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
						ay1 = klavye.nextInt();
						if(ay1 < 0 || ay1 > 12)
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
								yil1 = klavye.nextInt();
								if(yil1 < 0)
								{
									System.out.println();
									System.out.println("Y�l de�eri 0'dan k���k olamaz. L�tfen tekrar deneyiniz...");
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
				System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
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
			System.out.println("\"Kimlik Bilgileri\" sorular�na ge�ilsin mi?");
			System.out.println("1: Evet");
			System.out.println("2: Hay�r");
			System.out.print("Se�iminiz: ");
			setSecim(klavye.nextInt());
			switch(getSecim())
			{
				case 1:
					System.out.println();
					System.out.print("*****KAN BA�I��ISI ADAYININ K�ML�K B�LG�LER�*****");
					System.out.println();
				
					duzeltme = klavye.nextLine();
					
					System.out.print("T.C. Kimlik Numaran�z : ");
					TCKimlikNo = klavye.nextLine();
					
					System.out.print("Ad�n�z Soyad�n�z : ");
					adSoyad = klavye.nextLine();
					
					System.out.print("Baba Ad�n�z : ");
					babaAdi = klavye.nextLine();
					
					System.out.println("Do�um Tarihiniz");
					
					do
					{	
						kontrolEkstra1 = true;
						kontrolEkstra2 = true;
						kontrolEkstra3 = true;
						
						System.out.print("G�n : ");
						gun2 = klavye.nextInt();
						if(gun2 < 0 || gun2 > 31)
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
								ay2 = klavye.nextInt();
								if(ay2 < 0 || ay2 > 12)
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
										yil2 = klavye.nextInt();
										if(yil2 < 0)
										{
											System.out.println();
											System.out.println("Y�l de�eri 0'dan k���k olamaz. L�tfen tekrar deneyiniz...");
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
								System.out.print("Do�um Yeriniz (�l) : ");
								dogumYeri = klavye.nextLine();
							}
						}
						else
						{
							duzeltme = klavye.nextLine();
							
							System.out.print("Do�um Yeriniz (�l) : ");
							dogumYeri = klavye.nextLine();
						}
					}
					else
					{
						duzeltme = klavye.nextLine();
						
						System.out.print("Do�um Yeriniz (�l) : ");
						dogumYeri = klavye.nextLine();
					}
					
					if(kontrolEkstra1 == true)
					{
						do
						{
							System.out.println();
							System.out.println("\"Ki�isel Bilgiler\" sorular�na ge�ilsin mi?");
							System.out.println("1: Evet");
							System.out.println("2: Hay�r");
							System.out.print("Se�iminiz: ");
							setSecim(klavye.nextInt());
							switch(getSecim())
							{
								case 1:
									System.out.println();
									System.out.print("*****KAN BA�I��ISI ADAYININ K���SEL B�LG�LER�*****");
									System.out.println(); 
									
									do
									{
										try
										{
											System.out.println("Cinsiyetiniz");
											System.out.println("1: Erkek");
											System.out.println("2: Kad�n");
											System.out.print("Cevab�n�z: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													kontrolEkstra1 = false;
													cinsiyet = "Erkek";
													break;
												case 2:
													kontrolEkstra1 = false;
													cinsiyet = "Kad�n";
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
											System.out.print("Cevab�n�z: ");
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
											duzeltme = klavye.nextLine();
										}
									}
									while(kontrolEkstra1);
									
									do
									{
										try
										{
											kontrolEkstra1 = true;
											
											System.out.println("E�itim Durumunuz");
											System.out.println("1: Yok");
											System.out.println("2: �lkokul");
											System.out.println("3: Ortaokul");
											System.out.println("4: Lise");
											System.out.println("5: �nlisans");
											System.out.println("6: Lisans");
											System.out.println("7: Y�ksek Lisans");
											System.out.println("8: Doktora");
											System.out.print("Cevab�n�z: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													kontrolEkstra1 = false;
													egitimDurumu = "Yok";
													break;
												case 2:
													kontrolEkstra1 = false;
													egitimDurumu = "�lkokul";
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
													egitimDurumu = "�nlisans";
													break;
												case 6:
													kontrolEkstra1 = false;
													egitimDurumu = "Lisans";
													break;
												case 7:
													kontrolEkstra1 = false;
													egitimDurumu = "Y�ksek Lisans";
													break;
												case 8:
													kontrolEkstra1 = false;
													egitimDurumu = "Doktora";
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
											duzeltme = klavye.nextLine();
										}
									}
									while(kontrolEkstra1);
									
									duzeltme = klavye.nextLine();
									
									System.out.print("Mesle�iniz : ");
									meslek = klavye.nextLine();
									
									do
									{
										try
										{
											kontrolEkstra1 = true;
											
											System.out.println("Kan Ba���� Ge�mi�iniz");
											System.out.println("1: Hayat�mda �lk Kez Kan Ba���l�yorum.");
											System.out.println("2: Daha �nce Kan Ba���� Yapt�m.");
											System.out.print("Cevab�n�z: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													kontrolEkstra1 = false;
													kanBagisiGecmisi = "Hayat�mda �lk Kez Kan Ba���l�yorum.";
													break;
												case 2:
													kontrolEkstra1 = false;
													kanBagisiGecmisi = "Daha �nce Kan Ba���� Yapt�m.";
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
											duzeltme = klavye.nextLine();
										}
									}
									while(kontrolEkstra1);
									
									do
									{
										try
										{
											System.out.println();
											System.out.println("\"Adres ve Di�er �leti�im Bilgileri\" sorular�na ge�ilsin mi?");
											System.out.println("1: Evet");
											System.out.println("2: Hay�r");
											System.out.print("Se�iminiz: ");
											setSecim(klavye.nextInt());
											switch(getSecim())
											{
												case 1:
													System.out.println();
													System.out.print("*****KAN BA�I��ISI ADAYININ ADRES VE D��ER �LET���M B�LG�LER�*****");
													System.out.println(); 
													
													duzeltme = klavye.nextLine();
													
													System.out.print("Adresiniz : ");
													adres = klavye.nextLine();
													
													System.out.print("Telefon Numaran�z : ");
													telefonNumarasi = klavye.nextLine();
													
													System.out.print("E-posta Adresiniz : ");
													ePostaAdresi = klavye.nextLine();
													
													do
													{
														try
														{
															System.out.println();
															System.out.println("\"Bilgilendirme\" sorular�na ge�ilsin mi?");
															System.out.println("1: Evet");
															System.out.println("2: Hay�r");
															System.out.print("Se�iminiz: ");
															setSecim(klavye.nextInt());
															switch(getSecim())
															{
																case 1:
																	kontrolEkstra1 = true;
																	System.out.println();
																	System.out.println("*****FAAL�YETLER�M�Z HAKKINDA B�LG�LEND�R�LME*****");
																	do
																	{
																		try
																		{
																			System.out.println("T�rk K�z�lay�n�n kan hizmetleri hakk�nda bilgilendirilmek istiyor musunuz?");
																			System.out.println("1: Evet (Sadece \"SMS\" ile)");
																			System.out.println("2: Evet (Sadece \"Telefon\" ile)");
																			System.out.println("3: Evet (Sadece \"E-posta\" ile)");
																			System.out.println("4: Evet (\"SMS\" ve \"Telefon\" ile)");
																			System.out.println("5: Evet (\"SMS\" ve \"E-posta\" ile)");
																			System.out.println("6: Evet (\"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("7: Evet (\"SMS\", \"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("8: Hay�r, istemiyorum.");
																			System.out.print("Cevab�n�z: ");
																			setSecim(klavye.nextInt());
																			switch(getSecim())
																			{
																				case 1:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Sadece \"SMS\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda \"SMS\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 2:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Sadece \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 3:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Sadece \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 4:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"SMS\" ve \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda \"SMS\" ve \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 5:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"SMS\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda \"SMS\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 6:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 7:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "\"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda \"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 8:
																					kontrolEkstra1 = false;
																					kanHizmetleriBilgilendirme = "Bilgilendirme Yok";
																					System.out.println();
																					System.out.println("Kan hizmetleri hakk�nda herhangi bir bilgilendirme almayacaks�n�z.");
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
																			duzeltme = klavye.nextLine();
																		}
																	}
																	while(kontrolEkstra1);
																	kontrolEkstra1 = true;
																	do
																	{
																		try
																		{
																			System.out.println("T�rk K�z�lay�n�n di�er faaliyet alanlar� hakk�nda bilgilendirilmek istiyor musunuz?");
																			System.out.println("1: Evet (Sadece \"SMS\" ile)");
																			System.out.println("2: Evet (Sadece \"Telefon\" ile)");
																			System.out.println("3: Evet (Sadece \"E-posta\" ile)");
																			System.out.println("4: Evet (\"SMS\" ve \"Telefon\" ile)");
																			System.out.println("5: Evet (\"SMS\" ve \"E-posta\" ile");
																			System.out.println("6: Evet (\"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("7: Evet (\"SMS\", \"Telefon\" ve \"E-posta\" ile)");
																			System.out.println("8: Hay�r, istemiyorum.");
																			System.out.print("Cevab�n�z: ");
																			setSecim(klavye.nextInt());
																			switch(getSecim())
																			{
																				case 1:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Sadece \"SMS\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda \"SMS\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 2:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Sadece \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 3:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Sadece \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 4:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"SMS\" ve \"Telefon\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda \"SMS\" ve \"Telefon\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 5:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"SMS\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda \"SMS\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 6:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 7:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "\"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirme";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda \"SMS\", \"Telefon\" ve \"E-posta\" ile bilgilendirileceksiniz.");
																					System.out.println();
																					break;
																				case 8:
																					kontrolEkstra1 = false;
																					digerBilgilendirme = "Bilgilendirme Yok";
																					System.out.println();
																					System.out.println("Di�er faaliyet alanlar� hakk�nda herhangi bir bilgilendirme almayacaks�n�z.");
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
																			duzeltme = klavye.nextLine();
																		}
																	}
																	while(kontrolEkstra1);
																	
																	do
																	{
																		try
																		{
																			System.out.println("Yukar�da belirtmi� oldu�unuz kimlik, ileti�im ve di�er bilgilerin do�ru oldu�unu beyan ediyor musunuz?");
																			System.out.println("1: Evet, beyan ediyorum.");
																			System.out.println("2: Hay�r, beyan etmiyorum.");
																			System.out.print("Cevab�n�z: ");
																			setSecim(klavye.nextInt());
																			switch(getSecim())
																			{
																				case 1:
																					System.out.println();
																					System.out.println("Beyan�n�z sistem taraf�ndan kabul edilmi�tir.");
																					
																					do
																					{
																						try
																						{
																							kontrolEkstra1 = true;
																							
																							System.out.println();
																							System.out.println("\"�l��m ve �nceleme De�erleri\" k�sm�na ge�ilsin mi?");
																							System.out.println("1: Evet");
																							System.out.println("2: Hay�r");
																							System.out.print("Se�iminiz: ");
																							setSecim(klavye.nextInt());
																							switch(getSecim())
																							{
																								case 1:
																									System.out.println();
																									System.out.print("*****KAN BA�I��ISI ADAYININ �L��M VE �NCELEME DE�ERLER�*****");
																									System.out.println();
																								
																									duzeltme = klavye.nextLine();
																									
																									System.out.println("Boy �l��m� yap�l�yor...");
																									System.out.println();
																									System.out.print("�l��m Sonucu Boy = ");
																									boy = klavye.nextLine();
																									
																									System.out.println();
																									System.out.println("V�cut a��rl��� hesaplan�yor...");
																									System.out.println();
																									System.out.print("Hesaplama Sonucu V�cut A��rl��� = ");
																									vucutAgirligi = klavye.nextInt();
																									if(vucutAgirligi < 50)
																									{
																										kontrolEkstra1 = false;
																										System.out.println();
																										System.out.println("Kilosu 50'den az olan bireyler kan ba����nda bulunamazlar.");
																										System.out.println("Kay�t formu sonland�r�l�yor...");
																									}
																									else
																									{
																										System.out.println();
																										System.out.println("V�cut s�cakl��� �l��l�yor...");
																										System.out.println();
																										System.out.print("�l��len V�cut S�cakl��� = ");
																										vucutSicakligi = klavye.nextInt();
																										if(vucutSicakligi <=35 || vucutSicakligi >= 39)
																										{
																											kontrolEkstra1 = false;
																											System.out.println();
																											System.out.println("V�cut s�cakl���n�z normal de�erlerin d���nda oldu�u i�in �u anda kan ba����nda bulunamazs�n�z.");
																											System.out.println("Kay�t formu sonland�r�l�yor...");
																										}
																										else
																										{
																											System.out.println();
																											System.out.println("Tansiyon �l��l�yor...");
																											System.out.println();
																											System.out.println("�l��len Sonuca G�re");
																											System.out.print("K���k Tansiyon De�eri = ");
																											kucukTansiyon = klavye.nextInt();
																											System.out.print("B�y�k Tansiyon De�eri = ");
																											buyukTansiyon = klavye.nextInt();
																											
																											tansiyon = kucukTansiyon + "/" + buyukTansiyon;
																											
																											if(kucukTansiyon < 70 || kucukTansiyon > 90 || buyukTansiyon < 120 || buyukTansiyon > 130)
																											{
																												kontrolEkstra1 = false;
																												System.out.println();
																												System.out.println("Tansiyonunuz normal de�erlerin d���nda oldu�u i�in �u anda kan ba����nda bulunamazs�n�z.");
																												System.out.println("Kay�t formu sonland�r�l�yor...");
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
																														System.out.print("�nceleme Sonucu: ");
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
																																System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
																																System.out.println();
																																break;
																														}
																													}
																													catch(Exception e)
																													{
																														System.out.println("HATA: " + e.getMessage());
																														System.out.println();
																														System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
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
																											System.out.println("\"Sorgulama Formu\" sorular�na ge�ilsin mi?");
																											System.out.println("1: Evet");
																											System.out.println("2: Hay�r");
																											System.out.print("Se�iminiz: ");
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
																																System.out.println("2: Hay�r");
																																System.out.print("Cevab�n�z: ");
																																setSecim(klavye.nextInt());
																																switch(getSecim())
																																{
																																	case 1:
																																		kontrolEkstra1 = false;
																																		sorgulamaFormuSorulariCevaplari[i] = "Evet";
																																		break;
																																	case 2:
																																		sorgulamaFormuSorulariCevaplari[i] = "Hay�r";
																																		System.out.println();
																																		System.out.println("Durum inceleniyor...");
																																		System.out.println();
																																		do
																																		{	
																																			System.out.println("Forma devam edilsin mi?");
																																			System.out.println("1: Evet, kan vermeye uygun.");
																																			System.out.println("2: Hay�r, kan vermeye uygun de�il.");
																																			System.out.print("Se�iminiz: ");
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
																																					System.out.println("�u anda kan vermek i�in uygun ko�ullarda de�ilsiniz.");
																																					System.out.println("Uygun ko�ullar sa�land�ktan sonra kan merkezimize tekrardan m�racaat edebilirsiniz.");
																																					System.out.print("�yi g�nler dileriz...");
																																					break;
																																				default:
																																					System.out.println();
																																					System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
																																					System.out.println();
																																					break;
																																			}
																																		}
																																		while(kontrolEkstra2);
																																		break;
																																	default:
																																		System.out.println();
																																		System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																System.out.println("2: Hay�r");
																																System.out.print("Cevab�n�z: ");
																																setSecim(klavye.nextInt());
																																switch(getSecim())
																																{
																																	case 1:
																																		kontrolEkstra1 = false;
																																		kontrol8 = false;
																																		sorgulamaFormuSorulariCevaplari[i] = "Evet";
																																		i = 1000;
																																		
																																		System.out.println();
																																		System.out.println("�zg�n�z, bu durumda kan ba���� yapamazs�n�z.");
																																		System.out.println("Mevcut durum ortadan kalkabilecek bir �ey ise sonras�nda kan merkezimize tekrardan m�racaat edebilirsiniz.");
																																		System.out.println("�yi g�nler dileriz...");
																																		break;
																																	case 2:
																																		kontrolEkstra1 = false;
																																		sorgulamaFormuSorulariCevaplari[i] = "Hay�r";
																																		break;
																																	default:
																																		System.out.println();
																																		System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																System.out.println("2: Hay�r");
																																System.out.print("Cevab�n�z: ");
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
																																			System.out.println("2: Hay�r, kan vermeye uygun de�il.");
																																			System.out.print("Se�iminiz: ");
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
																																					System.out.println("�u anda kan vermek i�in uygun ko�ullarda de�ilsiniz.");
																																					System.out.println("Uygun ko�ullar sa�land�ktan sonra kan merkezimize tekrardan m�racaat edebilirsiniz.");
																																					System.out.println("�yi g�nler dileriz...");
																																					break;
																																				default:
																																					System.out.println();
																																					System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
																																					System.out.println();
																																					break;
																																			}
																																		}
																																		while(kontrolEkstra2);
																																		
																																		break;
																																	case 2:
																																		sorgulamaFormuSorulariCevaplari[i] = "Hay�r";
																																		kontrolEkstra1 = false;
																																		break;
																																	default:
																																		System.out.println();
																																		System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																															System.out.println("\"Sorgulama Formu'ndaki sorular� dikkatlice okudum ve anlad�m.");
																															System.out.println("Verilen bilgiler do�rultusunda kan�m� g�n�ll� ve kar��l�ks�z olarak ba���lamay�");
																															System.out.println("ve tarama testleri yap�ld�ktan sonra gereksinimi olan herhangi bir hasta i�in ve/veya di�er t�bbi ama�lar i�in kullan�lmas�n�,");
																															System.out.println("tarama testerinden herhangi birinin pozitif ��kmas� halinde taraf�ma bildirilmesini kabul ediyorum.\"");
																															System.out.println("Yukar�daki beyan� onayl�yor musunuz?");
																															System.out.println("1: Evet, onayl�yorum.");
																															System.out.println("2: Hay�r, onaylam�yorum.");
																															System.out.print("Cevab�n�z: ");
																															setSecim(klavye.nextInt());
																															switch(getSecim())
																															{
																																case 1:
																																	System.out.println();
																																	System.out.println("Beyan�n�z sistem taraf�ndan onaylanm��t�r.");
																																	
																																	do
																																	{
																																		kontrolEkstra1 = true;
																																		kontrolEkstra2 = true;
																																		setKontrolEkstra3(
																																				true);	
																																		
																																		System.out.println();
																																		System.out.println("\"Ek Form\" sorular�na ge�ilsin mi?");
																																		System.out.println("1: Evet");
																																		System.out.println("2: Hay�r");
																																		System.out.print("Se�iminiz: ");
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
																																							System.out.println("2: Hay�r");
																																							System.out.print("Cevab�n�z: ");
																																							setSecim(klavye.nextInt());
																																							switch(getSecim())
																																							{
																																								case 1:
																																									ekFormSorulariCevaplari[i] = "Evet";
																																									System.out.println();
																																									System.out.println("Son 28 g�n i�erisinde COVID-19 tan�s� alm�� bir kimsenin kan ba����nda bulunabilmesi i�in �u anda negatif oldu�unu g�steren en fazla 3 g�n �ncesine ait PCR testi sonucu ile kan ba����na m�racaat etmesi gereklidir.");
																																									
																																									do
																																									{
																																										System.out.println("En �ok 3 g�n �ncesine ait PCR testiniz var m�?");
																																										System.out.println("1: Evet, var.");
																																										System.out.println("2: Hay�r, yok.");
																																										System.out.print("Cevab�n�z: ");
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
																																													System.out.println("2: Hay�r, kan vermeye yine de uygun de�il.");
																																													System.out.print("Se�iminiz: ");
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
																																															System.out.println("�u anda kan vermek i�in uygun ko�ullarda de�ilsiniz.");
																																															System.out.println("Uygun ko�ullar sa�land�ktan sonra kan merkezimize tekrardan m�racaat edebilirsiniz.");
																																															System.out.println("�yi g�nler dileriz...");
																																															break;
																																														default:
																																															System.out.println();
																																															System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																												System.out.println("�u anda kan vermek i�in uygun ko�ullarda de�ilsiniz.");
																																												System.out.println("En fazla 3 g�n �ncesine ait negatif PCR testi ile kan merkezimize tekrardan m�racaat edebilirsiniz.");
																																												System.out.println("�yi g�nler dileriz...");
																																												break;
																																											default:
																																												System.out.println();
																																												System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
																																												System.out.println();
																																												break;
																																										}
																																									}
																																									while(kontrolEkstra2);
																																									
																																									break;
																																								case 2:
																																									ekFormSorulariCevaplari[i] = "Hay�r";
																																									kontrolEkstra1 = false;
																																									break;
																																								default:
																																									System.out.println();
																																									System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																							System.out.println("2: Hay�r");
																																							System.out.print("Cevab�n�z: ");
																																							setSecim(klavye.nextInt());
																																							switch(getSecim())
																																							{
																																								case 1:
																																									ekFormSorulariCevaplari[i] = "Evet";
																																									System.out.println();
																																									System.out.println("COVID-19 olma riski ta��yan bir kimsenin kan ba����nda bulunabilmesi i�in �u anda negatif oldu�unu g�steren en fazla 3 g�n �ncesine ait PCR testi sonucu ile kan ba����na m�racaat etmesi gereklidir.");
																																									do
																																									{
																																										System.out.println("En fazla 3 g�n �ncesine ait PCR testiniz var m�?");
																																										System.out.println("1: Evet, var.");
																																										System.out.println("2: Hay�r, yok.");
																																										System.out.print("Cevab�n�z: ");
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
																																													System.out.println("2: Hay�r, kan vermeye yine de uygun de�il.");
																																													System.out.print("Se�iminiz: ");
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
																																															System.out.println("�u anda kan vermek i�in uygun ko�ullarda de�ilsiniz.");
																																															System.out.println("Uygun ko�ullar sa�land�ktan sonra kan merkezimize tekrardan m�racaat edebilirsiniz.");
																																															System.out.println("�yi g�nler dileriz...");
																																															break;
																																														default:
																																															System.out.println();
																																															System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																												System.out.println("�u anda kan vermek i�in uygun ko�ullarda de�ilsiniz.");
																																												System.out.println("En fazla 3 g�n �ncesine ait negatif PCR testi ile kan merkezimize tekrardan m�racaat edebilirsiniz.");
																																												System.out.println("�yi g�nler dileriz...");
																																												break;
																																											default:
																																												System.out.println();
																																												System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
																																												System.out.println();
																																												break;
																																										}
																																									}
																																									while(kontrolEkstra2);
																																									
																																									break;
																																								case 2:
																																									ekFormSorulariCevaplari[i] = "Hay�r";
																																									kontrolEkstra1 = false;
																																									break;
																																								default:
																																									System.out.println();
																																									System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																						System.out.println("Yukar�da vermi� oldu�unuz bilgilerin do�rulu�u kabul ediyor ve");
																																						System.out.println("payla�m�� oldu�unuz sa�l�k verilerinin K�z�lay taraf�ndan i�lenmesine onay veriyor musunuz?");
																																						System.out.println("1: Evet, onay veriyorum.");
																																						System.out.println("2: Hay�r, onay vermiyorum.");
																																						System.out.print("Cevab�n�z: ");
																																						setSecim(klavye.nextInt());
																																						switch(getSecim())
																																						{
																																							case 1:
																																								System.out.println();
																																								System.out.println("Onay�n�z sistem taraf�ndan kabul edilmi�tir.");
																																								System.out.println();
																																								
																																								do
																																								{
																																									System.out.println("Verilmi� olan t�m bilgiler ve yap�lm�� olan t�m kontroller sonucunda " + adSoyad + " kan vermeye uygun mudur?");
																																									System.out.println("1: Evet, uygundur.");
																																									System.out.println("2: Hay�r, yine de uygun de�ildir.");
																																									System.out.print("Se�im: ");
																																									setSecim(klavye.nextInt());
																																									switch(getSecim())
																																									{
																																										case 1:
																																											System.out.println();
																																											System.out.println("B�t�n kontrol i�lemleri ba�ar�yla ger�ekle�tirilmi�tir.");
																																											System.out.println("Kan vermek �zere uygun bir yere ge�ebilirsiniz.");
																																											
																																											do
																																											{
																																												kontrolEkstra1 = true;
																																												
																																												System.out.println();
																																												System.out.println("Bilgiler sisteme kaydedilsin mi?");
																																												System.out.println("1: Evet");
																																												System.out.println("2: Hay�r");
																																												System.out.print("Se�iminiz: ");
																																												setSecim(klavye.nextInt());
																																												switch(getSecim())
																																												{
																																													case 1:
																																														kontrolEkstra1 = false;
																																														
																																														PrintWriter ciktiAkimi = null;
																																														String dosya = "Kan Ba���� Ki�isel Veriler.txt";
																																														
																																														try
																																														{
																																															ciktiAkimi = new PrintWriter(new FileOutputStream(dosya, true));
																																														}
																																														catch(FileNotFoundException hata)
																																														{
																																															System.out.println("\'Kan Ba���� Ki�isel Veriler.txt\' dosyas� olu�turulurken hata oldu.");
																																															System.exit(0);
																																														}
																																														
																																														ciktiAkimi.println(adSoyad + " K���S�N�N KAN BA�I� B�LG�LER�");
																																														ciktiAkimi.println("Kan Verdi�i Tarih: " + tarih);
																																														ciktiAkimi.println("*****K�ML�K B�LG�LER�*****");
																																														ciktiAkimi.println("T.C. Kimlik Numaras�: " + TCKimlikNo);
																																														ciktiAkimi.println("Ad Soyad: " + adSoyad);
																																														ciktiAkimi.println("Baba Ad�: " + babaAdi);
																																														ciktiAkimi.println("Do�um Tarihi: " + dogumTarihi);
																																														ciktiAkimi.println("Do�um Yeri (�l): " + dogumYeri);
																																														ciktiAkimi.println("*****K���SEL B�LG�LER�*****");
																																														ciktiAkimi.println("Cinsiyet: " + cinsiyet);
																																														ciktiAkimi.println("Medeni Hal: " + medeniHal);
																																														ciktiAkimi.println("E�itim Durumu: " + egitimDurumu);
																																														ciktiAkimi.println("Meslek: " + meslek);
																																														ciktiAkimi.println("Kan Ba���� Ge�mi�i: " + kanBagisiGecmisi);
																																														ciktiAkimi.println("*****ADRES VE D��ER �LET���M B�LG�LER�*****");
																																														ciktiAkimi.println("Adres: " + adres);
																																														ciktiAkimi.println("Telefon Numaras�: " + telefonNumarasi);
																																														ciktiAkimi.println("E-posta Adresi: " + ePostaAdresi);
																																														ciktiAkimi.println("Kan Hizmetleri Hakk�nda Bilgilendirme: " + kanHizmetleriBilgilendirme);
																																														ciktiAkimi.println("Di�er Hizmetler Hakk�nda Bilgilendirme: " + digerBilgilendirme);
																																														ciktiAkimi.println("*****�L��M DE�ERLER�*****");
																																														ciktiAkimi.println("Boy: " + boy);
																																														ciktiAkimi.println("Kilo: " + vucutAgirligi);
																																														ciktiAkimi.println("V�cut S�cakl���: " + vucutSicakligi);
																																														ciktiAkimi.println("Tansiyon: " + tansiyon);
																																														ciktiAkimi.println("Kan Grubu: " + kanGrubu);
																																														ciktiAkimi.println("*****Sorgulama Formu Cevaplar�*****");
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
																																														ciktiAkimi.println("*****Ek Form Cevaplar�*****");
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
																																														String dosya2 = "Kan Ba��� Listesi.txt";
																																														
																																														try
																																														{
																																															ciktiAkimi2 = new PrintWriter(new FileOutputStream(dosya2));
																																														}
																																														catch(FileNotFoundException hata)
																																														{
																																															System.out.println();
																																															System.out.println("\'Kan Ba��� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
																																															System.exit(0);
																																														}
																																														
																																														for(int i = 0; i < kanBagisListesi.size(); i++)
																																														{
																																															ciktiAkimi2.println(kanBagisListesi.get(i));
																																														}
																																														ciktiAkimi2.close();
																																														
																																														System.out.println();
																																														System.out.println("Veriler \'Kan Ba���� Ki�isel Veriler.txt\' ve \'Kan Ba��� Listesi.txt\' dosyalar�na ba�ar�yla kaydedildi.");
																																														System.out.println();
																																														
																																														try
																																														{
																																															BufferedReader girisAkimi = new BufferedReader (new FileReader("Kan �htiya� Listesi.txt"));
																																															
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
																																															System.out.print("Kan �htiya� Listesi.txt dosyas� bulunamad� veya a��lamad�.");
																																														}
																																														catch(IOException e)
																																														{
																																															System.out.print("Kan �htiya� Listesi.txt dosyas�ndan veri giri�inde hata olu�tu.");
																																														}
																																														
																																														PrintWriter ciktiAkimi5 = null;
																																														String dosya5 = "Kan �htiya� Listesi.txt";
																																														
																																														try
																																														{
																																															ciktiAkimi5 = new PrintWriter(new FileOutputStream(dosya5));
																																														}
																																														catch(FileNotFoundException hata)
																																														{
																																															System.out.println("\'Kan �htiya� Listesi.txt\' dosyas� olu�turulurken hata oldu.");
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
																																															System.out.println("1: Kan Ba���� Men�s�ne D�n");
																																															System.out.println("2: Ana Men�ye D�n");
																																															System.out.print("Se�iminiz: ");
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
																																																	System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																														System.out.println("Kay�t formu sonland�r�l�yor...");
																																														break;
																																													default:
																																														System.out.println();
																																														System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																											System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
																																											break;
																																										default:
																																											System.out.println();
																																											System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																								System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
																																								break;
																																							default:
																																								System.out.println();
																																								System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																					System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
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
																																				System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
																																				break;
																																			default:
																																				System.out.println();
																																				System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																																	System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
																																	break;
																																default:
																																	System.out.println();
																																	System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																														System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
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
																													System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
																													break;
																												default:
																													System.out.println();
																													System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
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
																									System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
																									break;
																								default:
																									System.out.println();
																									System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
																									break;
																							}
																						}
																						catch(Exception e)
																						{
																							System.out.println("HATA: " + e.getMessage());
																							System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
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
																					System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
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
																	System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
																	break;
																default:
																	System.out.println();
																	System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
																	break;
															}
														}
														catch(Exception e)
														{
															System.out.println("HATA: " + e.getMessage());
															System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
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
													System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
													break;
												default:
													System.out.println();
													System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
													break;
											}
										}
										catch(Exception e)
										{
											System.out.println("HATA: " + e.getMessage());
											System.out.println("Yanl�� de�er girdiniz! L�tfen bir say� de�eri giriniz.");
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
									System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
									break;
								default:
									System.out.println();
									System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
									break;
							}
						}
						while(kontrol2);
					}
					break;
				case 2:
					kontrol1 = false;
					
					System.out.println();
					System.out.println("Kay�t formu sonland�r�l�yor... Maalesef kay�t ba�ar�s�z oldu.");
					break;
				default:
					System.out.println();
					System.out.println("Yanl�� bir se�im yapt�n�z. L�tfen tekrar deneyiniz...");
					break;
			}
		}
		while(kontrol1);
	}
	
	public void sorgulamaFormuSorulari()
	{
		sorgulamaFormuSorulariListesi.add("\"Kan Ba�����s� Bilgilendirilmi� Onam Formu\"nu okuyup anlad�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Kendinizi sa�l�kl� ve iyi hissediyor musunuz?");
		sorgulamaFormuSorulariListesi.add("Tehlikeli bir i�te (a��r i� makinesi operat�rl���, tren makinistli�i, da�c�l�k, dalg��l�k, para��t��l�k, i�leri gere�i portatif merdiven veya �antiye iskelesine t�rmanmak zorunda kalan ki�iler vb.) mi �al���yorsunuz?");
		sorgulamaFormuSorulariListesi.add("Daha �nce yapt���n�z bir kan ba���� m�racaat� herhangi bir nedenle geri �evrildi mi?");
		sorgulamaFormuSorulariListesi.add("Prostat b�y�mesi, sivilce, sedef hastal��� veya kellik i�in herhangi bir ila� kullan�yor musunuz?");
		sorgulamaFormuSorulariListesi.add("Herhangi bir enfeksiyon hastal��� i�in ila� (antibiyotik, ate� d���r�c� vb.) ald�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Son 5 g�n i�inde aspirin, herhangi bir a�r� kesici veya romatizma ilac� ald�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Alerjik reaksiyon ge�irdiniz mi, buna y�nelik tedavi ald�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Yukar�da belirtilenler d���nda ba�ka bir ila� kullan�yor musunuz?");
		sorgulamaFormuSorulariListesi.add("Son 1 hafta i�inde ishal (diyare) oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 1 ay i�inde herhangi bir a�� oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde di� tedavisi oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Kronik (m�zmin) bir hastal���n�z var m�?");
		sorgulamaFormuSorulariListesi.add("Para veya uyu�turucu kar��l���nda cinsel ili�kiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Frengi (sifiliz) veya bel so�uklu�u (gonore) nedeni ile tedavi oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("AIDS hastal���n�z var m�, kendinize b�yle bir hastal�k oldu�una dair bir ��pheniz var m�?");
		sorgulamaFormuSorulariListesi.add("AIDS hastas� oldu�unu bildi�iniz biriyle cinsel ili�kiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Kan ve kan �r�n� alan, diyalize giren veya hemofili hastas� biri ile cinsel ili�kiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Hi� uyu�turucu kulland�n�z m�?");
		sorgulamaFormuSorulariListesi.add("�ns�lin, b�y�me hormonu, imm�nglobulin (gamaglobulin), tamoksifen kulland�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde ameliyat veya endoskopik muayene oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Kalp-damar, akci�er, mide-barsak, b�brek hastal���n�z var m�?");
		sorgulamaFormuSorulariListesi.add("Bug�ne kadar hi� n�bet, sara (epilepsi) krizi veya fel� ge�irdiniz mi?");
		sorgulamaFormuSorulariListesi.add("Bug�ne kadar hi� kanser tan�s� ald�n�z m�, kanser tedavisi g�rd�n�z m�?");
		sorgulamaFormuSorulariListesi.add("�eker hastal���n�z ya da yayg�n romatizmal bir hastal���n�z var m�?");
		sorgulamaFormuSorulariListesi.add("Kanamal� bir hastal�k veya kan hastal���n�z var m�?");
		sorgulamaFormuSorulariListesi.add("S�tma (malarya), verem (t�berk�loz), malta hummas� (peynir hastal���, brucella), kemik iltihab� (osteomyelit) veya Karahumma (kala-azar) ge�irdiniz mi?");
		sorgulamaFormuSorulariListesi.add("Hepatit (sar�l�k hastal���) ge�irdiniz mi, ta��y�c�s� m�s�n�z?");
		sorgulamaFormuSorulariListesi.add("Hepatit (sar�l�k hastal���) olan biri ile ayn� evde ya��yor musunuz veya cinsel ili�kiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Toksoplazma ge�irdiniz mi? ( Toksoplazma Kedilerden bula�an bir parazit t�r�d�r.)");
		sorgulamaFormuSorulariListesi.add("Kamerun, Orta Afrika, �ad, Kongo, Ekvatoryal Gine, Gabon, Nijer yada Nijerya'da hi� bulundunuz mu?");
		sorgulamaFormuSorulariListesi.add("1980-1996 y�llar� aras�nda �ngiltere, Kuzey �rlanda, Galler ya da �sko�ya�da bulundunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 3 y�l i�inde yukar�daki �lkeler d���nda ba�ka �lkelerde bulundunuz mu?");
		sorgulamaFormuSorulariListesi.add("Ailenizde Deli Dana Hastal��� (Creutzfeldt-Jakob) olan birisi oldu mu?");
		sorgulamaFormuSorulariListesi.add("Size Dura mater (beyin zar�) veya kornea nakli yap�ld� m�?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde size kan, doku veya organ nakli yap�ld� m�?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde bir ba�kas�n�n kan� ile temas�n�z oldu mu?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde akupunktur, botoks, tak� i�in cilt deldirme, sa� ekimi veya estetik m�dahaleler yapt�rd�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde d�vme, hacamat yapt�rd�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde hayvan �s�r��� nedeni ile kuduz a��s� oldunuz mu?");
		sorgulamaFormuSorulariListesi.add("Son 12 ay i�inde �� g�nden fazla tutuklu kald�n�z m� veya �� g�nden fazla tutuklu kalan birisiyle cinsel ili�kiniz oldu mu?");
		sorgulamaFormuSorulariListesi.add("Erkekler i�in: Son 3 ay i�inde kan ba���� yapt�n�z m�?\nKad�nlar i�in: Son 4 ay i�inde kan ba���� yapt�n�z m�?");
		sorgulamaFormuSorulariListesi.add("Erkekler i�in: Bug�ne dek hi� erkek erke�e cinsel ili�kide bulundunuz mu?" + "\nKad�nlar i�in: Son 12 ayda hamilelik ge�irdiniz mi veya d���k yapt�n�z m�? �u an hamile misiniz?");
	}
	
	public void ekFormSorulari()
	{
		ekFormSorulariListesi.add("Son 28 g�n i�erisinde COVID-19 hastal��� tan�s� ald�n�z m�?");
		ekFormSorulariListesi.add("Son 28 g�n i�erisinde klinik bir belirtiniz (ate�, �ks�r�k, solunum s�k�nt�s�, bo�az a�r�s� vb.) oldu mu?");
		ekFormSorulariListesi.add("Son 28 g�n i�erisinde COVID-19 hastal��� tan�s� alm�� (kesin vaka) veya COVID-19 hastal��� ��phesi olan (olas� vaka) biriyle maskesiz veya a�z� ve burnu kapayacak �ekilde kural�na uygun maske takmayarak 2 metreden daha yak�n mesafede, tek seferde 10 dakikadan uzun s�reyle, ayn� ortamda (ev/ofis/oda vb.) bulundunuz mu?");
		ekFormSorulariListesi.add("Son 28 g�n i�erisinde yurt d��� seyahatiniz oldu mu?");
		ekFormSorulariListesi.add("Son 28 g�n i�erisinde yurt d���ndan d�nen biriyle maskesiz veya a�z� ve burnu kapayacak �ekilde kural�na uygun maske takmayarak 2 metreden daha yak�n mesafede, tek seferde 10 dakikadan uzun s�reyle, ayn� ortamda (ev/ofis/oda vb.) bulundunuz mu?");
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