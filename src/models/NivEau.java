package models;

public class NivEau {

	private int grad;
	private int niveau;

        public NivEau(int difficulte) {
            grad = difficulte;
            setNiv();
        }
        
	public void gradPlus() {
		grad++;
                setNiv();
	}

	public void setNiv() {
		if (niveau < 3)
                    niveau = 2;
                else if (niveau < 6)
                    niveau = 3;
                else if (niveau < 8)
                    niveau = 4;
                else if (niveau < 10)
                    niveau = 5;
                else 
                    niveau = 0;
	}
        
        public int getNiv() {
            return niveau;
        }

}