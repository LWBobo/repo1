package entity;

public class Score {
	private int mathscores ;
	private int politicsscores ;
	private int foreignlanguagescores ;
	private int professionalbasiccoursescores ;
	private int totalscores;
	private int mathscoresline;
	private int politicsscoresline;
	private int foreignlanguagescoresline;
	private int professionalbasiccoursescoresline;
	private int totalscoresline ;
	public Score(int mathscores, int politicsscores, int foreignlanguagescores, int professionalbasiccoursescores) {
		this.mathscores = mathscores;
		this.politicsscores = politicsscores;
		this.foreignlanguagescores = foreignlanguagescores;
		this.professionalbasiccoursescores = professionalbasiccoursescores;
		this.totalscores = mathscores + politicsscores + foreignlanguagescores + professionalbasiccoursescores;
	}
	
	
	public Score(int mathscoresline, int politicsscoresline, int foreignlanguagescoresline,
			int professionalbasiccoursescoresline, int totalscoresline) {
		super();
		this.mathscoresline = mathscoresline;
		this.politicsscoresline = politicsscoresline;
		this.foreignlanguagescoresline = foreignlanguagescoresline;
		this.professionalbasiccoursescoresline = professionalbasiccoursescoresline;
		this.totalscoresline = totalscoresline;
	}


	public Score() {
		super();
	}


	public int getTotalscores() {
		return totalscores;
	}

	public int getMathscores() {
		return mathscores;
	}
	public void setMathscores(int mathscores) {
		this.mathscores = mathscores;
	}
	public int getPoliticsscores() {
		return politicsscores;
	}
	public void setPoliticsscores(int politicsscores) {
		this.politicsscores = politicsscores;
	}
	public int getForeignlanguagescores() {
		return foreignlanguagescores;
	}
	public void setForeignlanguagescores(int foreignlanguagescores) {
		this.foreignlanguagescores = foreignlanguagescores;
	}
	public int getProfessionalbasiccoursescores() {
		return professionalbasiccoursescores;
	}
	public void setProfessionalbasiccoursescores(int professionalbasiccoursescores) {
		this.professionalbasiccoursescores = professionalbasiccoursescores;
	}


	public int getMathscoresline() {
		return mathscoresline;
	}


	public void setMathscoresline(int mathscoresline) {
		this.mathscoresline = mathscoresline;
	}


	public int getPoliticsscoresline() {
		return politicsscoresline;
	}


	public void setPoliticsscoresline(int politicsscoresline) {
		this.politicsscoresline = politicsscoresline;
	}


	public int getForeignlanguagescoresline() {
		return foreignlanguagescoresline;
	}


	public void setForeignlanguagescoresline(int foreignlanguagescoresline) {
		this.foreignlanguagescoresline = foreignlanguagescoresline;
	}


	public int getProfessionalbasiccoursescoresline() {
		return professionalbasiccoursescoresline;
	}


	public void setProfessionalbasiccoursescoresline(int professionalbasiccoursescoresline) {
		this.professionalbasiccoursescoresline = professionalbasiccoursescoresline;
	}


	public int getTotalscoresline() {
		return totalscoresline;
	}


	public void setTotalscoresline(int totalscoresline) {
		this.totalscoresline = totalscoresline;
	}


	public void setTotalscores(int totalscores) {
		this.totalscores = totalscores;
	}
	
	@Override
	public String toString() {
		
		return this.getMathscores() + "\t" + this.getPoliticsscores() + "\t" + this.getForeignlanguagescores()
				+ "\t" + this.getProfessionalbasiccoursescores() + "\t" + this.getTotalscores();
	}
}