package bucky;

public class Product {

    private String nazwa;
    private double kalorie1;
    private double weglowodany;
    private double bialka;
    private double tluszcze;

    public Product(){
        this.nazwa = "";
        this.kalorie1 = 0;
        this.weglowodany = 0;
        this.bialka = 0;
        this.tluszcze = 0;
    }

    public Product(String nazwa, double kalorie1, double weglowodany, double bialka, double tluszcze){
        this.nazwa = nazwa;
        this.kalorie1 = kalorie1;
        this.weglowodany = weglowodany;
        this.bialka = bialka;
        this.tluszcze = tluszcze;
    }

    
	
	
    public String getNazwa() {
    	
    	return nazwa;
	}
	
	public double getKalorie1() {
		return kalorie1;
	}



	public  void setKalorie1(double kalorie1) {
		this.kalorie1 = kalorie1;
	}



	public double getWeglowodany() {
		return weglowodany;
	}



	public void setWeglowodany(double weglowodany) {
		this.weglowodany = weglowodany;
	}



	public double getBialka() {
		return bialka;
	}



	public void setBialka(double bialka) {
		this.bialka = bialka;
	}



	public double getTluszcze() {
		return tluszcze;
	}



	public void setTluszcze( double tluszcze) {
		this.tluszcze = tluszcze;
	}
	
	


	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}