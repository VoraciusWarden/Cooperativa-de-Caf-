package cafe.modelo;

public class Lote {
    private String varietal;
    private String notas;
    private String origen;
    private int altura;
    private String productor;
    private double libras;

    public Lote(String varietal, String notas, String origen, int altura, String productor, double libras){
        this.varietal = varietal;
        this.notas = notas;
        this.origen = origen; 
        this.altura = altura;
        this.productor = productor;
        this.libras = libras;
    }

    public String getNombre() {
        return varietal;  
    }

    @Override
    public String toString(){
        return "Varietal: " + varietal + "\nNotas: " + notas + "\nOrigen: " + origen + "\nAltura: " + altura + "\nProductor: " + productor + "\nLibras: " + libras;
    }
}
