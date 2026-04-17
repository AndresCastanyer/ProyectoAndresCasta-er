import java.util.Objects;

public class Producte implements Comparable<Producte> {
    private final String id; // Inmutable [cite: 39]
    private double preu;
    private final Marca marca; // Inmutable [cite: 39]

    public Producte(String id, double preu, Marca marca) {
        assert preu >= 0 : "El preu no pot ser negatiu"; // Tarea 2: Asserció [cite: 99]
        this.id = id;
        this.preu = preu;
        this.marca = marca;
    }

   
    public String getId() { return id; }
    public Marca getMarca() { return marca; }
    public double getPreu() { return preu; }
    public void setPreu(double preu) { 
        assert preu >= 0 : "El nou preu no pot ser negatiu";
        this.preu = preu; 
    }

    @Override
    public boolean equals(Object o) { // Basado en ID [cite: 63, 64]
        if (this == o) return true;
        if (!(o instanceof Producte)) return false;
        Producte producte = (Producte) o;
        return Objects.equals(id, producte.id);
    }

    @Override
    public int compareTo(Producte o) { // Orden alfabético [cite: 98]
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() { return id + " (" + preu + "€)"; }
}

class StockProducte {
    private int quantitat;
    private final Producte producte;

    public StockProducte(Producte producte, int quantitat) {
        this.producte = producte;
        this.quantitat = quantitat;
    }

    public int getQuantitat() { return quantitat; }
    public Producte getProducte() { return producte; }
    public void decrementa(int q) { this.quantitat -= q; }
}
// Enumerado para las marcas limitadas [cite: 41]
public enum Marca {
    PepeWear, LaCostera, Flor_del_taronger
}

// Excepciones personalizadas [cite: 58, 72, 93]
class CanNotMergeBrandsException extends RuntimeException {
    public CanNotMergeBrandsException(String msg) { super(msg); }
}

class NotExistEnougthItemException extends RuntimeException {
    public NotExistEnougthItemException(String msg) { super(msg); }
}

class ShowRoomNotOpenException extends Exception {
    public ShowRoomNotOpenException(String msg) { super(msg); }
}