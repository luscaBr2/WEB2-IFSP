
public class Instrumento implements InterfaceInstrumento {
	private String instrumento;
	
	public String getInstrumento() {
		return instrumento;
	}
	
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	
	public Instrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	
	public String tocar() {
		return "Tocando "+this.instrumento;
	}
}
